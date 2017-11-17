package fr.mmyumu.troncgame.model;

/**
 * Define a character of the game
 * Created by mmyumu on 01/01/2016.
 */
public class GameCharacterDef {
    private static final String TAG = "GameCharacterDef";
    private String identifier;
    private String name;
    private int hp;
    private int mp;
    private double actionSpeed;
    private int attack;
    private boolean friendly;
    private String fightWaitingTexturePath;
    private boolean usingAI;
    private boolean playable;
    private String overworldTopTexturePath;
    private String overworldBottomTexturePath;
    private String overworldLeftTexturePath;
    private String overworldRightTexturePath;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public double getActionSpeed() {
        return actionSpeed;
    }

    public void setActionSpeed(double actionSpeed) {
        this.actionSpeed = actionSpeed;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getFightWaitingTexturePath() {
        return fightWaitingTexturePath;
    }

    public void setFightWaitingTexturePath(String fightTexturePath) {
        this.fightWaitingTexturePath = fightTexturePath;
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }

    public boolean isUsingAI() {
        return usingAI;
    }

    public void setUsingAI(boolean usingAI) {
        this.usingAI = usingAI;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public String getOverworldTopTexturePath() {
        return overworldTopTexturePath;
    }

    public void setOverworldTopTexturePath(String overworldTopTexturePath) {
        this.overworldTopTexturePath = overworldTopTexturePath;
    }

    public String getOverworldBottomTexturePath() {
        return overworldBottomTexturePath;
    }

    public void setOverworldBottomTexturePath(String overworldBottomTexturePath) {
        this.overworldBottomTexturePath = overworldBottomTexturePath;
    }

    public String getOverworldLeftTexturePath() {
        return overworldLeftTexturePath;
    }

    public void setOverworldLeftTexturePath(String overworldLeftTexturePath) {
        this.overworldLeftTexturePath = overworldLeftTexturePath;
    }

    public String getOverworldRightTexturePath() {
        return overworldRightTexturePath;
    }

    public void setOverworldRightTexturePath(String overworldRightTexturePath) {
        this.overworldRightTexturePath = overworldRightTexturePath;
    }
}
