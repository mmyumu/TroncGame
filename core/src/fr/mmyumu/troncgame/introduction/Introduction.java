package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;

/**
 * Display the introduction elements
 * Created by mmyumu on 22/02/2016.
 */
public class Introduction extends Stage {

    @Inject
    public Introduction(ScalingViewport viewport) {
        super(viewport);
    }

    public void init(IntroductionText introductionText) {
        addActor(introductionText);
    }
}
