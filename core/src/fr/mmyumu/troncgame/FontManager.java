package fr.mmyumu.troncgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by mmyumu on 21/02/2016.
 */
public class FontManager {

    public BitmapFont loadKarmaticArcade(Color color, int size) {
        return loadFont(Constants.FontPath.KARMATIC_ARCADE, color, size);
    }

    private BitmapFont loadFont(String fontPath, Color color, int size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        font.setColor(color);

        return font;
    }
}
