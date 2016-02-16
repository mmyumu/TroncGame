package fr.mmyumu.troncgame.model;

/**
 * An item which can be carried by the team
 * Created by mmyumu on 14/02/2016.
 */
public class Item {
    private String identifier;
    private String name;
    private String texturePath;

    public Item(String identifier, String name, String texturePath) {
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
