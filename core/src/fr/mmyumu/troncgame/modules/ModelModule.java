package fr.mmyumu.troncgame.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.model.Team;

/**
 * Dagger module to provide Overworld
 * Created by mmyumu on 07/11/2015.
 */
@Module(includes = {GameModule.class})
public class ModelModule {
    @Provides
    @ActivityScope
    @Named("main")
    GameCharacter provideMainCharacter() {
        GameCharacter character = new GameCharacter();
        character.setFightTexturePath(FightConstants.TexturePath.MAIN_CHARACTER);
        character.setName("Sophie");
        character.setHp(9999);
        character.setMp(999);
        character.setActionSpeed(40);
        return character;
    }

    @Provides
    @ActivityScope
    @Named("sideKick")
    GameCharacter provideSideKickCharacter() {
        GameCharacter character = new GameCharacter();
        character.setFightTexturePath(FightConstants.TexturePath.SIDEKICK_CHARACTER);
        character.setName("Le poto");
        character.setHp(9999);
        character.setMp(999);
        character.setActionSpeed(20);
        return character;
    }

    @Provides
    @ActivityScope
    Team provideTeam(@Named("main") GameCharacter mainCharacter, @Named("sideKick") GameCharacter sideKickCharacter) {
        Team team = new Team();
        team.add(mainCharacter);
        team.add(sideKickCharacter);
        return team;
    }
}
