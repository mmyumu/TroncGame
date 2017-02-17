package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.overworld.OverworldConstants;

/**
 * Logic of the GameCharacter displayed on the Overworld map
 * Created by mmyumu on 21/11/2015.
 */
public class OverworldCharacterLogic {
    private static final String TAG = "OverworldCharacter";
    private static final int MOVE_SPEED = 900;

    private final Rectangle hitbox;

    private final Speed speed;
    private final GameCharacter character;
    private List<TiledMapTileLayer> layers;
    private final Vector2 center;
    private GridPoint2 moveTarget;

    public OverworldCharacterLogic(GameCharacter character) {
        this.character = character;
        this.center = new Vector2(0, 0);
        this.speed = new Speed();

        this.hitbox = new Rectangle();
        initHitbox(center);
    }

    public void initCenter(int x, int y) {
        center.x = x;
        center.y = y;
        initHitbox(center);
    }

    public Vector2 getCenter() {
        return center;
    }

    public void setLayers(List<TiledMapTileLayer> layers) {
        this.layers = layers;
    }

    private void initHitbox(Vector2 p) {
        hitbox.set(retrieveLeft(p), retrieveBottom(p), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
    }

    private float retrieveLeft(Vector2 p) {
        return p.x - OverworldConstants.TILE_WIDTH / 2;
    }

    private float retrieveBottom(Vector2 p) {
        return p.y - OverworldConstants.TILE_HEIGHT / 2;
    }

    public void update(float delta) {
        if (moveTarget != null) {
            Gdx.app.debug(TAG, "moveTarget = " + moveTarget.x + ", " + moveTarget.y);
            move(delta);
        }
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

    public GridPoint2 getMoveTarget() {
        return moveTarget;
    }

    public void setMoveTarget(GridPoint2 moveTarget) {
        this.moveTarget = moveTarget;
    }

    private void move(float delta) {
        computeMovement(delta);

        speed.x = computeMaximumHorizontalMovementOnCollision(speed.x);
        applyHorizontalMovement();

        speed.y = computeMaximumVerticalMovementOnCollision(speed.y);
        applyVerticalMovement();
    }

    private void computeMovement(float delta) {
        speed.x = 0;
        speed.y = 0;

        if (moveTarget != null) {
            Gdx.app.debug(TAG, "centerX=" + center.x + " centerY=" + center.y);
            Gdx.app.debug(TAG, "moveTarget x=" + moveTarget.x + " y=" + moveTarget.y);

            if (!isTargetCloserThanMaxMovement(delta)) {
                computeSpeed(delta);
            } else {
                moveTarget = null;
            }
        }
    }

    private boolean isTargetCloserThanMaxMovement(float delta) {
        float xDistance = moveTarget.x - center.x;
        float yDistance = moveTarget.y - center.y;
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance)) < MOVE_SPEED * delta;
    }

    private void computeSpeed(float delta) {
        float moveSpeed = MOVE_SPEED * delta;
        if (isVerticalMovement()) {
            speed.x = 0;
            speed.y = moveSpeed;
        } else if (isHorizontalMovement()) {
            speed.x = moveSpeed;
            speed.y = 0;
        } else {
            float xDistance = moveTarget.x - center.x;
            float yDistance = moveTarget.y - center.y;

            double slope = yDistance / (double) xDistance;
            speed.x = (float) (moveSpeed / Math.sqrt(slope * slope + 1));
            speed.y = (float) Math.sqrt(moveSpeed * moveSpeed - speed.x * speed.x);
        }

        if (moveTarget.x < center.x) {
            speed.invertX();
        }

        if (moveTarget.y < center.y) {
            speed.invertY();
        }

        Gdx.app.debug(TAG, "speedX=" + speed.x + " speedY=" + speed.y);
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
        List<Rectangle> hitBoxes = new ArrayList<Rectangle>();

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

        for (TiledMapTileLayer layer : layers) {
            TiledMapTileLayer.Cell bottomLeftCell = layer.getCell(leftIndex, bottomIndex);
            TiledMapTileLayer.Cell middleLeftCell = layer.getCell(leftIndex, middleIndex);
            TiledMapTileLayer.Cell topLeftCell = layer.getCell(leftIndex, topIndex);

            TiledMapTileLayer.Cell bottomCenterCell = layer.getCell(centerIndex, bottomIndex);
            TiledMapTileLayer.Cell topCenterCell = layer.getCell(centerIndex, topIndex);

            TiledMapTileLayer.Cell bottomRightCell = layer.getCell(rightIndex, bottomIndex);
            TiledMapTileLayer.Cell middleRightCell = layer.getCell(rightIndex, middleIndex);
            TiledMapTileLayer.Cell topRightCell = layer.getCell(rightIndex, topIndex);

            if (isBlockingCell(bottomLeftCell)) {
                hitBoxes.add(new Rectangle(leftIndex * OverworldConstants.TILE_WIDTH, bottomIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }
            if (isBlockingCell(middleLeftCell)) {
                hitBoxes.add(new Rectangle(leftIndex * OverworldConstants.TILE_WIDTH, middleIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }
            if (isBlockingCell(topLeftCell)) {
                hitBoxes.add(new Rectangle(leftIndex * OverworldConstants.TILE_WIDTH, topIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }

            if (isBlockingCell(bottomCenterCell)) {
                hitBoxes.add(new Rectangle(centerIndex * OverworldConstants.TILE_WIDTH, bottomIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }
            if (isBlockingCell(topCenterCell)) {
                hitBoxes.add(new Rectangle(centerIndex * OverworldConstants.TILE_WIDTH, topIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }

            if (isBlockingCell(bottomRightCell)) {
                hitBoxes.add(new Rectangle(rightIndex * OverworldConstants.TILE_WIDTH, bottomIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }
            if (isBlockingCell(middleRightCell)) {
                hitBoxes.add(new Rectangle(rightIndex * OverworldConstants.TILE_WIDTH, middleIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }
            if (isBlockingCell(topRightCell)) {
                hitBoxes.add(new Rectangle(rightIndex * OverworldConstants.TILE_WIDTH, topIndex * OverworldConstants.TILE_HEIGHT, OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT));
            }
        }

        return hitBoxes;
    }

    public boolean isBlockingCell(TiledMapTileLayer.Cell cell) {
        return cell != null && cell.getTile().getProperties().get(OverworldConstants.BLOCK) != null && Boolean.valueOf(cell.getTile().getProperties().get(OverworldConstants.BLOCK).toString());
    }

    public GameCharacter getCharacter() {
        return character;
    }
}
