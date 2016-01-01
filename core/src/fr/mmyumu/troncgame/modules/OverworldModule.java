package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Named;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.game.OverworldCharacter;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenu;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenuList;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS;
import fr.mmyumu.troncgame.overworld.ui.OverworldUI;

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
    OverworldScreen provideOverworldScreen(TroncGame troncGame, AssetManager assetManager, OrthographicCamera camera) {
        return new OverworldScreen(troncGame, assetManager, camera);
    }

    @Provides
    @ActivityScope
    OverworldUI provideOverworldUI(ScalingViewport viewport, TroncGame troncGame, OverworldFPS overworldFPS) {
        return new OverworldUI(viewport, troncGame, overworldFPS);
    }

    @Provides
    @ActivityScope
    OverworldMenu provideOverworldMenu(ScalingViewport viewport, Lazy<OverworldScreen> overworldScreen, OverworldFPS overworldFPS, OverworldMenuList overworldMenuListActor) {
        return new OverworldMenu(viewport, overworldScreen, overworldFPS, overworldMenuListActor);
    }

    @Provides
    @ActivityScope
    @Named("ui")
    OverworldFPS provideOverworldFPSGame(I18NBundle bundle) {
        return new OverworldFPS(bundle);
    }

    @Provides
    @ActivityScope
    @Named("menu")
    OverworldFPS provideOverworldFPSMenu(I18NBundle bundle) {
        return new OverworldFPS(bundle);
    }

    @Provides
    @ActivityScope
    OverworldMenuList provideOverworldMenuList(AssetManager assetManager, I18NBundle bundle, Skin skin) {
        return new OverworldMenuList(assetManager, bundle, skin);
    }

    @Provides
    @ActivityScope
    OverworldCharacter provideOverworldCharacter(AssetManager assetManager, OrthographicCamera camera) {
        return new OverworldCharacter(assetManager, camera);
    }
}
