package fr.mmyumu.troncgame.overworld.menu;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.DoubleCheckLazy;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldMenu_Factory implements Factory<OverworldMenu> {
  private final MembersInjector<OverworldMenu> membersInjector;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<OverworldScreen> overworldScreenProvider;
  private final Provider<OverworldFPS> overworldFPSProvider;
  private final Provider<OverworldMenuList> overworldMenuListProvider;

  public OverworldMenu_Factory(MembersInjector<OverworldMenu> membersInjector, Provider<ScalingViewport> viewportProvider, Provider<OverworldScreen> overworldScreenProvider, Provider<OverworldFPS> overworldFPSProvider, Provider<OverworldMenuList> overworldMenuListProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
    assert overworldScreenProvider != null;
    this.overworldScreenProvider = overworldScreenProvider;
    assert overworldFPSProvider != null;
    this.overworldFPSProvider = overworldFPSProvider;
    assert overworldMenuListProvider != null;
    this.overworldMenuListProvider = overworldMenuListProvider;
  }

  @Override
  public OverworldMenu get() {  
    OverworldMenu instance = new OverworldMenu(viewportProvider.get(), DoubleCheckLazy.create(overworldScreenProvider), overworldFPSProvider.get(), overworldMenuListProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldMenu> create(MembersInjector<OverworldMenu> membersInjector, Provider<ScalingViewport> viewportProvider, Provider<OverworldScreen> overworldScreenProvider, Provider<OverworldFPS> overworldFPSProvider, Provider<OverworldMenuList> overworldMenuListProvider) {  
    return new OverworldMenu_Factory(membersInjector, viewportProvider, overworldScreenProvider, overworldFPSProvider, overworldMenuListProvider);
  }
}

