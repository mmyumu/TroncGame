package fr.mmyumu.troncgame;

import com.badlogic.gdx.ApplicationListener;


public class DaggerAdapter implements ApplicationListener {

    private Class applicationListenerClass;
    private ApplicationListener delegateApplicationListener;
    private Object[] daggerModules;

    public DaggerAdapter(Class<? extends ApplicationListener> applicationListenerClass,
                         Object... daggerModules) {
        this.applicationListenerClass = applicationListenerClass;
    }

    @Override
    public void create() {
//        final ObjectGraph objectGraph = ObjectGraph.create(daggerModules);
//        final ApplicationListener applicationListener =
//                (ApplicationListener) objectGraph.get(applicationListenerClass);
//        delegateApplicationListener = applicationListener;
//        Dagger_TroncGameComponent.create().createTroncGame();
//        TroncGameComponent comp = Da

        TroncGame troncGame = new TroncGame();
        delegateApplicationListener = troncGame;
        delegateApplicationListener.create();
    }

    @Override
    public void resize(int width, int height) {
        delegateApplicationListener.resize(width, height);
    }

    @Override
    public void render() {
        delegateApplicationListener.render();
    }

    @Override
    public void pause() {
        delegateApplicationListener.pause();
    }

    @Override
    public void resume() {
        delegateApplicationListener.resume();
    }

    @Override
    public void dispose() {
        delegateApplicationListener.dispose();
    }
}