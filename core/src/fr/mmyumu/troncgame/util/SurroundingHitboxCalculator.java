package fr.mmyumu.troncgame.util;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

import fr.mmyumu.troncgame.overworld.OverworldConstants;

/**
 * Compute the surrounding hitboxes of a specific hitbox.
 * Created by mmyumu on 17/11/2017.
 */

public class SurroundingHitboxCalculator {
    private Rectangle hitbox;
    private List<TiledMapTileLayer> layers;
    private int tileWidth;
    private int tileHeight;

    public SurroundingHitboxCalculator(Rectangle hitbox, List<TiledMapTileLayer> layers, int tileWidth, int tileHeight) {
        this.hitbox = hitbox;
        this.layers = layers;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    public List<Rectangle> compute() {
        List<Rectangle> hitBoxes = new ArrayList<>();

        float left = hitbox.x;
        float center = hitbox.x + hitbox.width / 2;
        float right = hitbox.x + hitbox.width;
        float bottom = hitbox.y;
        float middle = hitbox.y + hitbox.height / 2;
        float top = hitbox.y + hitbox.height;

        int leftIndex = (int) (left / tileWidth);
        int centerIndex = (int) (center / tileWidth);
        int rightIndex = (int) (right / tileWidth);
        int bottomIndex = (int) (bottom / tileHeight);
        int middleIndex = (int) (middle / tileHeight);
        int topIndex = (int) (top / tileHeight);

        for (TiledMapTileLayer layer : layers) {
            TiledMapTileLayer.Cell bottomLeftCell = layer.getCell(leftIndex, bottomIndex);
            TiledMapTileLayer.Cell middleLeftCell = layer.getCell(leftIndex, middleIndex);
            TiledMapTileLayer.Cell topLeftCell = layer.getCell(leftIndex, topIndex);

            TiledMapTileLayer.Cell bottomCenterCell = layer.getCell(centerIndex, bottomIndex);
            TiledMapTileLayer.Cell topCenterCell = layer.getCell(centerIndex, topIndex);

            TiledMapTileLayer.Cell bottomRightCell = layer.getCell(rightIndex, bottomIndex);
            TiledMapTileLayer.Cell middleRightCell = layer.getCell(rightIndex, middleIndex);
            TiledMapTileLayer.Cell topRightCell = layer.getCell(rightIndex, topIndex);

            addCellIfBlocking(hitBoxes, bottomLeftCell, leftIndex, bottomIndex);
            addCellIfBlocking(hitBoxes, middleLeftCell, leftIndex, middleIndex);
            addCellIfBlocking(hitBoxes, topLeftCell, leftIndex, topIndex);

            addCellIfBlocking(hitBoxes, bottomCenterCell, centerIndex, bottomIndex);
            addCellIfBlocking(hitBoxes, topCenterCell, centerIndex, topIndex);

            addCellIfBlocking(hitBoxes, bottomRightCell, rightIndex, bottomIndex);
            addCellIfBlocking(hitBoxes, middleRightCell, rightIndex, middleIndex);
            addCellIfBlocking(hitBoxes, topRightCell, rightIndex, topIndex);
        }

        return hitBoxes;
    }

    private void addCellIfBlocking(List<Rectangle> hitBoxes, TiledMapTileLayer.Cell cell, int horizontalIndex, int verticalIndex) {
        if (isBlockingCell(cell)) {
            hitBoxes.add(new Rectangle(horizontalIndex * tileWidth, verticalIndex * tileHeight, tileWidth, tileHeight));
        }
    }

    private boolean isBlockingCell(TiledMapTileLayer.Cell cell) {
        return cell != null && cell.getTile().getProperties().get(OverworldConstants.BLOCK) != null && Boolean.valueOf(cell.getTile().getProperties().get(OverworldConstants.BLOCK).toString());
    }
}
