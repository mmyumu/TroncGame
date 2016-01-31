package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;

/**
 * The background of the main menu
 * Created by mmyumu on 31/01/2016.
 */
public class MainMenuBackground extends Actor {

    private final Texture texture;

    @Inject
    public MainMenuBackground(AssetManager assetManager) {
        this.texture = assetManager.get(Constants.TexturePath.MAIN_MENU, Texture.class);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, 0, 0);
        super.draw(batch, parentAlpha);
    }
}
