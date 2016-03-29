package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.audio.Musical;
import fr.mmyumu.troncgame.fight.game.FightGame;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenu;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.ui.FightUI;

/**
 * Screen to be displayed when fight is engaged
 * Created by mmyumu on 17/11/2015.
 */
public class FightScreen extends ScreenAdapter implements Musical, InputProcessor {
    private static final String TAG = "FightScreen";
    private static final float END_DELAY = 1;

    private final TroncGame troncGame;
    private final AssetManager assetManager;
    private final Viewport viewport;

    private final FightGame fightGame;
    private final FightPopUpMenu fightPopUpMenu;
    private final FightUI fightUI;

    private final FightLogic fightLogic;

    private Music firstChipTune;
    private boolean ended;

    @Inject
    public FightScreen(TroncGame troncGame, AssetManager assetManager, ScalingViewport viewport, FightLogic fightLogic) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.viewport = viewport;
        this.fightLogic = fightLogic;

        fightGame = troncGame.getFightComponent().createFightGame();
        fightUI = troncGame.getFightComponent().createFightUI();
        fightPopUpMenu = new FightPopUpMenu(viewport);

        ended = false;

        initStages();
    }

    private void initStages() {
        initGame();
        initUI();
        initFightPopUpMenu();
    }


    private void initGame() {
        fightGame.initBackground(fightLogic.getFightBackground());
        fightGame.initFightTeam(fightLogic.getFightTeam());
        fightGame.initEnemyTeam(fightLogic.getEnemyFightTeam());
    }

    private void initUI() {
        fightUI.initMainInfos(fightLogic.getMainInfos());
    }

    private void initFightPopUpMenu() {
        fightPopUpMenu.initPopUpElements(fightLogic.getPopUpMenuLogic().getPopUpMenuElements());
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Fight");

        initMusic();
        initInputProcessors();
    }

    private void initMusic() {
        firstChipTune = assetManager.get(FightConstants.MusicPath.FIRST_CHIPTUNE, Music.class);
        firstChipTune.setLooping(true);
        firstChipTune.play();
    }

    /**
     * Init the multiplexer and the input processors
     */
    private void initInputProcessors() {
        // TODO: add UI input processor
        troncGame.setInputProcessors(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
        draw();
    }

    private void update(float delta) {
        if (fightLogic.isEnded() && !ended) {
            ended = true;
            endFight();
        }
        fightLogic.update(delta);
        fightGame.act(delta);
        fightUI.act(delta);
        fightPopUpMenu.act(delta);
    }

    private void endFight() {
        stopPlaying();

        Gdx.input.setInputProcessor(null);

        //TODO: Play win music

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                troncGame.setScreen(troncGame.getOverworldComponent().createOverworldLoadingScreen());
            }
        }, END_DELAY);
    }

    private void draw() {
        fightGame.draw();
        fightUI.draw();
        fightPopUpMenu.draw();
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touchCoords = viewport.unproject(new Vector2(screenX, screenY));

        Actor hitIcon = fightPopUpMenu.hit(touchCoords.x, touchCoords.y, true);
        if (hitIcon instanceof FightPopUpMenuIcon) {
            FightPopUpMenuIcon touchedIcon = (FightPopUpMenuIcon) hitIcon;
            fightLogic.iconTouched(touchedIcon);
        } else {
            Actor hitCharacter = fightGame.hit(touchCoords.x, touchCoords.y, true);
            if (hitCharacter instanceof FightCharacter) {
                FightCharacter touchedCharacter = (FightCharacter) hitCharacter;
                fightLogic.characterTouched(touchedCharacter);
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
