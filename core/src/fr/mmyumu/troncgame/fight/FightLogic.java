package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.manager.CharacterManager;

/**
 * Manage the logic of the Fight
 * Created by mmyumu on 17/01/2016.
 */
public class FightLogic {
    private static final String TAG = "FightLogic";

    private final AssetManager assetManager;
    private final I18NBundle bundle;
    private final Skin skin;
    private final CharacterManager characterManager;
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

    private final Random r;


    @Inject
    public FightLogic(AssetManager assetManager, I18NBundle bundle, Skin skin, CharacterManager characterManager, EnemyFightTeamGenerator enemyFightTeamGenerator, FightPopUpMenuLogic popUpMenuLogic) {
        this.assetManager = assetManager;
        this.bundle = bundle;
        this.skin = skin;
        this.characterManager = characterManager;
        this.enemyFightTeamGenerator = enemyFightTeamGenerator;
        this.popUpMenuLogic = popUpMenuLogic;

        r = new Random();

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
        List<FightCharacter> fightTeam = new ArrayList<>();
        Collection<GameCharacter> characters = characterManager.getTeam().getCharacters();
        int i = 0;
        for (GameCharacter character : characters) {
            FightCharacter fightCharacter = new FightCharacter(skin, 100, FightConstants.MAIN_INFOS_HEIGHT + 20 + 400 - (200 * i), character, assetManager.get(character.getDefinition().getFightWaitingTexturePath(), Texture.class), true);
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
                } else {
                    fightState = FightState.CHARACTER_SELECTED;
                }
                popUpMenuLogic.selectIcon(touchedIcon);
                break;
            default:
                // Do nothing
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
                tryToTargetCharacter(touchedCharacter);
                break;
        }
    }

    private void tryToSelectCharacter(FightCharacter touchedCharacter) {
        if (touchedCharacter.getCharacter().getDefinition().isUsingAI()) {
            Gdx.app.debug(TAG, "Character " + touchedCharacter.getCharacter().retrieveName() + " using AI cannot be selected.");
        } else {
            if (touchedCharacter.isReady()) {
                selectCharacter(touchedCharacter);
                popUpMenuLogic.selectReadyCharacter(touchedCharacter);
            } else {
                popUpMenuLogic.selectNotReadyCharacter(touchedCharacter);
            }
        }
    }

    private void unselectCharacterIfAlreadySelected(FightCharacter touchedCharacter) {
        if (selectedCharacter.equals(touchedCharacter)) {
            popUpMenuLogic.unselectCharacter();
            resetCharacterSelection();
        }
    }

    private void tryToTargetCharacter(FightCharacter touchedCharacter) {
        if (selectedCharacter.equals(touchedCharacter)) {
            resetCharacterSelection();
        } else if (!touchedCharacter.getCharacter().getDefinition().isFriendly()) {
            doAction(touchedCharacter);
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
        popUpMenuLogic.selectCharacter(selectedCharacter);
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

    private void playAICharacters() {
        for (FightCharacter character : enemyFightTeam) {
            if (character.getCharacter().isAlive() && character.isReady()) {
                FightCharacter targetCharacter = computeTargetCharacter();
                character.attack(targetCharacter);
            }
        }
    }

    private FightCharacter computeTargetCharacter() {
        int random = r.nextInt(fightTeam.size());
        return fightTeam.get(random);
    }

    public void update(float delta) {
        playAICharacters();

        switch (fightState) {
            case NOTHING_SELECTED:
                fightBackground.setDarkened(false);
                fightMainInfos.setDarkened(false);
                darkenCharacters(fightTeam, false);
                darkenCharacters(enemyFightTeam, false);
                break;
            case CHARACTER_SELECTED:
                fightBackground.setDarkened(true);
                fightMainInfos.setDarkened(true);
                darkenCharacters(fightTeam, true);
                darkenCharacters(enemyFightTeam, true);
                break;
            case ACTION_SELECTED:
                fightBackground.setDarkened(true);
                fightMainInfos.setDarkened(true);
                darkenCharacters(fightTeam, true);
                darkenCharacters(enemyFightTeam, false);
                break;
        }
    }

    private void darkenCharacters(List<FightCharacter> characters, boolean darkened) {
        for (FightCharacter character : characters) {
            character.setDarkened(darkened);
        }
    }
}
