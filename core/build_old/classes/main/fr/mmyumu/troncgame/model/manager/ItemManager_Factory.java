package fr.mmyumu.troncgame.model.manager;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public enum ItemManager_Factory implements Factory<ItemManager> {
INSTANCE;

  @Override
  public ItemManager get() {  
    return new ItemManager();
  }

  public static Factory<ItemManager> create() {  
    return INSTANCE;
  }
}

