package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightLoadingScreen_Factory implements Factory<FightLoadingScreen> {
  private final MembersInjector<FightLoadingScreen> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;

  public FightLoadingScreen_Factory(MembersInjector<FightLoadingScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
  }

  @Override
  public FightLoadingScreen get() {  
    FightLoadingScreen instance = new FightLoadingScreen(troncGameProvider.get(), assetManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<FightLoadingScreen> create(MembersInjector<FightLoadingScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    return new FightLoadingScreen_Factory(membersInjector, troncGameProvider, assetManagerProvider);
  }
}

