package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldModule_ProvideOverworldLoadingScreenFactory implements Factory<OverworldLoadingScreen> {
  private final OverworldModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<ModelManager> modelManagerProvider;

  public OverworldModule_ProvideOverworldLoadingScreenFactory(OverworldModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ModelManager> modelManagerProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert modelManagerProvider != null;
    this.modelManagerProvider = modelManagerProvider;
  }

  @Override
  public OverworldLoadingScreen get() {  
    OverworldLoadingScreen provided = module.provideOverworldLoadingScreen(troncGameProvider.get(), assetManagerProvider.get(), modelManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OverworldLoadingScreen> create(OverworldModule module, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ModelManager> modelManagerProvider) {  
    return new OverworldModule_ProvideOverworldLoadingScreenFactory(module, troncGameProvider, assetManagerProvider, modelManagerProvider);
  }
}

