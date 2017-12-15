package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuContinue;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuModule_ProvideMainMenuContinueFactory implements Factory<MainMenuContinue> {
  private final MainMenuModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;

  public MainMenuModule_ProvideMainMenuContinueFactory(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert gameStatePersisterProvider != null;
    this.gameStatePersisterProvider = gameStatePersisterProvider;
  }

  @Override
  public MainMenuContinue get() {  
    MainMenuContinue provided = module.provideMainMenuContinue(troncGameProvider.get(), assetManagerProvider.get(), bundleProvider.get(), gameStatePersisterProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<MainMenuContinue> create(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    return new MainMenuModule_ProvideMainMenuContinueFactory(module, troncGameProvider, assetManagerProvider, bundleProvider, gameStatePersisterProvider);
  }
}

