package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideViewportFactory implements Factory<ScalingViewport> {
  private final FightModule module;
  private final Provider<OrthographicCamera> cameraProvider;

  public FightModule_ProvideViewportFactory(FightModule module, Provider<OrthographicCamera> cameraProvider) {  
    assert module != null;
    this.module = module;
    assert cameraProvider != null;
    this.cameraProvider = cameraProvider;
  }

  @Override
  public ScalingViewport get() {  
    ScalingViewport provided = module.provideViewport(cameraProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ScalingViewport> create(FightModule module, Provider<OrthographicCamera> cameraProvider) {  
    return new FightModule_ProvideViewportFactory(module, cameraProvider);
  }
}

