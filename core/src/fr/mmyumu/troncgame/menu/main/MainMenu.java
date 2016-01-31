package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.List;

import javax.inject.Inject;

/**
 * Display the different buttons of the main menu
 * Created by mmyumu on 31/01/2016.
 */
public class MainMenu extends Stage {

    @Inject
    public MainMenu(ScalingViewport viewport) {
        super(viewport);
    }

    public void init(MainMenuBackground mainMenuBackground, List<Actor> buttons) {
        addActor(mainMenuBackground);
        for (Actor button : buttons) {
            addActor(button);
        }
    }
}
