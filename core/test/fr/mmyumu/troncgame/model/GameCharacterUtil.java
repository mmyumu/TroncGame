package fr.mmyumu.troncgame.model;

/**
 * Created by mlabetaa on 14/12/2017.
 */

public class GameCharacterUtil {
    public static  GameCharacterDef createCharacterDef() {
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
}
