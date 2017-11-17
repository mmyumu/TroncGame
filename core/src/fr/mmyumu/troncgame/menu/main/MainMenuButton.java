package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.I18NBundle;

import fr.mmyumu.troncgame.Constants;

/**
 * Button of the main menu
 * Created by mmyumu on 31/01/2016.
 */
public abstract class MainMenuButton extends Actor {
    private final AssetManager assetManager;
    private final I18NBundle bundle;

    private Texture mainMenu;
    private BitmapFont font;

    public MainMenuButton(AssetManager assetManager, I18NBundle bundle, int y) {
        this.assetManager = assetManager;
        this.bundle = bundle;

        loadFonts();
        loadTexture();

        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, bundle.get(getPropertyKey()));
        float x = mainMenu.getWidth() / 2 - layout.width / 2;

        setBounds(x, y - layout.height, layout.width, layout.height);

        initListener();
    }

    private void initListener() {
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonClicked(event, x, y);
            }
        });
    }

    private void loadFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FontPath.BM_BLOCK));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 72;
        font = generator.generateFont(parameter);
        generator.dispose();

        font.setColor(1f, 1f, 1f, 1f);
    }

    private void loadTexture() {
        mainMenu = assetManager.get(Constants.TexturePath.MAIN_MENU, Texture.class);
    }

    @Override
    public void draw(Batch batch, float alpha) {
        font.draw(batch, bundle.get(getPropertyKey()), getX(), getY() + getHeight());
    }

    protected abstract void buttonClicked(InputEvent event, float x, float y);

    protected abstract String getPropertyKey();
}
