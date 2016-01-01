package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.model.Team;

/**
 * Display the main infos in the Fight Screen
 * Created by mmyumu on 18/12/2015.
 */
public class FightMainInfos extends Table {
    private AssetManager assetManager;
    private Team team;

    @Inject
    public FightMainInfos(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.team = team;

        initTable();
    }

    private void initTable() {
        setBackground(new TextureRegionDrawable(new TextureRegion(assetManager.get(FightConstants.TexturePath.MAIN_INFOS, Texture.class))));
        setBounds(0, 0, FightConstants.MAIN_INFOS_WIDTH, FightConstants.MAIN_INFOS_HEIGHT);
    }
}
