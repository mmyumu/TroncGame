package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Represent the speed (x and y components) in a plan
 * Created by mmyumu on 03/10/2015.
 */
class Speed extends Vector2 {
    public void invertX() {
        x = -x;
    }

    public void invertY() {
        y = -y;
    }
}
