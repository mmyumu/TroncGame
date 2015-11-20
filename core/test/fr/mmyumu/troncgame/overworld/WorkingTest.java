package fr.mmyumu.troncgame.overworld;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class WorkingTest {
    @Test
    public void testFail2() {
        fail("not implemented");
    }

    @Test
    public void thisAlwaysPasses() {
        assertTrue(true);
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }

    @Test
    public void testFail() {
        fail("not implemented");
    }
}