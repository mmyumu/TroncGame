package fr.mmyumu.troncgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import javax.inject.Inject;

/**
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuScreen extends ScreenAdapter {

    private OrthographicCamera cam;

    private Stage stage;

    private SpriteBatch batch;
    private BitmapFont font;
    private BitmapFont font72;
    private Texture mainMenu;
    private ShapeRenderer shapeRenderer;

    private TroncGame troncGame;
    private AssetManager assetManager;

    float xRatio;
    float yRatio;

    @Inject
    public MainMenuScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void render(float delta) {
        //cam.update();
        //batch.setProjectionMatrix(cam.combined);
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //shapeRenderer.rect(1133, 1457, 305, 133);
        //shapeRenderer.scale(xRatio, yRatio, 1);
        shapeRenderer.rect(650, 200, 200, 100);
        shapeRenderer.end();
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        shapeRenderer = new ShapeRenderer();
        mainMenu = assetManager.get("main_menu.png", Texture.class);

        System.out.println("### mainMenu.getWidth()=" + mainMenu.getWidth());
        System.out.println("### mainMenu.getHeight()=" + mainMenu.getHeight());

        System.out.println("### Gdx.graphics.getWidth()=" + Gdx.graphics.getWidth());
        System.out.println("### Gdx.graphics.getHeight()=" + Gdx.graphics.getHeight());

        xRatio = mainMenu.getWidth() / (float) Gdx.graphics.getWidth();
        yRatio = mainMenu.getHeight() / (float) Gdx.graphics.getHeight();
        //xRatio = Gdx.graphics.getWidth() / (float) mainMenu.getWidth();
        //yRatio = Gdx.graphics.getHeight() / (float) mainMenu.getHeight();

        System.out.println("### xRatio=" + xRatio);
        System.out.println("### yRatio=" + yRatio);


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 12;
        font72 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!

        //cam = new OrthographicCamera(2000 * xRatio, 500 * yRatio);
        //cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        //cam.update();

        stage = new Stage(new FitViewport(mainMenu.getWidth(), mainMenu.getHeight()));
        stage.addActor(new MyActor());
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    public class MyActor extends Actor {
        //Texture texture = new Texture(Gdx.files.internal("data/jet.png"));

        @Override
        public void draw(Batch batch, float alpha) {
            //batch.draw(texture,0,0);
//            batch.begin();
            batch.draw(mainMenu, 0, 0);
            font.draw(batch, "TEST String", 200, 200);
            font72.draw(batch, "test free type", 300, 300);
  //          batch.end();
        }
    }
}
