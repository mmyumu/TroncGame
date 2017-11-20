package fr.mmyumu.troncgame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the Compass point class
 * Created by mmyumu on 20/11/2017.
 */

public class CompassPointTest {
    @Test
    public void testEastRadianAngle() {
        assertEquals("East radian value", 0, CompassPoint.EAST.getRadiansAngle(), 0.0001);
    }

    @Test
    public void testNorthRadianAngle() {
        assertEquals("North radian value", 1.5708, CompassPoint.NORTH.getRadiansAngle(), 0.0001);
    }

    @Test
    public void testWestRadianAngle() {
        assertEquals("West radian value", 3.14159, CompassPoint.WEST.getRadiansAngle(), 0.0001);
    }

    @Test
    public void testSouthRadianAngle() {
        assertEquals("South radian value", 4.71239, CompassPoint.SOUTH.getRadiansAngle(), 0.0001);
    }
}
