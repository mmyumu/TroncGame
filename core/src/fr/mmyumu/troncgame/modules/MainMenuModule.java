package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenu;
import fr.mmyumu.troncgame.menu.main.MainMenuContinue;
import fr.mmyumu.troncgame.menu.main.MainMenuLoadingScreen;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;
import fr.mmyumu.troncgame.menu.main.MainMenuStart;
import fr.mmyumu.troncgame.model.manager.ItemManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

/**
 * Dagger module to provide Main Menu
 * Created by mmyumu on 07/11/2015.
 */
@Module
public class MainMenuModule {
    @Provides
    @ActivityScope
    MainMenuLoadingScreen provideMainMenuLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        return new MainMenuLoadingScreen(troncGame, assetManager);
    }

    @Provides
    @ActivityScope
    OrthographicCamera provideOrthographicCamera() {
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false);
        return camera;
    }

    @Provides
    @ActivityScope
    ScalingViewport provideViewport(OrthographicCamera camera) {
        return new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT, camera);
    }

    @Provides
    @ActivityScope
    MainMenuScreen provideMainMenuScreen(TroncGame troncGame, ScalingViewport viewport, GameStatePersister gameStatePersister) {
        return new MainMenuScreen(troncGame, viewport, gameStatePersister);
    }

    @Provides
    @ActivityScope
    MainMenu provideMainMenu(ScalingViewport viewport) {
        return new MainMenu(viewport);
    }

    @Provides
    @ActivityScope
    MainMenuStart provideMainMenuStart(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle, GameStatePersister gameStatePersister, ItemManager itemManager) {
        return new MainMenuStart(troncGame, assetManager, bundle, gameStatePersister, itemManager, 400);
    }

    @Provides
    @ActivityScope
    MainMenuContinue provideMainMenuContinue(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle, GameStatePersister gameStatePersister) {
        return new MainMenuContinue(troncGame, assetManager, bundle, gameStatePersister, 500);
    }
}
