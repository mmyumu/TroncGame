package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuStart;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuModule_ProvideMainMenuStartFactory implements Factory<MainMenuStart> {
  private final MainMenuModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;
  private final Provider<ModelManager> modelManagerProvider;

  public MainMenuModule_ProvideMainMenuStartFactory(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider, Provider<ModelManager> modelManagerProvider) {  
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
    assert modelManagerProvider != null;
    this.modelManagerProvider = modelManagerProvider;
  }

  @Override
  public MainMenuStart get() {  
    MainMenuStart provided = module.provideMainMenuStart(troncGameProvider.get(), assetManagerProvider.get(), bundleProvider.get(), gameStatePersisterProvider.get(), modelManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<MainMenuStart> create(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider, Provider<ModelManager> modelManagerProvider) {  
    return new MainMenuModule_ProvideMainMenuStartFactory(module, troncGameProvider, assetManagerProvider, bundleProvider, gameStatePersisterProvider, modelManagerProvider);
  }
}

