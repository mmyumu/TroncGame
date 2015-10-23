package fr.mmyumu.troncgame;

import dagger.Module;

@Module(
        injects = {
                TroncGame.class,
                GameScreen.class
        }
)
public class GameModule {

}