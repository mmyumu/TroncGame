package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvideI18NBundleFactory implements Factory<I18NBundle> {
  private final GameModule module;

  public GameModule_ProvideI18NBundleFactory(GameModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public I18NBundle get() {  
    I18NBundle provided = module.provideI18NBundle();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<I18NBundle> create(GameModule module) {  
    return new GameModule_ProvideI18NBundleFactory(module);
  }
}

