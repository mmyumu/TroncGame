package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenuList;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldModule_ProvideOverworldMenuListFactory implements Factory<OverworldMenuList> {
  private final OverworldModule module;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<Skin> skinProvider;

  public OverworldModule_ProvideOverworldMenuListFactory(OverworldModule module, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    assert module != null;
    this.module = module;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public OverworldMenuList get() {  
    OverworldMenuList provided = module.provideOverworldMenuList(assetManagerProvider.get(), bundleProvider.get(), skinProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OverworldMenuList> create(OverworldModule module, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    return new OverworldModule_ProvideOverworldMenuListFactory(module, assetManagerProvider, bundleProvider, skinProvider);
  }
}

