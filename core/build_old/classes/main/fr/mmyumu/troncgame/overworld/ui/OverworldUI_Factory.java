package fr.mmyumu.troncgame.overworld.ui;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldUI_Factory implements Factory<OverworldUI> {
  private final MembersInjector<OverworldUI> membersInjector;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<OverworldFPS> overworldFPSProvider;

  public OverworldUI_Factory(MembersInjector<OverworldUI> membersInjector, Provider<ScalingViewport> viewportProvider, Provider<TroncGame> troncGameProvider, Provider<OverworldFPS> overworldFPSProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert overworldFPSProvider != null;
    this.overworldFPSProvider = overworldFPSProvider;
  }

  @Override
  public OverworldUI get() {  
    OverworldUI instance = new OverworldUI(viewportProvider.get(), troncGameProvider.get(), overworldFPSProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldUI> create(MembersInjector<OverworldUI> membersInjector, Provider<ScalingViewport> viewportProvider, Provider<TroncGame> troncGameProvider, Provider<OverworldFPS> overworldFPSProvider) {  
    return new OverworldUI_Factory(membersInjector, viewportProvider, troncGameProvider, overworldFPSProvider);
  }
}

