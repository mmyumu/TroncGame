package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.ui.FightMainInfos;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightMainInfosFactory implements Factory<FightMainInfos> {
  private final FightModule module;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<Skin> skinProvider;

  public FightModule_ProvideFightMainInfosFactory(FightModule module, Provider<I18NBundle> bundleProvider, Provider<AssetManager> assetManagerProvider, Provider<Skin> skinProvider) {  
    assert module != null;
    this.module = module;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public FightMainInfos get() {  
    FightMainInfos provided = module.provideFightMainInfos(bundleProvider.get(), assetManagerProvider.get(), skinProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightMainInfos> create(FightModule module, Provider<I18NBundle> bundleProvider, Provider<AssetManager> assetManagerProvider, Provider<Skin> skinProvider) {  
    return new FightModule_ProvideFightMainInfosFactory(module, bundleProvider, assetManagerProvider, skinProvider);
  }
}

