package fr.mmyumu.troncgame.overworld;

/**
 * Represent the speed (x and y components) in a plan
 * Created by mmyumu on 03/10/2015.
 */
class Speed {
    private double x;
    private double y;

    public Speed() {
        super();
    }

    public Speed(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void invertX() {
        x = -x;
    }

    public void invertY() {
        y = -y;
    }
}
