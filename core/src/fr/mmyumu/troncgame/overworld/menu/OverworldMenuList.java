package fr.mmyumu.troncgame.overworld.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;
import javax.inject.Named;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.overworld.OverworldConstants;

/**
 * The list of different features in menus
 * Created by mmyumu on 27/12/2015.
 */
public class OverworldMenuList extends Table {
    private static final String TAG = "OverworldMenuList";
    private final AssetManager assetManager;
    private final Skin skin;
    private final I18NBundle bundle;

    @Inject
    public OverworldMenuList(AssetManager assetManager, I18NBundle bundle, @Named("press2PStart-normalSize") Skin skin) {
        this.assetManager = assetManager;
        this.bundle = bundle;
        this.skin = skin;

        initTable();
        initMenuLabels();
    }

    private void initTable() {
        setTouchable(Touchable.enabled);
        setBackground(new TextureRegionDrawable(new TextureRegion(assetManager.get(OverworldConstants.TexturePath.MENU_LIST, Texture.class))));
        setBounds(1000, (Constants.HEIGHT - OverworldConstants.MENU_LIST_HEIGHT) / 2, OverworldConstants.MENU_LIST_WIDTH, OverworldConstants.MENU_LIST_HEIGHT);
    }

    private void initMenuLabels() {
        Label exitLabel = new Label(bundle.get("exit"), skin);
        exitLabel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.debug(TAG, "Exit application");
                Gdx.app.exit();
                super.clicked(event, x, y);
            }
        });
        add(exitLabel);
    }
}
