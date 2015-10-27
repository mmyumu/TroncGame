package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.LoadingScreen;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;
import fr.mmyumu.troncgame.TroncGame;

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
