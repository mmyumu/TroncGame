package fr.mmyumu.troncgame.components;

import dagger.Subcomponent;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.introduction.IntroductionLoadingScreen;
import fr.mmyumu.troncgame.introduction.IntroductionScreen;
import fr.mmyumu.troncgame.introduction.Introduction;
import fr.mmyumu.troncgame.introduction.IntroductionText;
import fr.mmyumu.troncgame.modules.IntroductionModule;

/**
 * Dagger component to instantiate Main Menu objects
 * Created by mmyumu on 07/11/2015.
 */
@ActivityScope
@Subcomponent(
        modules = IntroductionModule.class
)
public interface IntroductionComponent {
    IntroductionLoadingScreen introductionLoadingScreen();

    IntroductionScreen introductionScreen();

    IntroductionText introductionText();

    Introduction introduction();
}
