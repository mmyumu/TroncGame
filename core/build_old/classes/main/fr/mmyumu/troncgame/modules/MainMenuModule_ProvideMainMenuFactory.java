package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.menu.main.MainMenu;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuModule_ProvideMainMenuFactory implements Factory<MainMenu> {
  private final MainMenuModule module;
  private final Provider<ScalingViewport> viewportProvider;

  public MainMenuModule_ProvideMainMenuFactory(MainMenuModule module, Provider<ScalingViewport> viewportProvider) {  
    assert module != null;
    this.module = module;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public MainMenu get() {  
    MainMenu provided = module.provideMainMenu(viewportProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<MainMenu> create(MainMenuModule module, Provider<ScalingViewport> viewportProvider) {  
    return new MainMenuModule_ProvideMainMenuFactory(module, viewportProvider);
  }
}

