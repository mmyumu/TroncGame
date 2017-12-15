package fr.mmyumu.troncgame.model.manager;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public enum ThemeManager_Factory implements Factory<ThemeManager> {
INSTANCE;

  @Override
  public ThemeManager get() {  
    return new ThemeManager();
  }

  public static Factory<ThemeManager> create() {  
    return INSTANCE;
  }
}

