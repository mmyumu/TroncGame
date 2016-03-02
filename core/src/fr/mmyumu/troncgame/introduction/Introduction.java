package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Display the introduction elements
 * Created by mmyumu on 22/02/2016.
 */
public class Introduction extends Stage {

    private IntroductionText introductionText;
    private final TroncGame troncGame;

    @Inject
    public Introduction(TroncGame troncGame, ScalingViewport viewport) {
        super(viewport);
        this.troncGame = troncGame;
    }

    public void init(IntroductionText introductionText) {
        this.introductionText = introductionText;
        addActor(introductionText);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(introductionText.isFullyDisplayed()) {
            troncGame.setScreen(troncGame.getOverworldComponent().createOverworldLoadingScreen());
        } else {
            introductionText.setFullyDisplayed(true);
        }
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
