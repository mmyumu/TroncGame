package fr.mmyumu.troncgame.util;

import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * General utility class
 * Created by mmyumu on 30/10/2015.
 */
public class Utils {
    private static final String TAG = "Utils";

    public String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            Gdx.app.error(TAG, "Error while reading stream to convert it to string", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Gdx.app.error(TAG, "Error while closing stream to be converted to string", e);
            }
        }
        return sb.toString();
    }
}
