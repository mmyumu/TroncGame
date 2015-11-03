package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.Utils;

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

    @Provides
    @ActivityScope
    public Utils provideUtils() {
        return new Utils();
    }

    @Provides
    @ActivityScope
    public I18NBundle provideI18NBundle() {
        FileHandle baseFileHandle = Gdx.files.internal("i18n/myBundle");

//        Locale locale = new Locale("fr", "CA", "VAR1");
        return I18NBundle.createBundle(baseFileHandle, Locale.getDefault());
    }
}
