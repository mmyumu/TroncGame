package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.ModelConstants;
import fr.mmyumu.troncgame.model.Weapon;
import fr.mmyumu.troncgame.model.manager.ItemManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

/**
 * Actor to display main menu
 * Created by mmyumu on 27/10/2015.
 */
public class MainMenuStart extends MainMenuButton {
    private static final String TAG = "MainMenuStart";

    private final TroncGame troncGame;
    private final GameStatePersister gameStatePersister;
    private ItemManager itemManager;

    @Inject
    public MainMenuStart(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle, GameStatePersister gameStatePersister, ItemManager itemManager, Integer y) {
        super(assetManager, bundle, y);

        this.troncGame = troncGame;
        this.gameStatePersister = gameStatePersister;
        this.itemManager = itemManager;
    }

    @Override
    protected void buttonClicked(InputEvent event, float x, float y) {
        Gdx.app.debug(TAG, "Start button pressed");

        gameStatePersister.clear();

        troncGame.getModelComponent().mainCharacter().getEquipment().equip((Weapon) itemManager.get(ModelConstants.Identifier.BASIC_SWORD));

        troncGame.setScreen(troncGame.getOverworldComponent().createOverworldLoadingScreen());
    }

    @Override
    protected String getPropertyKey() {
        return "start";
    }
}
