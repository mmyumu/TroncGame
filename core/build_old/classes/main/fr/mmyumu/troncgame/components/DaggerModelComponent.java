package fr.mmyumu.troncgame.components;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import fr.mmyumu.troncgame.FontManager;
import fr.mmyumu.troncgame.GameInputProcessor;
import fr.mmyumu.troncgame.GameLoadingScreen;
import fr.mmyumu.troncgame.GameLoadingScreen_Factory;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.dialog.DialogManager;
import fr.mmyumu.troncgame.dialog.DialogManager_Factory;
import fr.mmyumu.troncgame.fight.FightLoadingScreen;
import fr.mmyumu.troncgame.fight.FightLogic;
import fr.mmyumu.troncgame.fight.FightScreen;
import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;
import fr.mmyumu.troncgame.fight.game.FightGame;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuIcon;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuLogic;
import fr.mmyumu.troncgame.fight.popup.FightPopUpMenuNotReady;
import fr.mmyumu.troncgame.fight.ui.FightUI;
import fr.mmyumu.troncgame.introduction.Introduction;
import fr.mmyumu.troncgame.introduction.IntroductionLoadingScreen;
import fr.mmyumu.troncgame.introduction.IntroductionScreen;
import fr.mmyumu.troncgame.introduction.IntroductionText;
import fr.mmyumu.troncgame.introduction.IntroductionText_Factory;
import fr.mmyumu.troncgame.introduction.Introduction_Factory;
import fr.mmyumu.troncgame.menu.main.MainMenu;
import fr.mmyumu.troncgame.menu.main.MainMenuBackground;
import fr.mmyumu.troncgame.menu.main.MainMenuBackground_Factory;
import fr.mmyumu.troncgame.menu.main.MainMenuContinue;
import fr.mmyumu.troncgame.menu.main.MainMenuLoadingScreen;
import fr.mmyumu.troncgame.menu.main.MainMenuScreen;
import fr.mmyumu.troncgame.menu.main.MainMenuStart;
import fr.mmyumu.troncgame.model.manager.CharacterManager;
import fr.mmyumu.troncgame.model.manager.ItemManager;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.model.manager.ThemeManager;
import fr.mmyumu.troncgame.modules.FightModule;
import fr.mmyumu.troncgame.modules.FightModule_ProvideEnemyFightTeamGeneratorFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightGameFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightLoadingScreenFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightLogicFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightPopUpMenuLogicFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightPopUpMenuNotReadyFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightPopUpMenuSpellIconFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightPopUpMenuWeaponsIconFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightScreenFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideFightUIFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideOrthographicCameraFactory;
import fr.mmyumu.troncgame.modules.FightModule_ProvideViewportFactory;
import fr.mmyumu.troncgame.modules.GameModule;
import fr.mmyumu.troncgame.modules.GameModule_ProvideAssetManagerFactory;
import fr.mmyumu.troncgame.modules.GameModule_ProvideFontManagerFactory;
import fr.mmyumu.troncgame.modules.GameModule_ProvideGameInputProcessorFactory;
import fr.mmyumu.troncgame.modules.GameModule_ProvideGameStatePersisterFactory;
import fr.mmyumu.troncgame.modules.GameModule_ProvideI18NBundleFactory;
import fr.mmyumu.troncgame.modules.GameModule_ProvidePress2PStartSkinFactory;
import fr.mmyumu.troncgame.modules.GameModule_ProvidePressStart2PNormalSizeFactory;
import fr.mmyumu.troncgame.modules.GameModule_ProvideTroncGameFactory;
import fr.mmyumu.troncgame.modules.IntroductionModule;
import fr.mmyumu.troncgame.modules.IntroductionModule_ProvideIntroductionLoadingScreenFactory;
import fr.mmyumu.troncgame.modules.IntroductionModule_ProvideIntroductionScreenFactory;
import fr.mmyumu.troncgame.modules.IntroductionModule_ProvideOrthographicCameraFactory;
import fr.mmyumu.troncgame.modules.IntroductionModule_ProvideViewportFactory;
import fr.mmyumu.troncgame.modules.MainMenuModule;
import fr.mmyumu.troncgame.modules.MainMenuModule_ProvideMainMenuContinueFactory;
import fr.mmyumu.troncgame.modules.MainMenuModule_ProvideMainMenuFactory;
import fr.mmyumu.troncgame.modules.MainMenuModule_ProvideMainMenuLoadingScreenFactory;
import fr.mmyumu.troncgame.modules.MainMenuModule_ProvideMainMenuScreenFactory;
import fr.mmyumu.troncgame.modules.MainMenuModule_ProvideMainMenuStartFactory;
import fr.mmyumu.troncgame.modules.MainMenuModule_ProvideOrthographicCameraFactory;
import fr.mmyumu.troncgame.modules.MainMenuModule_ProvideViewportFactory;
import fr.mmyumu.troncgame.modules.ModelModule;
import fr.mmyumu.troncgame.modules.ModelModule_ProvideCharacterManagerFactory;
import fr.mmyumu.troncgame.modules.ModelModule_ProvideItemManagerFactory;
import fr.mmyumu.troncgame.modules.ModelModule_ProvideModelManagerFactory;
import fr.mmyumu.troncgame.modules.ModelModule_ProvideThemeManagerFactory;
import fr.mmyumu.troncgame.modules.OverworldModule;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideGameOrthographicCameraFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideGameViewportFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideOverworldLoadingScreenFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideOverworldMenuFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideOverworldMenuListFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideOverworldScreenFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideOverworldUIFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideUIOrthographicCameraFactory;
import fr.mmyumu.troncgame.modules.OverworldModule_ProvideUIViewportFactory;
import fr.mmyumu.troncgame.overworld.OverworldLoadingScreen;
import fr.mmyumu.troncgame.overworld.OverworldScreen;
import fr.mmyumu.troncgame.overworld.game.OverworldGameInputProcessor;
import fr.mmyumu.troncgame.overworld.game.OverworldGameInputProcessor_Factory;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenu;
import fr.mmyumu.troncgame.overworld.menu.OverworldMenuList;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS;
import fr.mmyumu.troncgame.overworld.ui.OverworldFPS_Factory;
import fr.mmyumu.troncgame.overworld.ui.OverworldUI;
import fr.mmyumu.troncgame.overworld.ui.OverworldUIInputProcessor;
import fr.mmyumu.troncgame.overworld.ui.OverworldUIInputProcessor_Factory;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerModelComponent implements ModelComponent {
  private Provider<ItemManager> provideItemManagerProvider;
  private Provider<CharacterManager> provideCharacterManagerProvider;
  private Provider<ThemeManager> provideThemeManagerProvider;
  private Provider<ModelManager> provideModelManagerProvider;

  private DaggerModelComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static ModelComponent create() {  
    return builder().build();
  }

  private void initialize(final Builder builder) {  
    this.provideItemManagerProvider = ScopedProvider.create(ModelModule_ProvideItemManagerFactory.create(builder.modelModule));
    this.provideCharacterManagerProvider = ScopedProvider.create(ModelModule_ProvideCharacterManagerFactory.create(builder.modelModule));
    this.provideThemeManagerProvider = ScopedProvider.create(ModelModule_ProvideThemeManagerFactory.create(builder.modelModule));
    this.provideModelManagerProvider = ScopedProvider.create(ModelModule_ProvideModelManagerFactory.create(builder.modelModule, provideItemManagerProvider, provideCharacterManagerProvider, provideThemeManagerProvider));
  }

  @Override
  public GameComponent createGameComponent(GameModule gameModule) {  
    return new GameComponentImpl(gameModule);
  }

  public static final class Builder {
    private ModelModule modelModule;
  
    private Builder() {  
    }
  
    public ModelComponent build() {  
      if (modelModule == null) {
        this.modelModule = new ModelModule();
      }
      return new DaggerModelComponent(this);
    }
  
    public Builder modelModule(ModelModule modelModule) {  
      if (modelModule == null) {
        throw new NullPointerException("modelModule");
      }
      this.modelModule = modelModule;
      return this;
    }
  }

  private final class GameComponentImpl implements GameComponent {
    private final GameModule gameModule;
    private Provider<GameStatePersister> provideGameStatePersisterProvider;
    private Provider<GameInputProcessor> provideGameInputProcessorProvider;
    private Provider<TroncGame> provideTroncGameProvider;
    private Provider<AssetManager> provideAssetManagerProvider;
    private Provider<GameLoadingScreen> gameLoadingScreenProvider;
    private Provider<I18NBundle> provideI18NBundleProvider;
    private Provider<BitmapFont> providePressStart2PNormalSizeProvider;
    private Provider<Skin> providePress2PStartSkinProvider;
    private Provider<FontManager> provideFontManagerProvider;
  
    private GameComponentImpl(GameModule gameModule) {  
      if (gameModule == null) {
        throw new NullPointerException();
      }
      this.gameModule = gameModule;
      initialize();
    }
  
    private void initialize() {  
      this.provideGameStatePersisterProvider = GameModule_ProvideGameStatePersisterFactory.create(gameModule, DaggerModelComponent.this.provideModelManagerProvider);
      this.provideGameInputProcessorProvider = GameModule_ProvideGameInputProcessorFactory.create(gameModule, provideGameStatePersisterProvider);
      this.provideTroncGameProvider = GameModule_ProvideTroncGameFactory.create(gameModule);
      this.provideAssetManagerProvider = ScopedProvider.create(GameModule_ProvideAssetManagerFactory.create(gameModule));
      this.gameLoadingScreenProvider = GameLoadingScreen_Factory.create((MembersInjector) MembersInjectors.noOp(), provideTroncGameProvider, provideAssetManagerProvider);
      this.provideI18NBundleProvider = ScopedProvider.create(GameModule_ProvideI18NBundleFactory.create(gameModule));
      this.providePressStart2PNormalSizeProvider = ScopedProvider.create(GameModule_ProvidePressStart2PNormalSizeFactory.create(gameModule));
      this.providePress2PStartSkinProvider = ScopedProvider.create(GameModule_ProvidePress2PStartSkinFactory.create(gameModule, providePressStart2PNormalSizeProvider));
      this.provideFontManagerProvider = ScopedProvider.create(GameModule_ProvideFontManagerFactory.create(gameModule));
    }
  
    @Override
    public void inject(TroncGame troncGame) {  
      MembersInjectors.noOp().injectMembers(troncGame);
    }
  
    @Override
    public GameInputProcessor createGameInputProcessor() {  
      return provideGameInputProcessorProvider.get();
    }
  
    @Override
    public GameLoadingScreen loadingScreen() {  
      return gameLoadingScreenProvider.get();
    }
  
    @Override
    public FightComponent createFightComponent(FightModule fightModule) {  
      return new FightComponentImpl(fightModule);
    }
  
    @Override
    public MainMenuComponent createMainMenuComponent(MainMenuModule mainMenuModule) {  
      return new MainMenuComponentImpl(mainMenuModule);
    }
  
    @Override
    public OverworldComponent createOverworldComponent(OverworldModule overworldModule) {  
      return new OverworldComponentImpl(overworldModule);
    }
  
    @Override
    public IntroductionComponent createIntroductionComponent() {  
      return new IntroductionComponentImpl();
    }
  
    private final class FightComponentImpl implements FightComponent {
      private final FightModule fightModule;
      private Provider<FightLoadingScreen> provideFightLoadingScreenProvider;
      private Provider<OrthographicCamera> provideOrthographicCameraProvider;
      private Provider<ScalingViewport> provideViewportProvider;
      private Provider<EnemyFightTeamGenerator> provideEnemyFightTeamGeneratorProvider;
      private Provider<FightPopUpMenuNotReady> provideFightPopUpMenuNotReadyProvider;
      private Provider<FightPopUpMenuIcon> provideFightPopUpMenuSpellIconProvider;
      private Provider<FightPopUpMenuIcon> provideFightPopUpMenuWeaponsIconProvider;
      private Provider<FightPopUpMenuLogic> provideFightPopUpMenuLogicProvider;
      private Provider<FightLogic> provideFightLogicProvider;
      private Provider<FightScreen> provideFightScreenProvider;
      private Provider<FightGame> provideFightGameProvider;
      private Provider<FightUI> provideFightUIProvider;
    
      private FightComponentImpl(FightModule fightModule) {  
        if (fightModule == null) {
          throw new NullPointerException();
        }
        this.fightModule = fightModule;
        initialize();
      }
    
      private void initialize() {  
        this.provideFightLoadingScreenProvider = ScopedProvider.create(FightModule_ProvideFightLoadingScreenFactory.create(fightModule, GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideAssetManagerProvider));
        this.provideOrthographicCameraProvider = ScopedProvider.create(FightModule_ProvideOrthographicCameraFactory.create(fightModule));
        this.provideViewportProvider = ScopedProvider.create(FightModule_ProvideViewportFactory.create(fightModule, provideOrthographicCameraProvider));
        this.provideEnemyFightTeamGeneratorProvider = ScopedProvider.create(FightModule_ProvideEnemyFightTeamGeneratorFactory.create(fightModule, GameComponentImpl.this.provideAssetManagerProvider, DaggerModelComponent.this.provideCharacterManagerProvider, GameComponentImpl.this.providePress2PStartSkinProvider));
        this.provideFightPopUpMenuNotReadyProvider = ScopedProvider.create(FightModule_ProvideFightPopUpMenuNotReadyFactory.create(fightModule, GameComponentImpl.this.provideI18NBundleProvider, GameComponentImpl.this.providePress2PStartSkinProvider));
        this.provideFightPopUpMenuSpellIconProvider = ScopedProvider.create(FightModule_ProvideFightPopUpMenuSpellIconFactory.create(fightModule, GameComponentImpl.this.provideAssetManagerProvider, GameComponentImpl.this.provideI18NBundleProvider, GameComponentImpl.this.provideFontManagerProvider));
        this.provideFightPopUpMenuWeaponsIconProvider = ScopedProvider.create(FightModule_ProvideFightPopUpMenuWeaponsIconFactory.create(fightModule, GameComponentImpl.this.provideAssetManagerProvider, GameComponentImpl.this.provideI18NBundleProvider, GameComponentImpl.this.provideFontManagerProvider));
        this.provideFightPopUpMenuLogicProvider = FightModule_ProvideFightPopUpMenuLogicFactory.create(fightModule, GameComponentImpl.this.provideAssetManagerProvider, provideFightPopUpMenuNotReadyProvider, provideFightPopUpMenuSpellIconProvider, provideFightPopUpMenuWeaponsIconProvider);
        this.provideFightLogicProvider = FightModule_ProvideFightLogicFactory.create(fightModule, GameComponentImpl.this.provideAssetManagerProvider, GameComponentImpl.this.provideI18NBundleProvider, GameComponentImpl.this.providePress2PStartSkinProvider, DaggerModelComponent.this.provideCharacterManagerProvider, provideEnemyFightTeamGeneratorProvider, provideFightPopUpMenuLogicProvider);
        this.provideFightScreenProvider = FightModule_ProvideFightScreenFactory.create(fightModule, GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideAssetManagerProvider, provideViewportProvider, provideFightLogicProvider);
        this.provideFightGameProvider = ScopedProvider.create(FightModule_ProvideFightGameFactory.create(fightModule, provideViewportProvider));
        this.provideFightUIProvider = ScopedProvider.create(FightModule_ProvideFightUIFactory.create(fightModule, provideViewportProvider));
      }
    
      @Override
      public FightLoadingScreen createFightLoadingScreen() {  
        return provideFightLoadingScreenProvider.get();
      }
    
      @Override
      public FightScreen createFightScreen() {  
        return provideFightScreenProvider.get();
      }
    
      @Override
      public FightGame createFightGame() {  
        return provideFightGameProvider.get();
      }
    
      @Override
      public FightUI createFightUI() {  
        return provideFightUIProvider.get();
      }
    }
  
    private final class MainMenuComponentImpl implements MainMenuComponent {
      private final MainMenuModule mainMenuModule;
      private Provider<MainMenuLoadingScreen> provideMainMenuLoadingScreenProvider;
      private Provider<OrthographicCamera> provideOrthographicCameraProvider;
      private Provider<ScalingViewport> provideViewportProvider;
      private Provider<MainMenuScreen> provideMainMenuScreenProvider;
      private Provider<MainMenu> provideMainMenuProvider;
      private Provider<MainMenuStart> provideMainMenuStartProvider;
      private Provider<MainMenuContinue> provideMainMenuContinueProvider;
      private Provider<MainMenuBackground> mainMenuBackgroundProvider;
    
      private MainMenuComponentImpl(MainMenuModule mainMenuModule) {  
        if (mainMenuModule == null) {
          throw new NullPointerException();
        }
        this.mainMenuModule = mainMenuModule;
        initialize();
      }
    
      private void initialize() {  
        this.provideMainMenuLoadingScreenProvider = ScopedProvider.create(MainMenuModule_ProvideMainMenuLoadingScreenFactory.create(mainMenuModule, GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideAssetManagerProvider));
        this.provideOrthographicCameraProvider = ScopedProvider.create(MainMenuModule_ProvideOrthographicCameraFactory.create(mainMenuModule));
        this.provideViewportProvider = ScopedProvider.create(MainMenuModule_ProvideViewportFactory.create(mainMenuModule, provideOrthographicCameraProvider));
        this.provideMainMenuScreenProvider = ScopedProvider.create(MainMenuModule_ProvideMainMenuScreenFactory.create(mainMenuModule, GameComponentImpl.this.provideTroncGameProvider, provideViewportProvider, GameComponentImpl.this.provideGameStatePersisterProvider));
        this.provideMainMenuProvider = ScopedProvider.create(MainMenuModule_ProvideMainMenuFactory.create(mainMenuModule, provideViewportProvider));
        this.provideMainMenuStartProvider = ScopedProvider.create(MainMenuModule_ProvideMainMenuStartFactory.create(mainMenuModule, GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideAssetManagerProvider, GameComponentImpl.this.provideI18NBundleProvider, GameComponentImpl.this.provideGameStatePersisterProvider, DaggerModelComponent.this.provideModelManagerProvider));
        this.provideMainMenuContinueProvider = ScopedProvider.create(MainMenuModule_ProvideMainMenuContinueFactory.create(mainMenuModule, GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideAssetManagerProvider, GameComponentImpl.this.provideI18NBundleProvider, GameComponentImpl.this.provideGameStatePersisterProvider));
        this.mainMenuBackgroundProvider = MainMenuBackground_Factory.create((MembersInjector) MembersInjectors.noOp(), GameComponentImpl.this.provideAssetManagerProvider);
      }
    
      @Override
      public MainMenuLoadingScreen createMainMenuLoadingScreen() {  
        return provideMainMenuLoadingScreenProvider.get();
      }
    
      @Override
      public MainMenuScreen createMainMenuScreen() {  
        return provideMainMenuScreenProvider.get();
      }
    
      @Override
      public MainMenu createMainMenu() {  
        return provideMainMenuProvider.get();
      }
    
      @Override
      public MainMenuStart createMainMenuStart() {  
        return provideMainMenuStartProvider.get();
      }
    
      @Override
      public MainMenuContinue createMainMenuContinue() {  
        return provideMainMenuContinueProvider.get();
      }
    
      @Override
      public MainMenuBackground createMainMenuBackground() {  
        return mainMenuBackgroundProvider.get();
      }
    }
  
    private final class OverworldComponentImpl implements OverworldComponent {
      private final OverworldModule overworldModule;
      private Provider<OverworldLoadingScreen> provideOverworldLoadingScreenProvider;
      private Provider<OrthographicCamera> provideGameOrthographicCameraProvider;
      private Provider<ScalingViewport> provideGameViewportProvider;
      private Provider<OverworldScreen> provideOverworldScreenProvider;
      private Provider<OverworldGameInputProcessor> overworldGameInputProcessorProvider;
      private Provider<OverworldUIInputProcessor> overworldUIInputProcessorProvider;
      private Provider<OrthographicCamera> provideUIOrthographicCameraProvider;
      private Provider<ScalingViewport> provideUIViewportProvider;
      private Provider<OverworldFPS> overworldFPSProvider;
      private Provider<OverworldUI> provideOverworldUIProvider;
      private Provider<OverworldMenuList> provideOverworldMenuListProvider;
      private Provider<OverworldMenu> provideOverworldMenuProvider;
    
      private OverworldComponentImpl(OverworldModule overworldModule) {  
        if (overworldModule == null) {
          throw new NullPointerException();
        }
        this.overworldModule = overworldModule;
        initialize();
      }
    
      private void initialize() {  
        this.provideOverworldLoadingScreenProvider = ScopedProvider.create(OverworldModule_ProvideOverworldLoadingScreenFactory.create(overworldModule, GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideAssetManagerProvider, DaggerModelComponent.this.provideModelManagerProvider));
        this.provideGameOrthographicCameraProvider = ScopedProvider.create(OverworldModule_ProvideGameOrthographicCameraFactory.create(overworldModule));
        this.provideGameViewportProvider = ScopedProvider.create(OverworldModule_ProvideGameViewportFactory.create(overworldModule, provideGameOrthographicCameraProvider));
        this.provideOverworldScreenProvider = ScopedProvider.create(OverworldModule_ProvideOverworldScreenFactory.create(overworldModule, GameComponentImpl.this.provideTroncGameProvider, DaggerModelComponent.this.provideCharacterManagerProvider, GameComponentImpl.this.provideAssetManagerProvider, provideGameViewportProvider, GameComponentImpl.this.provideGameStatePersisterProvider));
        this.overworldGameInputProcessorProvider = OverworldGameInputProcessor_Factory.create((MembersInjector) MembersInjectors.noOp(), provideOverworldScreenProvider, provideGameViewportProvider);
        this.overworldUIInputProcessorProvider = OverworldUIInputProcessor_Factory.create((MembersInjector) MembersInjectors.noOp(), provideOverworldScreenProvider);
        this.provideUIOrthographicCameraProvider = ScopedProvider.create(OverworldModule_ProvideUIOrthographicCameraFactory.create(overworldModule));
        this.provideUIViewportProvider = ScopedProvider.create(OverworldModule_ProvideUIViewportFactory.create(overworldModule, provideUIOrthographicCameraProvider));
        this.overworldFPSProvider = OverworldFPS_Factory.create((MembersInjector) MembersInjectors.noOp(), GameComponentImpl.this.provideI18NBundleProvider);
        this.provideOverworldUIProvider = ScopedProvider.create(OverworldModule_ProvideOverworldUIFactory.create(overworldModule, provideUIViewportProvider, GameComponentImpl.this.provideTroncGameProvider, overworldFPSProvider));
        this.provideOverworldMenuListProvider = ScopedProvider.create(OverworldModule_ProvideOverworldMenuListFactory.create(overworldModule, GameComponentImpl.this.provideAssetManagerProvider, GameComponentImpl.this.provideI18NBundleProvider, GameComponentImpl.this.providePress2PStartSkinProvider));
        this.provideOverworldMenuProvider = ScopedProvider.create(OverworldModule_ProvideOverworldMenuFactory.create(overworldModule, provideUIViewportProvider, provideOverworldScreenProvider, overworldFPSProvider, provideOverworldMenuListProvider));
      }
    
      @Override
      public OverworldLoadingScreen createOverworldLoadingScreen() {  
        return provideOverworldLoadingScreenProvider.get();
      }
    
      @Override
      public OverworldScreen createOverworldScreen() {  
        return provideOverworldScreenProvider.get();
      }
    
      @Override
      public OverworldGameInputProcessor createOverworldGameInputProcessor() {  
        return overworldGameInputProcessorProvider.get();
      }
    
      @Override
      public OverworldUIInputProcessor createOverworldUIInputProcessor() {  
        return overworldUIInputProcessorProvider.get();
      }
    
      @Override
      public OverworldUI createOverworldUI() {  
        return provideOverworldUIProvider.get();
      }
    
      @Override
      public OverworldMenu createOverworldMenu() {  
        return provideOverworldMenuProvider.get();
      }
    }
  
    private final class IntroductionComponentImpl implements IntroductionComponent {
      private final IntroductionModule introductionModule;
      private Provider<IntroductionLoadingScreen> provideIntroductionLoadingScreenProvider;
      private Provider<OrthographicCamera> provideOrthographicCameraProvider;
      private Provider<ScalingViewport> provideViewportProvider;
      private Provider<IntroductionScreen> provideIntroductionScreenProvider;
      private Provider<DialogManager> dialogManagerProvider;
      private Provider<IntroductionText> introductionTextProvider;
      private Provider<Introduction> introductionProvider;
    
      private IntroductionComponentImpl() {  
        this.introductionModule = new IntroductionModule();
        initialize();
      }
    
      private void initialize() {  
        this.provideIntroductionLoadingScreenProvider = ScopedProvider.create(IntroductionModule_ProvideIntroductionLoadingScreenFactory.create(introductionModule, GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideAssetManagerProvider, DaggerModelComponent.this.provideModelManagerProvider));
        this.provideOrthographicCameraProvider = ScopedProvider.create(IntroductionModule_ProvideOrthographicCameraFactory.create(introductionModule));
        this.provideViewportProvider = ScopedProvider.create(IntroductionModule_ProvideViewportFactory.create(introductionModule, provideOrthographicCameraProvider));
        this.provideIntroductionScreenProvider = ScopedProvider.create(IntroductionModule_ProvideIntroductionScreenFactory.create(introductionModule, GameComponentImpl.this.provideTroncGameProvider, provideViewportProvider));
        this.dialogManagerProvider = DialogManager_Factory.create((MembersInjector) MembersInjectors.noOp(), GameComponentImpl.this.provideAssetManagerProvider, GameComponentImpl.this.provideI18NBundleProvider, DaggerModelComponent.this.provideThemeManagerProvider);
        this.introductionTextProvider = IntroductionText_Factory.create((MembersInjector) MembersInjectors.noOp(), GameComponentImpl.this.provideTroncGameProvider, GameComponentImpl.this.provideI18NBundleProvider, dialogManagerProvider, GameComponentImpl.this.provideFontManagerProvider, DaggerModelComponent.this.provideCharacterManagerProvider, provideViewportProvider);
        this.introductionProvider = Introduction_Factory.create((MembersInjector) MembersInjectors.noOp(), provideViewportProvider);
      }
    
      @Override
      public IntroductionLoadingScreen introductionLoadingScreen() {  
        return provideIntroductionLoadingScreenProvider.get();
      }
    
      @Override
      public IntroductionScreen introductionScreen() {  
        return provideIntroductionScreenProvider.get();
      }
    
      @Override
      public IntroductionText introductionText() {  
        return introductionTextProvider.get();
      }
    
      @Override
      public Introduction introduction() {  
        return introductionProvider.get();
      }
    }
  }
}

