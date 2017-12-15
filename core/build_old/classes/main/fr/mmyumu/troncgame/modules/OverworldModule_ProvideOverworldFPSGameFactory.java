package fr.mmyumu.troncgame.modules;

import com.badlogic.gdx.utils.I18NBundle;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class OverworldModule_ProvideOverworldFPSGameFactory implements Factory<OverworldFPS> {
  private final OverworldModule module;
  private final Provider<I18NBundle> bundleProvider;

  public OverworldModule_ProvideOverworldFPSGameFactory(OverworldModule module, Provider<I18NBundle> bundleProvider) {  
    assert module != null;
    this.module = module;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
  }

  @Override
  public OverworldFPS get() {  
    OverworldFPS provided = module.provideOverworldFPSGame(bundleProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OverworldFPS> create(OverworldModule module, Provider<I18NBundle> bundleProvider) {  
    return new OverworldModule_ProvideOverworldFPSGameFactory(module, bundleProvider);
  }
}

