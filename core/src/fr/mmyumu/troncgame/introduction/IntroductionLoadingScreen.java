package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;

import fr.mmyumu.troncgame.DisplayableLoadingScreen;
import fr.mmyumu.troncgame.TroncGame;

/**
 * Displayed while loading the introduction
 * Created by mmyumu on 22/02/2016.
 */
public class IntroductionLoadingScreen extends DisplayableLoadingScreen {

    public IntroductionLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        super(troncGame, assetManager);
    }

    @Override
    protected Screen getNextScreen() {
        return troncGame.getIntroductionComponent().introductionScreen();
    }

    @Override
    protected void load() {
    }

    @Override
    protected String getDebugName() {
        return "Introduction";
    }
}
