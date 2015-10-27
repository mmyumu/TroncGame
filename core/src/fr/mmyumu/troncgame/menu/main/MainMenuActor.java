package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by mmyumuE on 27/10/2015.
 */
public class MainMenuActor extends Actor implements InputProcessor {
    private static final String TAG = "MainMenuActor";

    private Texture mainMenu;
    private BitmapFont font;
    private ShapeRenderer shapeRenderer;
    private Rectangle startBounds;

    private AssetManager assetManager;

    public MainMenuActor(AssetManager assetManager) {
        this.assetManager = assetManager;

        shapeRenderer = new ShapeRenderer();

        loadFonts();
        loadTexture();

        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, "Start");
        float startX = mainMenu.getWidth() / 2 - layout.width / 2;
        float startY = 300;

        startBounds = new Rectangle(startX, startY - layout.height, layout.width, layout.height);
    }

    private void loadFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 72;
        font = generator.generateFont(parameter);
        generator.dispose();

        font.setColor(1f, 0.5f, 0.5f, 1f);
    }

    private void loadTexture() {
        mainMenu = assetManager.get("data/main_menu.png", Texture.class);
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(mainMenu, 0, 0);
        font.draw(batch, "Start", startBounds.getX(), startBounds.getY() + startBounds.getHeight());
        batch.end();

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.setTransformMatrix(batch.getTransformMatrix());

        GL20 gl = Gdx.graphics.getGL20();
        gl.glEnable(GL20.GL_BLEND);
        gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1f, 0.5f, 0.5f, 0.1f);
        shapeRenderer.rect(startBounds.getX(), startBounds.getY(), startBounds.getWidth(), startBounds.getHeight());
        shapeRenderer.end();
        gl.glDisable(GL20.GL_BLEND);

        batch.begin();
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
        Vector2 convertedPoint = getStage().getViewport().unproject(new Vector2(screenX, screenY));
        if(startBounds.contains(convertedPoint.x, convertedPoint.y)) {
            // TODO: implement functional code here (test github)
            Gdx.app.log(TAG, "### START");
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
