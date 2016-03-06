package fr.mmyumu.troncgame.modules;

import dagger.Module;
import dagger.Provides;
import fr.mmyumu.troncgame.ActivityScope;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import fr.mmyumu.troncgame.model.manager.ItemManager;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.model.manager.ThemeManager;

/**
 * Dagger module to provide Overworld
 * Created by mmyumu on 07/11/2015.
 */
@Module
public class ModelModule {
    @Provides
    @ActivityScope
    ItemManager provideItemManager() {
        return new ItemManager();
    }

    @Provides
    @ActivityScope
    CharacterManager provideCharacterManager() {
        return new CharacterManager();
    }

    @Provides
    @ActivityScope
    ThemeManager provideThemeManager() {
        return new ThemeManager();
    }

    @Provides
    @ActivityScope
    ModelManager provideModelManager(ItemManager itemManager, CharacterManager characterManager, ThemeManager themeManager) {
        return new ModelManager(itemManager, characterManager, themeManager);
    }
}
