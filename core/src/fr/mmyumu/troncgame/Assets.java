package fr.mmyumu.troncgame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by mmyumu on 23/10/2015.
 */
public class Assets {
    public static AssetManager manager;
    public static Texture mainMenu;
//    public static TextureAtlas myGraphics;
//    public static TextureAtlas myOtherGraphics;

    public static void create() {
        manager = new AssetManager();
        load();
    }

    private static void load() {
//        manager.load("mygraphics.pack", TextureAtlas.class);
//        manager.load("myothergraphics.pack", TextureAtlas.class);
        manager.load("main_menu.png", Texture.class);
    }

    public static void done() {
//        myGraphics = manager.get("mygraphics.pack", TextureAtlas.class);
//        myOtherGraphics = manager.get("myothergraphics.pack", TextureAtlas.class);
        mainMenu = manager.get("main_menu.png", Texture.class);
    }

    public static void dispose() {
        manager.dispose();
    }
}
