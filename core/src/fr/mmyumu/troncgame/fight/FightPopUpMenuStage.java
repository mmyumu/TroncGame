package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;


/**
 * Stage to display the actors of the pop-up menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenuStage extends Stage {
    private FightCharacter fightCharacter;
    private Vector2 menuCenter;

    public FightPopUpMenuStage(Viewport viewport) {
        super(viewport);
    }

    @Override
    public void draw() {
        if (menuCenter != null) {
            super.draw();
        }
    }

    public void characterTouched(FightCharacter touchedCharacter, Vector2 touchCoords) {
        if (fightCharacter == touchedCharacter) {
            fightCharacter = null;
            menuCenter = null;
        } else {
            fightCharacter = touchedCharacter;
            menuCenter = touchCoords;
        }
    }

    public Vector2 getMenuCenter() {
        return menuCenter;
    }
}
