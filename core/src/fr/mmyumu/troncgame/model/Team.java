package fr.mmyumu.troncgame.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Manage the team of characters
 * Created by mmyumu on 01/01/2016. (happy new year)
 */
public class Team {
    private final Map<String, GameCharacter> characters;

    public Team() {
        characters = new LinkedHashMap<String, GameCharacter>();
    }

    public GameCharacter put(String identifier, GameCharacter character) {
        return characters.put(identifier, character);
    }

    public Collection<GameCharacter> getCharacters() {
        return characters.values();
    }

    public void clear() {
        characters.clear();
    }

    public GameCharacter getMainCharacter() {
        return characters.get("main");
    }
}
