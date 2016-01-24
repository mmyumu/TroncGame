package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import fr.mmyumu.troncgame.fight.FightCharacter;

/**
 * Display the current HP of the character.
 * Created by mmyumu on 24/01/2016.
 */
public class FightHPLabel extends Label {
    private FightCharacter fightCharacter;

    public FightHPLabel(FightCharacter fightCharacter, Skin skin) {
        super(String.valueOf(fightCharacter.getCharacter().getHp()), skin);

        this.fightCharacter = fightCharacter;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setText(String.valueOf(fightCharacter.getCharacter().getHp()));
    }
}
