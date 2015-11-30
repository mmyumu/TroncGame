package fr.mmyumu.troncgame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;

import javax.inject.Inject;

import fr.mmyumu.troncgame.audio.Musical;

/**
 * Input processor that is always added to the game
 * Created by mmyumu on 30/11/2015.
 */
public class GameInputProcessor extends InputAdapter {

    private TroncGame troncGame;

    @Inject
    public GameInputProcessor(TroncGame troncGame) {
        this.troncGame = troncGame;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.M) {
            Screen screen = troncGame.getScreen();

            if (screen instanceof Musical) {
                Musical musicalScreen = (Musical) screen;

                if (musicalScreen.isPlaying()) {
                    musicalScreen.stopPlaying();
                } else {
                    musicalScreen.play();
                }
            }
        }
        return false;
    }

}
