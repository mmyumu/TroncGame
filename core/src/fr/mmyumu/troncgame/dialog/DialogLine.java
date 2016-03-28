package fr.mmyumu.troncgame.dialog;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.List;

/**
 * A line of a dialog. It contains all the informations needed to display a line of dialog which is part of a dialog.
 * Created by mmyumu on 06/03/2016.
 */
public class DialogLine {
    private final List<DialogCharacter> characters;
    private final String text;
    private final DialogMode mode;
    private final I18NBundle bundle;
    private final BitmapFont font;
    private float x;
    private float y;
    private float width;
    private float height;
    private int align;

    private float timer;

    private int textIndex;
    private int startIndex;
    private float textTime;
    private boolean areaFull;


    public DialogLine(I18NBundle bundle, BitmapFont font, float x, float y, float width, float height, int align, String text, List<DialogCharacter> characters, DialogMode mode, float timer) {
        this.bundle = bundle;
        this.font = font;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.align = align;
        this.characters = characters;
        this.mode = mode;
        this.timer = timer;

        this.text = initText(text, characters);

        startIndex = 0;
        textIndex = 0;
    }

    private String initText(String text, List<DialogCharacter> characters) {
        if(characters == null) {
            return text;
        }

        StringBuilder finalText = new StringBuilder();
        boolean first = true;
        for (DialogCharacter character : characters) {
            if (!first) {
                finalText.append(", ");
            }
            finalText.append(character.getCharacter().getDefinition().getName());
            first = false;
        }
        finalText.append(bundle.get("colon"));
        finalText.append(" ");
        finalText.append(text);
        return finalText.toString();
    }

    public void update(float delta) {
        if (!isFullyDisplayed()) {
            updateText(delta);
        }
    }

    public boolean isFullyDisplayed() {
        return text.length() - 1 == textIndex;
    }

    private void updateText(float delta) {
        textTime += delta;
        if (textTime > timer) {
            if (textIndex < text.length() - 1) {
                if (isOutOfBound()) {
                    areaFull = true;
                } else {
                    textIndex++;
                }
            }
            textTime = 0;
        }
    }

    private boolean isOutOfBound() {
        return isOutOfBound(textIndex);
    }

    private boolean isOutOfBound(int index) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, getNextWordText(index), font.getColor(), width, align, true);

        return glyphLayout.height >= height;
    }

    public void draw(Batch batch, float parentAlpha) {
        Color color = font.getColor();
        color.a *= parentAlpha;

        font.draw(batch, getCurrentText(), x, y + height, width, align, true);
    }

    private CharSequence getCurrentText() {
        return text.substring(startIndex, textIndex);
    }

    private CharSequence getNextWordText(int index) {
        if(text.charAt(textIndex) ==  ' ') {
            return text.substring(startIndex, index + 1);
        }

        int nextWordIndex = text.indexOf(" ", index);
        if (nextWordIndex < 0) {
            nextWordIndex = text.length() - 1;
        }
        return text.substring(startIndex, nextWordIndex);
    }

    public void skip() {
        if (areaFull) {
            displayNextArea();
        } else {
            displayFullArea();
        }
    }

    private void displayNextArea() {
        startIndex = textIndex;
        areaFull = false;
    }

    private void displayFullArea() {
        for (int index = startIndex; index < text.length(); index++) {
            if (isOutOfBound(index) || index == text.length() - 1) {
                textIndex = index - 1;
                areaFull = true;
                break;
            }
        }
    }
}
