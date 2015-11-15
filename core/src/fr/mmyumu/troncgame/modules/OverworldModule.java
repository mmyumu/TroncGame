package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import fr.mmyumu.troncgame.overworld.OverworldScreen;

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
}
