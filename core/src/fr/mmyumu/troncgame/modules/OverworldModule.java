package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPSActor;
import fr.mmyumu.troncgame.overworld.ui.OverworldUIStage;

/**
 * Dagger module to provide Overworld
 * Created by mmyumu on 07/11/2015.
 */
@Module(includes = {GameModule.class})
public class OverworldModule {
    @Provides
    @ActivityScope
    OverworldLoadingScreen provideOverworldLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        return new OverworldLoadingScreen(troncGame, assetManager);
    }

    @Provides
    @ActivityScope
    OverworldScreen provideOverworldScreen(TroncGame troncGame, AssetManager assetManager) {
        return new OverworldScreen(troncGame, assetManager);
    }

    @Provides
    @ActivityScope
    OverworldUIStage provideOverworldUIStage(TroncGame troncGame) {
        return new OverworldUIStage(troncGame);
    }

    @Provides
    @ActivityScope
    OverworldFPSActor provideOverworldFPSActor(I18NBundle bundle) {
        return new OverworldFPSActor(bundle);
    }
}
