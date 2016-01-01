package fr.mmyumu.troncgame.overworld.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS;

/**
 * Stage to manage the menu when Overworld is paused
 * Created by mmyumu on 27/12/2015.
 */
public class OverworldMenu extends Stage {
    private static final String TAG = "OverworldMenu";

    private Lazy<OverworldScreen> overworldScreen;

    @Inject
    public OverworldMenu(ScalingViewport viewport, Lazy<OverworldScreen> overworldScreen, @Named("menu") OverworldFPS overworldFPS, OverworldMenuList overworldMenuList) {
        super(viewport);

        this.overworldScreen = overworldScreen;
        addActor(overworldFPS);
        addActor(overworldMenuList);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            Gdx.app.debug(TAG, "Escape pressed in Overworld Menu");
            overworldScreen.get().resumeGame();
            return true;
        }
        return super.keyDown(keycode);
    }
}
