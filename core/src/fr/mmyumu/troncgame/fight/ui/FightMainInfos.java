package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.FightCharacter;
import fr.mmyumu.troncgame.fight.FightConstants;

/**
 * Display the main infos in the Fight Screen
 * Created by mmyumu on 18/12/2015.
 */
public class FightMainInfos extends Table {
    private final I18NBundle bundle;
    private final AssetManager assetManager;
    private final Skin skin;

    private boolean darkened;

    @Inject
    public FightMainInfos(I18NBundle bundle, AssetManager assetManager, Skin skin) {
        this.bundle = bundle;
        this.assetManager = assetManager;
        this.skin = skin;

        initTable();
    }

    public void initFightTeam(List<FightCharacter> fightTeam) {
        initTableLabels(fightTeam);
    }

    private void initTable() {
        setBackground(new TextureRegionDrawable(new TextureRegion(assetManager.get(FightConstants.TexturePath.MAIN_INFOS, Texture.class))));
        setBounds(0, 0, FightConstants.MAIN_INFOS_WIDTH, FightConstants.MAIN_INFOS_HEIGHT);
        setDebug(false);

        top();
        left();
        pad(25);
    }

    private void initTableLabels(List<FightCharacter> fightTeam) {
        row().height(30);
        initHeaderRow();
        row().height(10);
        add(new Label("", skin)).height(10);

        for (FightCharacter character : fightTeam) {
            row().height(FightConstants.MainInfos.ROW_HEIGHT);
            createLabel(character);
        }
    }

    private void createLabel(FightCharacter fightCharacter) {
        Label nameLabel = new Label(fightCharacter.getCharacter().retrieveName(), skin);
        Label hpLabel = new FightHPLabel(fightCharacter, skin);
        Label mpLabel = new FightMPLabel(fightCharacter, skin);
        FightActionBar fightActionBar = new FightActionBar(assetManager, fightCharacter);

        add(nameLabel).width(FightConstants.MainInfos.NAME_WIDTH).left();
        add(hpLabel).width(FightConstants.MainInfos.HP_WIDTH).left();
        add(mpLabel).width(FightConstants.MainInfos.MP_WIDTH).left();
        add(fightActionBar).width(FightConstants.MainInfos.ACTION_BAR_WIDTH).left().pad(5, 20, 5, 20);
    }

    private void initHeaderRow() {
        Label nameLabel = new Label(bundle.get("mainInfos.name"), skin);
        Label hpLabel = new Label(bundle.get("mainInfos.hp"), skin);
        Label mpLabel = new Label(bundle.get("mainInfos.mp"), skin);
        Label actionBarLabel = new Label("", skin);
        add(nameLabel).width(FightConstants.MainInfos.NAME_WIDTH).top().left();
        add(hpLabel).width(FightConstants.MainInfos.HP_WIDTH).top().left();
        add(mpLabel).width(FightConstants.MainInfos.MP_WIDTH).top().left();
        add(actionBarLabel).width(FightConstants.MainInfos.ACTION_BAR_WIDTH).top().center();
    }

    public void setDarkened(boolean darkened) {
        this.darkened = darkened;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (darkened) {
            updateColor(0.5f, 0.5f, 0.5f, 1f);
        }

        super.draw(batch, parentAlpha);

        if (darkened) {
            updateColor(1f, 1f, 1f, 1f);
        }
    }

    private void updateColor(float r, float g, float b, float a) {
        setColor(r, g, b, a);

        for (Cell cell : getCells()) {
            cell.getActor().setColor(r, g, b, a);
        }
    }
}
