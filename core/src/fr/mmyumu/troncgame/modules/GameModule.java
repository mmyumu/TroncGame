package fr.mmyumu.troncgame.modules;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.TroncGame;

/**
 * Dagger module to provide game
 * Created by mmyumu on 24/10/2015.
 */
@Module
public class GameModule {

    private final TroncGame troncGame;

    public GameModule(TroncGame troncGame) {
        this.troncGame = troncGame;
    }

    @Provides
    public TroncGame provideTroncGame() {
        return troncGame;
    }
}
