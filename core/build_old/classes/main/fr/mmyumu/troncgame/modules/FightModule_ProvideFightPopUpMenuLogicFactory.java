package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.assets.AssetManager;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuNotReady;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightModule_ProvideFightPopUpMenuLogicFactory implements Factory<FightPopUpMenuLogic> {
  private final FightModule module;
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<FightPopUpMenuNotReady> fightPopUpMenuNotReadyProvider;
  private final Provider<FightPopUpMenuIcon> fightPopUpMenuSpellsIconProvider;
  private final Provider<FightPopUpMenuIcon> fightPopUpMenuWeaponsIconProvider;

  public FightModule_ProvideFightPopUpMenuLogicFactory(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<FightPopUpMenuNotReady> fightPopUpMenuNotReadyProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuSpellsIconProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuWeaponsIconProvider) {  
    assert module != null;
    this.module = module;
    assert assetManagerProvider != null;
    this.assetManagerProvider = assetManagerProvider;
    assert fightPopUpMenuNotReadyProvider != null;
    this.fightPopUpMenuNotReadyProvider = fightPopUpMenuNotReadyProvider;
    assert fightPopUpMenuSpellsIconProvider != null;
    this.fightPopUpMenuSpellsIconProvider = fightPopUpMenuSpellsIconProvider;
    assert fightPopUpMenuWeaponsIconProvider != null;
    this.fightPopUpMenuWeaponsIconProvider = fightPopUpMenuWeaponsIconProvider;
  }

  @Override
  public FightPopUpMenuLogic get() {  
    FightPopUpMenuLogic provided = module.provideFightPopUpMenuLogic(assetManagerProvider.get(), fightPopUpMenuNotReadyProvider.get(), fightPopUpMenuSpellsIconProvider.get(), fightPopUpMenuWeaponsIconProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<FightPopUpMenuLogic> create(FightModule module, Provider<AssetManager> assetManagerProvider, Provider<FightPopUpMenuNotReady> fightPopUpMenuNotReadyProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuSpellsIconProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuWeaponsIconProvider) {  
    return new FightModule_ProvideFightPopUpMenuLogicFactory(module, assetManagerProvider, fightPopUpMenuNotReadyProvider, fightPopUpMenuSpellsIconProvider, fightPopUpMenuWeaponsIconProvider);
  }
}

