package fr.mmyumu.troncgame.overworld.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import javax.inject.Inject;

import fr.mmyumu.troncgame.ScreenState;
import fr.mmyumu.troncgame.overworld.OverworldScreen;

/**
 * Input processor for UI in Overworld Screen
 * Created by mmyumu on 25/12/2015.
 */
public class OverworldUIInputProcessor extends InputAdapter {
    private static final String TAG = "OverworldUIInputProcessor";
    private final OverworldScreen overworldScreen;

    @Inject
    public OverworldUIInputProcessor(OverworldScreen overworldScreen) {
        this.overworldScreen = overworldScreen;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            Gdx.app.debug(TAG, "Escape pressed in Overworld");
            if(overworldScreen.getScreenState() == ScreenState.RUNNING) {
                overworldScreen.pause();
            } else if(overworldScreen.getScreenState() == ScreenState.PAUSE) {
                overworldScreen.resume();
            }

            return true;
        }
        return super.keyDown(keycode);
    }
}
