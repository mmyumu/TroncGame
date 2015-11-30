package fr.mmyumu.troncgame.components;

import javax.inject.Singleton;

import dagger.Component;
import fr.mmyumu.troncgame.GameInputProcessor;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.modules.GameModule;

/**
 * Dagger component of the game
 * Created by mmyumu on 24/10/2015.
 */
@Singleton
@Component(modules = {GameModule.class})
public interface GameComponent {
    void inject(TroncGame troncGame);

    GameInputProcessor createGameInputProcessor();
}
