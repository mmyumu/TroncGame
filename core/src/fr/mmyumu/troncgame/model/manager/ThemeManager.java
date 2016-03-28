package fr.mmyumu.troncgame.model.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import fr.mmyumu.troncgame.dialog.theme.DialogTheme;
import fr.mmyumu.troncgame.model.ModelConstants;

/**
 * Manage the themes of the game
 * Created by mmyumu on 27/03/2016.
 */
public class ThemeManager {
    private static final String TAG = "ThemeManager";
    private static final float MAX_COLOR_VALUE = 255;
    private Map<String, DialogTheme> dialogThemes;

    @Inject
    public ThemeManager() {
        this.dialogThemes = new HashMap<String, DialogTheme>();

        try {
            loadXml();
        } catch (IOException e) {
            Gdx.app.error(TAG, "The themes XML file cannot be parsed.");
        }
    }

    private void loadXml() throws IOException {
        XmlReader reader = new XmlReader();
        XmlReader.Element root = reader.parse(new FileHandle(ModelConstants.DataPath.THEMES));
        Array<XmlReader.Element> dialogElements = root.getChildrenByName("dialog");
        for (XmlReader.Element dialogElement : dialogElements) {
            String id = dialogElement.getAttribute("id");

            String topTexturePath = dialogElement.getChildByName("top").getText();
            String bottomTexturePath = dialogElement.getChildByName("bottom").getText();
            String leftTexturePath = dialogElement.getChildByName("left").getText();
            String rightTexturePath = dialogElement.getChildByName("right").getText();

            String topLeftTexturePath = dialogElement.getChildByName("topLeft").getText();
            String topRightTexturePath = dialogElement.getChildByName("topRight").getText();
            String bottomLeftTexturePath = dialogElement.getChildByName("bottomLeft").getText();
            String bottomRightTexturePath = dialogElement.getChildByName("bottomRight").getText();

            Color color = new Color();
            Array<XmlReader.Element> backgroundColorElements = dialogElement.getChildrenByName("backgroundColor");
            for (XmlReader.Element backgroundColorElement : backgroundColorElements) {
                Float red = Float.valueOf(backgroundColorElement.getChildByName("red").getText());
                Float green = Float.valueOf(backgroundColorElement.getChildByName("green").getText());
                Float blue = Float.valueOf(backgroundColorElement.getChildByName("blue").getText());

                color.set(red / MAX_COLOR_VALUE, green / MAX_COLOR_VALUE, blue / MAX_COLOR_VALUE, 1);
            }

            DialogTheme dialogTheme = new DialogTheme(topTexturePath, bottomTexturePath, leftTexturePath, rightTexturePath, topLeftTexturePath, topRightTexturePath, bottomLeftTexturePath, bottomRightTexturePath, color);
            dialogThemes.put(id, dialogTheme);
        }
    }

    public Map<String, DialogTheme> getDialogThemes() {
        return dialogThemes;
    }


    public interface ID {
        String BROWN = "dialog.brown";
    }
}
