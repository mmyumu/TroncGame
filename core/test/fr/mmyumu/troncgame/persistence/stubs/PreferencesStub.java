package fr.mmyumu.troncgame.persistence.stubs;

import com.badlogic.gdx.Preferences;

import java.util.Map;

/**
 * Created by mlabetaa on 14/12/2017.
 */

public class PreferencesStub implements Preferences {
    @Override
    public Preferences putBoolean(String key, boolean val) {
        return null;
    }

    @Override
    public Preferences putInteger(String key, int val) {
        return null;
    }

    @Override
    public Preferences putLong(String key, long val) {
        return null;
    }

    @Override
    public Preferences putFloat(String key, float val) {
        return null;
    }

    @Override
    public Preferences putString(String key, String val) {
        return null;
    }

    @Override
    public Preferences put(Map<String, ?> vals) {
        return null;
    }

    @Override
    public boolean getBoolean(String key) {
        return false;
    }

    @Override
    public int getInteger(String key) {
        return 0;
    }

    @Override
    public long getLong(String key) {
        return 0;
    }

    @Override
    public float getFloat(String key) {
        return 0;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return false;
    }

    @Override
    public int getInteger(String key, int defValue) {
        return 0;
    }

    @Override
    public long getLong(String key, long defValue) {
        return 0;
    }

    @Override
    public float getFloat(String key, float defValue) {
        return 0;
    }

    @Override
    public String getString(String key, String defValue) {
        return null;
    }

    @Override
    public Map<String, ?> get() {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void flush() {

    }
}
