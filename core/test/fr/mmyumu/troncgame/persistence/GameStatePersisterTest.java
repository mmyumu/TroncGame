package fr.mmyumu.troncgame.persistence;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.headless.HeadlessPreferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.stubbing.OngoingStubbing;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import javax.inject.Inject;

import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.GameCharacterDef;
import fr.mmyumu.troncgame.model.GameCharacterUtil;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import fr.mmyumu.troncgame.model.manager.ItemManager;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.model.manager.ThemeManager;
import fr.mmyumu.troncgame.overworld.game.OverworldCharacterLogic;
import fr.mmyumu.troncgame.persistence.stubs.PreferencesStub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by mmyumu on 14/12/2017.
 */

public class GameStatePersisterTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    private GameStatePersister gameStatePersister;

    public ModelManager modelManager;

    @Before
    public void setUp() {
        Gdx.app = mock(Application.class);
        Gdx.input = mock(Input.class);

        modelManager = new ModelManager(new ItemManager(), new CharacterManager(), new ThemeManager());

        File newFile = new File(testFolder.getRoot().getAbsolutePath() + "/gameStateTest.xml");
        try {
            newFile.createNewFile();
            FileHandle fileHandle = new FileHandle(newFile);
            Preferences preferences = new HeadlessPreferences(fileHandle);
            gameStatePersister = new GameStatePersister(modelManager, preferences);
        } catch (IOException e) {
            System.err.println("Cannot create preferences file " + newFile.getAbsolutePath());
        }
    }

    @Test
    public void testPersistenceScreenID() {
        gameStatePersister.save(ScreenID.OVERWORLD);

        ScreenID screenID = gameStatePersister.loadScreen();

        assertEquals("Screen ID", ScreenID.OVERWORLD, screenID);
    }

    @Test
    public void testPersistenceCharacter() {
        GameCharacter gameCharacter = new GameCharacter(GameCharacterUtil.createCharacterDef());
        OverworldCharacterLogic overworldCharacter = new OverworldCharacterLogic(gameCharacter);
        overworldCharacter.getCenter().set(38f, 55f);
        gameStatePersister.save(overworldCharacter);

        Vector2 characterPosition = gameStatePersister.loadPosition();

        assertEquals("Character x position", 38f, characterPosition.x, 0.01);
        assertEquals("Character y position", 55f, characterPosition.y, 0.01);
    }

    @Test
    public void testLoadNoPosition() {
        Vector2 characterPosition = gameStatePersister.loadPosition();

        assertNull("Character position", characterPosition);
    }

    @Test
    public void testSaveModel() {
        modelManager.newGame();
        gameStatePersister.saveModel();

        modelManager.getItemManager().getItems().clear();
        modelManager.getCharacterManager().getCharacters().clear();
        modelManager.getThemeManager().getDialogThemes().clear();

        gameStatePersister.loadModel();
    }
}
