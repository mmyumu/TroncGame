package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Screen to be displayed when loading the fights
 * Created by mmyumu on 17/11/2015.
 */
public class FightLoadingScreen extends ScreenAdapter {
    private static final String TAG = "FightLoadingScreen";

    private final TroncGame troncGame;
    private final AssetManager assetManager;

    @Inject
    public FightLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Loading fight");

        assetManager.load(FightConstants.MusicPath.FIRST_CHIPTUNE, Music.class);
        assetManager.load(FightConstants.TexturePath.BACKGROUND_PLAIN, Texture.class);
        assetManager.load(FightConstants.TexturePath.MAIN_CHARACTER, Texture.class);
    }

    @Override
    public void render(float delta) {
        if (assetManager.update()) {
            troncGame.setScreen(troncGame.getFightComponent().createFightScreen());
        }
        Gdx.app.debug(TAG, ".");
    }
}
