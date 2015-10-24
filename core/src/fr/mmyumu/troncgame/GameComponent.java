package fr.mmyumu.troncgame;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mmyumu on 24/10/2015.
 */
@Singleton
@Component(modules = {GameModule.class})
public interface GameComponent {
    void inject(TroncGame troncGame);
}
