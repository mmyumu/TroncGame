package fr.mmyumu.troncgame;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
public class MyPacker {
    public static void main (String[] args) throws Exception {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.duplicatePadding = false;
        //settings.debug = true;
        settings.paddingX = 2;
        settings.paddingY = 2;
        settings.duplicatePadding = true;
        TexturePacker.process(settings, "texturepacker/tiles/overworld", "android/assets/maps/outdoor/tiles", "tileset");
    }
}