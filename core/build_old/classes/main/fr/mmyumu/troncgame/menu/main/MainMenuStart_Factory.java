package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuStart_Factory implements Factory<MainMenuStart> {
  private final MembersInjector<MainMenuStart> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;
  private final Provider<ModelManager> modelManagerProvider;
  private final Provider<Integer> yProvider;

  public MainMenuStart_Factory(MembersInjector<MainMenuStart> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider, Provider<ModelManager> modelManagerProvider, Provider<Integer> yProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
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
    assert yProvider != null;
    this.yProvider = yProvider;
  }

  @Override
  public MainMenuStart get() {  
    MainMenuStart instance = new MainMenuStart(troncGameProvider.get(), assetManagerProvider.get(), bundleProvider.get(), gameStatePersisterProvider.get(), modelManagerProvider.get(), yProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MainMenuStart> create(MembersInjector<MainMenuStart> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider, Provider<ModelManager> modelManagerProvider, Provider<Integer> yProvider) {  
    return new MainMenuStart_Factory(membersInjector, troncGameProvider, assetManagerProvider, bundleProvider, gameStatePersisterProvider, modelManagerProvider, yProvider);
  }
}

