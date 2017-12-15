package fr.mmyumu.troncgame.dialog.theme;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by mmyumu on 15/12/2017.
 */

public class DialogThemeRenderer {
    private final ShapeRenderer shapeRenderer;
    private DialogTheme dialogTheme;

    public DialogThemeRenderer(DialogTheme dialogTheme) {
        this.dialogTheme = dialogTheme;

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(dialogTheme.getColor());
    }

    public void draw(Batch batch, float parentAlpha, AssetManager assetManager, float x, float y, float width, float height) {
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
        batch.begin();

        Texture topTexture = assetManager.get(dialogTheme.getTop(), Texture.class);
        Texture bottomTexture = assetManager.get(dialogTheme.getBottom(), Texture.class);
        Texture leftTexture = assetManager.get(dialogTheme.getLeft(), Texture.class);
        Texture rightTexture = assetManager.get(dialogTheme.getRight(), Texture.class);

        Texture topLeftTexture = assetManager.get(dialogTheme.getTopLeft(), Texture.class);
        Texture topRightTexture = assetManager.get(dialogTheme.getTopRight(), Texture.class);
        Texture bottomLeftTexture = assetManager.get(dialogTheme.getBottomLeft(), Texture.class);
        Texture bottomRightTexture = assetManager.get(dialogTheme.getBottomRight(), Texture.class);

        for (float i = x - 5; i < x + width; i++) {
            batch.draw(topTexture, i, y + height, 1, 5);
        }
        for (float i = x - 5; i < x + width; i++) {
            batch.draw(bottomTexture, i, y - 5, 1, 5);
        }
        for (float i = y - 5; i < y + height; i++) {
            batch.draw(leftTexture, x - 5, i, 5, 1);
        }
        for (float i = y - 5; i < y + height; i++) {
            batch.draw(rightTexture, x + width, i, 5, 1);
        }

        batch.draw(topLeftTexture, x - 5, y + height, 5, 5);
        batch.draw(topRightTexture, x + width, y + height, 5, 5);
        batch.draw(bottomLeftTexture, x - 5, y - 5, 5, 5);
        batch.draw(bottomRightTexture, x + width, y - 5, 5, 5);
    }
}
