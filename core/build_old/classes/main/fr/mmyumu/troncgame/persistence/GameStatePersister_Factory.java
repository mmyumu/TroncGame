package fr.mmyumu.troncgame.persistence;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameStatePersister_Factory implements Factory<GameStatePersister> {
  private final Provider<ModelManager> modelManagerProvider;

  public GameStatePersister_Factory(Provider<ModelManager> modelManagerProvider) {  
    assert modelManagerProvider != null;
    this.modelManagerProvider = modelManagerProvider;
  }

  @Override
  public GameStatePersister get() {  
    return new GameStatePersister(modelManagerProvider.get());
  }

  public static Factory<GameStatePersister> create(Provider<ModelManager> modelManagerProvider) {  
    return new GameStatePersister_Factory(modelManagerProvider);
  }
}

