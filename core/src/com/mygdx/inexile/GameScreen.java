package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
/**
 * The Main Game Screen
 *
 * @author (cai lehwald)
 * @version (1)
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter implements Screen {
    final InExileGame game;
    int height = 640;
    int width = 480;
    OrthographicCamera camera;
    Viewport viewport;
    public static Player player;
    public static Events events;
    public static Battle battle;
    private SpriteBatch batch;
    private Skin skin;
    private Stage stage;
    Dialog dialog;
    public static Label gamelog;
    public ScrollPane scroller;
    Sprite Hud;
    static Sprite EventWindow;

    public static boolean dayhasbegun = true;


    public GameScreen(final InExileGame gam) {
        this.game = gam;
        player = new Player();
        events = new Events();
        battle = new Battle();

        Hud = new Sprite(new Texture(Gdx.files.internal("HUD.png")));
        EventWindow = new Sprite(new Texture(Gdx.files.internal("EventWindow.png")));


        camera = new OrthographicCamera();
        viewport = (new StretchViewport(width, height, camera));
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        create();
    }

    public void create() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        stage = new Stage(new StretchViewport(width, height)); Gdx.input.setInputProcessor(stage);

        gamelog = new Label("Start", skin);
        gamelog.setAlignment(Align.center);
        gamelog.setWrap(true);

        Table scrollTable = new Table();
        scrollTable.add(gamelog);
        scrollTable.row();

        scroller = new ScrollPane(scrollTable);

        Table table = new Table();
        table.setBounds(10, 10, 460, 200);
        table.add(scroller).fill().expand();

        stage.addActor(table);

        final TextButton button = new TextButton("Continue" , skin , "default");
        button.setBounds(240, 220, 230, 40);

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (dayhasbegun) {
                        gamelog.setText(gamelog.getText() + "\n DAY " + player.day);
                        events.pickevents();
                    player.statuscheck();
                }
                else if (!player.combat ){
                    EventWindow.setTexture(new Texture(Gdx.files.internal("CampFire.png")));
                    gamelog.setText(gamelog.getText() + "\n You set up camp");
                    gamelog.setText(gamelog.getText() + "\n ");
                    player.day++;
                    player.lvlcheck();
                    dayhasbegun = true;
                }
                else if (player.combat) {
                    battle.Combat();
                    player.statuscheck();
                }

                if (!player.alive) {
                    game.setScreen(new GameOverScreen(game));
                    dispose();
                }
                else if (player.health <= 0) {
                    gamelog.setText(gamelog.getText() + "\nYou are Dead.....");
                    player.alive = false;
                }
            }
        });

        /*
        dialog = new Dialog("End Game", skin);
        dialog.button("Continue", 1L);
        dialog.text("hello world");
        dialog.show(stage, null);
        dialog.setBounds(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()/2, 200, 300);
        stage.addActor(dialog);
        */

        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // tell the camera to update its matrices.
        camera.update();
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);

        this.stage.act();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        scroller.fling(1, 0, -30);
        stage.act();

        game.batch.begin();
        game.batch.draw(Hud, Hud.getX(), Hud.getY(), Hud.getWidth(), Hud.getHeight());
        game.batch.draw(EventWindow, 10, 270, EventWindow.getWidth(), EventWindow.getHeight());
        game.font.draw(game.batch, "Health: " + player.health, 17, 620);
        game.font.draw(game.batch, "Strength: " + player.strength, 17, 600);
        game.font.draw(game.batch, "Level: " + player.lvl, 17, 580);
        game.font.draw(game.batch, "XP: " + player.XP, 17, 560);

        game.font.draw(game.batch, "Gold: " + player.gold, 17, 500);
        game.font.draw(game.batch, "Medicine: " + player.medicine, 17, 480);

        game.font.draw(game.batch, "Score: " + player.score, 400, 620);
        game.font.draw(game.batch, "Day: " + player.day, 400, 600);
        game.batch.end();
        this.stage.draw();
        batch.begin();
        stage.draw();
        batch.end();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
    }

    /// resize the viewport, camera and stage. VERY VERY IMPORTANT FOR SCALING ON DIFFERENT DEVICES
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        stage.getViewport().update(width, height);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    // dispose of assets when moving away from the GameScreen.
    // for example if you dont dispose of the game music, then that instance of the music will continue
    // to play whereever you are in the application
    @Override
    public void dispose() {
    //    stage.dispose();
    }

    public static Player getPlayer() {
        return player;
    }
    public static Battle getBattle() {return battle; }
}
