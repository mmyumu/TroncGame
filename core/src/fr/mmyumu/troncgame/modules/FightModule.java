package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.fight.FightBackground;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightMainCharacter;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.FightSideKickCharacter;

/**
 * Dagger module to provide Fight
 * Created by mmyumu on 18/11/2015.
 */
@Module(includes = {GameModule.class})
public class FightModule {
    @Provides
    @ActivityScope
    FightLoadingScreen provideFightLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        return new FightLoadingScreen(troncGame, assetManager);
    }

    @Provides
    @ActivityScope
    FightScreen provideFightScreen(TroncGame troncGame, AssetManager assetManager, OrthographicCamera camera) {
        return new FightScreen(troncGame, assetManager, camera);
    }

    @Provides
    @ActivityScope
    FightBackground provideFightBackground(AssetManager assetManager) {
        return new FightBackground(assetManager);
    }

    @Provides
    @ActivityScope
    FightMainCharacter provideFightMainCharacter(AssetManager assetManager) {
        return new FightMainCharacter(assetManager);
    }

    @Provides
    @ActivityScope
    FightSideKickCharacter provideFightSideKickCharacter(AssetManager assetManager) {
        return new FightSideKickCharacter(assetManager);
    }
}
