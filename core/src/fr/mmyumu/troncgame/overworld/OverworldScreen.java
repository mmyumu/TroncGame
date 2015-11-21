package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.overworld.game.OverworldCharacter;
import fr.mmyumu.troncgame.overworld.game.OverworldMap;
import fr.mmyumu.troncgame.overworld.ui.OverworldUIStage;

/**
 * Overworld screen displaying a top-down view to the world
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldScreen extends ScreenAdapter {
    private static final String TAG = "OverworldScreen";
    private final TroncGame troncGame;
    private final AssetManager assetManager;
    private final OverworldUIStage uiStage;
    private OverworldCharacter mainCharacter;
    private OverworldMap map;
    private OrthographicCamera camera;
    private Viewport viewport;

    @Inject
    public OverworldScreen(TroncGame troncGame, AssetManager assetManager, OrthographicCamera camera) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.camera = camera;

        this.uiStage = troncGame.getOverworldComponent().createOverworldUIStage();
    }

    public OverworldCharacter getMainCharacter() {
        return mainCharacter;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Overworld");

        camera.setToOrtho(false);
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);
        viewport.apply();

        map = new OverworldMap(OverworldConstants.MapPath.VILLAGE, camera, assetManager);
        mainCharacter = loadMainCharacter();

        initInputProcessors();
    }

    /**
     * Init the multiplexer and the input processors
     */
    private void initInputProcessors() {
        fr.mmyumu.troncgame.overworld.game.OverworldGameInputProcessor overworldGameInputProcessor = troncGame.getOverworldComponent().createOverworldGameInputProcessor();
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
        mainCharacter.update(delta);
        uiStage.act(delta);
    }

    private void draw() {
        float oldX = camera.position.x;
        float oldY = camera.position.y;

        float minX = Math.max(mainCharacter.getX(), Constants.WIDTH / 2);
        float newX = Math.min((map.getWidth() - Constants.WIDTH / 2), minX);

        float minY = Math.max(mainCharacter.getY(), Constants.HEIGHT / 2);
        float newY = Math.min((map.getHeight() - Constants.HEIGHT / 2), minY);

        camera.position.set(newX, newY, 0);
        camera.update();

        map.drawBackground();
        mainCharacter.draw();
        map.drawForeground();

        uiStage.draw();

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




        OverworldCharacter overworldCharacter = troncGame.getOverworldComponent().createOverworldCharacter();
        overworldCharacter.initCenter((int) centerX, (int) centerY);
        overworldCharacter.setObstaclesLayer(map.getObstaclesLayer());

        return overworldCharacter;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public Viewport getViewport() {
        return viewport;
    }
}