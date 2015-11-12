package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Character which is displayed on the Overworld map
 * Created by mmyumu on 30/10/2015.
 */
class OverworldCharacter extends Actor {
    private static final String TAG = "OverworldCharacter";
    private static final int MOVE_SPEED = 30;

    private final AssetManager assetManager;
    private GridPoint2 center;
    private Camera camera;
    private GridPoint2 moveTarget;
    private Speed speed;

    private SpriteBatch batch;

    public OverworldCharacter(GridPoint2 center, Camera camera, AssetManager assetManager) {
        this.center = center;
        this.camera = camera;
        this.assetManager = assetManager;

        this.moveTarget = null;

        this.batch = new SpriteBatch();

        initBounds(center);
    }

    private void initBounds(GridPoint2 p) {
        setBounds(retrieveLeft(p), retrieveBottom(p), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
    }

    private int retrieveLeft(GridPoint2 p) {
        return p.x - OverworldConstants.TILE_WIDTH / 2;
    }

    private int retrieveBottom(GridPoint2 p) {
        return p.y - OverworldConstants.TILE_HEIGHT / 2;
    }

    public void update(float delta) {
        super.act(delta);

        if (moveTarget != null) {
            Gdx.app.debug(TAG, "moveTarget = " + moveTarget.x + ", " + moveTarget.y);
        }
    }

    public void draw() {
        batch.begin();
        Texture texture = assetManager.get(OverworldConstants.TexturePath.MAIN_CHARACTER, Texture.class);
        batch.setProjectionMatrix(camera.combined);
        batch.draw(texture, getX(), getY(), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
        batch.end();
    }

    public void setMoveTarget(GridPoint2 moveTarget) {
        this.moveTarget = moveTarget;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void computeMovement() {
        speed = new Speed(0, 0);

        if (moveTarget != null) {
            Gdx.app.debug(TAG, "centerX=" + center.x + " centerY=" + center.y);
            Gdx.app.debug(TAG, "moveTarget x=" + moveTarget.x + " y=" + moveTarget.y);

            if (!isTargetCloserThanMaxMovement()) {
                speed = computeSpeed();
            } else {
                moveTarget = null;
            }
        }
    }

    private boolean isTargetCloserThanMaxMovement() {
        int xDistance = moveTarget.x - center.x;
        int yDistance = moveTarget.y - center.y;
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance)) < MOVE_SPEED;
    }

    private Speed computeSpeed() {
        Speed speed = new Speed();
        if (isVerticalMovement()) {
            speed.x = 0;
            speed.y = MOVE_SPEED;
        } else if (isHorizontalMovement()) {
            speed.x = MOVE_SPEED;
            speed.y = 0;
        } else {
            int xDistance = moveTarget.x - center.x;
            int yDistance = moveTarget.y - center.y;

            double slope = yDistance / (double) xDistance;
            speed.x = (float) (MOVE_SPEED / Math.sqrt(slope * slope + 1));
            speed.y = (float) Math.sqrt(MOVE_SPEED * MOVE_SPEED - speed.x * speed.x);
        }

        if (moveTarget.x < center.x) {
            speed.invertX();
        }

        if (moveTarget.y < center.y) {
            speed.invertY();
        }

        Gdx.app.debug(TAG, "speedX=" + speed.x + " speedY=" + speed.y);
        return speed;
    }

    private boolean isVerticalMovement() {
        return moveTarget.x == center.x;
    }

    private boolean isHorizontalMovement() {
        return moveTarget.y == center.y;
    }

    public void applyHorizontalMovement() {
        center.x += speed.x;
        initBounds(center);
    }

    public void applyVerticalMovement() {
        center.y += speed.y;
        initBounds(center);
    }

    public void cameraMoved(float x, float y) {
        if (moveTarget != null) {
            Gdx.app.debug(TAG, "Camera moved x=" + x + " y=" + y);
            moveTarget.x += x;
            moveTarget.y += y;
        }
    }
}
