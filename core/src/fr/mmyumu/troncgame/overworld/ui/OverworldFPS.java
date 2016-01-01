package fr.mmyumu.troncgame.overworld.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;

/**
 * Display the FPS in Overworld UI
 * Created by mmyumu on 16/11/2015.
 */
public class OverworldFPS extends Actor {
    private BitmapFont font;
    private final I18NBundle bundle;

    @Inject
    public OverworldFPS(I18NBundle bundle) {
        this.bundle = bundle;
        loadFonts();
    }

    private void loadFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FontPath.PRESS_START_2P));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        font = generator.generateFont(parameter);
        generator.dispose();

        font.setColor(1f, 1f, 1f, 1f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, Gdx.graphics.getFramesPerSecond() + " " + bundle.get("fps"), 5, Constants.HEIGHT - font.getLineHeight());
    }
}
