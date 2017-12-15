package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideEnemyFightTeamGeneratorFactory implements Factory<EnemyFightTeamGenerator> {
  private final FightModule module;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<Skin> skinProvider;

  public FightModule_ProvideEnemyFightTeamGeneratorFactory(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<Skin> skinProvider) {  
    assert module != null;
    this.module = module;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert characterManagerProvider != null;
    this.characterManagerProvider = characterManagerProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
  }

  @Override
  public EnemyFightTeamGenerator get() {  
    EnemyFightTeamGenerator provided = module.provideEnemyFightTeamGenerator(assetManagerProvider.get(), characterManagerProvider.get(), skinProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<EnemyFightTeamGenerator> create(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<Skin> skinProvider) {  
    return new FightModule_ProvideEnemyFightTeamGeneratorFactory(module, assetManagerProvider, characterManagerProvider, skinProvider);
  }
}

