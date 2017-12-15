package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.assets.AssetManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class FightPopUpMenuLogic_Factory implements Factory<FightPopUpMenuLogic> {
  private final Provider<AssetManager> assetManagerProvider;
  private final Provider<FightPopUpMenuNotReady> fightPopUpMenuNotReadyProvider;
  private final Provider<FightPopUpMenuIcon> fightPopUpMenuSpellsIconProvider;
  private final Provider<FightPopUpMenuIcon> fightPopUpMenuWeaponsIconProvider;

  public FightPopUpMenuLogic_Factory(Provider<AssetManager> assetManagerProvider, Provider<FightPopUpMenuNotReady> fightPopUpMenuNotReadyProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuSpellsIconProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuWeaponsIconProvider) {  
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
    return new FightPopUpMenuLogic(assetManagerProvider.get(), fightPopUpMenuNotReadyProvider.get(), fightPopUpMenuSpellsIconProvider.get(), fightPopUpMenuWeaponsIconProvider.get());
  }

  public static Factory<FightPopUpMenuLogic> create(Provider<AssetManager> assetManagerProvider, Provider<FightPopUpMenuNotReady> fightPopUpMenuNotReadyProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuSpellsIconProvider, Provider<FightPopUpMenuIcon> fightPopUpMenuWeaponsIconProvider) {  
    return new FightPopUpMenuLogic_Factory(assetManagerProvider, fightPopUpMenuNotReadyProvider, fightPopUpMenuSpellsIconProvider, fightPopUpMenuWeaponsIconProvider);
  }
}

