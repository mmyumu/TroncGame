package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import javax.inject.Inject;

import fr.mmyumu.troncgame.DisplayableLoadingScreen;
import fr.mmyumu.troncgame.TroncGame;

/**
 * Screen displayed when loading the Overworld
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldLoadingScreen extends DisplayableLoadingScreen {
    @Inject
    public OverworldLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        super(troncGame, assetManager);
    }

    @Override
    protected Screen getNextScreen() {
        return troncGame.getOverworldComponent().createOverworldScreen();
    }

    @Override
    protected void load() {
        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        assetManager.load(OverworldConstants.MapPath.VILLAGE, TiledMap.class);
        assetManager.load(OverworldConstants.TexturePath.MAIN_CHARACTER, Texture.class);
        assetManager.load(OverworldConstants.TexturePath.MENU_LIST, Texture.class);
    }

    @Override
    protected String getDebugName() {
        return "overworld";
    }
}
