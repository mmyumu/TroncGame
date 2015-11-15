package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.GridPoint2;
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
        camera.setToOrtho(false);
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
    }

    private void update(float delta) {
//        moveMainCharacter();
        mainCharacter.update(delta);
    }

    private void draw() {
        float oldX = camera.position.x;
        float oldY = camera.position.y;

        float minX = Math.max(mainCharacter.getX(), Constants.WIDTH / 2);
        float newX = Math.min((map.getWidth() - Constants.WIDTH / 2), minX);

        float minY = Math.max(mainCharacter.getY(), Constants.HEIGHT / 2);
        float newY = Math.min((map.getHeight() - Constants.HEIGHT / 2), minY);

        camera.position.set(newX, newY, 0);
//        camera.position.set(mainCharacter.getX(), mainCharacter.getY(), 0);
//        gameStage.getCamera().position.x = newX;
//        gameStage.getCamera().position.y = newY;


        camera.update();

        map.drawBackground();
        mainCharacter.draw();
        map.drawForeground();

        cameraMoved(camera.position.x - oldX, camera.position.y - oldY);
    }

    private void cameraMoved(float x, float y) {
        mainCharacter.cameraMoved(x, y);
    }

    /**
     * Load the character and add it to the gameStage
     */
    private OverworldCharacter loadMainCharacter() {
        float centerX = OverworldConstants.TILE_WIDTH * 1.5f;
        float centerY = OverworldConstants.TILE_HEIGHT * 1.5f;

        OverworldCharacter character = new OverworldCharacter(new GridPoint2((int) centerX, (int) centerY), camera, map.getObstaclesLayer(), assetManager);

        return character;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public Viewport getViewport() {
        return viewport;
    }
}