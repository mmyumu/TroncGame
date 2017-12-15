package fr.mmyumu.troncgame.overworld.menu;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldMenuList_Factory implements Factory<OverworldMenuList> {
  private final MembersInjector<OverworldMenuList> membersInjector;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<Skin> skinProvider;

  public OverworldMenuList_Factory(MembersInjector<OverworldMenuList> membersInjector, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public OverworldMenuList get() {  
    OverworldMenuList instance = new OverworldMenuList(assetManagerProvider.get(), bundleProvider.get(), skinProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldMenuList> create(MembersInjector<OverworldMenuList> membersInjector, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    return new OverworldMenuList_Factory(membersInjector, assetManagerProvider, bundleProvider, skinProvider);
  }
}

