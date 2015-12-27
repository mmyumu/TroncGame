package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.audio.Musical;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import fr.mmyumu.troncgame.fight.ui.FightUIStage;

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
    private FightPopUpMenuStage fightPopUpMenuStage;
    private FightUIStage fightUIStage;

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

        camera.setToOrtho(false);
        viewport = new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT, camera);

        initStages();
        initMusic();
        initInputProcessors();

        viewport.apply();
    }

    private void initMusic() {
        firstChipTune = assetManager.get(FightConstants.MusicPath.FIRST_CHIPTUNE, Music.class);
        firstChipTune.setLooping(true);
        firstChipTune.play();
    }

    private void initStages() {
        initFightGameStage();
        initFightPopUpStage();
        initFightUIStage();
    }

    private void initFightGameStage() {
        fightGameStage = new FightGameStage(viewport);

        FightBackground fightBackground = troncGame.getFightComponent().createFightBackground();
        fightGameStage.addActor(fightBackground);

        FightMainCharacter fightMainCharacter = troncGame.getFightComponent().createFightMainCharacter();
        fightGameStage.addActor(fightMainCharacter);

        FightSideKickCharacter fightSideKickCharacter = troncGame.getFightComponent().createFightSideKickCharacter();
        fightGameStage.addActor(fightSideKickCharacter);
    }

    private void initFightPopUpStage() {
        fightPopUpMenuStage = new FightPopUpMenuStage(viewport);

        FightPopUpMenuIcon fightPopUpMenuSpellsIcon = troncGame.getFightComponent().createFightPopUpMenuSpellsIcon();
        fightPopUpMenuStage.addActor(fightPopUpMenuSpellsIcon);

        FightPopUpMenuIcon fightPopUpMenuWeaponsIcon = troncGame.getFightComponent().createFightPopUpMenuWeaponsIcon();
        fightPopUpMenuStage.addActor(fightPopUpMenuWeaponsIcon);
    }

    private void initFightUIStage() {
        fightUIStage = new FightUIStage(viewport);

        FightMainInfos fightMainInfos = troncGame.getFightComponent().createFightMainInfos();
        fightUIStage.addActor(fightMainInfos);
    }


    /**
     * Init the multiplexer and the input processors
     */
    private void initInputProcessors() {
        // TODO: add UI input processor
        FightGameInputProcessor fightGameInputProcessor = troncGame.getFightComponent().createFightGameInputProcessor();
//        GestureDetector gestureDetector = new GestureDetector(fightGameInputProcessor);
        troncGame.setInputProcessors(fightGameInputProcessor);
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
        fightUIStage.act(delta);
        fightPopUpMenuStage.act(delta);
    }

    private void draw() {
        fightGameStage.draw();
        fightUIStage.draw();
        fightPopUpMenuStage.draw();
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

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touchCoords = viewport.unproject(new Vector2(screenX, screenY));

        Actor hitIcon = fightPopUpMenuStage.hit(touchCoords.x, touchCoords.y, true);
        if (hitIcon != null && hitIcon instanceof FightPopUpMenuIcon) {
            Gdx.app.debug(TAG, "Icon touched !");
        } else {
            Actor hitCharacter = fightGameStage.hit(touchCoords.x, touchCoords.y, true);
            if (hitCharacter != null && hitCharacter instanceof FightCharacter) {
                Gdx.app.debug(TAG, "Fight character touched !");

                FightCharacter fightCharacter = (FightCharacter) hitCharacter;
                fightPopUpMenuStage.characterTouched(fightCharacter, touchCoords);
            }
        }

        return false;
    }
}
