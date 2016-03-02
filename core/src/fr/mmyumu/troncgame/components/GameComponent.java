package fr.mmyumu.troncgame.components;

import dagger.Subcomponent;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.GameInputProcessor;
import fr.mmyumu.troncgame.GameLoadingScreen;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.modules.FightModule;
import fr.mmyumu.troncgame.modules.GameModule;
import fr.mmyumu.troncgame.modules.MainMenuModule;
import fr.mmyumu.troncgame.modules.OverworldModule;

/**
 * Dagger component of the game
 * Created by mmyumu on 24/10/2015.
 */
@ActivityScope
@Subcomponent(
        modules = {GameModule.class}
)
public interface GameComponent {
    void inject(TroncGame troncGame);

    GameInputProcessor createGameInputProcessor();

    GameLoadingScreen loadingScreen();

    /* Sub components */
    FightComponent createFightComponent(FightModule fightModule);

    MainMenuComponent createMainMenuComponent(MainMenuModule mainMenuModule);

    OverworldComponent createOverworldComponent(OverworldModule overworldModule);

    IntroductionComponent createIntroductionComponent();
}
