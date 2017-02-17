package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import fr.mmyumu.troncgame.fight.FightCharacter;

/**
 * Display the current MP of the character.
 * Created by mmyumu on 24/01/2016.
 */
public class FightMPLabel extends Label {
    private final FightCharacter fightCharacter;

    public FightMPLabel(FightCharacter fightCharacter, Skin skin) {
        super(String.valueOf(fightCharacter.getCharacter().getCurrentMp()), skin);

        this.fightCharacter = fightCharacter;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setText(String.valueOf(fightCharacter.getCharacter().getCurrentMp()));
    }
}
