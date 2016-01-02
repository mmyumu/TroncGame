package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;
import javax.inject.Named;

import fr.mmyumu.troncgame.overworld.OverworldScreen;

/**
 * Manage the inputs on the Game when Overworld is displayed
 * Created by mmyumu on 07/11/2015.
 */
public class OverworldGameInputProcessor extends InputAdapter {
    private static final String TAG = "OverworldGameInputProcessor";
    private final OverworldScreen overworldScreen;
    private final ScalingViewport viewport;

    @Inject
    public OverworldGameInputProcessor(OverworldScreen overworldScreen, @Named("game") ScalingViewport viewport) {
        this.overworldScreen = overworldScreen;
        this.viewport = viewport;
    }

    private void initMainCharacterMoveTarget(int screenX, int screenY) {
        Vector2 touchCoords = viewport.unproject(new Vector2(screenX, screenY));
        overworldScreen.getMainCharacter().setMoveTarget(new GridPoint2((int) touchCoords.x, (int) touchCoords.y));
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.debug(TAG, "touchDown x=" + screenX + " y=" + screenY);
        initMainCharacterMoveTarget(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Gdx.app.debug(TAG, "touchDragged x=" + screenX + " y=" + screenY);
        initMainCharacterMoveTarget(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO: add a preference to manage if the touch up set the move target to null or not
        overworldScreen.getMainCharacter().setMoveTarget(null);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.F) {
            overworldScreen.startFight();
        }
        return super.keyDown(keycode);
    }
}
