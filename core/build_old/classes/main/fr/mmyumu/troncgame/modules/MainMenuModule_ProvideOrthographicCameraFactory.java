package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.graphics.OrthographicCamera;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainMenuModule_ProvideOrthographicCameraFactory implements Factory<OrthographicCamera> {
  private final MainMenuModule module;

  public MainMenuModule_ProvideOrthographicCameraFactory(MainMenuModule module) {  
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

  public static Factory<OrthographicCamera> create(MainMenuModule module) {  
    return new MainMenuModule_ProvideOrthographicCameraFactory(module);
  }
}

