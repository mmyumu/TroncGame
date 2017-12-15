package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.FightLogic;
import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightLogicFactory implements Factory<FightLogic> {
  private final FightModule module;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<Skin> skinProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<EnemyFightTeamGenerator> enemyFightTeamGeneratorProvider;
  private final Provider<FightPopUpMenuLogic> fightPopUpMenuLogicProvider;

  public FightModule_ProvideFightLogicFactory(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider, Provider<CharacterManager> characterManagerProvider, Provider<EnemyFightTeamGenerator> enemyFightTeamGeneratorProvider, Provider<FightPopUpMenuLogic> fightPopUpMenuLogicProvider) {  
    assert module != null;
    this.module = module;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert skinProvider != null;
    this.skinProvider = skinProvider;
    assert characterManagerProvider != null;
    this.characterManagerProvider = characterManagerProvider;
    assert enemyFightTeamGeneratorProvider != null;
    this.enemyFightTeamGeneratorProvider = enemyFightTeamGeneratorProvider;
    assert fightPopUpMenuLogicProvider != null;
    this.fightPopUpMenuLogicProvider = fightPopUpMenuLogicProvider;
  }

  @Override
  public FightLogic get() {  
    FightLogic provided = module.provideFightLogic(assetManagerProvider.get(), bundleProvider.get(), skinProvider.get(), characterManagerProvider.get(), enemyFightTeamGeneratorProvider.get(), fightPopUpMenuLogicProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightLogic> create(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider, Provider<CharacterManager> characterManagerProvider, Provider<EnemyFightTeamGenerator> enemyFightTeamGeneratorProvider, Provider<FightPopUpMenuLogic> fightPopUpMenuLogicProvider) {  
    return new FightModule_ProvideFightLogicFactory(module, assetManagerProvider, bundleProvider, skinProvider, characterManagerProvider, enemyFightTeamGeneratorProvider, fightPopUpMenuLogicProvider);
  }
}

