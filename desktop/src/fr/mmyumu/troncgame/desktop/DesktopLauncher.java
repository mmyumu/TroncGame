package fr.mmyumu.troncgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import fr.mmyumu.troncgame.TroncGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Tronc";
		config.width = 1600;
		config.height = 900;
		TroncGame troncGame = new TroncGame();
		new LwjglApplication(troncGame, config);
	}
}
