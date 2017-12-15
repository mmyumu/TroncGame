package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.ItemManager;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ModelModule_ProvideItemManagerFactory implements Factory<ItemManager> {
  private final ModelModule module;

  public ModelModule_ProvideItemManagerFactory(ModelModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public ItemManager get() {  
    ItemManager provided = module.provideItemManager();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ItemManager> create(ModelModule module) {  
    return new ModelModule_ProvideItemManagerFactory(module);
  }
}

