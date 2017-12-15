package fr.mmyumu.troncgame.fight.game;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightGame_Factory implements Factory<FightGame> {
  private final MembersInjector<FightGame> membersInjector;
  private final Provider<ScalingViewport> viewportProvider;

  public FightGame_Factory(MembersInjector<FightGame> membersInjector, Provider<ScalingViewport> viewportProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public FightGame get() {  
    FightGame instance = new FightGame(viewportProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<FightGame> create(MembersInjector<FightGame> membersInjector, Provider<ScalingViewport> viewportProvider) {  
    return new FightGame_Factory(membersInjector, viewportProvider);
  }
}

