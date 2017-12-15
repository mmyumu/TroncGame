package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.game.FightGame;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightGameFactory implements Factory<FightGame> {
  private final FightModule module;
  private final Provider<ScalingViewport> viewportProvider;

  public FightModule_ProvideFightGameFactory(FightModule module, Provider<ScalingViewport> viewportProvider) {  
    assert module != null;
    this.module = module;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public FightGame get() {  
    FightGame provided = module.provideFightGame(viewportProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightGame> create(FightModule module, Provider<ScalingViewport> viewportProvider) {  
    return new FightModule_ProvideFightGameFactory(module, viewportProvider);
  }
}

