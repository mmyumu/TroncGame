package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Tile displayed in the Overworld
 * Created by mmyumu on 30/10/2015.
 */
public class OverworldTile extends Actor {

    private final GridPoint2 bottomLeft;
    private final Type type;
    private final AssetManager assetManager;


    public OverworldTile(int x, int y, char typeChar, AssetManager assetManager) {
        this.bottomLeft = new GridPoint2(x, y);
        this.type = Type.getType(typeChar);
        this.assetManager = assetManager;

        if (this.type == null) {
            throw new OverworldException("The type " + typeChar + " is not a registered Overworld tile.");
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Texture texture = assetManager.get(type.getTexturePath(), Texture.class);
        batch.draw(texture, bottomLeft.x, bottomLeft.y, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
    }

    public enum Type {
        // TODO: add a collision attribute to the tiles?
        NONE(' ', null), DIRT('D', OverworldConstants.TexturePath.TILE_DIRT), GRASS('G', OverworldConstants.TexturePath.TILE_GRASS), WALL('W', OverworldConstants.TexturePath.TILE_WALL);

        private final char typeChar;
        private final String texturePath;

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
