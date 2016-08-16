package fr.mmyumu.troncgame.map;

/**
 * Enum to list the type of the map
 * Created by mmyumu on 17/07/2016.
 */
public enum MapType {
    FIELD_MAP("fieldmap"), OVERWORLD_MAP("overworld");

    private final String type;

    MapType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static MapType get(String type) {
        for(MapType mapType : values()) {
            if(mapType.type.equals(type)) {
                return mapType;
            }
        }

        return null;
    }
}
