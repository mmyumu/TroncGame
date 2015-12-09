package fr.mmyumu.troncgame.components;

import javax.inject.Named;

import dagger.Component;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.fight.FightBackground;
import fr.mmyumu.troncgame.fight.FightGameInputProcessor;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightMainCharacter;
import fr.mmyumu.troncgame.fight.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.FightSideKickCharacter;
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

    FightBackground createFightBackground();

    FightMainCharacter createFightMainCharacter();

    FightSideKickCharacter createFightSideKickCharacter();

    FightGameInputProcessor createFightGameInputProcessor();

    @Named("spells") FightPopUpMenuIcon createFightPopUpMenuSpellsIcon();
    @Named("weapons") FightPopUpMenuIcon createFightPopUpMenuWeaponsIcon();
}
