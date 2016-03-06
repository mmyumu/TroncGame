package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import fr.mmyumu.troncgame.DisplayableLoadingScreen;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.dialog.theme.DialogTheme;
import fr.mmyumu.troncgame.model.manager.ModelManager;

/**
 * Displayed while loading the introduction
 * Created by mmyumu on 22/02/2016.
 */
public class IntroductionLoadingScreen extends DisplayableLoadingScreen {

    private final ModelManager modelManager;

    public IntroductionLoadingScreen(TroncGame troncGame, AssetManager assetManager, ModelManager modelManager) {
        super(troncGame, assetManager);
        this.modelManager = modelManager;
    }

    @Override
    protected Screen getNextScreen() {
        return troncGame.getIntroductionComponent().introductionScreen();
    }

    @Override
    protected void load() {
        loadThemes();
    }

    private void loadThemes() {
        for (DialogTheme dialogTheme : modelManager.getThemeManager().getDialogThemes().values()) {
            assetManager.load(dialogTheme.getTop(), Texture.class);
            assetManager.load(dialogTheme.getBottom(), Texture.class);
            assetManager.load(dialogTheme.getLeft(), Texture.class);
            assetManager.load(dialogTheme.getRight(), Texture.class);

            assetManager.load(dialogTheme.getTopLeft(), Texture.class);
            assetManager.load(dialogTheme.getTopRight(), Texture.class);
            assetManager.load(dialogTheme.getBottomLeft(), Texture.class);
            assetManager.load(dialogTheme.getBottomRight(), Texture.class);
        }
    }

    @Override
    protected String getDebugName() {
        return "Introduction";
    }
}
