package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import javax.inject.Inject;

import fr.mmyumu.troncgame.DisplayableLoadingScreen;
import fr.mmyumu.troncgame.TroncGame;

/**
 * Screen to be displayed when loading the fights
 * Created by mmyumu on 17/11/2015.
 */
public class FightLoadingScreen extends DisplayableLoadingScreen {

    @Inject
    public FightLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        super(troncGame, assetManager);
    }

    @Override
    protected Screen getNextScreen() {
        return troncGame.getFightComponent().createFightScreen();
    }

    @Override
    protected void load() {
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
    protected String getDebugName() {
        return "fight";
    }
}
