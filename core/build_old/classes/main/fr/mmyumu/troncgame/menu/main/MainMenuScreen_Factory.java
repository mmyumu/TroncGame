package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuScreen_Factory implements Factory<MainMenuScreen> {
  private final MembersInjector<MainMenuScreen> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<ScalingViewport> viewportProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;

  public MainMenuScreen_Factory(MembersInjector<MainMenuScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<ScalingViewport> viewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
    assert gameStatePersisterProvider != null;
    this.gameStatePersisterProvider = gameStatePersisterProvider;
  }

  @Override
  public MainMenuScreen get() {  
    MainMenuScreen instance = new MainMenuScreen(troncGameProvider.get(), viewportProvider.get(), gameStatePersisterProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MainMenuScreen> create(MembersInjector<MainMenuScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<ScalingViewport> viewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    return new MainMenuScreen_Factory(membersInjector, troncGameProvider, viewportProvider, gameStatePersisterProvider);
  }
}

