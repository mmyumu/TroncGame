package fr.mmyumu.troncgame;

import javax.inject.Singleton;

import dagger.Component;

/**
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
}
