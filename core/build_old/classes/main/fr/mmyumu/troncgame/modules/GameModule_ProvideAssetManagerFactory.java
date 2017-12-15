package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class GameModule_ProvideAssetManagerFactory implements Factory<AssetManager> {
  private final GameModule module;

  public GameModule_ProvideAssetManagerFactory(GameModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public AssetManager get() {  
    AssetManager provided = module.provideAssetManager();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<AssetManager> create(GameModule module) {  
    return new GameModule_ProvideAssetManagerFactory(module);
  }
}

