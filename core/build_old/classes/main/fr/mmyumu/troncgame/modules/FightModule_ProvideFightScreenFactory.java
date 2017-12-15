package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.fight.FightLogic;
import fr.mmyumu.troncgame.fight.FightScreen;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightScreenFactory implements Factory<FightScreen> {
  private final FightModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<FightLogic> fightLogicProvider;

  public FightModule_ProvideFightScreenFactory(FightModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> viewportProvider, Provider<FightLogic> fightLogicProvider) {  
    assert module != null;
    this.module = module;
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
    FightScreen provided = module.provideFightScreen(troncGameProvider.get(), assetManagerProvider.get(), viewportProvider.get(), fightLogicProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightScreen> create(FightModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> viewportProvider, Provider<FightLogic> fightLogicProvider) {  
    return new FightModule_ProvideFightScreenFactory(module, troncGameProvider, assetManagerProvider, viewportProvider, fightLogicProvider);
  }
}

