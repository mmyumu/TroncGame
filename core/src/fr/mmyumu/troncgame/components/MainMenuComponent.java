package fr.mmyumu.troncgame.components;

import dagger.Component;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.menu.main.MainMenuStart;
import fr.mmyumu.troncgame.menu.main.MainMenuLoadingScreen;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;
import fr.mmyumu.troncgame.modules.MainMenuModule;

/**
 * Dagger component to instantiate Main Menu objects
 * Created by mmyumu on 07/11/2015.
 */
@ActivityScope
@Component(
        dependencies = GameComponent.class,
        modules = MainMenuModule.class
)
public interface MainMenuComponent {
    MainMenuLoadingScreen createMainMenuLoadingScreen();

    MainMenuScreen createMainMenuScreen();

    MainMenuStart createMainMenuStart();
}
