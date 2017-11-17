package fr.mmyumu.troncgame.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.dialog.theme.DialogTheme;
import fr.mmyumu.troncgame.model.manager.ThemeManager;

/**
 * Manage dialogs: position, characters, text
 * Created by mmyumu on 06/03/2016.
 */
public class DialogManager extends InputAdapter {
    private static final float MARGIN = 20f;
    private final AssetManager assetManager;
    private final I18NBundle bundle;
    private final ThemeManager themeManager;
    private final List<DialogListener> dialogListeners;
    private final List<DialogLine> lines;
    private float x;
    private float y;
    private float width;
    private float height;
    private DialogTheme dialogTheme;
    private int lineIndex;
    private DialogLine currentLine;

    private InputProcessor previousInputProcessor;

    @Inject
    public DialogManager(AssetManager assetManager, I18NBundle bundle, ThemeManager themeManager) {
        this.assetManager = assetManager;
        this.bundle = bundle;
        this.themeManager = themeManager;

        dialogListeners = new ArrayList<>();
        lines = new ArrayList<>();

        lineIndex = 0;
    }

    public void addListener(DialogListener listener) {
        dialogListeners.add(listener);
    }

    public void addLine(BitmapFont font, int align, String text, List<DialogCharacter> characters, DialogMode mode, float timer) {
        lines.add(new DialogLine(bundle, font, x, y, width, height, align, text, characters, mode, timer));
    }

    public void update(float delta) {
        currentLine.update(delta);
    }

    public void draw(Batch batch, float parentAlpha) {
        dialogTheme.draw(batch, parentAlpha, assetManager, x - MARGIN, y - MARGIN, width + (MARGIN * 2), height + (MARGIN * 2));
        currentLine.draw(batch, parentAlpha);
    }

    public void start() {
        previousInputProcessor = Gdx.input.getInputProcessor();
        Gdx.input.setInputProcessor(this);

        if (!lines.isEmpty()) {
            currentLine = lines.get(lineIndex);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (currentLine.isFullyDisplayed()) {
            if (isFullyDisplayed()) {
                Gdx.input.setInputProcessor(previousInputProcessor);
                fireDialogOver();
            } else {
                lineIndex++;
                currentLine = lines.get(lineIndex);
            }
        } else {
            currentLine.skip();
        }
        return super.touchDown(screenX, screenY, pointer, button);
    }

    private void fireDialogOver() {
        for (DialogListener listener : dialogListeners) {
            listener.dialogOver();
        }
    }

    public boolean isFullyDisplayed() {
        return currentLine.isFullyDisplayed() && (lines.isEmpty() || lines.size() - 1 == lineIndex);
    }

    public void init(float x, float y, float width, float height, String theme) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dialogTheme = themeManager.getDialogThemes().get(theme);
    }
}
