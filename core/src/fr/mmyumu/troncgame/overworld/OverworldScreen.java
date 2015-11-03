package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.Utils;

/**
 * Overworld screen displaying a top-down view to the world
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldScreen extends ScreenAdapter {
    private static final String TAG = "OverworldScreen";
    private final TroncGame troncGame;
    private final AssetManager assetManager;
    private final Utils utils;
    private OverworldCharacter mainCharacter;

    private Stage stage;

    @Inject
    public OverworldScreen(TroncGame troncGame, AssetManager assetManager, Utils utils) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
        this.utils = utils;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Overworld");


        stage = new Stage(new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT));

        FileHandle fileHandle = Gdx.files.internal("maps/village.txt");
        InputStream is = fileHandle.read();
        String map = utils.convertStreamToString(is);

        loadMap(map);
        loadCharacter();

    }

    private void loadCharacter() {
        Double centerX = OverworldConstants.TILE_WIDTH * 1.5;
        Double centerY = OverworldConstants.TILE_HEIGHT * 1.5;

        mainCharacter = new OverworldCharacter(new GridPoint2(centerX.intValue(), centerY.intValue()), assetManager);

        stage.addActor(mainCharacter);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    private void loadMap(String map) {
        List<String> lines = new ArrayList<String>();
        int width = 0;

        Scanner scanner = new Scanner(map);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // no more lines to read
            if (line == null) {
                break;
            }

            if (!line.startsWith("!")) {
                lines.add(line);
                width = Math.max(width, line.length());

            }
        }

        for (int j = 0; j < lines.size(); j++) {
            String line = lines.get(j);
            for (int i = 0; i < width; i++) {
                if (i < line.length()) {
                    char ch = line.charAt(i);
                    OverworldTile t = new OverworldTile(i * OverworldConstants.TILE_WIDTH, j * OverworldConstants.TILE_WIDTH, ch, assetManager);
                    stage.addActor(t);
                }
            }
        }
    }
}