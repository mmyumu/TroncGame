package fr.mmyumu.troncgame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage the team of characters
 * Created by mmyumu on 01/01/2016. (happy new year)
 */
public class Team {
    private final List<GameCharacter> characters;

    public Team() {
        characters = new ArrayList<GameCharacter>();
    }

    public boolean add(GameCharacter character) {
        return characters.add(character);
    }

    public List<GameCharacter> getCharacters() {
        return characters;
    }

    public void clear() {
        characters.clear();
    }
}
