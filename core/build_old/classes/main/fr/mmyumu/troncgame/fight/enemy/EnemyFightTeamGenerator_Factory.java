package fr.mmyumu.troncgame.fight.enemy;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class EnemyFightTeamGenerator_Factory implements Factory<EnemyFightTeamGenerator> {
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<Skin> skinProvider;

  public EnemyFightTeamGenerator_Factory(Provider<AssetManager> assetManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<Skin> skinProvider) {  
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert characterManagerProvider != null;
    this.characterManagerProvider = characterManagerProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public EnemyFightTeamGenerator get() {  
    return new EnemyFightTeamGenerator(assetManagerProvider.get(), characterManagerProvider.get(), skinProvider.get());
  }

  public static Factory<EnemyFightTeamGenerator> create(Provider<AssetManager> assetManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<Skin> skinProvider) {  
    return new EnemyFightTeamGenerator_Factory(assetManagerProvider, characterManagerProvider, skinProvider);
  }
}

