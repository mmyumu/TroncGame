package fr.mmyumu.troncgame.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import fr.mmyumu.troncgame.DaggerAdapter;
import fr.mmyumu.troncgame.GameModule;
import fr.mmyumu.troncgame.TroncGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		DaggerAdapter daggerAdapter = new DaggerAdapter(TroncGame.class, new GameModule());
		initialize(daggerAdapter, config);
	}
}
