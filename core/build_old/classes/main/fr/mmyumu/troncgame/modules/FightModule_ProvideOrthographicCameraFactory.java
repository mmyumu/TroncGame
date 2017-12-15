package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.graphics.OrthographicCamera;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideOrthographicCameraFactory implements Factory<OrthographicCamera> {
  private final FightModule module;

  public FightModule_ProvideOrthographicCameraFactory(FightModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public OrthographicCamera get() {  
    OrthographicCamera provided = module.provideOrthographicCamera();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OrthographicCamera> create(FightModule module) {  
    return new FightModule_ProvideOrthographicCameraFactory(module);
  }
}

