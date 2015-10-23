package fr.mmyumu.troncgame;

import com.badlogic.gdx.Game;
import javax.inject.Inject;

public class TroncGame extends Game {

    @Inject GameScreen gameScreen;

    @Override
    public void create() {
        this.setScreen(gameScreen);
    }

}