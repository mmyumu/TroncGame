package fr.mmyumu.troncgame.dialog;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.ThemeManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DialogManager_Factory implements Factory<DialogManager> {
  private final MembersInjector<DialogManager> membersInjector;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<ThemeManager> themeManagerProvider;

  public DialogManager_Factory(MembersInjector<DialogManager> membersInjector, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<ThemeManager> themeManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert themeManagerProvider != null;
    this.themeManagerProvider = themeManagerProvider;
  }

  @Override
  public DialogManager get() {  
    DialogManager instance = new DialogManager(assetManagerProvider.get(), bundleProvider.get(), themeManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<DialogManager> create(MembersInjector<DialogManager> membersInjector, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<ThemeManager> themeManagerProvider) {  
    return new DialogManager_Factory(membersInjector, assetManagerProvider, bundleProvider, themeManagerProvider);
  }
}

