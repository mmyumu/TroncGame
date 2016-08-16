package fr.mmyumu.troncgame.overworld;

/**
 * Constants for the Overworld
 * Created by mmyumu on 30/10/2015.
 */
public interface OverworldConstants {
    int TILE_WIDTH = 90;
    int TILE_HEIGHT = 90;

    int MENU_LIST_WIDTH = 240;
    int MENU_LIST_HEIGHT = 768;

    String BLOCK = "block";

    interface MapPath {
        String VILLAGE = "maps/overworld/outdoor/outdoor.tmx";
    }

    interface TexturePath {
        String MENU_LIST = "data/overworld/menu_list.png";
    }

    interface SkinPath {
        String SKIN_ATLAS = "data/uiskin.atlas";
        String SKIN_JSON = "data/uiskin.json";
    }
}
