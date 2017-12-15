package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightPopUpMenuNotReady_Factory implements Factory<FightPopUpMenuNotReady> {
  private final MembersInjector<FightPopUpMenuNotReady> membersInjector;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<Skin> skinProvider;

  public FightPopUpMenuNotReady_Factory(MembersInjector<FightPopUpMenuNotReady> membersInjector, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public FightPopUpMenuNotReady get() {  
    FightPopUpMenuNotReady instance = new FightPopUpMenuNotReady(bundleProvider.get(), skinProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<FightPopUpMenuNotReady> create(MembersInjector<FightPopUpMenuNotReady> membersInjector, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider) {  
    return new FightPopUpMenuNotReady_Factory(membersInjector, bundleProvider, skinProvider);
  }
}

