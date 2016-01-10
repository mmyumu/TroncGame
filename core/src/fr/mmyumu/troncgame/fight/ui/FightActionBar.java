package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.model.GameCharacter;

/**
 * Manage the action bar (bar to show when character can act)
 * Created by mmyumu on 02/01/2016.
 */
public class FightActionBar extends Actor {
    private final AssetManager assetManager;
    private final GameCharacter character;

    public FightActionBar(AssetManager assetManager, GameCharacter character) {
        this.assetManager = assetManager;
        this.character = character;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(assetManager.get(FightConstants.TexturePath.ACTION_BAR, Texture.class), getX(), getY(), getWidth(), getHeight());

        // TODO: draw the filling of the action bar
    }
}
