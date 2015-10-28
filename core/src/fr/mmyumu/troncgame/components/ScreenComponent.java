package fr.mmyumu.troncgame.components;

import dagger.Component;
import fr.mmyumu.troncgame.*;
import fr.mmyumu.troncgame.menu.main.MainMenuActor;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;
import fr.mmyumu.troncgame.modules.ScreenModule;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import fr.mmyumu.troncgame.overworld.OverworldScreen;

/**
 * Dagger component for the different screens
 * Created by mmyumu on 24/10/2015.
 */
@ActivityScope
@Component(
        dependencies = GameComponent.class,
        modules = ScreenModule.class
)
public interface ScreenComponent {
    LoadingScreen createLoadingScreen();

    MainMenuScreen createMainMenuScreen();

    MainMenuActor createMainMenuActor();

    OverworldLoadingScreen createOverworldLoadingScreen();

    OverworldScreen createOverworldScreen();
}
