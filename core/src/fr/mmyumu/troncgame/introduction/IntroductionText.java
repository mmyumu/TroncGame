package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.FontManager;

/**
 * Display the text of the introduction
 * Created by mmyumu on 28/02/2016.
 */
public class IntroductionText extends Actor {
    private static final int TEXT_WIDTH = 1000;
    private static final int TEXT_HEIGHT = 500;
    private final BitmapFont font;
    private boolean fullyDisplayed;

    private String text;
    private int textIndex;
    private float textTime;


    @Inject
    public IntroductionText(I18NBundle bundle, FontManager fontManager, ScalingViewport viewport) {
        this.font = fontManager.loadVisitor(new Color(1f, 1f, 1f, 1f), 64);
        this.fullyDisplayed = false;

        float x = (viewport.getWorldWidth() - TEXT_WIDTH) / 2;
        float y = (viewport.getWorldHeight() - TEXT_HEIGHT) / 2;
        setBounds(x, y, TEXT_WIDTH, TEXT_HEIGHT);

        text = bundle.format("introduction.text");
        textIndex = 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (fullyDisplayed) {
            textIndex = text.length() - 1;
        } else {
            updateText(delta);
        }
    }

    private void updateText(float delta) {
        textTime += delta;
        if (textTime > 0.1) {
            if (textIndex < text.length() - 1) {
                textIndex++;
            } else {
                fullyDisplayed = true;
            }
            textTime = 0;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, text.substring(0, textIndex), getX(), getY() + getHeight(), getWidth(), Align.left, true);
    }

    public boolean isFullyDisplayed() {
        return fullyDisplayed;
    }

    public void setFullyDisplayed(boolean fullyDisplayed) {
        this.fullyDisplayed = fullyDisplayed;
    }
}
