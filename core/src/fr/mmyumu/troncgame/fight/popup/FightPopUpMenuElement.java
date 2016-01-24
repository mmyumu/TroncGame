package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.mmyumu.troncgame.CompassPoint;
import fr.mmyumu.troncgame.fight.FightConstants;

/**
 * Element of the pop up menu in Fight (icons, not ready text)
 * Created by mmyumu on 12/01/2016.
 */
public abstract class FightPopUpMenuElement extends Actor {
    private final CompassPoint compassPoint;
    private Vector2 menuCenter;

    public FightPopUpMenuElement(CompassPoint compassPoint) {
        this.compassPoint = compassPoint;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (menuCenter != null) {
            drawElement(batch, parentAlpha);
        }
    }

    protected abstract void drawElement(Batch batch, float parentAlpha);

    public void display(Vector2 touchCoords) {
        menuCenter = touchCoords;
        Vector2 iconCoords = computeIconCoords();
        setBounds(iconCoords.x, iconCoords.y, FightConstants.ICON_WIDTH, FightConstants.ICON_HEIGHT);
    }

    public void hide() {
        menuCenter = null;
        setBounds(0, 0, 0, 0);
    }

    private Vector2 computeIconCoords() {
        float x = getRadius() * (float) Math.cos(compassPoint.getRadiansAngle()) + menuCenter.x - FightConstants.ICON_WIDTH / 2;
        float y = getRadius() * (float) Math.sin(compassPoint.getRadiansAngle()) + menuCenter.y - FightConstants.ICON_HEIGHT / 2;

        return new Vector2(x, y);
    }

    protected abstract float getRadius();
}
