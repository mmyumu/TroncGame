package fr.mmyumu.troncgame;

import org.junit.Test;

/**
 * Test the private constructor of Constants class.
 * Mostly for code coverage purpose
 * Created by mmyumu on 20/11/2017.
 */

public class ConstantsTest {
    @Test
    public void testConstantsConstructor() {
        Constants constants = TestUtils.runConstructor(Constants.class);
    }

    @Test
    public void testTexturePathConstructor() {
        Constants.TexturePath texturePath = TestUtils.runInnerClassConstructor(Constants.TexturePath.class);
    }

    @Test
    public void testFontPathConstructor() {
        Constants.FontPath fontPath = TestUtils.runInnerClassConstructor(Constants.FontPath.class);
    }
}
