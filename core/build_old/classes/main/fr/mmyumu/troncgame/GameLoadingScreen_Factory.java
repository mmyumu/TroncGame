package fr.mmyumu.troncgame;

import com.badlogic.gdx.assets.AssetManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameLoadingScreen_Factory implements Factory<GameLoadingScreen> {
  private final MembersInjector<GameLoadingScreen> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;

  public GameLoadingScreen_Factory(MembersInjector<GameLoadingScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
  }

  @Override
  public GameLoadingScreen get() {  
    GameLoadingScreen instance = new GameLoadingScreen(troncGameProvider.get(), assetManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<GameLoadingScreen> create(MembersInjector<GameLoadingScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    return new GameLoadingScreen_Factory(membersInjector, troncGameProvider, assetManagerProvider);
  }
}

