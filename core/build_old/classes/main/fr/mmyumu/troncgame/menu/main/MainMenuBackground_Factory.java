package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.assets.AssetManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuBackground_Factory implements Factory<MainMenuBackground> {
  private final MembersInjector<MainMenuBackground> membersInjector;
  private final Provider<AssetManager> assetManagerProvider;

  public MainMenuBackground_Factory(MembersInjector<MainMenuBackground> membersInjector, Provider<AssetManager> assetManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
  }

  @Override
  public MainMenuBackground get() {  
    MainMenuBackground instance = new MainMenuBackground(assetManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MainMenuBackground> create(MembersInjector<MainMenuBackground> membersInjector, Provider<AssetManager> assetManagerProvider) {  
    return new MainMenuBackground_Factory(membersInjector, assetManagerProvider);
  }
}

