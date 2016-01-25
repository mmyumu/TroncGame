package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.Team;

/**
 * Manage the logic of the Fight
 * Created by mmyumu on 17/01/2016.
 */
public class FightLogic {
    private static final String TAG = "FightLogic";

    private final AssetManager assetManager;
    private final I18NBundle bundle;
    private final Skin skin;
    private final Team team;
    private final EnemyFightTeamGenerator enemyFightTeamGenerator;
    private final FightPopUpMenuLogic popUpMenuLogic;

    private FightCharacter selectedCharacter;
    private FightPopUpMenuIcon selectedIcon;
    private FightCharacter targetCharacter;

    private FightBackground fightBackground;
    private List<FightCharacter> fightTeam;
    private List<FightCharacter> enemyFightTeam;
    private FightMainInfos fightMainInfos;

    private FightState fightState;


    @Inject
    public FightLogic(AssetManager assetManager, I18NBundle bundle, Skin skin, Team team, EnemyFightTeamGenerator enemyFightTeamGenerator, FightPopUpMenuLogic popUpMenuLogic) {
        this.assetManager = assetManager;
        this.bundle = bundle;
        this.skin = skin;
        this.team = team;
        this.enemyFightTeamGenerator = enemyFightTeamGenerator;
        this.popUpMenuLogic = popUpMenuLogic;

        startNew();
    }

    public void startNew() {
        resetCharacterSelection();

        fightBackground = new FightBackground(assetManager);
        enemyFightTeam = enemyFightTeamGenerator.generate();
        fightTeam = createFightTeam();

        fightMainInfos = new FightMainInfos(bundle, assetManager, skin);
        fightMainInfos.initFightTeam(fightTeam);
    }

    private List<FightCharacter> createFightTeam() {
        List<FightCharacter> fightTeam = new ArrayList<FightCharacter>();
        int i = 0;
        for (GameCharacter character : team.getCharacters()) {
            FightCharacter fightCharacter = new FightCharacter(100, FightConstants.MAIN_INFOS_HEIGHT + 20 + 200 * i, character, assetManager.get(character.getFightTexturePath(), Texture.class), true);
            fightTeam.add(fightCharacter);
            i++;
        }

        return fightTeam;
    }

    public void iconTouched(FightPopUpMenuIcon touchedIcon) {
        Gdx.app.debug(TAG, "Icon touched [" + touchedIcon.getName() + "]");
        selectedIcon = touchedIcon;

        switch (fightState) {
            case CHARACTER_SELECTED:
            case ACTION_SELECTED:
                if (selectedIcon.isAction()) {
                    fightState = FightState.ACTION_SELECTED;
                }
                popUpMenuLogic.selectIcon(touchedIcon);
                break;
        }

    }

    public void characterTouched(FightCharacter touchedCharacter) {
        Gdx.app.debug(TAG, "Character touched [" + touchedCharacter.getName() + "]");

        switch (fightState) {
            case NOTHING_SELECTED:
                tryToSelectCharacter(touchedCharacter);
                break;
            case CHARACTER_SELECTED:
                unselectCharacterIfAlreadySelected(touchedCharacter);
                break;
            case ACTION_SELECTED:
                doAction(touchedCharacter);
                break;
        }
    }

    private void tryToSelectCharacter(FightCharacter touchedCharacter) {
        if (touchedCharacter.isReady()) {
            selectCharacter(touchedCharacter);
            popUpMenuLogic.selectReadyCharacter(touchedCharacter);
        } else {
            popUpMenuLogic.selectNotReadyCharacter(touchedCharacter);
        }
    }

    private void unselectCharacterIfAlreadySelected(FightCharacter touchedCharacter) {
        if (selectedCharacter.equals(touchedCharacter)) {
            popUpMenuLogic.unselectCharacter();
            resetCharacterSelection();
        }
    }

    private void doAction(FightCharacter touchedCharacter) {
        targetCharacter = touchedCharacter;
        selectedCharacter.attack(targetCharacter);
        resetCharacterSelection();
    }

    public void resetCharacterSelection() {
        selectedCharacter = null;
        selectedIcon = null;
        targetCharacter = null;

        fightState = FightState.NOTHING_SELECTED;
        popUpMenuLogic.unselectCharacter();
    }

    private void selectCharacter(FightCharacter touchedCharacter) {
        selectedCharacter = touchedCharacter;
        fightState = FightState.CHARACTER_SELECTED;
    }

    public FightBackground getFightBackground() {
        return fightBackground;
    }

    public List<FightCharacter> getFightTeam() {
        return fightTeam;
    }

    public List<FightCharacter> getEnemyFightTeam() {
        return enemyFightTeam;
    }

    public boolean isEnded() {
        for (FightCharacter enemy : enemyFightTeam) {
            if (enemy.getCharacter().isAlive()) {
                return false;
            }
        }
        return true;
    }

    public FightPopUpMenuLogic getPopUpMenuLogic() {
        return popUpMenuLogic;
    }

    public FightMainInfos getMainInfos() {
        return fightMainInfos;
    }
}
