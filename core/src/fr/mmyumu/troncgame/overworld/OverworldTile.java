package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.inject.Inject;

/**
 * Created by mmyumu on 30/10/2015.
 */
public class OverworldTile extends Actor {

    @Inject AssetManager assetManager;
    private final OverworldCharacter mainCharacter;
    private final int x;
    private final int y;
    private final Type type;


    public OverworldTile(OverworldCharacter mainCharacter, int x, int y, char typeChar, AssetManager assetManager) {
        this.mainCharacter = mainCharacter;
        this.x = x;
        this.y = y;
        this.type = Type.getType(typeChar);
        this.assetManager = assetManager;

        if (this.type == null) {
            throw new OverworldException("The type " + typeChar + " is not a registered Overworld tile.");
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Texture texture = assetManager.get(type.getTexturePath(), Texture.class);
        batch.draw(texture, x, y, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
    }

    public enum Type {
        // TODO: add a collision attribute to the tiles?
        NONE(' ', null), DIRT('D', "data/tiledirt.png"), GRASS('G', "data/tilegrass.png"), WALL('W', "data/tilewall.png");

        private char typeChar;
        private String texturePath;

        Type(char typeChar, String texturePath) {
            this.typeChar = typeChar;
            this.texturePath = texturePath;
        }

        public static Type getType(char typeChar) {
            for (Type type : Type.values()) {
                if (type.typeChar == typeChar) {
                    return type;
                }
            }
            return null;
        }

        public String getTexturePath() {
            return texturePath;
        }
    }
}
