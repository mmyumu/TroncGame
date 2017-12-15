package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.introduction.IntroductionScreen;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class IntroductionModule_ProvideIntroductionScreenFactory implements Factory<IntroductionScreen> {
  private final IntroductionModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<ScalingViewport> viewportProvider;

  public IntroductionModule_ProvideIntroductionScreenFactory(IntroductionModule module, Provider<TroncGame> troncGameProvider, Provider<ScalingViewport> viewportProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public IntroductionScreen get() {  
    IntroductionScreen provided = module.provideIntroductionScreen(troncGameProvider.get(), viewportProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<IntroductionScreen> create(IntroductionModule module, Provider<TroncGame> troncGameProvider, Provider<ScalingViewport> viewportProvider) {  
    return new IntroductionModule_ProvideIntroductionScreenFactory(module, troncGameProvider, viewportProvider);
  }
}

