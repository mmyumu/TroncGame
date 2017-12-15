package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

import java.util.LinkedList;

import fr.mmyumu.troncgame.CompassPoint;
import fr.mmyumu.troncgame.model.GameCharacter;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Generic behaviors of characters in a Fight
 * Created by mmyumu on 04/12/2015.
 */
public class FightCharacter extends Actor {
    private static final float RADIUS = 20f;

    private final Texture texture;
    private final boolean hasFightPopUpMenu;
    private final Label label;
    private final LinkedList<Integer> queueDamages;
    private final FightCharacterLogic fightCharacterLogic;

    private boolean darkened;

    public FightCharacter(Skin skin, int x, int y, GameCharacter character, Texture texture, boolean hasFightPopUpMenu) {
        this.texture = texture;
        this.hasFightPopUpMenu = hasFightPopUpMenu;
        this.label = new Label("", skin);

        this.label.setAlignment(Align.center);
        this.queueDamages = new LinkedList<>();

        setName(character.retrieveName());
        setPosition(x, y);
        setBounds(x, y, FightConstants.CHARACTER_WIDTH, FightConstants.CHARACTER_HEIGHT);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        fightCharacterLogic.update(delta);
        label.act(delta);

        if (label.getActions().size == 0 && !queueDamages.isEmpty()) {
            Integer damage = queueDamages.pop();
            Vector2 coords = retrieveLabelCoords();
            initDamageLabel(coords.x, coords.y, damage);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (darkened) {
            batch.setColor(0.5f, 0.5f, 0.5f, 1f);
        }

        if (getCharacter().isAlive()) {
            batch.draw(texture, getX(), getY(), FightConstants.CHARACTER_WIDTH, FightConstants.CHARACTER_HEIGHT);
        }
        label.draw(batch, parentAlpha);

        if (darkened) {
            batch.setColor(1f, 1f, 1f, 1f);
        }
    }

    public boolean hasFightPopUpMenu() {
        return hasFightPopUpMenu;
    }

    protected void displayDamage(int damage) {
        Vector2 coords = retrieveLabelCoords();

        if (label.getActions().size == 0) {
            initDamageLabel(coords.x, coords.y, damage);
        } else {
            queueDamages.add(damage);
        }
    }

    private Vector2 retrieveLabelCoords() {
        final float x = RADIUS * (float) Math.cos(CompassPoint.NORTH.getRadiansAngle()) + getCenter().x - FightConstants.LABEL_WIDTH / 2;
        final float y = RADIUS * (float) Math.sin(CompassPoint.NORTH.getRadiansAngle()) + getCenter().y - FightConstants.LABEL_HEIGHT / 2;
        return new Vector2(x, y);
    }

    private void hideDamage() {
        label.clear();
        label.setBounds(0, 0, 0, 0);
    }

    private void initDamageLabel(float x, float y, int damage) {
        RunnableAction run = new RunnableAction();
        run.setRunnable(this::hideDamage);

        Action action = sequence(moveTo(x, y), parallel(fadeOut(1), moveTo(x, y + 50, 1)), run);

        label.clearActions();
        label.setBounds(x, y, FightConstants.LABEL_WIDTH, FightConstants.LABEL_HEIGHT);
        label.setColor(1f, 0.1f, 0.1f, 1f);
        label.setText(String.valueOf(damage));
        label.addAction(action);
    }

    public void setDarkened(boolean darkened) {
        this.darkened = darkened;
    }
}
