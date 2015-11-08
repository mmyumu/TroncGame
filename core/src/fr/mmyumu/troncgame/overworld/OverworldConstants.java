package fr.mmyumu.troncgame.overworld;

/**
 * Constants for the Overworld
 * Created by mmyumu on 30/10/2015.
 */
interface OverworldConstants {
    int TILE_WIDTH = 60;
    int TILE_HEIGHT = 60;

    interface MapPath {
        String VILLAGE = "maps/village.txt";
    }

    interface TexturePath {
        String MAIN_CHARACTER = "data/character.png";
        String TILE_DIRT = "data/tile_dirt.png";
        String TILE_GRASS = "data/tile_grass.png";
        String TILE_WALL = "data/tile_wall.png";
    }
}
