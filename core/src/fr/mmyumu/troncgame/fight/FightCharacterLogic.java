package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.mmyumu.troncgame.model.GameCharacter;

/**
 * Manage the logic of the Character in the Fight
 * Created by mmyumu on 10/01/2016.
 */
public class FightCharacterLogic {
    private final GameCharacter character;

    private double actionValue;

    public FightCharacterLogic(int x, int y, GameCharacter character) {
        this.character = character;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public double getActionValue() {
        return actionValue;
    }

    public void update(float delta) {
        actionValue += character.getActionSpeed() * delta;

        if (actionValue >= FightConstants.MainInfos.MAX_ACTION_VALUE) {
            actionValue = FightConstants.MainInfos.MAX_ACTION_VALUE;
        }
    }

    public boolean isReady() {
        return actionValue == FightConstants.MainInfos.MAX_ACTION_VALUE;
    }

    public void attack(FightCharacterLogic targetCharacterLogic) {
        int damage = character.attack(targetCharacter.getCharacter());
        targetCharacter.displayDamage(damage);
        actionValue = 0;
    }

    public Vector2 getCenter() {
        float x = getX() + getWidth() / 2;
        float y = getY() + getHeight() / 2;
        return new Vector2(x, y);
    }
}
