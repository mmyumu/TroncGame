package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.FontManager;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvideFontManagerFactory implements Factory<FontManager> {
  private final GameModule module;

  public GameModule_ProvideFontManagerFactory(GameModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public FontManager get() {  
    FontManager provided = module.provideFontManager();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FontManager> create(GameModule module) {  
    return new GameModule_ProvideFontManagerFactory(module);
  }
}

