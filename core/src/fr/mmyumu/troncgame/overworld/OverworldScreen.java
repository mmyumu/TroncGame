package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;
import javax.inject.Named;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.ScreenState;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.overworld.game.OverworldCharacter;
import fr.mmyumu.troncgame.overworld.game.OverworldGameInputProcessor;
import fr.mmyumu.troncgame.overworld.game.OverworldMap;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenu;
import fr.mmyumu.troncgame.overworld.ui.OverworldUI;
import fr.mmyumu.troncgame.overworld.ui.OverworldUIInputProcessor;

/**
 * Overworld screen displaying a top-down view to the world
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldScreen extends ScreenAdapter {
    private static final String TAG = "OverworldScreen";

    private static final int MAX = 10;

    private final TroncGame troncGame;
    private final AssetManager assetManager;
    private final ScalingViewport gameViewport;
    private OverworldUI overworldUI;
    private OverworldMenu overworldMenu;

    private OverworldCharacter mainCharacter;
    private OverworldMap map;

    private ScreenState screenState;

    @Inject
    public OverworldScreen(TroncGame troncGame, AssetManager assetManager, @Named("game") ScalingViewport gameViewport) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.gameViewport = gameViewport;

        initStages();
    }

    private void initStages() {
        overworldUI = troncGame.getOverworldComponent().createOverworldUI();
        overworldMenu = troncGame.getOverworldComponent().createOverworldMenu();
    }

    public OverworldCharacter getMainCharacter() {
        return mainCharacter;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Overworld");

        screenState = ScreenState.RUNNING;

        OrthographicCamera gameCamera = (OrthographicCamera) gameViewport.getCamera();
        map = new OverworldMap(OverworldConstants.MapPath.VILLAGE, gameCamera, assetManager);
        mainCharacter = loadMainCharacter();

        initInputProcessors();
    }

    /**
     * Init the multiplexer and the input processors
     */
    private void initInputProcessors() {
        if (screenState == ScreenState.RUNNING) {
            OverworldGameInputProcessor overworldGameInputProcessor = troncGame.getOverworldComponent().createOverworldGameInputProcessor();
            OverworldUIInputProcessor overworldUIInputProcessor = troncGame.getOverworldComponent().createOverworldUIInputProcessor();
            troncGame.setInputProcessors(overworldUIInputProcessor, overworldGameInputProcessor);
        } else if (screenState == ScreenState.PAUSE) {
            troncGame.setInputProcessors(overworldMenu);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
        draw();
    }

    private void update(float delta) {
        switch (screenState) {
            case RUNNING:
                updateRunning(delta);
                break;
            case PAUSE:
                updatePause(delta);
                break;
        }
    }

    private void updatePause(float delta) {
        overworldMenu.act(delta);
    }

    private void updateRunning(float delta) {
        checkFight(delta);
        mainCharacter.update(delta);
        overworldUI.act(delta);
    }

    private void draw() {
        switch (screenState) {
            case RUNNING:
                drawRunning();
                break;
            case PAUSE:
                drawPause();
                break;
        }
    }

    private void drawPause() {
        map.drawBackground();
        mainCharacter.draw();
        map.drawForeground();
        overworldMenu.draw();
    }

    private void drawRunning() {
        float oldX = gameViewport.getCamera().position.x;
        float oldY = gameViewport.getCamera().position.y;

        float minX = Math.max(mainCharacter.getX(), Constants.WIDTH / 2);
        float newX = Math.min((map.getWidth() - Constants.WIDTH / 2), minX);

        float minY = Math.max(mainCharacter.getY(), Constants.HEIGHT / 2);
        float newY = Math.min((map.getHeight() - Constants.HEIGHT / 2), minY);

        gameViewport.getCamera().position.set(newX, newY, 0);
        gameViewport.getCamera().update();

        map.drawBackground();
        mainCharacter.draw();
        map.drawForeground();

        overworldUI.draw();

        cameraMoved(gameViewport.getCamera().position.x - oldX, gameViewport.getCamera().position.y - oldY);
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
        gameViewport.update(width, height);
    }

    private void checkFight(float delta) {
        if (mainCharacter.getMoveTarget() != null) {
            int randomMax = (int) (MAX / delta);
            int random = ThreadLocalRandom.current().nextInt(0, randomMax);
            Gdx.app.debug(TAG, "Random=" + random + " randomMax=" + randomMax);
            if (random == randomMax - 1) {
                mainCharacter.setMoveTarget(null);
                startFight();
            }
        }

    }

    public void startFight() {
        Gdx.input.setInputProcessor(null);
        troncGame.setScreen(troncGame.getFightComponent().createFightLoadingScreen());
    }

    public void pauseGame() {
        mainCharacter.setMoveTarget(null);
        screenState = ScreenState.PAUSE;
        initInputProcessors();
    }

    public void resumeGame() {
        screenState = ScreenState.RUNNING;
        initInputProcessors();
    }
}