package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvidePress2PStartSkinFactory implements Factory<Skin> {
  private final GameModule module;
  private final Provider<BitmapFont> fontProvider;

  public GameModule_ProvidePress2PStartSkinFactory(GameModule module, Provider<BitmapFont> fontProvider) {  
    assert module != null;
    this.module = module;
    assert fontProvider != null;
    this.fontProvider = fontProvider;
  }

  @Override
  public Skin get() {  
    Skin provided = module.providePress2PStartSkin(fontProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Skin> create(GameModule module, Provider<BitmapFont> fontProvider) {  
    return new GameModule_ProvidePress2PStartSkinFactory(module, fontProvider);
  }
}

