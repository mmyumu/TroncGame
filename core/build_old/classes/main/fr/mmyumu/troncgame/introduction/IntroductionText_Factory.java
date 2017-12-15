package fr.mmyumu.troncgame.introduction;

import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.Factory;
import fr.mmyumu.troncgame.FontManager;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.dialog.DialogManager;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class IntroductionText_Factory implements Factory<IntroductionText> {
  private final MembersInjector<IntroductionText> membersInjector;
  private final Provider<TroncGame> troncGameProvider;
  private final Provider<I18NBundle> bundleProvider;
  private final Provider<DialogManager> dialogManagerProvider;
  private final Provider<FontManager> fontManagerProvider;
  private final Provider<CharacterManager> characterManagerProvider;
  private final Provider<ScalingViewport> viewportProvider;

  public IntroductionText_Factory(MembersInjector<IntroductionText> membersInjector, Provider<TroncGame> troncGameProvider, Provider<I18NBundle> bundleProvider, Provider<DialogManager> dialogManagerProvider, Provider<FontManager> fontManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<ScalingViewport> viewportProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert troncGameProvider != null;
    this.troncGameProvider = troncGameProvider;
    assert bundleProvider != null;
    this.bundleProvider = bundleProvider;
    assert dialogManagerProvider != null;
    this.dialogManagerProvider = dialogManagerProvider;
    assert fontManagerProvider != null;
    this.fontManagerProvider = fontManagerProvider;
    assert characterManagerProvider != null;
    this.characterManagerProvider = characterManagerProvider;
    assert viewportProvider != null;
    this.viewportProvider = viewportProvider;
  }

  @Override
  public IntroductionText get() {  
    IntroductionText instance = new IntroductionText(troncGameProvider.get(), bundleProvider.get(), dialogManagerProvider.get(), fontManagerProvider.get(), characterManagerProvider.get(), viewportProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<IntroductionText> create(MembersInjector<IntroductionText> membersInjector, Provider<TroncGame> troncGameProvider, Provider<I18NBundle> bundleProvider, Provider<DialogManager> dialogManagerProvider, Provider<FontManager> fontManagerProvider, Provider<CharacterManager> characterManagerProvider, Provider<ScalingViewport> viewportProvider) {  
    return new IntroductionText_Factory(membersInjector, troncGameProvider, bundleProvider, dialogManagerProvider, fontManagerProvider, characterManagerProvider, viewportProvider);
  }
}

