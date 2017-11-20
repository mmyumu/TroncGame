package fr.mmyumu.troncgame.util;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Rectangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fr.mmyumu.troncgame.overworld.OverworldConstants;

import static org.junit.Assert.*;

/**
 * Test the calculation of hitboxes surrounding another hitbox
 * Created by mmyumu on 17/11/2017.
 */
public class SurroundingHitboxCalculatorTest {
    private static final int TILE_WIDTH = 10;
    private static final int TILE_HEIGHT = 10;
    private static final int HITBOX_WIDTH = 20;
    private static final int HITBOX_HEIGHT = 20;

    @Test
    public void testSurroundedBy8BlockingTiles() {
        Rectangle hitbox = new Rectangle(15f, 25f, HITBOX_WIDTH, HITBOX_HEIGHT);
        List<TiledMapTileLayer> layers = new ArrayList<>();

        TiledMapTileLayer layer = new TiledMapTileLayer(6, 6, TILE_WIDTH, TILE_HEIGHT);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                TiledMapTile tile = new StaticTiledMapTile(new TextureRegion());
                tile.getProperties().put(OverworldConstants.BLOCK, "true");
                cell.setTile(tile);
                layer.setCell(i, j, cell);
            }
        }

        layers.add(layer);

        SurroundingHitboxCalculator surroundingHitboxCalculator = new SurroundingHitboxCalculator(hitbox, layers, TILE_WIDTH, TILE_HEIGHT);

        List<Rectangle> surroundingBoxes = surroundingHitboxCalculator.compute();
        assertEquals("Number of blocking boxes", 8, surroundingBoxes.size());
    }

    @Test
    public void testSurroundedBy8NotBlockingTiles() {
        Rectangle hitbox = new Rectangle(15f, 25f, HITBOX_WIDTH, HITBOX_HEIGHT);
        List<TiledMapTileLayer> layers = new ArrayList<>();

        TiledMapTileLayer layer = new TiledMapTileLayer(6, 6, TILE_WIDTH, TILE_HEIGHT);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                TiledMapTile tile = new StaticTiledMapTile(new TextureRegion());
                cell.setTile(tile);
                layer.setCell(i, j, cell);
            }
        }

        layers.add(layer);

        SurroundingHitboxCalculator surroundingHitboxCalculator = new SurroundingHitboxCalculator(hitbox, layers, TILE_WIDTH, TILE_HEIGHT);

        List<Rectangle> surroundingBoxes = surroundingHitboxCalculator.compute();
        assertEquals("Number of blocking boxes", 0, surroundingBoxes.size());
    }

    @Test
    public void testSurroundedBy3BlockingTilesAtBottom() {
        Rectangle hitbox = new Rectangle(15f, 25f, HITBOX_WIDTH, HITBOX_HEIGHT);
        List<TiledMapTileLayer> layers = new ArrayList<>();

        TiledMapTileLayer layer = new TiledMapTileLayer(6, 6, TILE_WIDTH, TILE_HEIGHT);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                TiledMapTile tile = new StaticTiledMapTile(new TextureRegion());
                if (j == 2) {
                    tile.getProperties().put(OverworldConstants.BLOCK, "true");
                }
                cell.setTile(tile);
                layer.setCell(i, j, cell);
            }
        }

        layers.add(layer);

        SurroundingHitboxCalculator surroundingHitboxCalculator = new SurroundingHitboxCalculator(hitbox, layers, TILE_WIDTH, TILE_HEIGHT);

        List<Rectangle> surroundingBoxes = surroundingHitboxCalculator.compute();
        assertEquals("Number of blocking boxes", 3, surroundingBoxes.size());
    }

    @Test
    public void testSurroundedBy3BlockingTilesAtLeft() {
        Rectangle hitbox = new Rectangle(15f, 25f, HITBOX_WIDTH, HITBOX_HEIGHT);
        List<TiledMapTileLayer> layers = new ArrayList<>();

        TiledMapTileLayer layer = new TiledMapTileLayer(6, 6, TILE_WIDTH, TILE_HEIGHT);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                TiledMapTile tile = new StaticTiledMapTile(new TextureRegion());
                if (i == 1) {
                    tile.getProperties().put(OverworldConstants.BLOCK, "true");
                }
                cell.setTile(tile);
                layer.setCell(i, j, cell);
            }
        }

        layers.add(layer);

        SurroundingHitboxCalculator surroundingHitboxCalculator = new SurroundingHitboxCalculator(hitbox, layers, TILE_WIDTH, TILE_HEIGHT);

        List<Rectangle> surroundingBoxes = surroundingHitboxCalculator.compute();
        assertEquals("Number of blocking boxes", 3, surroundingBoxes.size());
    }

    @Test
    public void testSurroundedBy1BlockingTilesAtBottomRight() {
        Rectangle hitbox = new Rectangle(15f, 25f, HITBOX_WIDTH, HITBOX_HEIGHT);
        List<TiledMapTileLayer> layers = new ArrayList<>();

        TiledMapTileLayer layer = new TiledMapTileLayer(6, 6, TILE_WIDTH, TILE_HEIGHT);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                TiledMapTile tile = new StaticTiledMapTile(new TextureRegion());
                if (j == 2 && i >= 3) {
                    tile.getProperties().put(OverworldConstants.BLOCK, "true");
                }
                cell.setTile(tile);
                layer.setCell(i, j, cell);
            }
        }

        layers.add(layer);

        SurroundingHitboxCalculator surroundingHitboxCalculator = new SurroundingHitboxCalculator(hitbox, layers, TILE_WIDTH, TILE_HEIGHT);

        List<Rectangle> surroundingBoxes = surroundingHitboxCalculator.compute();
        assertEquals("Number of blocking boxes", 1, surroundingBoxes.size());
    }
}