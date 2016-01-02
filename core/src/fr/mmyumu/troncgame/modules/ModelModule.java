package fr.mmyumu.troncgame.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.model.Character;
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
    Character provideMainCharacter() {
        Character character = new Character();
        character.setName("Sophie");
        character.setHp(9999);
        character.setMp(999);
        return character;
    }

    @Provides
    @ActivityScope
    @Named("sideKick")
    Character provideSideKickCharacter() {
        Character character = new Character();
        character.setName("Le poto");
        character.setHp(9999);
        character.setMp(999);
        return character;
    }

    @Provides
    @ActivityScope
    Team provideTeam(@Named("main") Character mainCharacter, @Named("sideKick") Character sideKickCharacter) {
        Team team = new Team();
        team.add(mainCharacter);
        team.add(sideKickCharacter);
        return team;
    }
}
