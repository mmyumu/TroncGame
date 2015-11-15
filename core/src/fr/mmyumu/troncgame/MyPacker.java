package fr.mmyumu.troncgame;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
public class MyPacker {
    public static void main (String[] args) throws Exception {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.duplicatePadding = true;
        settings.paddingX = 5;
        settings.paddingY = 5;
        TexturePacker.process(settings, "texturepacker/tiles/", "android/assets/data/tiles/", "tileset");
    }
}