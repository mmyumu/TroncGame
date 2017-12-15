package fr.mmyumu.troncgame.model.manager;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ModelManager_Factory implements Factory<ModelManager> {
  private final Provider<ItemManager> itemManagerProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<ThemeManager> themeManagerProvider;

  public ModelManager_Factory(Provider<ItemManager> itemManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<ThemeManager> themeManagerProvider) {  
    assert itemManagerProvider != null;
    this.itemManagerProvider = itemManagerProvider;
    assert characterManagerProvider != null;
    this.characterManagerProvider = characterManagerProvider;
    assert themeManagerProvider != null;
    this.themeManagerProvider = themeManagerProvider;
  }

  @Override
  public ModelManager get() {  
    return new ModelManager(itemManagerProvider.get(), characterManagerProvider.get(), themeManagerProvider.get());
  }

  public static Factory<ModelManager> create(Provider<ItemManager> itemManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<ThemeManager> themeManagerProvider) {  
    return new ModelManager_Factory(itemManagerProvider, characterManagerProvider, themeManagerProvider);
  }
}

