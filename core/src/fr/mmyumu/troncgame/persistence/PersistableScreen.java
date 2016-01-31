package fr.mmyumu.troncgame.persistence;

import com.badlogic.gdx.Screen;

/**
 * A screen that can be persisted/loaded
 * Created by mmyumu on 31/01/2016.
 */
public interface PersistableScreen extends Screen {
    void load();
}
