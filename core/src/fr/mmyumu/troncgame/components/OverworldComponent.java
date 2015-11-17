package fr.mmyumu.troncgame.components;

import dagger.Component;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.modules.OverworldModule;
import fr.mmyumu.troncgame.overworld.OverworldGameInputProcessor;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPSActor;
import fr.mmyumu.troncgame.overworld.ui.OverworldUIStage;

/**
 * Dagger component to instantiate Overworld objects
 * Created by mmyumu on 07/11/2015.
 */
@ActivityScope
@Component(
        dependencies = GameComponent.class,
        modules = OverworldModule.class
)
public interface OverworldComponent {
    OverworldLoadingScreen createOverworldLoadingScreen();

    OverworldScreen createOverworldScreen();

    OverworldGameInputProcessor createOverworldGameInputProcessor();

    OverworldUIStage createOverworldUIStage();

    OverworldFPSActor createOverworldFPSActor();
}
