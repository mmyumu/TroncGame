package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ModelModule_ProvideCharacterManagerFactory implements Factory<CharacterManager> {
  private final ModelModule module;

  public ModelModule_ProvideCharacterManagerFactory(ModelModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public CharacterManager get() {  
    CharacterManager provided = module.provideCharacterManager();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<CharacterManager> create(ModelModule module) {  
    return new ModelModule_ProvideCharacterManagerFactory(module);
  }
}

