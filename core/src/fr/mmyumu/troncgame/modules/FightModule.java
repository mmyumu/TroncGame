package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.CompassPoint;
import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.fight.FightBackground;
import fr.mmyumu.troncgame.fight.FightCharacter;
import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.fight.FightGame;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import fr.mmyumu.troncgame.fight.ui.FightUI;
import fr.mmyumu.troncgame.model.Team;

/**
 * Dagger module to provide Fight
 * Created by mmyumu on 18/11/2015.
 */
@Module(includes = {GameModule.class, ModelModule.class})
public class FightModule {
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
    FightLoadingScreen provideFightLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        return new FightLoadingScreen(troncGame, assetManager);
    }

    @Provides
    @ActivityScope
    FightScreen provideFightScreen(TroncGame troncGame, AssetManager assetManager, ScalingViewport viewport) {
        return new FightScreen(troncGame, assetManager, viewport);
    }

    @Provides
    @ActivityScope
    FightBackground provideFightBackground(AssetManager assetManager) {
        return new FightBackground(assetManager);
    }

    @Provides
    @ActivityScope
    @Named("spells")
    FightPopUpMenuIcon provideFightPopUpMenuSpellIcon(AssetManager assetManager) {
        return new FightPopUpMenuIcon(FightConstants.TexturePath.SPELLS_ICON, CompassPoint.NORTH, assetManager);
    }

    @Provides
    @ActivityScope
    @Named("weapons")
    FightPopUpMenuIcon provideFightPopUpMenuWeaponsIcon(AssetManager assetManager) {
        return new FightPopUpMenuIcon(FightConstants.TexturePath.WEAPONS_ICON, CompassPoint.SOUTH, assetManager);
    }

    @Provides
    @ActivityScope
    FightMainInfos provideFightMainInfos(I18NBundle bundle, AssetManager assetManager, Skin skin, Team team) {
        return new FightMainInfos(bundle, assetManager, skin, team);
    }

    @Provides
    @ActivityScope
    FightGame provideFightGame(ScalingViewport viewport, AssetManager assetManager, FightBackground fightBackground, Team team) {
        return new FightGame(viewport, assetManager, fightBackground, team);
    }

    @Provides
    @ActivityScope
    FightUI provideFightUI(ScalingViewport viewport, FightMainInfos fightMainInfos) {
        return new FightUI(viewport, fightMainInfos);
    }
}
