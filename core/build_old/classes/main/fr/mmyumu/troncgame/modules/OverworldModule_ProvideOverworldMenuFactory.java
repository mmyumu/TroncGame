package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.DoubleCheckLazy;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenu;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenuList;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldModule_ProvideOverworldMenuFactory implements Factory<OverworldMenu> {
  private final OverworldModule module;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<OverworldScreen> overworldScreenProvider;
  private final Provider<OverworldFPS> overworldFPSProvider;
  private final Provider<OverworldMenuList> overworldMenuListActorProvider;

  public OverworldModule_ProvideOverworldMenuFactory(OverworldModule module, Provider<ScalingViewport> viewportProvider, Provider<OverworldScreen> overworldScreenProvider, Provider<OverworldFPS> overworldFPSProvider, Provider<OverworldMenuList> overworldMenuListActorProvider) {  
    assert module != null;
    this.module = module;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
    assert overworldScreenProvider != null;
    this.overworldScreenProvider = overworldScreenProvider;
    assert overworldFPSProvider != null;
    this.overworldFPSProvider = overworldFPSProvider;
    assert overworldMenuListActorProvider != null;
    this.overworldMenuListActorProvider = overworldMenuListActorProvider;
  }

  @Override
  public OverworldMenu get() {  
    OverworldMenu provided = module.provideOverworldMenu(viewportProvider.get(), DoubleCheckLazy.create(overworldScreenProvider), overworldFPSProvider.get(), overworldMenuListActorProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OverworldMenu> create(OverworldModule module, Provider<ScalingViewport> viewportProvider, Provider<OverworldScreen> overworldScreenProvider, Provider<OverworldFPS> overworldFPSProvider, Provider<OverworldMenuList> overworldMenuListActorProvider) {  
    return new OverworldModule_ProvideOverworldMenuFactory(module, viewportProvider, overworldScreenProvider, overworldFPSProvider, overworldMenuListActorProvider);
  }
}

