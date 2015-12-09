package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.InputAdapter;

import javax.inject.Inject;

/**
 * Manage the inputs for the game in the Fights
 * Created by mmyumu on 06/12/2015.
 */
public class FightGameInputProcessor extends InputAdapter {
    private final static String TAG = "FightGameInputProcessor";
    private FightScreen fightScreen;

    @Inject
    public FightGameInputProcessor(FightScreen fightScreen) {
        this.fightScreen = fightScreen;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return fightScreen.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }
}
