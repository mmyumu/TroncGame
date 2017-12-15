package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuContinue_Factory implements Factory<MainMenuContinue> {
  private final MembersInjector<MainMenuContinue> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;
  private final Provider<Integer> yProvider;

  public MainMenuContinue_Factory(MembersInjector<MainMenuContinue> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider, Provider<Integer> yProvider) {  
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
    assert yProvider != null;
    this.yProvider = yProvider;
  }

  @Override
  public MainMenuContinue get() {  
    MainMenuContinue instance = new MainMenuContinue(troncGameProvider.get(), assetManagerProvider.get(), bundleProvider.get(), gameStatePersisterProvider.get(), yProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MainMenuContinue> create(MembersInjector<MainMenuContinue> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<GameStatePersister> gameStatePersisterProvider, Provider<Integer> yProvider) {  
    return new MainMenuContinue_Factory(membersInjector, troncGameProvider, assetManagerProvider, bundleProvider, gameStatePersisterProvider, yProvider);
  }
}

