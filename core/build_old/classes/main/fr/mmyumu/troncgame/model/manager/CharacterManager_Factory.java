package fr.mmyumu.troncgame.model.manager;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public enum CharacterManager_Factory implements Factory<CharacterManager> {
INSTANCE;

  @Override
  public CharacterManager get() {  
    return new CharacterManager();
  }

  public static Factory<CharacterManager> create() {  
    return INSTANCE;
  }
}

