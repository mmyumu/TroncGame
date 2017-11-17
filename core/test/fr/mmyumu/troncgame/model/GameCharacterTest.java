package fr.mmyumu.troncgame.model;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Test the logic of the Overworld GameCharacter
 * Created by mmyumu on 21/11/2015.
 */
public class GameCharacterTest {

    private GameCharacter gameCharacter;

    @Before
    public void setUp() {
        Gdx.app = mock(Application.class);
        Gdx.input = mock(Input.class);

        gameCharacter = new GameCharacter(createCharacterDef());

                Weapon testWeapon = new Weapon(createWeaponDef());

        gameCharacter.getEquipment().equip(testWeapon);
    }

    private WeaponDef createWeaponDef() {
        return new WeaponDef("test.weapon", "Test weapon", "test/texture", 10);
    }

    private GameCharacterDef createCharacterDef() {
        GameCharacterDef gameCharacterDef = new GameCharacterDef();

        gameCharacterDef.setIdentifier("test.character");
        gameCharacterDef.setName("Test character");
        gameCharacterDef.setFriendly(true);
        gameCharacterDef.setUsingAI(false);
        gameCharacterDef.setPlayable(true);

        gameCharacterDef.setAttack(52);
        gameCharacterDef.setActionSpeed(30);
        gameCharacterDef.setHp(135);
        gameCharacterDef.setMp(74);

        return gameCharacterDef;
    }

    private GameCharacterDef createTargetCharacterDef() {
        GameCharacterDef gameCharacterDef = new GameCharacterDef();

        gameCharacterDef.setIdentifier("test.target.character");
        gameCharacterDef.setName("Test target character");
        gameCharacterDef.setFriendly(false);
        gameCharacterDef.setUsingAI(true);
        gameCharacterDef.setPlayable(false);

        gameCharacterDef.setAttack(15);
        gameCharacterDef.setActionSpeed(20);
        gameCharacterDef.setHp(85);
        gameCharacterDef.setMp(38);

        return gameCharacterDef;
    }

    @Test
    public void testAttack() {
        GameCharacter targetCharacter = new GameCharacter(createTargetCharacterDef());
        gameCharacter.attack(targetCharacter);

        assertEquals("Target character HP", 23, targetCharacter.getCurrentHp());
    }

    @Test
    public void testName() {
        assertEquals("Character definition name", "Test character", gameCharacter.retrieveName());

        gameCharacter.setName("Test character overridden");

        assertEquals("Character name", "Test character overridden", gameCharacter.retrieveName());
    }

    @Test
    public void testIsAlive() {
        assertEquals("Character is alive", true, gameCharacter.isAlive());
    }

    @Test
    public void testIsDead() {
        gameCharacter.setCurrentHp(0);
        assertEquals("Character is dead", false, gameCharacter.isAlive());
    }

    @Test
    public void testMP() {
        assertEquals("Character MP", 74, gameCharacter.getCurrentMp());

        gameCharacter.setCurrentMp(12);
        assertEquals("Character MP", 12, gameCharacter.getCurrentMp());
    }

    @Test
    public void testActionSpeed() {
        assertEquals("Character action speed", 30d, gameCharacter.getActionSpeed());
    }

    @Test
    public void testAccessors() {
        gameCharacter.getDefinition().setFightWaitingTexturePath("dummyFightWaiting.png");
        gameCharacter.getDefinition().setOverworldTopTexturePath("dummyOverworldTop.png");
        gameCharacter.getDefinition().setOverworldBottomTexturePath("dummyOverworldBottom.png");
        gameCharacter.getDefinition().setOverworldLeftTexturePath("dummyOverworldLeft.png");
        gameCharacter.getDefinition().setOverworldRightTexturePath("dummyOverworldRight.png");

        assertEquals("Character ID", "test.character", gameCharacter.getDefinition().getIdentifier());
        assertEquals("Character playable", true, gameCharacter.getDefinition().isPlayable());
        assertEquals("Character friendly", true, gameCharacter.getDefinition().isFriendly());
        assertEquals("Character using AI", false, gameCharacter.getDefinition().isUsingAI());

        assertEquals("Character fight waiting texture", "dummyFightWaiting.png", gameCharacter.getDefinition().getFightWaitingTexturePath());
        assertEquals("Character overworld top texture", "dummyOverworldTop.png", gameCharacter.getDefinition().getOverworldTopTexturePath());
        assertEquals("Character overworld bottom texture", "dummyOverworldBottom.png", gameCharacter.getDefinition().getOverworldBottomTexturePath());
        assertEquals("Character overworld left texture", "dummyOverworldLeft.png", gameCharacter.getDefinition().getOverworldLeftTexturePath());
        assertEquals("Character overworld right texture", "dummyOverworldRight.png", gameCharacter.getDefinition().getOverworldRightTexturePath());
    }
}

