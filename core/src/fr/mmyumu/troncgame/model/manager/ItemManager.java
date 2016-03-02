package fr.mmyumu.troncgame.model.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
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
    private static final String TAG = "ItemManager";

    private Map<String, Item> items;

    @Inject
    public ItemManager() {
        this.items = new HashMap<String, Item>();

        try {
            loadXml();
        } catch (IOException e) {
            Gdx.app.error(TAG, "The items XML file cannot be parsed.");
        }
    }

    private void loadXml() throws IOException {
        XmlReader reader = new XmlReader();
        XmlReader.Element root = reader.parse(new FileHandle(ModelConstants.DataPath.ITEMS));
        Array<XmlReader.Element> weaponElements = root.getChildrenByName("weapon");
        for (XmlReader.Element weaponElement : weaponElements) {
            String identifier = weaponElement.getAttribute("identifier");
            String name = weaponElement.getAttribute("name");
            String texturePath = weaponElement.getChildByName("texture").getText();
            int attack = Integer.valueOf(weaponElement.getChildByName("attack").getText());

            Weapon weapon = new Weapon(identifier, name, texturePath, attack);
            items.put(identifier, weapon);
        }
    }

    public Item get(String key) {
        return items.get(key);
    }
}
