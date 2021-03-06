package com.mygdx.inexile.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.inexile.InExileGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "InExile";
		config.width = 480;
		config.height = 640;
		new LwjglApplication(new InExileGame(), config);
	}
}
