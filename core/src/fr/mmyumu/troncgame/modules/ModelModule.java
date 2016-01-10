package fr.mmyumu.troncgame.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.model.GameCharacter;
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
        character.setName("Sophie");
        character.setHp(9999);
        character.setMp(999);
        return character;
    }

    @Provides
    @ActivityScope
    @Named("sideKick")
    GameCharacter provideSideKickCharacter() {
        GameCharacter character = new GameCharacter();
        character.setName("Le poto");
        character.setHp(9999);
        character.setMp(999);
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
