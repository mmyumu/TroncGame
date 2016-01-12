package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.CompassPoint;

/**
 * Manage the display of the "not ready" message when the user tries to open the menu of a character with an action bar not filled
 * Created by mmyumu on 12/01/2016.
 */
public class FightPopUpMenuNotReady extends FightPopUpMenuElement {
    private static final float RADIUS = 100f;

    private I18NBundle bundle;
    private BitmapFont font;

    @Inject
    public FightPopUpMenuNotReady(I18NBundle bundle, BitmapFont font) {
        super(CompassPoint.NORTH);
        this.bundle = bundle;
        this.font = font;
    }

    public void drawElement(Batch batch, float parentAlpha) {
        font.draw(batch, bundle.get("fight.notReady"), getX(), getY());
    }

    @Override
    protected float getRadius() {
        return RADIUS;
    }
}
