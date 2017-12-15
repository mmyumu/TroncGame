package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class Introduction_Factory implements Factory<Introduction> {
  private final MembersInjector<Introduction> membersInjector;
  private final Provider<ScalingViewport> viewportProvider;

  public Introduction_Factory(MembersInjector<Introduction> membersInjector, Provider<ScalingViewport> viewportProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public Introduction get() {  
    Introduction instance = new Introduction(viewportProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<Introduction> create(MembersInjector<Introduction> membersInjector, Provider<ScalingViewport> viewportProvider) {  
    return new Introduction_Factory(membersInjector, viewportProvider);
  }
}

