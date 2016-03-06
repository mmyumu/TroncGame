package fr.mmyumu.troncgame.dialog.theme;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * The UI theme of the dialog
 * Created by mmyumu on 23/03/2016.
 */
public class DialogTheme {
    private final String top;
    private final String bottom;
    private final String left;
    private final String right;
    private final String topLeft;
    private final String topRight;
    private final String bottomLeft;
    private final String bottomRight;

    private final Color color;

    private final ShapeRenderer shapeRenderer;

    public DialogTheme(String top, String bottom, String left, String right, String topLeft, String topRight, String bottomLeft, String bottomRight, Color color) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.color = color;

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(color);
    }

    public void draw(Batch batch, float parentAlpha, AssetManager assetManager, float x, float y, float width, float height) {
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
        batch.begin();

        Texture topTexture = assetManager.get(top, Texture.class);
        Texture bottomTexture = assetManager.get(bottom, Texture.class);
        Texture leftTexture = assetManager.get(left, Texture.class);
        Texture rightTexture = assetManager.get(right, Texture.class);

        Texture topLeftTexture = assetManager.get(topLeft, Texture.class);
        Texture topRightTexture = assetManager.get(topRight, Texture.class);
        Texture bottomLeftTexture = assetManager.get(bottomLeft, Texture.class);
        Texture bottomRightTexture = assetManager.get(bottomRight, Texture.class);

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

    public String getTop() {
        return top;
    }

    public String getBottom() {
        return bottom;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getTopLeft() {
        return topLeft;
    }

    public String getTopRight() {
        return topRight;
    }

    public String getBottomLeft() {
        return bottomLeft;
    }

    public String getBottomRight() {
        return bottomRight;
    }
}
