package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS;
import fr.mmyumu.troncgame.overworld.ui.OverworldUI;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldModule_ProvideOverworldUIFactory implements Factory<OverworldUI> {
  private final OverworldModule module;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<OverworldFPS> overworldFPSProvider;

  public OverworldModule_ProvideOverworldUIFactory(OverworldModule module, Provider<ScalingViewport> viewportProvider, Provider<TroncGame> troncGameProvider, Provider<OverworldFPS> overworldFPSProvider) {  
    assert module != null;
    this.module = module;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert overworldFPSProvider != null;
    this.overworldFPSProvider = overworldFPSProvider;
  }

  @Override
  public OverworldUI get() {  
    OverworldUI provided = module.provideOverworldUI(viewportProvider.get(), troncGameProvider.get(), overworldFPSProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OverworldUI> create(OverworldModule module, Provider<ScalingViewport> viewportProvider, Provider<TroncGame> troncGameProvider, Provider<OverworldFPS> overworldFPSProvider) {  
    return new OverworldModule_ProvideOverworldUIFactory(module, viewportProvider, troncGameProvider, overworldFPSProvider);
  }
}

