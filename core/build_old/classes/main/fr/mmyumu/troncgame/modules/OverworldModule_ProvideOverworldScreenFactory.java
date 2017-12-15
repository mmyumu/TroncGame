package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldModule_ProvideOverworldScreenFactory implements Factory<OverworldScreen> {
  private final OverworldModule module;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<ScalingViewport> gameViewportProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;

  public OverworldModule_ProvideOverworldScreenFactory(OverworldModule module, Provider<TroncGame> troncGameProvider, Provider<CharacterManager> characterManagerProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> gameViewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    assert module != null;
    this.module = module;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert characterManagerProvider != null;
    this.characterManagerProvider = characterManagerProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert gameViewportProvider != null;
    this.gameViewportProvider = gameViewportProvider;
    assert gameStatePersisterProvider != null;
    this.gameStatePersisterProvider = gameStatePersisterProvider;
  }

  @Override
  public OverworldScreen get() {  
    OverworldScreen provided = module.provideOverworldScreen(troncGameProvider.get(), characterManagerProvider.get(), assetManagerProvider.get(), gameViewportProvider.get(), gameStatePersisterProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OverworldScreen> create(OverworldModule module, Provider<TroncGame> troncGameProvider, Provider<CharacterManager> characterManagerProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> gameViewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    return new OverworldModule_ProvideOverworldScreenFactory(module, troncGameProvider, characterManagerProvider, assetManagerProvider, gameViewportProvider, gameStatePersisterProvider);
  }
}

