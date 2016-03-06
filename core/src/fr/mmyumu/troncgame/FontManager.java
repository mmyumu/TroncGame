package fr.mmyumu.troncgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by mmyumu on 21/02/2016.
 */
public class FontManager {

    public BitmapFont loadKarmaticArcade(Color color, FreeTypeFontGenerator.FreeTypeFontParameter parameters) {
        return loadFont(Constants.FontPath.KARMATIC_ARCADE, color, parameters);
    }

    public BitmapFont loadVisitor(Color color, FreeTypeFontGenerator.FreeTypeFontParameter parameters) {
        return loadFont(Constants.FontPath.VISITOR, color, parameters);
    }

    private BitmapFont loadFont(String fontPath, Color color, FreeTypeFontGenerator.FreeTypeFontParameter parameters) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        BitmapFont font = generator.generateFont(parameters);
        generator.dispose();

        font.setColor(color);

        return font;
    }

    public FreeTypeFontGenerator.FreeTypeFontParameter parameters(int size, int borderWidth) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = size;
        parameters.borderWidth = borderWidth;

        return parameters;
    }
}
