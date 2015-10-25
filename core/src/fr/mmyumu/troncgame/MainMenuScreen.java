package fr.mmyumu.troncgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;

/**
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuScreen extends ScreenAdapter {

    private Texture mainMenu;
    private Stage stage;

    private TroncGame troncGame;
    private AssetManager assetManager;

    @Inject
    public MainMenuScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void show() {
        mainMenu = assetManager.get("data/main_menu.png", Texture.class);

        stage = new Stage(new ScalingViewport(Scaling.fit, mainMenu.getWidth(), mainMenu.getHeight()));
        stage.addActor(new MainMenuActor());
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    public class MainMenuActor extends Actor {
        private SpriteBatch batch;
        private BitmapFont font;
        private ShapeRenderer shapeRenderer;
        private GlyphLayout layout;
        private float startX;
        private float startY;


        public MainMenuActor() {
            shapeRenderer = new ShapeRenderer();
            layout = new GlyphLayout();

            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = 72;
            font = generator.generateFont(parameter); // font size 12 pixels
            generator.dispose(); // don't forget to dispose to avoid memory leaks!

            layout.setText(font, "Start");
            startX = mainMenu.getWidth() / 2 - layout.width / 2;
            startY = 300;

            font.setColor(1f, 0.5f, 0.5f, 1f);

        }

        @Override
        public void draw(Batch batch, float alpha) {
            batch.draw(mainMenu, 0, 0);
            font.draw(batch, "Start", startX, startY);
            batch.end();

            shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
            shapeRenderer.setTransformMatrix(batch.getTransformMatrix());

            GL20 gl = Gdx.graphics.getGL20();
            gl.glEnable(GL20.GL_BLEND);
            gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(1f, 0.5f, 0.5f, 0.1f);
            shapeRenderer.rect(startX, startY, layout.width, -layout.height);
            shapeRenderer.end();
            gl.glDisable(GL20.GL_BLEND);

            batch.begin();
        }
    }
}
