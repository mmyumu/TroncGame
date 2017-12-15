package fr.mmyumu.troncgame.overworld.ui;

import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldUIInputProcessor_Factory implements Factory<OverworldUIInputProcessor> {
  private final MembersInjector<OverworldUIInputProcessor> membersInjector;
  private final Provider<OverworldScreen> overworldScreenProvider;

  public OverworldUIInputProcessor_Factory(MembersInjector<OverworldUIInputProcessor> membersInjector, Provider<OverworldScreen> overworldScreenProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert overworldScreenProvider != null;
    this.overworldScreenProvider = overworldScreenProvider;
  }

  @Override
  public OverworldUIInputProcessor get() {  
    OverworldUIInputProcessor instance = new OverworldUIInputProcessor(overworldScreenProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldUIInputProcessor> create(MembersInjector<OverworldUIInputProcessor> membersInjector, Provider<OverworldScreen> overworldScreenProvider) {  
    return new OverworldUIInputProcessor_Factory(membersInjector, overworldScreenProvider);
  }
}

