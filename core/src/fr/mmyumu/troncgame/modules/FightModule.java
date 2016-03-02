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
import fr.mmyumu.troncgame.FontManager;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightLogic;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.fight.game.FightGame;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuNotReady;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import fr.mmyumu.troncgame.fight.ui.FightUI;
import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.ModelConstants;
import fr.mmyumu.troncgame.model.Team;

/**
 * Dagger module to provide Fight
 * Created by mmyumu on 18/11/2015.
 */
@Module
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
    FightScreen provideFightScreen(TroncGame troncGame, AssetManager assetManager, ScalingViewport viewport, FightLogic fightLogic) {
        return new FightScreen(troncGame, assetManager, viewport, fightLogic);
    }

    @Provides
    @ActivityScope
    @Named("spells")
    FightPopUpMenuIcon provideFightPopUpMenuSpellIcon(AssetManager assetManager, I18NBundle bundle, FontManager fontManager) {
        return new FightPopUpMenuIcon(FightConstants.TexturePath.SPELLS_ICON, CompassPoint.NORTH, assetManager, bundle.get("fight.spells"), fontManager, false);
    }

    @Provides
    @ActivityScope
    @Named("weapons")
    FightPopUpMenuIcon provideFightPopUpMenuWeaponsIcon(AssetManager assetManager, I18NBundle bundle, FontManager fontManager) {
        return new FightPopUpMenuIcon(FightConstants.TexturePath.WEAPONS_ICON, CompassPoint.SOUTH, assetManager, bundle.get("fight.attack"), fontManager, true);
    }

    @Provides
    @ActivityScope
    FightPopUpMenuNotReady provideFightPopUpMenuNotReady(I18NBundle bundle, Skin skin) {
        return new FightPopUpMenuNotReady(bundle, skin);
    }

    @Provides
    @ActivityScope
    FightMainInfos provideFightMainInfos(I18NBundle bundle, AssetManager assetManager, Skin skin) {
        return new FightMainInfos(bundle, assetManager, skin);
    }

    @Provides
    @ActivityScope
    FightGame provideFightGame(ScalingViewport viewport) {
        return new FightGame(viewport);
    }

    @Provides
    @ActivityScope
    FightUI provideFightUI(ScalingViewport viewport) {
        return new FightUI(viewport);
    }

    @Provides
    @ActivityScope
    EnemyFightTeamGenerator provideEnemyFightTeamGenerator(AssetManager assetManager, @Named(ModelConstants.Identifier.MAIN_CHARACTER) GameCharacter mainCharacter, Skin skin) {
        return new EnemyFightTeamGenerator(assetManager, mainCharacter, skin);
    }

    @Provides
    FightPopUpMenuLogic provideFightPopUpMenuLogic(AssetManager assetManager, FightPopUpMenuNotReady fightPopUpMenuNotReady, @Named("spells") FightPopUpMenuIcon fightPopUpMenuSpellsIcon, @Named("weapons") FightPopUpMenuIcon fightPopUpMenuWeaponsIcon) {
        return new FightPopUpMenuLogic(assetManager, fightPopUpMenuNotReady, fightPopUpMenuSpellsIcon, fightPopUpMenuWeaponsIcon);
    }

    @Provides
    FightLogic provideFightLogic(AssetManager assetManager, I18NBundle bundle, Skin skin, Team team, EnemyFightTeamGenerator enemyFightTeamGenerator, FightPopUpMenuLogic fightPopUpMenuLogic) {
        return new FightLogic(assetManager, bundle, skin, team, enemyFightTeamGenerator, fightPopUpMenuLogic);
    }
}
