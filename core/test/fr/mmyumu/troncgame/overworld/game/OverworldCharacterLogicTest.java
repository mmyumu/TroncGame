package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import fr.mmyumu.troncgame.TestUtils;
import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.GameCharacterDef;
import fr.mmyumu.troncgame.overworld.OverworldConstants;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test the logic of the Overworld GameCharacter
 * Created by mmyumu on 21/11/2015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ThreadLocalRandom.class, OverworldCharacterLogic.class})
public class OverworldCharacterLogicTest {

    private OverworldCharacterLogic overworldCharacterLogic;

    @Before
    public void setUp() {
        Gdx.app = mock(Application.class);
        Gdx.input = mock(Input.class);

        overworldCharacterLogic = new OverworldCharacterLogic(new GameCharacter(new GameCharacterDef()));
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
        checkCenterAndHitbox(500, 200);
    }

    @Test
    public void testSetMoveTarget() {
        overworldCharacterLogic.setMoveTarget(new GridPoint2(800, 600));

        checkMoveTarget(800, 600);
    }

    @Test
    public void testSetObstaclesLayer() {
        overworldCharacterLogic.setLayers(Arrays.asList(mock(TiledMapTileLayer.class)));

        List<TiledMapTileLayer> layers = (List) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "layers");
        assertNotNull("Layers after setter", layers);
    }

    @Test
    public void testCameraMovedWithoutMoveTarget() {
        GridPoint2 moveTarget = (GridPoint2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "moveTarget");
        assertNull("Default move target", moveTarget);

        overworldCharacterLogic.cameraMoved(11, 10);

        moveTarget = (GridPoint2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "moveTarget");
        assertNull("Move target after camera move", moveTarget);
    }

    @Test
    public void testCameraMovedWithMoveTarget() {
        overworldCharacterLogic.setMoveTarget(new GridPoint2(800, 600));
        overworldCharacterLogic.cameraMoved(11, 10);

        checkMoveTarget(811, 610);
    }

    @Test
    public void testUpdateWithoutMoveTarget() {
        mockRandom(0);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.update(0.01f);

        checkCenterAndHitbox(500, 200);
    }

    @Test
    public void testUpdateWithTopMoveTarget() {
        mockRandom(0);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(mock(TiledMapTileLayer.class)));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(500, 300));

        overworldCharacterLogic.update(0.01f);

        checkCenterAndHitbox(500, 209);
        checkSpeed(0, 9);
    }

    @Test
    public void testUpdateWithBottomMoveTarget() {
        mockRandom(0);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(mock(TiledMapTileLayer.class)));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(500, 100));

        overworldCharacterLogic.update(0.01f);

        checkCenterAndHitbox(500, 191);
        checkSpeed(0, -9);
    }

    @Test
    public void testUpdateWithLeftMoveTarget() {
        mockRandom(0);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(mock(TiledMapTileLayer.class)));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(400, 200));

        overworldCharacterLogic.update(0.01f);

        checkCenterAndHitbox(491, 200);
        checkSpeed(-9, 0);
    }

    @Test
    public void testUpdateWithRightMoveTarget() {
        mockRandom(0);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(mock(TiledMapTileLayer.class)));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(600, 200));

        overworldCharacterLogic.update(0.01f);

        checkCenterAndHitbox(509, 200);
        checkSpeed(9, 0);
    }

    @Test
    public void testTopCollision() {
        mockRandom(0);

        TiledMapTileLayer.Cell cell1 = createBlockingCell();
        TiledMapTileLayer.Cell cell2 = createBlockingCell();

        TiledMapTileLayer obstaclesLayer = mock(TiledMapTileLayer.class);
        when(obstaclesLayer.getCell(5, 3)).thenReturn(cell1);
        when(obstaclesLayer.getCell(6, 3)).thenReturn(cell2);


        overworldCharacterLogic.initCenter(500, 220);
        overworldCharacterLogic.setLayers(Arrays.asList(obstaclesLayer));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(500, 320));

        overworldCharacterLogic.update(0.01f);
        checkCenterAndHitbox(500, 225);
        checkSpeed(0, 5);
    }

    @Test
    public void testTopAndRightCollision() {
        mockRandom(0);

        TiledMapTileLayer.Cell cell1 = createBlockingCell();
        TiledMapTileLayer.Cell cell2 = createBlockingCell();
        TiledMapTileLayer.Cell cell3 = createBlockingCell();
        TiledMapTileLayer.Cell cell4 = createBlockingCell();

        TiledMapTileLayer obstaclesLayer = mock(TiledMapTileLayer.class);
        when(obstaclesLayer.getCell(5, 3)).thenReturn(cell1);
        when(obstaclesLayer.getCell(6, 3)).thenReturn(cell2);
        when(obstaclesLayer.getCell(6, 2)).thenReturn(cell3);
        when(obstaclesLayer.getCell(6, 1)).thenReturn(cell4);

        overworldCharacterLogic.initCenter(490, 220);
        overworldCharacterLogic.setLayers(Arrays.asList(obstaclesLayer));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(600, 320));

        overworldCharacterLogic.update(0.01f);
        checkSpeed(5, 5);
        checkCenterAndHitbox(495, 225);

    }

    @Test
    public void testBottomCollision() {
        mockRandom(0);

        TiledMapTileLayer.Cell cell1 = createBlockingCell();
        TiledMapTileLayer.Cell cell2 = createBlockingCell();

        TiledMapTileLayer obstaclesLayer = mock(TiledMapTileLayer.class);
        when(obstaclesLayer.getCell(5, 1)).thenReturn(cell1);
        when(obstaclesLayer.getCell(6, 1)).thenReturn(cell2);

        overworldCharacterLogic.initCenter(500, 230);
        overworldCharacterLogic.setLayers(Arrays.asList(obstaclesLayer));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(500, 130));

        overworldCharacterLogic.update(0.01f);
        checkCenterAndHitbox(500, 225);
        checkSpeed(0, -5);
    }

    @Test
    public void testLeftCollision() {
        mockRandom(0);

        TiledMapTileLayer.Cell cell1 = createBlockingCell();
        TiledMapTileLayer.Cell cell2 = createBlockingCell();

        TiledMapTileLayer obstaclesLayer = mock(TiledMapTileLayer.class);
        when(obstaclesLayer.getCell(4, 2)).thenReturn(cell1);
        when(obstaclesLayer.getCell(4, 1)).thenReturn(cell2);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(obstaclesLayer));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(400, 200));

        overworldCharacterLogic.update(0.01f);
        checkCenterAndHitbox(495, 200);
        checkSpeed(-5, 0);
    }

    @Test
    public void testRightCollision() {
        mockRandom(0);

        TiledMapTileLayer.Cell cell1 = createBlockingCell();
        TiledMapTileLayer.Cell cell2 = createBlockingCell();

        TiledMapTileLayer obstaclesLayer = mock(TiledMapTileLayer.class);
        when(obstaclesLayer.getCell(6, 2)).thenReturn(cell1);
        when(obstaclesLayer.getCell(6, 1)).thenReturn(cell2);

        overworldCharacterLogic.initCenter(490, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(obstaclesLayer));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(590, 200));

        overworldCharacterLogic.update(0.01f);
        checkCenterAndHitbox(495, 200);
        checkSpeed(5, 0);
    }

    @Test
    public void testShortMovement() {
        mockRandom(0);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(mock(TiledMapTileLayer.class)));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(505, 200));

        overworldCharacterLogic.update(0.01f);
        checkCenterAndHitbox(500, 200);
        checkSpeed(0, 0);

        GridPoint2 moveTarget = (GridPoint2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "moveTarget");
        assertNull("Move target after camera move", moveTarget);
    }

    @Test
    public void testDiagonalMovement() {
        mockRandom(0);

        overworldCharacterLogic.initCenter(500, 200);
        overworldCharacterLogic.setLayers(Arrays.asList(mock(TiledMapTileLayer.class)));
        overworldCharacterLogic.setMoveTarget(new GridPoint2(800, 600));

        overworldCharacterLogic.update(0.01f);
        float speedX = 5.4f;
        float speedY = 7.2f;

        checkSpeed(speedX, speedY);
    }

    // TODO: move to Overworld Screen unit tests
//    @Test
//    public void testFightTriggered() throws Exception {
//        FightLoadingScreen fightLoadingScreen = mock(FightLoadingScreen.class);
//        FightComponent fightComponent = mock(FightComponent.class);
//        when(troncGame.getFightComponent()).thenReturn(fightComponent);
//        when(fightComponent.createFightLoadingScreen()).thenReturn(fightLoadingScreen);
//
//        mockRandom(999);
//
//        overworldCharacterLogic.initCenter(500, 200);
//        overworldCharacterLogic.setObstaclesLayer(mock(TiledMapTileLayer.class));
//        overworldCharacterLogic.setMoveTarget(new GridPoint2(800, 600));
//
//        overworldCharacterLogic.update(0.01f);
//        GridPoint2 moveTarget = (GridPoint2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "moveTarget");
//        assertNull("Move target after camera move", moveTarget);
//
//        verify(troncGame, times(1)).setScreen(fightLoadingScreen);
//    }

    private void checkCenterAndHitbox(int x, int y) {
        Vector2 center = (Vector2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "center");
        assertEquals("Center x coordinate after init", (float) x, center.x, 0.0001);
        assertEquals("Center y coordinate after init", (float) y, center.y, 0.0001);

        float xHitbox = x - OverworldConstants.TILE_WIDTH / 2;
        float yHitbox = y - OverworldConstants.TILE_HEIGHT / 2;
        assertEquals("Hitbox x coordinate after init", xHitbox, overworldCharacterLogic.getX(), 0.0001);
        assertEquals("Hitbox y coordinate after init", yHitbox, overworldCharacterLogic.getY(), 0.0001);

        Rectangle hitbox = (Rectangle) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "hitbox");
        assertEquals("Hitbox width", (float) OverworldConstants.TILE_WIDTH, hitbox.width, 0.0001);
        assertEquals("Hitbox height", (float) OverworldConstants.TILE_HEIGHT, hitbox.height, 0.0001);
    }

    private void checkSpeed(float x, float y) {
        Speed speed = (Speed) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "speed");
        assertEquals("Speed x after moving", x, speed.x, 0.0001);
        assertEquals("Speed y after moving", y, speed.y, 0.0001);
    }

    private void checkMoveTarget(int x, int y) {
        GridPoint2 moveTarget = (GridPoint2) TestUtils.retrieveValueFromObject(overworldCharacterLogic, "moveTarget");
        assertEquals("Move target x coordinate", x, moveTarget.x);
        assertEquals("Move target y coordinate", y, moveTarget.y);
    }

    private void mockRandom(int randomValue) {
        ThreadLocalRandom threadLocalRandom = mock(ThreadLocalRandom.class);
        when(threadLocalRandom.nextInt(anyInt(), anyInt())).thenReturn(randomValue);

        PowerMockito.mockStatic(ThreadLocalRandom.class);
        when(ThreadLocalRandom.current()).thenReturn(threadLocalRandom);
    }

    private TiledMapTileLayer.Cell createBlockingCell() {
        MapProperties mapProperties = mock(MapProperties.class);
        when(mapProperties.get(OverworldConstants.BLOCK)).thenReturn("true");

        TiledMapTile tile = mock(TiledMapTile.class);
        when(tile.getProperties()).thenReturn(mapProperties);

        TiledMapTileLayer.Cell cell = mock(TiledMapTileLayer.Cell.class);
        when(cell.getTile()).thenReturn(tile);

        return cell;
    }
}

