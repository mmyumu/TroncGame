package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvideGameStatePersisterFactory implements Factory<GameStatePersister> {
  private final GameModule module;
  private final Provider<ModelManager> modelManagerProvider;

  public GameModule_ProvideGameStatePersisterFactory(GameModule module, Provider<ModelManager> modelManagerProvider) {  
    assert module != null;
    this.module = module;
    assert modelManagerProvider != null;
    this.modelManagerProvider = modelManagerProvider;
  }

  @Override
  public GameStatePersister get() {  
    GameStatePersister provided = module.provideGameStatePersister(modelManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<GameStatePersister> create(GameModule module, Provider<ModelManager> modelManagerProvider) {  
    return new GameModule_ProvideGameStatePersisterFactory(module, modelManagerProvider);
  }
}

