package fr.mmyumu.troncgame.model.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import fr.mmyumu.troncgame.model.ItemDef;
import fr.mmyumu.troncgame.model.Weapon;
import fr.mmyumu.troncgame.model.WeaponDef;
import fr.mmyumu.troncgame.model.exception.NotFoundException;

/**
 * Manage the items of the game
 * Created by mmyumu on 15/02/2016.
 */
public class ItemManager {
    private static final String TAG = "ItemManager";

    private final Map<String, ItemDef> items;
    private final Map<String, WeaponDef> weapons;
    private InputStream inputStream;

    public class ID {
        public static final String BASIC_SWORD = "sword.basic";

        private ID() {
            // Private constructor since it's a utility class
        }
    }

    @Inject
    public ItemManager(InputStream inputStream) {
        this.inputStream = inputStream;
        this.items = new HashMap<>();
        this.weapons = new HashMap<>();

        try {
            loadXml();
        } catch (IOException e) {
            Gdx.app.error(TAG, "The items XML file cannot be parsed.");
        }
    }

    private void loadXml() throws IOException {
        XmlReader reader = new XmlReader();
        XmlReader.Element root = reader.parse(inputStream);
        Array<XmlReader.Element> weaponElements = root.getChildrenByName("weapon");
        for (XmlReader.Element weaponElement : weaponElements) {
            String id = weaponElement.getAttribute("id");
            String name = weaponElement.getAttribute("name");
            String texturePath = weaponElement.getChildByName("texture").getText();
            int attack = Integer.valueOf(weaponElement.getChildByName("attack").getText());

            WeaponDef weapon = new WeaponDef(id, name, texturePath, attack);
            items.put(id, weapon);
            weapons.put(id, weapon);
        }
    }

    public WeaponDef getWeapon(String key) {
        return weapons.get(key);
    }

    public Weapon createWeapon(String key) {
        WeaponDef weaponDef = weapons.get(key);
        if (weaponDef == null) {
            throw new NotFoundException("The weapon definition with ID=" + key + " cannot be found");
        }
        return new Weapon(weaponDef);
    }

    public Map<String, ItemDef> getItems() {
        return items;
    }
}
