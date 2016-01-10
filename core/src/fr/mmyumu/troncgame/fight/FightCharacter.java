package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import fr.mmyumu.troncgame.model.GameCharacter;

/**
 * Generic behaviors of characters in a Fight
 * Created by mmyumu on 04/12/2015.
 */
public class FightCharacter extends FightCharacterLogic {
    private Texture texture;

    public FightCharacter(int x, int y, GameCharacter character, Texture texture) {
        super(x, y, character);
        this.texture = texture;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), FightConstants.CHARACTER_WIDTH, FightConstants.CHARACTER_HEIGHT);
    }
}
