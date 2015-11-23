package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightScreen;

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
    FightScreen provideFightScreen(TroncGame troncGame, AssetManager assetManager) {
        return new FightScreen(troncGame, assetManager);
    }
}
