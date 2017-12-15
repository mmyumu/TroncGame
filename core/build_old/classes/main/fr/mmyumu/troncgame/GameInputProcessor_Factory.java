package fr.mmyumu.troncgame;

import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameInputProcessor_Factory implements Factory<GameInputProcessor> {
  private final MembersInjector<GameInputProcessor> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;

  public GameInputProcessor_Factory(MembersInjector<GameInputProcessor> membersInjector, Provider<TroncGame> troncGameProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert gameStatePersisterProvider != null;
    this.gameStatePersisterProvider = gameStatePersisterProvider;
  }

  @Override
  public GameInputProcessor get() {  
    GameInputProcessor instance = new GameInputProcessor(troncGameProvider.get(), gameStatePersisterProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<GameInputProcessor> create(MembersInjector<GameInputProcessor> membersInjector, Provider<TroncGame> troncGameProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    return new GameInputProcessor_Factory(membersInjector, troncGameProvider, gameStatePersisterProvider);
  }
}

