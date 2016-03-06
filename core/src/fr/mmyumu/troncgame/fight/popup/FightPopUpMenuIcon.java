package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

import fr.mmyumu.troncgame.CompassPoint;
import fr.mmyumu.troncgame.FontManager;

/**
 * Actor for an icon of the Pop-up Menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenuIcon extends FightPopUpMenuElement {
    private static final float RADIUS = 150f;
    private final boolean action;
    private Texture texture;
    private float alpha;
    private BitmapFont font;
    private GlyphLayout layout;
    private String title;

    public FightPopUpMenuIcon(String texturePath, CompassPoint compassPoint, AssetManager assetManager, String title, FontManager fontManager, boolean action) {
        super(compassPoint);
        this.title = title;
        this.texture = assetManager.get(texturePath, Texture.class);
        this.action = action;
        this.font = fontManager.loadKarmaticArcade(new Color(0.5f, 1f, 0.3f, 1f), fontManager.parameters(20, 0));
        alpha = 1f;
        setName(texturePath);

        layout = new GlyphLayout();
        layout.setText(font, title);
    }

    @Override
    protected void drawElement(Batch batch, float parentAlpha) {
        float centerX = getX() + getWidth() / 2;
        float textX = centerX - layout.width / 2;

        batch.setColor(1f, 1f, 1f, alpha * parentAlpha);
        font.getColor().a = alpha * parentAlpha;
        font.draw(batch, title, textX, getY() + getHeight() + font.getLineHeight() + 10);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    protected float getRadius() {
        return RADIUS;
    }

    @Override
    public void hide() {
        super.hide();
        alpha = 1f;
    }

    public void select() {
        alpha = 1f;
    }

    public void unselect() {
        alpha = 0.5f;
    }

    public boolean isAction() {
        return action;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
