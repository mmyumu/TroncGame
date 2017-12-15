package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.FontManager;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuIcon;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightPopUpMenuSpellIconFactory implements Factory<FightPopUpMenuIcon> {
  private final FightModule module;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<FontManager> fontManagerProvider;

  public FightModule_ProvideFightPopUpMenuSpellIconFactory(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<FontManager> fontManagerProvider) {  
    assert module != null;
    this.module = module;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert fontManagerProvider != null;
    this.fontManagerProvider = fontManagerProvider;
  }

  @Override
  public FightPopUpMenuIcon get() {  
    FightPopUpMenuIcon provided = module.provideFightPopUpMenuSpellIcon(assetManagerProvider.get(), bundleProvider.get(), fontManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightPopUpMenuIcon> create(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<FontManager> fontManagerProvider) {  
    return new FightModule_ProvideFightPopUpMenuSpellIconFactory(module, assetManagerProvider, bundleProvider, fontManagerProvider);
  }
}

