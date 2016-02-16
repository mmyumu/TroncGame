package fr.mmyumu.troncgame.components;

import javax.inject.Named;

import dagger.Component;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.ModelConstants;
import fr.mmyumu.troncgame.model.Weapon;
import fr.mmyumu.troncgame.modules.GameModule;
import fr.mmyumu.troncgame.modules.ModelModule;

/**
 * Dagger component of the game
 * Created by mmyumu on 24/10/2015.
 */
@ActivityScope
@Component(
        modules = {ModelModule.class}
)
public interface ModelComponent {
    /* Sub components */
    GameComponent createGameComponent(GameModule gameModule);

    @Named(ModelConstants.Identifier.MAIN_CHARACTER)
    GameCharacter mainCharacter();
}
