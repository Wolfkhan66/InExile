package com.mygdx.inexile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

/**
 * Created by caile_000 on 14/04/2016.
 */
public class GameScreen extends ScreenAdapter implements Screen {
    final InExileGame game;
    int height = 480;
    int width = 640;
    OrthographicCamera camera;
    Viewport viewport;
    public static int ran;
    public static Random r = new Random();
    public static Player player;


    public GameScreen(final InExileGame gam) {
        this.game = gam;
        player = new Player();


        camera = new OrthographicCamera();
        viewport = (new StretchViewport(width, height, camera));
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
    }

    public enum State
    {
        PAUSE,
        RUN,
        RESUME,
        STOPPED
    }

    private State state = State.RUN;
    @Override
    public void render(float delta) {


        switch (state) {
            case RUN:
                // tell the camera to update its matrices.
                camera.update();
                // clear the screen with a dark blue color. The
                // arguments to glClearColor are the red, green
                // blue and alpha component in the range [0,1]
                // of the color to be used to clear the screen.
                Gdx.gl.glClearColor(0, 0, 0.2f, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


                while (player.health > 0){
                    ran = r.nextInt(6 - 1 + 1) + 1 ;
                    System.out.println("*************** DAY " + player.day + " START ***************");
                    PrintChar();
                    delay();
                    Events.pickevents();
                    delay();
                    player.statuscheck();
                    System.out.println("*************** DAY " + player.day + " END ***************");
                    player.day ++;
                    player.lvlcheck();
                    delay();
                }
                death();

                // tell the SpriteBatch to render in the
                // coordinate system specified by the camera.
                game.batch.setProjectionMatrix(camera.combined);
                break;

            case PAUSE:
                break;
            case RESUME:
                break;
            default:
                break;
        }
    }

    public static void PrintChar(){

        System.out.println("****");
        System.out.println("Level " + player.lvl +"    Health: " + player.health + "     Strength: " + player.strength);
        System.out.println("Score: " + player.score+"     Gold: " + player.gold+"     XP: " + player.XP);
        System.out.println("Medicine " + player.medicine);
        System.out.println("   ");
    }

    public static void death(){
        System.out.println("You are Dead.....");
        System.exit(0);
    }

    public static void delay(){
        try {
            Thread.sleep(3000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

        /// resize the viewport, camera and stage. VERY VERY IMPORTANT FOR SCALING ON DIFFERENT DEVICES
        @Override
        public void resize(int width, int height) {
            viewport.update(width, height);
            camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        }

        @Override
        public void show() {
        }

        @Override
        public void hide() {
        }

        @Override
        public void pause()
        {
            this.state = State.PAUSE;
        }

        @Override
        public void resume()
        {
            this.state = State.RUN;
        }


        // dispose of assets when moving away from the GameScreen.
        // for example if you dont dispose of the game music, then that instance of the music will continue
        // to play whereever you are in the application
        @Override
        public void dispose() {

        }

        public void setGameState(State s){
            this.state = s;
        }

    }
