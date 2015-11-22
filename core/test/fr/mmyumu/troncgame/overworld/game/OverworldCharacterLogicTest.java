package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import org.junit.Before;
import org.junit.Test;

import fr.mmyumu.troncgame.TestUtils;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.overworld.OverworldConstants;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Test the logic of the Overworld Character
 * Created by mmyumu on 21/11/2015.
 */
public class OverworldCharacterLogicTest {

    private OverworldCharacterLogic overworldCharacterLogic;

    @Before
    public void setUp() {
        TroncGame troncGame = mock(TroncGame.class);
        overworldCharacterLogic = new OverworldCharacterLogic(troncGame);
    }

    @Test
    public void testDefaultCoordinates() {
        Vector2 center = (Vector2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "center");
        assertEquals("Default center x coordinate", 0f, center.x);
        assertEquals("Default center y coordinate", 0f, center.y);
    }

    @Test
    public void testInitCenter() {
        overworldCharacterLogic.initCenter(500, 200);

        Vector2 center = (Vector2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "center");
        assertEquals("Center x coordinate after init", 500f, center.x);
        assertEquals("Center y coordinate after init", 200f, center.y);

        float xHitbox = 500 - OverworldConstants.TILE_WIDTH / 2;
        float yHitbox = 200 - OverworldConstants.TILE_HEIGHT / 2;
        assertEquals("Hitbox x coordinate after init", xHitbox, overworldCharacterLogic.getX());
        assertEquals("Hitbox y coordinate after init", yHitbox, overworldCharacterLogic.getY());

        Rectangle hitbox = (Rectangle) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "hitbox");
        assertEquals("Hitbox width", (float) OverworldConstants.TILE_WIDTH, hitbox.width);
        assertEquals("Hitbox height", (float) OverworldConstants.TILE_HEIGHT, hitbox.height);
    }
}
