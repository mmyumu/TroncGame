package fr.mmyumu.troncgame;

import com.badlogic.gdx.ScreenAdapter;

/**
 * Created by mmyumu on 24/10/2015.
 */
public class TroncScreen extends ScreenAdapter {

    private TroncGame troncGame;

    public TroncScreen(TroncGame troncGame) {
        this.troncGame = troncGame;
    }

    public TroncGame getTroncGame() {
        return troncGame;
    }
}
