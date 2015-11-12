package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.List;

/**
 * Manage the map of the Overworld
 * Created by mmyumu on 10/11/2015.
 */
public class OverworldMap {
    private static final String TAG = "OverworldMap";

    private final AssetManager assetManager;

    private TiledMap map;
    private OrthographicCamera camera;
    private List<OverworldTile> tiles;
    private List<OverworldTile> obstacles;
    private int width;
    private int height;

    private TiledMapRenderer renderer;

    public OverworldMap(String mapPath, OrthographicCamera camera, AssetManager assetManager) {
        this.assetManager = assetManager;
        this.camera = camera;

        map = assetManager.get(mapPath);
        renderer = new OrthogonalTiledMapRenderer(map);

        MapProperties prop = map.getProperties();
        int mapWidth = prop.get("width", Integer.class);
        int mapHeight = prop.get("height", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);

        width = mapWidth * tilePixelWidth;
        height = mapHeight * tilePixelHeight;
    }

    public void drawBackground() {
        int[] backgroundLayers = {map.getLayers().getIndex("Ground"), map.getLayers().getIndex("Obstacles")};
        renderer.setView(camera);
        renderer.render(backgroundLayers);
    }

    public void drawForeground() {
        int[] foregroundLayers = {map.getLayers().getIndex("Foreground")};
        renderer.setView(camera);
        renderer.render(foregroundLayers);
    }

//    public List<OverworldTile> getTiles() {
//        return tiles;
//    }

//    public List<OverworldTile> getObstacles() {
//        return obstacles;
//    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
