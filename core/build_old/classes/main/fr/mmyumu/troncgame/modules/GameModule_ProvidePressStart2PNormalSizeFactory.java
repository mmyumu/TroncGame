package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvidePressStart2PNormalSizeFactory implements Factory<BitmapFont> {
  private final GameModule module;

  public GameModule_ProvidePressStart2PNormalSizeFactory(GameModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public BitmapFont get() {  
    BitmapFont provided = module.providePressStart2PNormalSize();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<BitmapFont> create(GameModule module) {  
    return new GameModule_ProvidePressStart2PNormalSizeFactory(module);
  }
}

