package fr.mmyumu.troncgame.components;

import javax.inject.Named;

import dagger.Component;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.fight.FightBackground;
import fr.mmyumu.troncgame.fight.FightGame;
import fr.mmyumu.troncgame.fight.FightGameInputProcessor;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightMainCharacter;
import fr.mmyumu.troncgame.fight.FightPopUpMenu;
import fr.mmyumu.troncgame.fight.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.FightSideKickCharacter;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import fr.mmyumu.troncgame.fight.ui.FightUI;
import fr.mmyumu.troncgame.modules.FightModule;

/**
 * Dagger component to instantiate Fight objects
 * Created by mmyumu on 18/11/2015.
 */
@ActivityScope
@Component(
        dependencies = GameComponent.class,
        modules = FightModule.class
)
public interface FightComponent {
    FightLoadingScreen createFightLoadingScreen();

    FightScreen createFightScreen();

    FightGameInputProcessor createFightGameInputProcessor();

    FightGame createFightGame();
    FightPopUpMenu createFightPopUpMenu();
    FightUI createFightUI();
}
