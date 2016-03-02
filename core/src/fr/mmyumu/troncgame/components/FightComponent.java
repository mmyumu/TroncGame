package fr.mmyumu.troncgame.components;

import dagger.Subcomponent;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.game.FightGame;
import fr.mmyumu.troncgame.fight.ui.FightUI;
import fr.mmyumu.troncgame.modules.FightModule;

/**
 * Dagger component to instantiate Fight objects
 * Created by mmyumu on 18/11/2015.
 */
@ActivityScope
@Subcomponent(
        modules = FightModule.class
)
public interface FightComponent {
    FightLoadingScreen createFightLoadingScreen();

    FightScreen createFightScreen();

    FightGame createFightGame();

    FightUI createFightUI();
}
