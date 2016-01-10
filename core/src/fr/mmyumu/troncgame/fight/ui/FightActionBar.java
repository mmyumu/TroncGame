package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.mmyumu.troncgame.fight.FightCharacter;
import fr.mmyumu.troncgame.fight.FightConstants;

/**
 * Manage the action bar (bar to show when character can act)
 * Created by mmyumu on 02/01/2016.
 */
public class FightActionBar extends Actor {
    private final AssetManager assetManager;
    private final FightCharacter fightCharacter;
    private final ShapeRenderer shapeRenderer;

    public FightActionBar(AssetManager assetManager, FightCharacter fightCharacter) {
        this.assetManager = assetManager;
        this.fightCharacter = fightCharacter;

        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(assetManager.get(FightConstants.TexturePath.ACTION_BAR, Texture.class), getX(), getY(), getWidth(), getHeight());

        // TODO: draw the filling of the action bar
        batch.end();

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.setTransformMatrix(batch.getTransformMatrix());

        GL20 gl = Gdx.graphics.getGL20();
        gl.glEnable(GL20.GL_BLEND);
        gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        if(fightCharacter.getActionValue() == FightConstants.MainInfos.MAX_ACTION_VALUE) {
            shapeRenderer.setColor(1f, 0.9f, 0.1f, 1f);
        } else {
            shapeRenderer.setColor(1f, 1f, 1f, 1f);
        }


        shapeRenderer.rect(getX() + 19, getY() + 10, (float) fightCharacter.getActionValue(), 15);
        shapeRenderer.end();
        gl.glDisable(GL20.GL_BLEND);

        batch.begin();
    }
}
