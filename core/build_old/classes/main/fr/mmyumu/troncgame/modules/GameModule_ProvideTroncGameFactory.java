package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvideTroncGameFactory implements Factory<TroncGame> {
  private final GameModule module;

  public GameModule_ProvideTroncGameFactory(GameModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public TroncGame get() {  
    TroncGame provided = module.provideTroncGame();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<TroncGame> create(GameModule module) {  
    return new GameModule_ProvideTroncGameFactory(module);
  }
}

