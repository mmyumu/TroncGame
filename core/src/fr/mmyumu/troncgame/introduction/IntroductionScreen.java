package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Display the introduction of the game
 * Created by mmyumu on 22/02/2016.
 */
public class IntroductionScreen extends ScreenAdapter {
    private TroncGame troncGame;
    private ScalingViewport viewport;
    private Introduction introduction;

    public IntroductionScreen(TroncGame troncGame, ScalingViewport viewport) {
        this.troncGame = troncGame;
        this.viewport = viewport;
    }


    @Override
    public void show() {
        super.show();
        initStages();
    }

    private void initStages() {
        IntroductionText introductionText = troncGame.getIntroductionComponent().introductionText();

        introduction = troncGame.getIntroductionComponent().introduction();
        introduction.init(introductionText);
    }



    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        introduction.act(delta);
    }

    private void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        introduction.draw();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
