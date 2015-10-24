package fr.mmyumu.troncgame;

import com.badlogic.gdx.assets.AssetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mmyumu on 24/10/2015.
 */
@Module(includes = {GameModule.class})
public class ScreenModule {
    @Provides
    @ActivityScope
    AssetManager provideAssetManager() {
        return new AssetManager();
    }

    @Provides
    @ActivityScope
    LoadingScreen provideLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        return new LoadingScreen(troncGame, assetManager);
    }

    @Provides
    @ActivityScope
    MainMenuScreen provideMainMenuScreen(TroncGame troncGame, AssetManager assetManager) {
        return new MainMenuScreen(troncGame, assetManager);
    }
}
