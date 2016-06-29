package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.mmyumu.troncgame.model.GameCharacter;


/**
 * GameCharacter which is displayed on the Overworld map
 * Created by mmyumu on 30/10/2015.
 */
public class OverworldCharacter extends OverworldCharacterLogic {
    private final SpriteBatch batch;
    private final Camera camera;

    private final Texture textureTop;
    private final Texture textureBottom;
    private final Texture textureLeft;
    private final Texture textureRight;

    private Texture currentTexture;

    public OverworldCharacter(GameCharacter character, AssetManager assetManager, Camera camera) {
        super(character);
        this.camera = camera;
        this.batch = new SpriteBatch();

        textureTop = assetManager.get(character.getDefinition().getOverworldTopTexturePath(), Texture.class);
        textureBottom = assetManager.get(character.getDefinition().getOverworldBottomTexturePath(), Texture.class);
        textureLeft = assetManager.get(character.getDefinition().getOverworldLeftTexturePath(), Texture.class);
        textureRight = assetManager.get(character.getDefinition().getOverworldRightTexturePath(), Texture.class);

        currentTexture = textureBottom;
    }

    public void draw() {
        batch.begin();

        if (getMoveTarget() != null) {
            double angle = Math.toDegrees(computeAngle(getMoveTarget().x, getMoveTarget().y, getCenter().x + 1, getCenter().y, getCenter().x, getCenter().y));
            if (angle < 0) {
                angle += 360;
            }
            if (angle >= 0 && angle < 45) {
                currentTexture = textureRight;
            } else if (angle >= 45 && angle < 135) {
                currentTexture = textureTop;
            } else if (angle >= 135 && angle < 225) {
                currentTexture = textureLeft;
            } else if (angle >= 225 && angle < 315) {
                currentTexture = textureBottom;
            } else if (angle >= 315 && angle < 360) {
                currentTexture = textureRight;
            }
            System.out.println("angle=" + angle);
        }

        batch.setProjectionMatrix(camera.combined);
        batch.setColor(1, 1, 1, 1);
        batch.draw(currentTexture, getX(), getY(), 90, 90);
        batch.end();
    }

    public double computeAngle(double point1X, double point1Y, double point2X, double point2Y, double fixedX, double fixedY) {
        double angle1 = Math.atan2(point1Y - fixedY, point1X - fixedX);
        double angle2 = Math.atan2(point2Y - fixedY, point2X - fixedX);

        return angle1 - angle2;
    }
}
