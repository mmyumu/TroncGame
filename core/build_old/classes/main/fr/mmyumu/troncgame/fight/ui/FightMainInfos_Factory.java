package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightMainInfos_Factory implements Factory<FightMainInfos> {
  private final MembersInjector<FightMainInfos> membersInjector;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<Skin> skinProvider;

  public FightMainInfos_Factory(MembersInjector<FightMainInfos> membersInjector, Provider<I18NBundle> bundleProvider, Provider<AssetManager> assetManagerProvider, Provider<Skin> skinProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public FightMainInfos get() {  
    FightMainInfos instance = new FightMainInfos(bundleProvider.get(), assetManagerProvider.get(), skinProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<FightMainInfos> create(MembersInjector<FightMainInfos> membersInjector, Provider<I18NBundle> bundleProvider, Provider<AssetManager> assetManagerProvider, Provider<Skin> skinProvider) {  
    return new FightMainInfos_Factory(membersInjector, bundleProvider, assetManagerProvider, skinProvider);
  }
}

