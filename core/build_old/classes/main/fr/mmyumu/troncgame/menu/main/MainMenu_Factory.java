package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenu_Factory implements Factory<MainMenu> {
  private final MembersInjector<MainMenu> membersInjector;
  private final Provider<ScalingViewport> viewportProvider;

  public MainMenu_Factory(MembersInjector<MainMenu> membersInjector, Provider<ScalingViewport> viewportProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public MainMenu get() {  
    MainMenu instance = new MainMenu(viewportProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MainMenu> create(MembersInjector<MainMenu> membersInjector, Provider<ScalingViewport> viewportProvider) {  
    return new MainMenu_Factory(membersInjector, viewportProvider);
  }
}

