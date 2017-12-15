package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.introduction.IntroductionLoadingScreen;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class IntroductionModule_ProvideIntroductionLoadingScreenFactory implements Factory<IntroductionLoadingScreen> {
  private final IntroductionModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<ModelManager> modelManagerProvider;

  public IntroductionModule_ProvideIntroductionLoadingScreenFactory(IntroductionModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ModelManager> modelManagerProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert modelManagerProvider != null;
    this.modelManagerProvider = modelManagerProvider;
  }

  @Override
  public IntroductionLoadingScreen get() {  
    IntroductionLoadingScreen provided = module.provideIntroductionLoadingScreen(troncGameProvider.get(), assetManagerProvider.get(), modelManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<IntroductionLoadingScreen> create(IntroductionModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ModelManager> modelManagerProvider) {  
    return new IntroductionModule_ProvideIntroductionLoadingScreenFactory(module, troncGameProvider, assetManagerProvider, modelManagerProvider);
  }
}

