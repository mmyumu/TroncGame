package fr.mmyumu.troncgame.model;

/**
 * An item which can be carried by the team
 * Created by mmyumu on 14/02/2016.
 */
public class Item {
    private String identifier;
    private String texturePath;

    public Item(String identifier, String texturePath) {
        this.identifier = identifier;
        this.texturePath = texturePath;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public String getIdentifier() {
        return identifier;
    }
}
