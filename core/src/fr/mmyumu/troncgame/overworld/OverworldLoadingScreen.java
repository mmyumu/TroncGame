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
import fr.mmyumu.troncgame.dialog.theme.DialogTheme;
import fr.mmyumu.troncgame.model.GameCharacterDef;
import fr.mmyumu.troncgame.model.ItemDef;
import fr.mmyumu.troncgame.model.manager.ModelManager;

/**
 * Screen displayed when loading the Overworld
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldLoadingScreen extends DisplayableLoadingScreen {
    private ModelManager modelManager;

    @Inject
    public OverworldLoadingScreen(TroncGame troncGame, AssetManager assetManager, ModelManager modelManager) {
        super(troncGame, assetManager);
        this.modelManager = modelManager;
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

        loadCharacters();
        loadItems();
    }

    private void loadCharacters() {
        for (GameCharacterDef character : modelManager.getCharacterManager().getCharacters().values()) {
            String texturePath = character.getFightWaitingTexturePath();

            if(texturePath != null && !texturePath.isEmpty()) {
                assetManager.load(texturePath, Texture.class);
            }
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
