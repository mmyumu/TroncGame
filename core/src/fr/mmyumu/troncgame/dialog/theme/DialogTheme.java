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

    public Color getColor() {
        return color;
    }
}
