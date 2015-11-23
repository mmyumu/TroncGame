package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.backends.lwjgl.audio.Ogg;
import com.badlogic.gdx.graphics.GL20;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Screen to be displayed when fight is engaged
 * Created by mmyumu on 17/11/2015.
 */
public class FightScreen extends ScreenAdapter {
    private static final String TAG = "FightScreen";

    private final TroncGame troncGame;
    private final AssetManager assetManager;

    @Inject
    public FightScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Fight");
        Music firstChipTune = assetManager.get(FightConstants.MusicPath.FIRST_CHIPTUNE, Music.class);
        firstChipTune.setLooping(true);
        firstChipTune.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        update(delta);
//        draw();
    }
}
