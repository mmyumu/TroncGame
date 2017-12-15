package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightLoadingScreenFactory implements Factory<FightLoadingScreen> {
  private final FightModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;

  public FightModule_ProvideFightLoadingScreenFactory(FightModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
  }

  @Override
  public FightLoadingScreen get() {  
    FightLoadingScreen provided = module.provideFightLoadingScreen(troncGameProvider.get(), assetManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightLoadingScreen> create(FightModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider) {  
    return new FightModule_ProvideFightLoadingScreenFactory(module, troncGameProvider, assetManagerProvider);
  }
}

