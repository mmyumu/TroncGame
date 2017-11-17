package fr.mmyumu.troncgame.model.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.GameCharacterDef;
import fr.mmyumu.troncgame.model.ModelConstants;
import fr.mmyumu.troncgame.model.Team;

/**
 * Manage the characters of the game
 * Created by mmyumu on 01/03/2016.
 */
public class CharacterManager {
    private static final String TAG = "CharacterManager";
    public static final String ATTRIBUTE_FALSE_VALUE = "false";

    private Team team;
    private final Map<String, GameCharacterDef> characters;

    @Inject
    public CharacterManager() {
        this.characters = new HashMap<>();

        try {
            loadXml();
        } catch (IOException e) {
            Gdx.app.error(TAG, "The characters XML file cannot be parsed.");
        }
    }

    private void loadXml() throws IOException {
        XmlReader reader = new XmlReader();
        XmlReader.Element root = reader.parse(new FileHandle(ModelConstants.DataPath.CHARACTERS));
        Array<XmlReader.Element> characterElements = root.getChildrenByName("character");
        for (XmlReader.Element characterElement : characterElements) {
            GameCharacterDef character = new GameCharacterDef();
            parseCharacterElement(character, characterElement);
        }
    }

    private void parseCharacterElement(GameCharacterDef character, XmlReader.Element characterElement) {
        String id = characterElement.getAttribute("id");
        String name = characterElement.getAttribute("name");
        boolean friendly = Boolean.valueOf(characterElement.getAttribute("friendly", ATTRIBUTE_FALSE_VALUE));
        boolean usingAI = Boolean.valueOf(characterElement.getAttribute("usingAI", ATTRIBUTE_FALSE_VALUE));
        boolean playable = Boolean.valueOf(characterElement.getAttribute("playable", ATTRIBUTE_FALSE_VALUE));

        int attack = Integer.valueOf(characterElement.getChildByName("attack").getText());
        int actionSpeed = Integer.valueOf(characterElement.getChildByName("actionSpeed").getText());
        int hp = Integer.valueOf(characterElement.getChildByName("hp").getText());
        int mp = Integer.valueOf(characterElement.getChildByName("mp").getText());

        character.setIdentifier(id);
        character.setName(name);
        character.setFriendly(friendly);
        character.setUsingAI(usingAI);
        character.setPlayable(playable);

        character.setAttack(attack);
        character.setActionSpeed(actionSpeed);
        character.setHp(hp);
        character.setMp(mp);

        parseFightElement(character, characterElement.getChildByName("fight"));
        parseOverworldElement(character, characterElement.getChildByName("overworld"));

        characters.put(id, character);
    }

    private void parseFightElement(GameCharacterDef character, XmlReader.Element fightElement) {
        if(fightElement != null) {
            String waitingTexture = fightElement.getChildByName("waitingTexture").getText();
            character.setFightWaitingTexturePath(waitingTexture);
        }
    }

    private void parseOverworldElement(GameCharacterDef character, XmlReader.Element overworldElement) {
        if(overworldElement != null) {
            String topTexture = overworldElement.getChildByName("topTexture").getText();
            character.setOverworldTopTexturePath(topTexture);

            String bottomTexture = overworldElement.getChildByName("bottomTexture").getText();
            character.setOverworldBottomTexturePath(bottomTexture);

            String leftTexture = overworldElement.getChildByName("leftTexture").getText();
            character.setOverworldLeftTexturePath(leftTexture);

            String rightTexture = overworldElement.getChildByName("rightTexture").getText();
            character.setOverworldRightTexturePath(rightTexture);
        }
    }

    public Map<String, GameCharacterDef> getCharacters() {
        return characters;
    }

    public void newTeam() {
        team = new Team();

        for (GameCharacterDef characterDef : characters.values()) {
            if (characterDef.isPlayable()) {
                GameCharacter character = new GameCharacter(characterDef);
                team.put(character.getDefinition().getIdentifier(), character);
            }
        }
    }

    public Team getTeam() {
        return team;
    }

    public class ID {
        public static final String MAIN = "main";
        public static final String SIDE_KICK = "sideKick";
        public static final String BEST_FRIEND = "bestFriend";

        private ID() {
            // Private constructor since it's a utility class
        }
    }
}
