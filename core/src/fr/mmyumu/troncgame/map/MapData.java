package fr.mmyumu.troncgame.map;

/**
 * Data needed to create a map
 * Created by mmyumu on 17/07/2016.
 */
public class MapData {
    private static final String PATH_SEPARATOR = "/";
    private static final String MAP_EXTENSION = ".tmx";
    private static final String MAPS_FOLDER = "maps";
    private MapType type;
    private String name;

    public MapData(MapType type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getPath() {
        return MAPS_FOLDER + PATH_SEPARATOR + type.getType() + PATH_SEPARATOR + name + PATH_SEPARATOR + name + MAP_EXTENSION;
    }
}
