package fr.mmyumu.troncgame.map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;

import javax.inject.Inject;

/**
 * Implementation of the factory to create the maps
 * Created by mmyumu on 23/08/2016.
 */
public class MapFactoryImpl implements MapFactory {

    private final OrthographicCamera camera;
    private final AssetManager assetManager;

    @Inject
    public MapFactoryImpl(OrthographicCamera camera, AssetManager assetManager) {
        this.camera = camera;
        this.assetManager = assetManager;
    }

    @Override
    public Map create(String path, int tileHeight) {
        return new Map(path, camera, assetManager, tileHeight);
    }
}
