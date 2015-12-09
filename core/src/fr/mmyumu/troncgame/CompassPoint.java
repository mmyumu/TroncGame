package fr.mmyumu.troncgame;

/**
 * Compass point with their angle
 * Created by mmyumu on 07/12/2015.
 */
public enum CompassPoint {
    EAST(0f), NORTH(90f), WEST(180f), SOUTH(270f);

    private float angle;

    CompassPoint(float angle) {
        this.angle = angle;
    }

    public double getRadiansAngle() {
        return Math.toRadians(angle);
    }
}
