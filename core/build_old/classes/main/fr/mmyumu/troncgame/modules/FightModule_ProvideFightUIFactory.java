package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.ui.FightUI;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightUIFactory implements Factory<FightUI> {
  private final FightModule module;
  private final Provider<ScalingViewport> viewportProvider;

  public FightModule_ProvideFightUIFactory(FightModule module, Provider<ScalingViewport> viewportProvider) {  
    assert module != null;
    this.module = module;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public FightUI get() {  
    FightUI provided = module.provideFightUI(viewportProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightUI> create(FightModule module, Provider<ScalingViewport> viewportProvider) {  
    return new FightModule_ProvideFightUIFactory(module, viewportProvider);
  }
}

