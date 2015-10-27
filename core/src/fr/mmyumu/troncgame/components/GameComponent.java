package fr.mmyumu.troncgame.components;

import javax.inject.Singleton;

import dagger.Component;
import fr.mmyumu.troncgame.TroncGame;

/**
 * Created by mmyumu on 24/10/2015.
 */
@Singleton
@Component(modules = {fr.mmyumu.troncgame.modules.GameModule.class})
public interface GameComponent {
    void inject(TroncGame troncGame);
}
