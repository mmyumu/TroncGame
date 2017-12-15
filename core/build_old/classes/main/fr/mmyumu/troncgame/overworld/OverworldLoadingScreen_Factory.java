package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.assets.AssetManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldLoadingScreen_Factory implements Factory<OverworldLoadingScreen> {
  private final MembersInjector<OverworldLoadingScreen> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<ModelManager> modelManagerProvider;

  public OverworldLoadingScreen_Factory(MembersInjector<OverworldLoadingScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ModelManager> modelManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert modelManagerProvider != null;
    this.modelManagerProvider = modelManagerProvider;
  }

  @Override
  public OverworldLoadingScreen get() {  
    OverworldLoadingScreen instance = new OverworldLoadingScreen(troncGameProvider.get(), assetManagerProvider.get(), modelManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<OverworldLoadingScreen> create(MembersInjector<OverworldLoadingScreen> membersInjector, Provider<TroncGame> troncGameProvider, Provider<AssetManager> assetManagerProvider, Provider<ModelManager> modelManagerProvider) {  
    return new OverworldLoadingScreen_Factory(membersInjector, troncGameProvider, assetManagerProvider, modelManagerProvider);
  }
}

