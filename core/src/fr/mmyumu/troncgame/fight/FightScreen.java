package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.audio.Musical;

/**
 * Screen to be displayed when fight is engaged
 * Created by mmyumu on 17/11/2015.
 */
public class FightScreen extends ScreenAdapter implements Musical {
    private static final String TAG = "FightScreen";

    private final TroncGame troncGame;
    private final AssetManager assetManager;
    private final OrthographicCamera camera;
    private Viewport viewport;

    private FightGameStage fightGameStage;
    private Music firstChipTune;

    @Inject
    public FightScreen(TroncGame troncGame, AssetManager assetManager, OrthographicCamera camera) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.camera = camera;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Fight");

        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false);
        viewport = new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT);

        initStage();
        initMusic();
        initInputProcessors();

        viewport.apply();
    }

    private void initMusic() {
        firstChipTune = assetManager.get(FightConstants.MusicPath.FIRST_CHIPTUNE, Music.class);
        firstChipTune.setLooping(true);
        firstChipTune.play();
    }

    private void initStage() {
        fightGameStage = new FightGameStage(viewport);

        FightBackground fightBackground = troncGame.getFightComponent().createFightBackground();
        fightGameStage.addActor(fightBackground);

        FightMainCharacter fightMainCharacter = troncGame.getFightComponent().createFightMainCharacter();
        fightGameStage.addActor(fightMainCharacter);
    }

    /**
     * Init the multiplexer and the input processors
     */
    private void initInputProcessors() {
        // TODO: add UI input processor
        troncGame.setInputProcessors();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
        draw();
    }

    private void update(float delta) {
        fightGameStage.act(delta);
    }

    private void draw() {
        fightGameStage.draw();
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public boolean isPlaying() {
        return firstChipTune.isPlaying();
    }

    @Override
    public void play() {
        firstChipTune.play();
    }

    @Override
    public void stopPlaying() {
        firstChipTune.stop();
    }
}
