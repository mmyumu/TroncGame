package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
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
        assetManager.load(FightConstants.TexturePath.SIDEKICK_CHARACTER, Texture.class);
        assetManager.load(FightConstants.TexturePath.SPELLS_ICON, Texture.class);
        assetManager.load(FightConstants.TexturePath.WEAPONS_ICON, Texture.class);
        assetManager.load(FightConstants.TexturePath.ENEMY, Texture.class);

        assetManager.load(FightConstants.TexturePath.MAIN_INFOS, Texture.class);
        assetManager.load(FightConstants.TexturePath.ACTION_BAR, Texture.class);
    }

    @Override
    public void render(float delta) {
        // TODO: add transition here such as graphics or blur the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (assetManager.update()) {
            troncGame.setScreen(troncGame.getFightComponent().createFightScreen());
        }
        Gdx.app.debug(TAG, ".");
    }
}
