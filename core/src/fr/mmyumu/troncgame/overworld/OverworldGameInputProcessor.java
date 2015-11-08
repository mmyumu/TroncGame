package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;

import javax.inject.Inject;

/**
 * Manage the inputs on the Game when Overworld is displayed
 * Created by mmyumu on 07/11/2015.
 */
public class OverworldGameInputProcessor extends InputAdapter {

    private OverworldScreen overworldScreen;

    @Inject
    public OverworldGameInputProcessor(OverworldScreen overworldScreen) {
        this.overworldScreen = overworldScreen;
    }

    private void initMainCharacterMoveTarget(int screenX, int screenY) {
        Vector2 touchCoords = overworldScreen.getGameStage().getViewport().unproject(new Vector2(screenX, screenY));
        overworldScreen.getMainCharacter().setMoveTarget(new GridPoint2((int) touchCoords.x, (int) touchCoords.y));
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        initMainCharacterMoveTarget(screenX, screenY);
//        Actor actor = gameStage.hit(touchCoords.x, touchCoords.y, true);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        initMainCharacterMoveTarget(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO: add a preference to manage if the touch up set the move target to null or not
        overworldScreen.getMainCharacter().setMoveTarget(null);
        return false;
    }
}
