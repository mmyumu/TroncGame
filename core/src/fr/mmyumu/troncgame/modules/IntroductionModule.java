package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.introduction.IntroductionLoadingScreen;
import fr.mmyumu.troncgame.introduction.IntroductionScreen;
import fr.mmyumu.troncgame.model.manager.ModelManager;

/**
 * Dagger module to provide Main Menu
 * Created by mmyumu on 07/11/2015.
 */
@Module
public class IntroductionModule {
    @Provides
    @ActivityScope
    IntroductionLoadingScreen provideIntroductionLoadingScreen(TroncGame troncGame, AssetManager assetManager, ModelManager modelManager) {
        return new IntroductionLoadingScreen(troncGame, assetManager, modelManager);
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
    IntroductionScreen provideIntroductionScreen(TroncGame troncGame, ScalingViewport viewport) {
        return new IntroductionScreen(troncGame, viewport);
    }
}
