package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.util.Utils;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvideUtilsFactory implements Factory<Utils> {
  private final GameModule module;

  public GameModule_ProvideUtilsFactory(GameModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Utils get() {  
    Utils provided = module.provideUtils();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Utils> create(GameModule module) {  
    return new GameModule_ProvideUtilsFactory(module);
  }
}

