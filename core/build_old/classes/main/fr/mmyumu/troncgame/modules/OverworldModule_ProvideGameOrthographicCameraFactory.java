package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.graphics.OrthographicCamera;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldModule_ProvideGameOrthographicCameraFactory implements Factory<OrthographicCamera> {
  private final OverworldModule module;

  public OverworldModule_ProvideGameOrthographicCameraFactory(OverworldModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public OrthographicCamera get() {  
    OrthographicCamera provided = module.provideGameOrthographicCamera();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OrthographicCamera> create(OverworldModule module) {  
    return new OverworldModule_ProvideGameOrthographicCameraFactory(module);
  }
}

