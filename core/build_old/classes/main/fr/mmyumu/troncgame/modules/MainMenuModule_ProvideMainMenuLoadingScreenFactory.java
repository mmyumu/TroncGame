package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuLoadingScreen;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuModule_ProvideMainMenuLoadingScreenFactory implements Factory<MainMenuLoadingScreen> {
  private final MainMenuModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;

  public MainMenuModule_ProvideMainMenuLoadingScreenFactory(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
  }

  @Override
  public MainMenuLoadingScreen get() {  
    MainMenuLoadingScreen provided = module.provideMainMenuLoadingScreen(troncGameProvider.get(), assetManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<MainMenuLoadingScreen> create(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    return new MainMenuModule_ProvideMainMenuLoadingScreenFactory(module, troncGameProvider, assetManagerProvider);
  }
}

