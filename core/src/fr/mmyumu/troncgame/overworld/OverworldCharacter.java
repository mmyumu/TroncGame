package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Character which is displayed on the Overworld map
 * Created by mmyumu on 30/10/2015.
 */
class OverworldCharacter {
    private static final String TAG = "OverworldCharacter";
    private static final int MOVE_SPEED = 30;

    private final AssetManager assetManager;
    private final Camera camera;
    private final TiledMapTileLayer obstaclesLayer;
    private final GridPoint2 center;
    private final Rectangle hitbox;
    private final SpriteBatch batch;
    private GridPoint2 moveTarget;
    private Speed speed;

    public OverworldCharacter(GridPoint2 center, Camera camera, TiledMapTileLayer obstaclesLayer, AssetManager assetManager) {
        this.center = center;
        this.camera = camera;
        this.obstaclesLayer = obstaclesLayer;
        this.assetManager = assetManager;

        this.moveTarget = null;

        this.batch = new SpriteBatch();

        this.hitbox = new Rectangle();
        initHitbox(center);
    }

    private void initHitbox(GridPoint2 p) {
        hitbox.set(retrieveLeft(p), retrieveBottom(p), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
    }

    private int retrieveLeft(GridPoint2 p) {
        return p.x - OverworldConstants.TILE_WIDTH / 2;
    }

    private int retrieveBottom(GridPoint2 p) {
        return p.y - OverworldConstants.TILE_HEIGHT / 2;
    }

    public void update(float delta) {
        if (moveTarget != null) {
            Gdx.app.debug(TAG, "moveTarget = " + moveTarget.x + ", " + moveTarget.y);
            move();
        }
    }

    public void draw() {
        batch.begin();
        Texture texture = assetManager.get(OverworldConstants.TexturePath.MAIN_CHARACTER, Texture.class);
        batch.setProjectionMatrix(camera.combined);
        batch.setColor(1, 1, 1, 1);
        batch.draw(texture, getX(), getY(), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
        batch.end();
    }

    public void setMoveTarget(GridPoint2 moveTarget) {
        this.moveTarget = moveTarget;
    }

    public void cameraMoved(float x, float y) {
        if (moveTarget != null) {
            Gdx.app.debug(TAG, "Camera moved x=" + x + " y=" + y);
            moveTarget.x += x;
            moveTarget.y += y;
        }
    }

    public float getX() {
        return hitbox.x;
    }

    public float getY() {
        return hitbox.y;
    }


    private void move() {
        computeMovement();

        speed.x = computeMaximumHorizontalMovementOnCollision(speed.x);
        applyHorizontalMovement();

        speed.y = computeMaximumVerticalMovementOnCollision(speed.y);
        applyVerticalMovement();
    }

    private void computeMovement() {
        speed.x = 0;
        speed.y = 0;

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

    private void applyHorizontalMovement() {
        center.x += speed.x;
        initHitbox(center);
    }

    private void applyVerticalMovement() {
        center.y += speed.y;
        initHitbox(center);
    }

    private float computeMaximumHorizontalMovementOnCollision(float speedX) {
        Rectangle characterHitboxAfterMove = new Rectangle(getX() + speedX, getY(), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
        List<Rectangle> obstaclesHitbox = retrieveSurroundingHitboxes(characterHitboxAfterMove);

        for (Rectangle obstacleHitbox : obstaclesHitbox) {
            Rectangle intersection = new Rectangle();
            if (Intersector.intersectRectangles(characterHitboxAfterMove, obstacleHitbox, intersection)) {
                Gdx.app.debug(TAG, "Horizontal collision detected");
                if (intersection.x > characterHitboxAfterMove.x) {
                    return speedX - intersection.width;
                } else if (intersection.x + intersection.width < characterHitboxAfterMove.x + characterHitboxAfterMove.width) {
                    return speedX + intersection.width;
                } else {
                    Gdx.app.error(TAG, "Should not happen");
                }
            }
        }

        return speedX;
    }

    private float computeMaximumVerticalMovementOnCollision(float speedY) {
        Rectangle characterHitboxAfterMove = new Rectangle(getX(), getY() + speedY, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
        List<Rectangle> obstaclesHitbox = retrieveSurroundingHitboxes(characterHitboxAfterMove);

        for (Rectangle obstacleHitbox : obstaclesHitbox) {
            Rectangle intersection = new Rectangle();
            if (Intersector.intersectRectangles(characterHitboxAfterMove, obstacleHitbox, intersection)) {
                Gdx.app.debug(TAG, "Vertical collision detected");
                if (intersection.y > characterHitboxAfterMove.y) {
                    return speedY - intersection.height;
                } else if (intersection.y + intersection.height < characterHitboxAfterMove.y + characterHitboxAfterMove.height) {
                    return speedY + intersection.height;
                } else {
                    Gdx.app.error(TAG, "Should not happen");
                }
            }
        }

        return speedY;
    }

    /**
     * Get the hitboxes surrounding the given hitbox
     *
     * @return the surrounding hitboxes
     */
    private List<Rectangle> retrieveSurroundingHitboxes(Rectangle hitbox) {
        List<Rectangle> leftCellsHitboxes = new ArrayList<Rectangle>();
        float left = hitbox.x;
        float center = hitbox.x + hitbox.width / 2;
        float right = hitbox.x + hitbox.width;
        float bottom = hitbox.y;
        float middle = hitbox.y + hitbox.height / 2;
        float top = hitbox.y + hitbox.height;

        int leftIndex = (int) (left / OverworldConstants.TILE_WIDTH);
        int centerIndex = (int) (center / OverworldConstants.TILE_WIDTH);
        int rightIndex = (int) (right / OverworldConstants.TILE_WIDTH);
        int bottomIndex = (int) (bottom / OverworldConstants.TILE_HEIGHT);
        int middleIndex = (int) (middle / OverworldConstants.TILE_HEIGHT);
        int topIndex = (int) (top / OverworldConstants.TILE_HEIGHT);

        TiledMapTileLayer.Cell bottomLeftCell = obstaclesLayer.getCell(leftIndex, bottomIndex);
        TiledMapTileLayer.Cell middleLeftCell = obstaclesLayer.getCell(leftIndex, middleIndex);
        TiledMapTileLayer.Cell topLeftCell = obstaclesLayer.getCell(leftIndex, topIndex);

        TiledMapTileLayer.Cell bottomCenterCell = obstaclesLayer.getCell(centerIndex, bottomIndex);
        TiledMapTileLayer.Cell middleCenterCell = obstaclesLayer.getCell(centerIndex, middleIndex);
        TiledMapTileLayer.Cell topCenterCell = obstaclesLayer.getCell(centerIndex, topIndex);

        TiledMapTileLayer.Cell bottomRightCell = obstaclesLayer.getCell(rightIndex, bottomIndex);
        TiledMapTileLayer.Cell middleRightCell = obstaclesLayer.getCell(rightIndex, middleIndex);
        TiledMapTileLayer.Cell topRightCell = obstaclesLayer.getCell(rightIndex, topIndex);

        if (bottomLeftCell != null) {
            leftCellsHitboxes.add(new Rectangle(leftIndex * OverworldConstants.TILE_WIDTH, bottomIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }
        if (middleLeftCell != null) {
            leftCellsHitboxes.add(new Rectangle(leftIndex * OverworldConstants.TILE_WIDTH, middleIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }
        if (topLeftCell != null) {
            leftCellsHitboxes.add(new Rectangle(leftIndex * OverworldConstants.TILE_WIDTH, topIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }

        if (bottomCenterCell != null) {
            leftCellsHitboxes.add(new Rectangle(centerIndex * OverworldConstants.TILE_WIDTH, bottomIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }
        if (middleCenterCell != null) {
            leftCellsHitboxes.add(new Rectangle(centerIndex * OverworldConstants.TILE_WIDTH, middleIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }
        if (topCenterCell != null) {
            leftCellsHitboxes.add(new Rectangle(centerIndex * OverworldConstants.TILE_WIDTH, topIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }

        if (bottomRightCell != null) {
            leftCellsHitboxes.add(new Rectangle(rightIndex * OverworldConstants.TILE_WIDTH, bottomIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }
        if (middleRightCell != null) {
            leftCellsHitboxes.add(new Rectangle(rightIndex * OverworldConstants.TILE_WIDTH, middleIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }
        if (topRightCell != null) {
            leftCellsHitboxes.add(new Rectangle(rightIndex * OverworldConstants.TILE_WIDTH, topIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
        }

        return leftCellsHitboxes;
    }
}
