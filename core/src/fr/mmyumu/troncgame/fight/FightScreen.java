package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;

/**
 * Screen to be displayed when fight is engaged
 * Created by mmyumu on 17/11/2015.
 */
public class FightScreen extends ScreenAdapter {
    private static final String TAG = "FightScreen";

    private final TroncGame troncGame;
    private final AssetManager assetManager;
    private final OrthographicCamera camera;
    private Viewport viewport;

    private FightGameStage fightGameStage;

    private SpriteBatch batch;

    @Inject
    public FightScreen(TroncGame troncGame, AssetManager assetManager, OrthographicCamera camera) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.camera = camera;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Fight");


        fightGameStage = new FightGameStage();
        FightMainCharacter fightMainCharacter = troncGame.getFightComponent().createFightMainCharacter();
        fightGameStage.addActor(fightMainCharacter);

        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false);
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);
        viewport.apply();

        batch = new SpriteBatch();

        Music firstChipTune = assetManager.get(FightConstants.MusicPath.FIRST_CHIPTUNE, Music.class);
        firstChipTune.setLooping(true);
        firstChipTune.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
        draw();
    }

    private void update(float delta) {

    }

    private void draw() {
        batch.begin();
        batch.draw(assetManager.get(FightConstants.TexturePath.BACKGROUND_PLAIN, Texture.class), 0, 0, Constants.WIDTH, Constants.HEIGHT);
        batch.end();

        fightGameStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
