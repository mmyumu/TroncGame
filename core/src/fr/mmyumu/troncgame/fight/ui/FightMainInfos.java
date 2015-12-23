package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.FightConstants;

/**
 * Display the main infos in the Fight Screen
 * Created by mmyumu on 18/12/2015.
 */
public class FightMainInfos extends Actor {
    private AssetManager assetManager;

    @Inject
    public FightMainInfos(AssetManager assetManager) {
        this.assetManager = assetManager;
        setBounds(0, 0, FightConstants.MAIN_INFOS_WIDTH, FightConstants.MAIN_INFOS_HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(assetManager.get(FightConstants.TexturePath.MAIN_INFOS, Texture.class), getX(), getY(), getWidth(), getHeight());
    }
}
