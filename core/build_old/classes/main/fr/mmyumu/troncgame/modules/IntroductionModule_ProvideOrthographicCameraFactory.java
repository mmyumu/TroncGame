package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.graphics.OrthographicCamera;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class IntroductionModule_ProvideOrthographicCameraFactory implements Factory<OrthographicCamera> {
  private final IntroductionModule module;

  public IntroductionModule_ProvideOrthographicCameraFactory(IntroductionModule module) {  
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

  public static Factory<OrthographicCamera> create(IntroductionModule module) {  
    return new IntroductionModule_ProvideOrthographicCameraFactory(module);
  }
}

