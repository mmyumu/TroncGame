package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldGameInputProcessor_Factory implements Factory<OverworldGameInputProcessor> {
  private final MembersInjector<OverworldGameInputProcessor> membersInjector;
  private final Provider<OverworldScreen> overworldScreenProvider;
  private final Provider<ScalingViewport> viewportProvider;

  public OverworldGameInputProcessor_Factory(MembersInjector<OverworldGameInputProcessor> membersInjector, Provider<OverworldScreen> overworldScreenProvider, Provider<ScalingViewport> viewportProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert overworldScreenProvider != null;
    this.overworldScreenProvider = overworldScreenProvider;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public OverworldGameInputProcessor get() {  
    OverworldGameInputProcessor instance = new OverworldGameInputProcessor(overworldScreenProvider.get(), viewportProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldGameInputProcessor> create(MembersInjector<OverworldGameInputProcessor> membersInjector, Provider<OverworldScreen> overworldScreenProvider, Provider<ScalingViewport> viewportProvider) {  
    return new OverworldGameInputProcessor_Factory(membersInjector, overworldScreenProvider, viewportProvider);
  }
}

