package fr.mmyumu.troncgame.map;

import java.io.File;

/**
 * Created by mmyumu on 17/07/2016.
 */
public class MapData {
    private static final String MAP_EXTENSION = ".tmx";
    private MapType type;
    private String name;
    private String entrance;

    public MapData(MapType type, String name, String entrance) {
        this.type = type;
        this.name = name;
        this.entrance = entrance;
    }

    public String getPath() {
        return type.getType() + File.separator + name + File.separator + name + MAP_EXTENSION;
    }
}
