package fr.mmyumu.troncgame.overworld.ui;

import com.badlogic.gdx.utils.I18NBundle;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldFPS_Factory implements Factory<OverworldFPS> {
  private final MembersInjector<OverworldFPS> membersInjector;
  private final Provider<I18NBundle> bundleProvider;

  public OverworldFPS_Factory(MembersInjector<OverworldFPS> membersInjector, Provider<I18NBundle> bundleProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
  }

  @Override
  public OverworldFPS get() {  
    OverworldFPS instance = new OverworldFPS(bundleProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldFPS> create(MembersInjector<OverworldFPS> membersInjector, Provider<I18NBundle> bundleProvider) {  
    return new OverworldFPS_Factory(membersInjector, bundleProvider);
  }
}

