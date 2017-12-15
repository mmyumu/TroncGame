package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldScreen_Factory implements Factory<OverworldScreen> {
  private final MembersInjector<OverworldScreen> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<ScalingViewport> gameViewportProvider;
  private final Provider<GameStatePersister> gameStatePersisterProvider;

  public OverworldScreen_Factory(MembersInjector<OverworldScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<CharacterManager> characterManagerProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> gameViewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
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
    OverworldScreen instance = new OverworldScreen(troncGameProvider.get(), characterManagerProvider.get(), assetManagerProvider.get(), gameViewportProvider.get(), gameStatePersisterProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldScreen> create(MembersInjector<OverworldScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<CharacterManager> characterManagerProvider, Provider<AssetManager> assetManagerProvider, Provider<ScalingViewport> gameViewportProvider, Provider<GameStatePersister> gameStatePersisterProvider) {  
    return new OverworldScreen_Factory(membersInjector, troncGameProvider, characterManagerProvider, assetManagerProvider, gameViewportProvider, gameStatePersisterProvider);
  }
}

