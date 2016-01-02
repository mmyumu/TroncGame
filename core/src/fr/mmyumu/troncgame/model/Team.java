package fr.mmyumu.troncgame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage the team of characters
 * Created by mmyumu on 01/01/2016. (happy new year)
 */
public class Team {
    private final List<Character> characters;

    public Team() {
        characters = new ArrayList<Character>();
    }

    public boolean add(Character character) {
        return characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
