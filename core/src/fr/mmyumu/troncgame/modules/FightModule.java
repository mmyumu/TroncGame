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
import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.fight.FightGame;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightLogic;
import fr.mmyumu.troncgame.fight.FightPopUpMenu;
import fr.mmyumu.troncgame.fight.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.fight.FightPopUpMenuNotReady;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import fr.mmyumu.troncgame.fight.ui.FightUI;
import fr.mmyumu.troncgame.model.GameCharacter;
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
    FightScreen provideFightScreen(TroncGame troncGame, AssetManager assetManager, ScalingViewport viewport, FightGame fightGame, FightPopUpMenu fightPopUpMenu, FightUI fightUI, FightLogic fightLogic) {
        return new FightScreen(troncGame, assetManager, viewport, fightGame, fightPopUpMenu, fightUI, fightLogic);
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
        return new FightPopUpMenuIcon(FightConstants.TexturePath.SPELLS_ICON, CompassPoint.NORTH, assetManager, false);
    }

    @Provides
    @ActivityScope
    @Named("weapons")
    FightPopUpMenuIcon provideFightPopUpMenuWeaponsIcon(AssetManager assetManager) {
        return new FightPopUpMenuIcon(FightConstants.TexturePath.WEAPONS_ICON, CompassPoint.SOUTH, assetManager, true);
    }

    @Provides
    @ActivityScope
    FightPopUpMenuNotReady provideFightPopUpMenuNotReady(I18NBundle bundle, Skin skin) {
        return new FightPopUpMenuNotReady(bundle, skin);
    }

    @Provides
    @ActivityScope
    FightMainInfos provideFightMainInfos(I18NBundle bundle, AssetManager assetManager, Skin skin, FightLogic fightLogic) {
        return new FightMainInfos(bundle, assetManager, skin, fightLogic);
    }

    @Provides
    @ActivityScope
    FightGame provideFightGame(ScalingViewport viewport, FightBackground fightBackground, FightLogic fightLogic) {
        return new FightGame(viewport, fightBackground, fightLogic);
    }

    @Provides
    @ActivityScope
    FightUI provideFightUI(ScalingViewport viewport, FightMainInfos fightMainInfos) {
        return new FightUI(viewport, fightMainInfos);
    }

    @Provides
    @ActivityScope
    EnemyFightTeamGenerator provideEnemyFightTeamGenerator(AssetManager assetManager, @Named("main") GameCharacter mainCharacter) {
        return new EnemyFightTeamGenerator(assetManager, mainCharacter);
    }

    @Provides
    @ActivityScope
    FightPopUpMenuLogic provideFightPopUpMenuLogic(FightPopUpMenuNotReady fightPopUpMenuNotReady, @Named("spells") FightPopUpMenuIcon fightPopUpMenuSpellsIcon, @Named("weapons") FightPopUpMenuIcon fightPopUpMenuWeaponsIcon) {
        return new FightPopUpMenuLogic(fightPopUpMenuNotReady, fightPopUpMenuSpellsIcon, fightPopUpMenuWeaponsIcon);
    }

    @Provides
    @ActivityScope
    FightLogic provideFightLogic(AssetManager assetManager, Team team, EnemyFightTeamGenerator enemyFightTeamGenerator, FightPopUpMenuLogic fightPopUpMenuLogic) {
        return new FightLogic(assetManager, team, enemyFightTeamGenerator, fightPopUpMenuLogic);
    }
}
