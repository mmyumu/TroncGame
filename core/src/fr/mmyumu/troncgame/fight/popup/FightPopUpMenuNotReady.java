package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.CompassPoint;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Manage the display of the "not ready" message when the user tries to open the menu of a character with an action bar not filled
 * Created by mmyumu on 12/01/2016.
 */
public class FightPopUpMenuNotReady extends FightPopUpMenuElement {
    private static final float RADIUS = 100f;

    private final Label label;

    @Inject
    public FightPopUpMenuNotReady(I18NBundle bundle, Skin skin) {
        super(CompassPoint.NORTH);
        label = new Label(bundle.get("fight.notReady"), skin);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        label.act(delta);
    }

    @Override
    public void display(Vector2 touchCoords) {
        super.display(touchCoords);

        label.clearActions();
        label.setColor(1, 1, 1, 1);

        RunnableAction run = new RunnableAction();
        run.setRunnable(this::hide);

        label.addAction(sequence(fadeOut(1), run));
        label.setBounds(getX(), getY(), getWidth(), getHeight());
    }

    public void drawElement(Batch batch, float parentAlpha) {
        label.draw(batch, parentAlpha);
    }

    @Override
    protected float getRadius() {
        return RADIUS;
    }
}
