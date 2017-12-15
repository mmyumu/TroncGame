package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.ThemeManager;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ModelModule_ProvideThemeManagerFactory implements Factory<ThemeManager> {
  private final ModelModule module;

  public ModelModule_ProvideThemeManagerFactory(ModelModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public ThemeManager get() {  
    ThemeManager provided = module.provideThemeManager();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ThemeManager> create(ModelModule module) {  
    return new ModelModule_ProvideThemeManagerFactory(module);
  }
}

