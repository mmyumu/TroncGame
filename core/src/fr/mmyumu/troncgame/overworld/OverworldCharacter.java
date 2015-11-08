package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Character which is displayed on the Overworld map
 * Created by mmyumu on 30/10/2015.
 */
class OverworldCharacter extends Actor {
    private static final String TAG = "OverworldCharacter";
    private static final int MOVE_SPEED = 20;

    private final AssetManager assetManager;
    private GridPoint2 center;
    private GridPoint2 moveTarget;
    private Speed speed;

    public OverworldCharacter(GridPoint2 center, AssetManager assetManager) {
        this.center = center;
        this.assetManager = assetManager;

        this.moveTarget = null;
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

    @Override
    public void act(float delta) {
        super.act(delta);

        if (moveTarget != null) {
            Gdx.app.debug(TAG, "moveTarget = " + moveTarget.x + ", " + moveTarget.y);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Texture texture = assetManager.get(OverworldConstants.TexturePath.MAIN_CHARACTER, Texture.class);
        batch.draw(texture, getX(), getY(), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
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
            Gdx.app.debug(TAG, "moveTarget.y - centerY=" + (moveTarget.y - center.x));
            Gdx.app.debug(TAG, "moveTarget.x - centerX=" + (moveTarget.x - center.y));

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
            Gdx.app.debug(TAG, "slope=" + slope);
            speed.x = (float) (MOVE_SPEED / Math.sqrt(slope * slope + 1));
            speed.y = (float) Math.sqrt(MOVE_SPEED * MOVE_SPEED - speed.x * speed.x);
        }

        if (moveTarget.x < center.x) {
            speed.invertX();
        }

        if (moveTarget.y < center.y) {
            speed.invertY();
        }

        System.out.println("speedX=" + speed.x + " speedY=" + speed.y);
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
}
