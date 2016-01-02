package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.model.Character;
import fr.mmyumu.troncgame.model.Team;

/**
 * Display the main infos in the Fight Screen
 * Created by mmyumu on 18/12/2015.
 */
public class FightMainInfos extends Table {
    private final I18NBundle bundle;
    private final AssetManager assetManager;
    private final Skin skin;
    private final Team team;

    @Inject
    public FightMainInfos(I18NBundle bundle, AssetManager assetManager, Skin skin, Team team) {
        this.bundle = bundle;
        this.assetManager = assetManager;
        this.skin = skin;
        this.team = team;

        initTable();
        initTableLabels();
    }

    private void initTable() {
        setBackground(new TextureRegionDrawable(new TextureRegion(assetManager.get(FightConstants.TexturePath.MAIN_INFOS, Texture.class))));
        setBounds(0, 0, FightConstants.MAIN_INFOS_WIDTH, FightConstants.MAIN_INFOS_HEIGHT);
        setDebug(false);

        top();
        left();
        pad(25);
    }

    private void initTableLabels() {
        row().height(30);
        initHeaderRow();
        row().height(10);
        add(new Label("", skin)).height(10);

        for (Character character : team.getCharacters()) {
//            row().height(10);
//            add(new Label("", skin)).height(10);
            row().height(FightConstants.MainInfos.ROW_HEIGHT);
            createLabel(character);
        }
    }

    private void createLabel(Character character) {
        Label nameLabel = new Label(character.getName(), skin);
        Label hpLabel = new Label(character.getHp().toString(), skin);
        Label mpLabel = new Label(character.getMp().toString(), skin);
        FightActionBar fightActionBar = new FightActionBar(assetManager, character);

        add(nameLabel).width(FightConstants.MainInfos.NAME_WIDTH).left();
        add(hpLabel).width(FightConstants.MainInfos.HP_WIDTH).left();
        add(mpLabel).width(FightConstants.MainInfos.MP_WIDTH).left();
        add(fightActionBar).width(FightConstants.MainInfos.ACTION_BAR_WIDTH).left().pad(5, 20, 5, 20);
    }

    private void initHeaderRow() {
        Label nameLabel = new Label(bundle.get("mainInfos.name"), skin);
        Label hpLabel = new Label(bundle.get("mainInfos.hp").toString(), skin);
        Label mpLabel = new Label(bundle.get("mainInfos.mp").toString(), skin);
        Label actionBarLabel = new Label("", skin);
        add(nameLabel).width(FightConstants.MainInfos.NAME_WIDTH).top().left();
        add(hpLabel).width(FightConstants.MainInfos.HP_WIDTH).top().left();
        add(mpLabel).width(FightConstants.MainInfos.MP_WIDTH).top().left();
        add(actionBarLabel).width(FightConstants.MainInfos.ACTION_BAR_WIDTH).top().center();
    }
}
