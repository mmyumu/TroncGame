package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.FontManager;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.dialog.DialogCharacter;
import fr.mmyumu.troncgame.dialog.DialogListener;
import fr.mmyumu.troncgame.dialog.DialogManager;
import fr.mmyumu.troncgame.dialog.DialogMode;
import fr.mmyumu.troncgame.dialog.DialogSlot;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import fr.mmyumu.troncgame.model.manager.ThemeManager;

/**
 * Display the text of the introduction
 * Created by mmyumu on 28/02/2016.
 */
public class IntroductionText extends Actor implements DialogListener {
    private static final int TEXT_WIDTH = 1000;
    private static final int TEXT_HEIGHT = 500;

    private TroncGame troncGame;
    private final DialogManager dialogManager;


    @Inject
    public IntroductionText(TroncGame troncGame, I18NBundle bundle, DialogManager dialogManager, FontManager fontManager, ThemeManager themeManager, CharacterManager characterManager, AssetManager assetManager, ScalingViewport viewport) {
        this.troncGame = troncGame;
        this.dialogManager = dialogManager;

        float x = (viewport.getWorldWidth() - TEXT_WIDTH) / 2;
        float y = (viewport.getWorldHeight() - TEXT_HEIGHT) / 2;
        setBounds(x, y, TEXT_WIDTH, TEXT_HEIGHT);

        setColor(188, 170, 164, 1);

        BitmapFont fontVisitor = fontManager.loadVisitor(new Color(1f, 1f, 1f, 1f), fontManager.parameters(64, 2));
//        BitmapFont fontKarmatic = fontManager.loadKarmaticArcade(new Color(1f, 1f, 1f, 1f), fontManager.parameters(50, 0));

        List<DialogCharacter> loremIpsumCharacters = new ArrayList<DialogCharacter>();
        loremIpsumCharacters.add(new DialogCharacter(characterManager.getTeam().getMainCharacter(), DialogSlot.LEFT));
        loremIpsumCharacters.add(new DialogCharacter(characterManager.getTeam().getSideKickCharacter(), DialogSlot.RIGHT));

        dialogManager.init(getX(), getY(), getWidth(), getHeight(), ThemeManager.ID.BROWN);
        dialogManager.addListener(this);
        dialogManager.addLine(fontVisitor, Align.left, bundle.format("introduction.text"), null, DialogMode.CHARACTER_BY_CHARACTER, 0.05f);
        dialogManager.addLine(fontVisitor, Align.left, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", loremIpsumCharacters, DialogMode.CHARACTER_BY_CHARACTER, 0.05f);
        dialogManager.start();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        dialogManager.update(delta);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        dialogManager.draw(batch, parentAlpha);
    }

    @Override
    public void dialogOver() {
        troncGame.setScreen(troncGame.getOverworldComponent().createOverworldLoadingScreen());
    }
}
