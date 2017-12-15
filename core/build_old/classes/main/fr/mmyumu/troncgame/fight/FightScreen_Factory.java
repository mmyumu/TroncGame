package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightScreen_Factory implements Factory<FightScreen> {
  private final MembersInjector<FightScreen> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<FightLogic> fightLogicProvider;

  public FightScreen_Factory(MembersInjector<FightScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> viewportProvider, Provider<FightLogic> fightLogicProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
    assert fightLogicProvider != null;
    this.fightLogicProvider = fightLogicProvider;
  }

  @Override
  public FightScreen get() {  
    FightScreen instance = new FightScreen(troncGameProvider.get(), assetManagerProvider.get(), viewportProvider.get(), fightLogicProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<FightScreen> create(MembersInjector<FightScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> viewportProvider, Provider<FightLogic> fightLogicProvider) {  
    return new FightScreen_Factory(membersInjector, troncGameProvider, assetManagerProvider, viewportProvider, fightLogicProvider);
  }
}

