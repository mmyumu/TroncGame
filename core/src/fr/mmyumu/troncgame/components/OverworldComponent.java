package fr.mmyumu.troncgame.components;

import dagger.Component;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.modules.OverworldModule;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.game.OverworldCharacter;
import fr.mmyumu.troncgame.overworld.game.OverworldGameInputProcessor;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenu;
import fr.mmyumu.troncgame.overworld.ui.OverworldUIInputProcessor;
import fr.mmyumu.troncgame.overworld.ui.OverworldUI;

/**
 * Dagger component to instantiate Overworld objects
 * Created by mmyumu on 07/11/2015.
 */
@ActivityScope
@Component(
        dependencies = GameComponent.class,
        modules = OverworldModule.class
)
public interface OverworldComponent {
    OverworldLoadingScreen createOverworldLoadingScreen();

    OverworldScreen createOverworldScreen();

    OverworldGameInputProcessor createOverworldGameInputProcessor();

    OverworldUI createOverworldUI();

    OverworldCharacter createOverworldCharacter();

    OverworldUIInputProcessor createOverworldUIInputProcessor();

    OverworldMenu createOverworldMenu();
}
