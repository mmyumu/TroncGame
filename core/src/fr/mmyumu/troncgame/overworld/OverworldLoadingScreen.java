package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Screen displayed when loading the Overworld
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldLoadingScreen extends ScreenAdapter {
    private static final String TAG = "OverworldLoadingScreen";

    private final TroncGame troncGame;
    private final AssetManager assetManager;

    @Inject
    public OverworldLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Loading overworld");

        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        assetManager.load(OverworldConstants.MapPath.VILLAGE, TiledMap.class);

        assetManager.load(OverworldConstants.TexturePath.TILE_DIRT, Texture.class);
        assetManager.load(OverworldConstants.TexturePath.TILE_GRASS, Texture.class);
        assetManager.load(OverworldConstants.TexturePath.TILE_WALL, Texture.class);

        assetManager.load(OverworldConstants.TexturePath.MAIN_CHARACTER, Texture.class);
    }

    @Override
    public void render(float delta) {
        if (assetManager.update()) {
            troncGame.setScreen(troncGame.getOverworldComponent().createOverworldScreen());
        }
        Gdx.app.debug(TAG, ".");
    }
}
