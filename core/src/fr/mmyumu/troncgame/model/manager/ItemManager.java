package fr.mmyumu.troncgame.model.manager;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import fr.mmyumu.troncgame.model.Item;
import fr.mmyumu.troncgame.model.ModelConstants;
import fr.mmyumu.troncgame.model.Weapon;

/**
 * Manage the items of the game
 * Created by mmyumu on 15/02/2016.
 */
public class ItemManager {
    private static final String BASIC_SWORD = "sword.basic";

    private Map<String, Item> items;

    @Inject
    public ItemManager() {
        this.items = new HashMap<String, Item>();

        basicSword();
    }

    public Item get(String key) {
        return items.get(key);
    }

    public Weapon basicSword() {
        Item item = items.get(BASIC_SWORD);
        if(item != null) {
            return (Weapon) item;
        }

        Weapon weapon = new Weapon(BASIC_SWORD, ModelConstants.TexturePath.BASIC_SWORD, 5);
        items.put(BASIC_SWORD, weapon);
        return weapon;
    }
}
