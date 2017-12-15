package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.GameInputProcessor;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvideGameInputProcessorFactory implements Factory<GameInputProcessor> {
  private final GameModule module;
  private final Provider<GameStatePersister> gameStatePersisterProvider;

  public GameModule_ProvideGameInputProcessorFactory(GameModule module, Provider<GameStatePersister> gameStatePersisterProvider) {  
    assert module != null;
    this.module = module;
    assert gameStatePersisterProvider != null;
    this.gameStatePersisterProvider = gameStatePersisterProvider;
  }

  @Override
  public GameInputProcessor get() {  
    GameInputProcessor provided = module.provideGameInputProcessor(gameStatePersisterProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<GameInputProcessor> create(GameModule module, Provider<GameStatePersister> gameStatePersisterProvider) {  
    return new GameModule_ProvideGameInputProcessorFactory(module, gameStatePersisterProvider);
  }
}

