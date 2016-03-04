package fr.mmyumu.troncgame.model;

/**
 * Definition of item of the game
 * Created by mmyumu on 14/02/2016.
 */
public class ItemDef {
    private String identifier;
    private String name;
    private String texturePath;

    public ItemDef(String identifier, String name, String texturePath) {
        this.identifier = identifier;
        this.name = name;
        this.texturePath = texturePath;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public String getIdentifier() {
        return identifier;
    }
}
