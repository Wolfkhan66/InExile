package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
/**
 *
 * @author (cai lehwald)
 * @version (1)
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InExileGame extends Game {
	SpriteBatch batch;
	BitmapFont font;

	public void create() {
		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		font.getScaleX();
		font.getScaleY();
		font.setColor(Color.GREEN);
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
