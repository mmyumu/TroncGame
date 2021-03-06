package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuActor;
import fr.mmyumu.troncgame.menu.main.MainMenuLoadingScreen;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;

/**
 * Dagger module to provide Main Menu
 * Created by mmyumu on 07/11/2015.
 */
@Module(includes = {GameModule.class})
public class MainMenuModule {
    @Provides
    @ActivityScope
    MainMenuLoadingScreen provideMainMenuLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        return new MainMenuLoadingScreen(troncGame, assetManager);
    }

    @Provides
    @ActivityScope
    MainMenuScreen provideMainMenuScreen(TroncGame troncGame) {
        return new MainMenuScreen(troncGame);
    }

    @Provides
    @ActivityScope
    MainMenuActor provideMainMenuActor(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle) {
        return new MainMenuActor(troncGame, assetManager, bundle);
    }
}
