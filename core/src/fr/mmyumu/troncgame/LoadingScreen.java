package fr.mmyumu.troncgame;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import javax.inject.Inject;

/**
 * Created by mmyumu on 24/10/2015.
 */
public class LoadingScreen extends ScreenAdapter {
    private TroncGame troncGame;
    private AssetManager assetManager;

    @Inject
    public LoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {
        assetManager.load("main_menu.png", Texture.class);
    }

    @Override
    public void render(float delta) {
        if (assetManager.update()) {
            troncGame.setScreen(troncGame.getScreenComponent().createMainMenuScreen());
        }
        System.out.println("### Loading");
    }
}
