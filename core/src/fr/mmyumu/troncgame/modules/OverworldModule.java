package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.I18NBundle;

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
import fr.mmyumu.troncgame.overworld.ui.OverworldFPSActor;
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
    OverworldUI provideOverworldUIStage(TroncGame troncGame, OverworldFPSActor overworldFPSActor) {
        return new OverworldUI(troncGame, overworldFPSActor);
    }

    @Provides
    @ActivityScope
    OverworldMenu provideOverworldMenuStage(Lazy<OverworldScreen> overworldScreen, OverworldFPSActor overworldFPSActor, OverworldMenuList overworldMenuListActor) {
        return new OverworldMenu(overworldScreen, overworldFPSActor, overworldMenuListActor);
    }

    @Provides
    @ActivityScope
    @Named("ui")
    OverworldFPSActor provideOverworldFPSGameActor(I18NBundle bundle) {
        return new OverworldFPSActor(bundle);
    }

    @Provides
    @ActivityScope
    @Named("menu")
    OverworldFPSActor provideOverworldFPSMenuActor(I18NBundle bundle) {
        return new OverworldFPSActor(bundle);
    }

    @Provides
    @ActivityScope
    OverworldMenuList provideOverworldMenuList(AssetManager assetManager, I18NBundle bundle) {
        return new OverworldMenuList(assetManager, bundle);
    }

    @Provides
    @ActivityScope
    OverworldCharacter provideOverworldCharacter(AssetManager assetManager, OrthographicCamera camera) {
        return new OverworldCharacter(assetManager, camera);
    }
}
