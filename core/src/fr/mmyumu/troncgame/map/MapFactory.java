package fr.mmyumu.troncgame.map;

/**
 * Factory to create maps
 * Created by mmyumu on 23/08/2016.
 */
public interface MapFactory {
    Map create(String path, int tileHeight);
}
