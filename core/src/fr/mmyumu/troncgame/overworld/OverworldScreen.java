package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.Utils;

/**
 * Overworld screen displaying a top-down view to the world
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldScreen extends ScreenAdapter {
    private static final String TAG = "OverworldScreen";
    private final TroncGame troncGame;
    private final AssetManager assetManager;
    private final Utils utils;
    private OverworldCharacter mainCharacter;
    private OverworldMap map;
    private OrthographicCamera camera;
    private Viewport viewport;
//    private TiledMap tiledMap;

//    private Stage gameStage;

    @Inject
    public OverworldScreen(TroncGame troncGame, AssetManager assetManager, Utils utils) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.utils = utils;
    }

//    public Stage getGameStage() {
//        return gameStage;
//    }

    public OverworldCharacter getMainCharacter() {
        return mainCharacter;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Overworld");

//        gameStage = new Stage(new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT));

//        FileHandle fileHandle = Gdx.files.internal(OverworldConstants.MapPath.VILLAGE);
//        InputStream is = fileHandle.read();
//        String map = utils.convertStreamToString(is);


        camera = new OrthographicCamera();
//        camera.setToOrtho(false);
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);
        viewport.apply();

//        camera.position.set(Constants.WIDTH / 2, Constants.HEIGHT / 2, 0);

        loadMap(OverworldConstants.MapPath.VILLAGE);
        mainCharacter = loadMainCharacter();

        initInputProcessors();
    }

    private void loadMap(String mapPath) {
        map = new OverworldMap(mapPath, camera, assetManager);
    }

    /**
     * Init the multiplexer and the input processors
     */
    private void initInputProcessors() {
        OverworldGameInputProcessor overworldGameInputProcessor = troncGame.getOverworldComponent().createOverworldGameInputProcessor();
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new OverworldUIInputProcessor());
        multiplexer.addProcessor(overworldGameInputProcessor);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        draw();

        camera.update();
    }

    private void update(float delta) {
        moveMainCharacter();
//        gameStage.act(delta);
    }

    private void draw() {
        map.drawBackground();
        mainCharacter.draw();
        map.drawForeground();
//        gameStage.draw();
        float oldX = camera.position.x;
        float oldY = camera.position.y;

        float minX = Math.max(mainCharacter.getX(), Constants.WIDTH / 2);
        float newX = Math.min((map.getWidth() - Constants.WIDTH / 2), minX);

        float minY = Math.max(mainCharacter.getY(), Constants.HEIGHT / 2);
        float newY = Math.min((map.getHeight() - Constants.HEIGHT / 2), minY);

//        camera.position.set(newX, newY, 0);
        camera.position.set(mainCharacter.getX(), mainCharacter.getY(), 0);
//        gameStage.getCamera().position.x = newX;
//        gameStage.getCamera().position.y = newY;
        cameraMoved(camera.position.x - oldX, camera.position.y - oldY);
    }

    private void cameraMoved(float x, float y) {
        mainCharacter.cameraMoved(x, y);
    }

    private void moveMainCharacter() {
        mainCharacter.computeMovement();

        float maximumHorizontalMovement = computeMaximumHorizontalMovementOnCollision(mainCharacter.getSpeed().x);
        mainCharacter.getSpeed().x = maximumHorizontalMovement;
        mainCharacter.applyHorizontalMovement();

        float maximumVerticalMovement = computeMaximumVerticalMovementOnCollision(mainCharacter.getSpeed().y);
        mainCharacter.getSpeed().y = maximumVerticalMovement;
        mainCharacter.applyVerticalMovement();
    }

    private float computeMaximumHorizontalMovementOnCollision(float speedX) {
//        for (OverworldTile obstacle : map.getObstacles()) {
//            Rectangle characterHitboxAfterMove = new Rectangle(mainCharacter.getX() + speedX, mainCharacter.getY(), mainCharacter.getWidth(), mainCharacter.getHeight());
//            Rectangle obstacleHitbox = new Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
//            Rectangle intersection = new Rectangle();
//            if (Intersector.intersectRectangles(characterHitboxAfterMove, obstacleHitbox, intersection)) {
//                Gdx.app.debug(TAG, "Horizontal collision detected");
//                if (intersection.x > characterHitboxAfterMove.x) {
//                    return speedX - intersection.width;
//                } else if (intersection.x + intersection.width < characterHitboxAfterMove.x + characterHitboxAfterMove.width) {
//                    return speedX + intersection.width;
//                } else {
//                    Gdx.app.error(TAG, "Should not happen");
//                }
//            }
//        }

        return speedX;
    }

    private float computeMaximumVerticalMovementOnCollision(float speedY) {
//        for (OverworldTile obstacle : map.getObstacles()) {
//            Rectangle characterHitboxAfterMove = new Rectangle(mainCharacter.getX(), mainCharacter.getY() + speedY, mainCharacter.getWidth(), mainCharacter.getHeight());
//            Rectangle obstacleHitbox = new Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
//            Rectangle intersection = new Rectangle();
//            if (Intersector.intersectRectangles(characterHitboxAfterMove, obstacleHitbox, intersection)) {
//                Gdx.app.debug(TAG, "Vertical collision detected");
//                if (intersection.y > characterHitboxAfterMove.y) {
//                    return speedY - intersection.height;
//                } else if (intersection.y + intersection.height < characterHitboxAfterMove.y + characterHitboxAfterMove.height) {
//                    return speedY + intersection.height;
//                } else {
//                    Gdx.app.error(TAG, "Should not happen");
//                }
//            }
//        }

        return speedY;
    }

    /**
     * Load the character and add it to the gameStage
     */
    private OverworldCharacter loadMainCharacter() {
        Double centerX = OverworldConstants.TILE_WIDTH * 1.5;
        Double centerY = OverworldConstants.TILE_HEIGHT * 1.5;

        Vector2 newCoords = new Vector2(centerX.floatValue(), centerY.floatValue());

        OverworldCharacter character = new OverworldCharacter(new GridPoint2((int) newCoords.x, (int) newCoords.y), camera, assetManager);

//        gameStage.addActor(character);

        return character;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
//        gameStage.getViewport().update(width, height);
    }

    public Viewport getViewport() {
        return viewport;
    }
}