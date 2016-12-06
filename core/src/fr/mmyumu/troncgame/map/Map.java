package fr.mmyumu.troncgame.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage a map
 * Created by mmyumu on 10/11/2015.
 */
public class Map {
    private static final String TAG = "Map";

    private final TiledMap map;
    private final MapData mapData;
    private final OrthographicCamera camera;
    private final int width;
    private final int height;

    private final TiledMapRenderer renderer;

    private int[] backgroundLayersId;
    private int[] foregroundLayersId;

    public Map(MapData mapData, OrthographicCamera camera, AssetManager assetManager, int tileHeight) {
        this.mapData = mapData;
        this.camera = camera;

        map = assetManager.get(mapData.getPath());

        MapProperties prop = map.getProperties();
        int mapWidth = prop.get("width", Integer.class);
        int mapHeight = prop.get("height", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);

        float ratio = tileHeight / (float) tilePixelHeight;

        width = (int) (mapWidth * tilePixelWidth * ratio);
        height = (int) (mapHeight * tilePixelHeight * ratio);

        Gdx.app.debug(TAG, "width=" + width + " height=" + height);

        renderer = new OrthogonalTiledMapRenderer(map, ratio);

        initBackgroundLayersId();
        initForegroundLayersId();
    }

    private void initBackgroundLayersId() {
        backgroundLayersId = initLayersId("Background");
    }

    private void initForegroundLayersId() {
        foregroundLayersId = initLayersId("Foreground");
    }

    private int[] initLayersId(String filter) {
        List<Integer> layersIdList = new ArrayList<Integer>();
        for (MapLayer layer : map.getLayers()) {
            if (layer.getName().contains(filter)) {
                layersIdList.add(map.getLayers().getIndex(layer));
            }
        }

        int[] layersId = new int[layersIdList.size()];
        int i = 0;
        for (Integer id : layersIdList) {
            layersId[i] = id;
            i++;
        }
        return layersId;
    }

    public void drawBackground() {
        renderer.setView(camera);
        renderer.render(backgroundLayersId);
    }

    public void drawForeground() {
        renderer.setView(camera);
        renderer.render(foregroundLayersId);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<TiledMapTileLayer> getTileLayers() {
        List<TiledMapTileLayer> layers = new ArrayList<TiledMapTileLayer>();
        for (MapLayer layer : map.getLayers()) {
            if (layer instanceof TiledMapTileLayer) {
                TiledMapTileLayer tileLayer = (TiledMapTileLayer) layer;
                layers.add(tileLayer);
            }
        }

        return layers;
    }

    public List<TiledMapTileLayer> getExits() {
        List<TiledMapTileLayer> layers = new ArrayList<TiledMapTileLayer>();
        for (MapLayer layer : map.getLayers()) {
            if (layer instanceof TiledMapTileLayer) {
                TiledMapTileLayer tileLayer = (TiledMapTileLayer) layer;
                layers.add(tileLayer);
            }
        }

        return layers;
    }
}