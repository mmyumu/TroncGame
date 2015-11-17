package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import fr.mmyumu.troncgame.overworld.OverworldConstants;

/**
 * Manage the map of the Overworld
 * Created by mmyumu on 10/11/2015.
 */
public class OverworldMap {
    private static final String TAG = "OverworldMap";

    private final TiledMap map;
    private final OrthographicCamera camera;
    private final int width;
    private final int height;

    private final TiledMapRenderer renderer;

    public OverworldMap(String mapPath, OrthographicCamera camera, AssetManager assetManager) {
        this.camera = camera;

        map = assetManager.get(mapPath);

        MapProperties prop = map.getProperties();
        int mapWidth = prop.get("width", Integer.class);
        int mapHeight = prop.get("height", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);

        float ratio = OverworldConstants.TILE_HEIGHT / (float) tilePixelHeight;

        width = (int) (mapWidth * tilePixelWidth * ratio);
        height = (int) (mapHeight * tilePixelHeight * ratio);

        Gdx.app.debug(TAG, "width=" + width + " height=" + height);

        renderer = new OrthogonalTiledMapRenderer(map, ratio);
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TiledMapTileLayer getObstaclesLayer() {
        return (TiledMapTileLayer) map.getLayers().get("Obstacles");
    }
}
