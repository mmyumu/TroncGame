package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private List<OverworldTile> obstacles;

    private Stage gameStage;

    @Inject
    public OverworldScreen(TroncGame troncGame, AssetManager assetManager, Utils utils) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.utils = utils;
    }

    public Stage getGameStage() {
        return gameStage;
    }

    public OverworldCharacter getMainCharacter() {
        return mainCharacter;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Overworld");

        gameStage = new Stage(new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT));

        FileHandle fileHandle = Gdx.files.internal(OverworldConstants.MapPath.VILLAGE);
        InputStream is = fileHandle.read();
        String map = utils.convertStreamToString(is);

        loadMap(map);
        mainCharacter = loadMainCharacter();

        initInputProcessors();
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
    }

    private void update(float delta) {
        moveMainCharacter();
        gameStage.act(delta);
    }

    private void draw() {
        gameStage.draw();
        float oldX = gameStage.getCamera().position.x;
        float oldY = gameStage.getCamera().position.y;
        gameStage.getCamera().position.x = Math.max(mainCharacter.getX(), Constants.WIDTH / 2);
        gameStage.getCamera().position.y = Math.max(mainCharacter.getY(), Constants.HEIGHT / 2);

        cameraMoved(gameStage.getCamera().position.x - oldX, gameStage.getCamera().position.y - oldY);
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
        for (OverworldTile obstacle : obstacles) {
            Rectangle characterHitboxAfterMove = new Rectangle(mainCharacter.getX() + speedX, mainCharacter.getY(), mainCharacter.getWidth(), mainCharacter.getHeight());
            Rectangle obstacleHitbox = new Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
            Rectangle intersection = new Rectangle();
            if (Intersector.intersectRectangles(characterHitboxAfterMove, obstacleHitbox, intersection)) {
                Gdx.app.debug(TAG, "Horizontal collision detected");
                if (intersection.x > characterHitboxAfterMove.x) {
                    return speedX - intersection.width;
                } else if (intersection.x + intersection.width < characterHitboxAfterMove.x + characterHitboxAfterMove.width) {
                    return speedX + intersection.width;
                } else {
                    Gdx.app.error(TAG, "Should not happen");
                }
            }
        }

        return speedX;
    }

    private float computeMaximumVerticalMovementOnCollision(float speedY) {
        for (OverworldTile obstacle : obstacles) {
            Rectangle characterHitboxAfterMove = new Rectangle(mainCharacter.getX(), mainCharacter.getY() + speedY, mainCharacter.getWidth(), mainCharacter.getHeight());
            Rectangle obstacleHitbox = new Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
            Rectangle intersection = new Rectangle();
            if (Intersector.intersectRectangles(characterHitboxAfterMove, obstacleHitbox, intersection)) {
                Gdx.app.debug(TAG, "Vertical collision detected");
                if (intersection.y > characterHitboxAfterMove.y) {
                    return speedY - intersection.height;
                } else if (intersection.y + intersection.height < characterHitboxAfterMove.y + characterHitboxAfterMove.height) {
                    return speedY + intersection.height;
                } else {
                    Gdx.app.error(TAG, "Should not happen");
                }
            }
        }

        return speedY;
    }

    /**
     * Load the given map by instantiating all the tiles
     *
     * @param map
     */
    private void loadMap(String map) {
        List<String> lines = new ArrayList<String>();
        int width = 0;

        Scanner scanner = new Scanner(map);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // no more lines to read
            if (line == null) {
                break;
            }

            if (!line.startsWith("!")) {
                lines.add(line);
                width = Math.max(width, line.length());

            }
        }

        obstacles = new ArrayList<OverworldTile>();
        for (int j = 0; j < lines.size(); j++) {
            String line = lines.get(j);
            for (int i = 0; i < width; i++) {
                if (i < line.length()) {
                    char ch = line.charAt(i);
                    OverworldTile t = new OverworldTile(i * OverworldConstants.TILE_WIDTH, (lines.size() - j) * OverworldConstants.TILE_HEIGHT, ch, assetManager);
                    gameStage.addActor(t);
                    if (t.getType().isObstacle()) {
                        obstacles.add(t);
                    }
                }
            }
        }
    }

    /**
     * Load the character and add it to the gameStage
     */
    private OverworldCharacter loadMainCharacter() {
        Double centerX = OverworldConstants.TILE_WIDTH * 1.5;
        Double centerY = OverworldConstants.TILE_HEIGHT * 1.5;

        OverworldCharacter character = new OverworldCharacter(new GridPoint2(centerX.intValue() + OverworldConstants.TILE_WIDTH, centerY.intValue() + OverworldConstants.TILE_HEIGHT), assetManager);

        gameStage.addActor(character);

        return character;
    }

    @Override
    public void resize(int width, int height) {
        gameStage.getViewport().update(width, height);
    }
}