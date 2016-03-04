package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.FontManager;
import fr.mmyumu.troncgame.GameInputProcessor;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.Utils;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.overworld.OverworldConstants;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

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

    @Provides
    @ActivityScope
    AssetManager provideAssetManager() {
        return new AssetManager();
    }

    @Provides
    GameInputProcessor provideGameInputProcessor(GameStatePersister gameStatePersister) {
        return new GameInputProcessor(troncGame, gameStatePersister);
    }

    @Provides
    @ActivityScope
    @Named("pressStart2P-normalSize")
    BitmapFont providePressStart2PNormalSize() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FontPath.PRESS_START_2P));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }

    @Provides
    @ActivityScope
    Skin providePress2PStartSkin(@Named("pressStart2P-normalSize") BitmapFont font) {
        Skin skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal(OverworldConstants.SkinPath.SKIN_ATLAS)));
        skin.add("default-font", font);
        skin.load(Gdx.files.internal(OverworldConstants.SkinPath.SKIN_JSON));

        return skin;
    }

    @Provides
    GameStatePersister provideGameStatePersister(ModelManager modelManager) {
        return new GameStatePersister(modelManager);
    }

    @Provides
    @ActivityScope
    FontManager provideFontManager() {
        return new FontManager();
    }
}
