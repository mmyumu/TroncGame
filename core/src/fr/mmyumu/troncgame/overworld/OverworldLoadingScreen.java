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
import fr.mmyumu.troncgame.map.Map;
import fr.mmyumu.troncgame.map.MapData;
import fr.mmyumu.troncgame.map.MapType;
import fr.mmyumu.troncgame.model.GameCharacterDef;
import fr.mmyumu.troncgame.model.ItemDef;
import fr.mmyumu.troncgame.model.manager.ModelManager;

/**
 * Screen displayed when loading the Overworld
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldLoadingScreen extends DisplayableLoadingScreen {
    private ModelManager modelManager;
    private MapData mapData;

    @Inject
    public OverworldLoadingScreen(TroncGame troncGame, AssetManager assetManager, ModelManager modelManager) {
        super(troncGame, assetManager);
        this.modelManager = modelManager;
    }

    public void setMapData(MapData mapData) {
        this.mapData = mapData;
    }

    @Override
    protected Screen getNextScreen() {
        OverworldScreen overworldScreen = troncGame.getOverworldComponent().createOverworldScreen();
        overworldScreen.initMap(mapData);
        return overworldScreen;
    }

    @Override
    protected void load() {
        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        assetManager.load(mapData.getPath(), TiledMap.class);
        assetManager.load(OverworldConstants.TexturePath.MENU_LIST, Texture.class);

        loadCharacters();
        loadItems();
    }

    private void loadCharacters() {
        for (GameCharacterDef character : modelManager.getCharacterManager().getCharacters().values()) {
            loadTexturePath(character.getFightWaitingTexturePath());

            loadTexturePath(character.getOverworldTopTexturePath());
            loadTexturePath(character.getOverworldBottomTexturePath());
            loadTexturePath(character.getOverworldLeftTexturePath());
            loadTexturePath(character.getOverworldRightTexturePath());
        }
    }

    private void loadTexturePath(String texturePath) {
        if(texturePath != null && !texturePath.isEmpty()) {
            assetManager.load(texturePath, Texture.class);
        }
    }

    private void loadItems() {
        for (ItemDef item : modelManager.getItemManager().getItems().values()) {
            assetManager.load(item.getTexturePath(), Texture.class);
        }
    }

    @Override
    protected String getDebugName() {
        return "overworld";
    }
}
