package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuModule_ProvideMainMenuScreenFactory implements Factory<MainMenuScreen> {
  private final MainMenuModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;

  public MainMenuModule_ProvideMainMenuScreenFactory(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<ScalingViewport> viewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
    assert gameStatePersisterProvider != null;
    this.gameStatePersisterProvider = gameStatePersisterProvider;
  }

  @Override
  public MainMenuScreen get() {  
    MainMenuScreen provided = module.provideMainMenuScreen(troncGameProvider.get(), viewportProvider.get(), gameStatePersisterProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<MainMenuScreen> create(MainMenuModule module, Provider<TroncGame> troncGameProvider, Provider<ScalingViewport> viewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    return new MainMenuModule_ProvideMainMenuScreenFactory(module, troncGameProvider, viewportProvider, gameStatePersisterProvider);
  }
}

