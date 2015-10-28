package fr.mmyumu.troncgame.components;

import dagger.Component;
import fr.mmyumu.troncgame.*;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;

/**
 * Created by mmyumu on 24/10/2015.
 */
@ActivityScope
@Component(
        dependencies = GameComponent.class,
        modules = fr.mmyumu.troncgame.modules.ScreenModule.class
)
public interface ScreenComponent {
    LoadingScreen createLoadingScreen();

    MainMenuScreen createMainMenuScreen();
}
