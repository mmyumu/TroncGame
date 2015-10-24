package fr.mmyumu.troncgame;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mmyumu on 24/10/2015.
 */
@Module
public class GameModule {

    private TroncGame troncGame;

    public GameModule(TroncGame troncGame) {
        this.troncGame = troncGame;
    }

    @Provides
    public TroncGame provideTroncGame() {
        return troncGame;
    }
}
