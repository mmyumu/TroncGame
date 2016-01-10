package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.mmyumu.troncgame.model.GameCharacter;

/**
 * Manage the logic of the Character in the Fight
 * Created by mmyumu on 10/01/2016.
 */
public class FightCharacterLogic extends Actor {
    private GameCharacter character;

    public FightCharacterLogic(int x, int y, GameCharacter character) {
        this.character = character;
        setPosition(x, y);
        setBounds(x, y, FightConstants.CHARACTER_WIDTH, FightConstants.CHARACTER_HEIGHT);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }
}
