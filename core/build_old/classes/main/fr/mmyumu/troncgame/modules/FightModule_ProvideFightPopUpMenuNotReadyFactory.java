package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuNotReady;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightPopUpMenuNotReadyFactory implements Factory<FightPopUpMenuNotReady> {
  private final FightModule module;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<Skin> skinProvider;

  public FightModule_ProvideFightPopUpMenuNotReadyFactory(FightModule module, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    assert module != null;
    this.module = module;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public FightPopUpMenuNotReady get() {  
    FightPopUpMenuNotReady provided = module.provideFightPopUpMenuNotReady(bundleProvider.get(), skinProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightPopUpMenuNotReady> create(FightModule module, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    return new FightModule_ProvideFightPopUpMenuNotReadyFactory(module, bundleProvider, skinProvider);
  }
}

