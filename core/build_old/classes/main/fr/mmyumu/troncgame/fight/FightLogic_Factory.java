package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightLogic_Factory implements Factory<FightLogic> {
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<Skin> skinProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<EnemyFightTeamGenerator> enemyFightTeamGeneratorProvider;
  private final Provider<FightPopUpMenuLogic> popUpMenuLogicProvider;

  public FightLogic_Factory(Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider, Provider<CharacterManager> characterManagerProvider, Provider<EnemyFightTeamGenerator> enemyFightTeamGeneratorProvider, Provider<FightPopUpMenuLogic> popUpMenuLogicProvider) {  
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
    assert popUpMenuLogicProvider != null;
    this.popUpMenuLogicProvider = popUpMenuLogicProvider;
  }

  @Override
  public FightLogic get() {  
    return new FightLogic(assetManagerProvider.get(), bundleProvider.get(), skinProvider.get(), characterManagerProvider.get(), enemyFightTeamGeneratorProvider.get(), popUpMenuLogicProvider.get());
  }

  public static Factory<FightLogic> create(Provider<AssetManager> assetManagerProvider, Provider<I18NBundle> bundleProvider, Provider<Skin> skinProvider, Provider<CharacterManager> characterManagerProvider, Provider<EnemyFightTeamGenerator> enemyFightTeamGeneratorProvider, Provider<FightPopUpMenuLogic> popUpMenuLogicProvider) {  
    return new FightLogic_Factory(assetManagerProvider, bundleProvider, skinProvider, characterManagerProvider, enemyFightTeamGeneratorProvider, popUpMenuLogicProvider);
  }
}

