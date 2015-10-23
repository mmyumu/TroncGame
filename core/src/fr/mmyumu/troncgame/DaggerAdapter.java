package fr.mmyumu.troncgame;

import com.badlogic.gdx.ApplicationListener;

import dagger.ObjectGraph;

public class DaggerAdapter implements ApplicationListener {

    private Class applicationListenerClass;
    private ApplicationListener delegateApplicationListener;
    private Object[] daggerModules;

    public DaggerAdapter(Class<? extends ApplicationListener> applicationListener,
                         Object... daggerModules) {
        this.setApplicationListenerClass(applicationListener);
        this.setDaggerModules(daggerModules);
    }

    @Override
    public void create() {
        final ObjectGraph objectGraph = ObjectGraph.create(this.getDaggerModules());
        final ApplicationListener applicationListener =
                (ApplicationListener) objectGraph.get(this.getInjectableGameClass());
        this.setDelegateApplicationListener(applicationListener);
        this.getDelegateApplicationListener().create();
    }

    @Override
    public void resize(int width, int height) {
        this.getDelegateApplicationListener().resize(width, height);
    }

    @Override
    public void render() {
        this.getDelegateApplicationListener().render();
    }

    @Override
    public void pause() {
        this.getDelegateApplicationListener().pause();
    }

    @Override
    public void resume() {
        this.getDelegateApplicationListener().resume();
    }

    @Override
    public void dispose() {
        this.getDelegateApplicationListener().dispose();
    }

    public Class getInjectableGameClass() {
        return applicationListenerClass;
    }

    private void setApplicationListenerClass(Class injectableGameClass) {
        this.applicationListenerClass = injectableGameClass;
    }

    private Object[] getDaggerModules() {
        return this.daggerModules;
    }

    private void setDaggerModules(Object[] daggerModules) {
        this.daggerModules = daggerModules;
    }

    private ApplicationListener getDelegateApplicationListener() {
        return delegateApplicationListener;
    }

    private void setDelegateApplicationListener(ApplicationListener applicationListener) {
        this.delegateApplicationListener = applicationListener;
    }
}