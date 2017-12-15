package fr.mmyumu.troncgame.modules;

import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import fr.mmyumu.troncgame.model.manager.ItemManager;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.model.manager.ThemeManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ModelModule_ProvideModelManagerFactory implements Factory<ModelManager> {
  private final ModelModule module;
  private final Provider<ItemManager> itemManagerProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<ThemeManager> themeManagerProvider;

  public ModelModule_ProvideModelManagerFactory(ModelModule module, Provider<ItemManager> itemManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<ThemeManager> themeManagerProvider) {  
    assert module != null;
    this.module = module;
    assert itemManagerProvider != null;
    this.itemManagerProvider = itemManagerProvider;
    assert characterManagerProvider != null;
    this.characterManagerProvider = characterManagerProvider;
    assert themeManagerProvider != null;
    this.themeManagerProvider = themeManagerProvider;
  }

  @Override
  public ModelManager get() {  
    ModelManager provided = module.provideModelManager(itemManagerProvider.get(), characterManagerProvider.get(), themeManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ModelManager> create(ModelModule module, Provider<ItemManager> itemManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<ThemeManager> themeManagerProvider) {  
    return new ModelModule_ProvideModelManagerFactory(module, itemManagerProvider, characterManagerProvider, themeManagerProvider);
  }
}

