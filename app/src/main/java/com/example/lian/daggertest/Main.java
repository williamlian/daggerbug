package com.example.lian.daggertest;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Main gets parent component as well as injectable provider from root.
 * Then creates main component and pass to menu manager for menu item injection.
 */
public class Main {
    public Main(ParentComponent parentComponent) {}

    /** ********************************************************************
     *
     * <Problematic Code>
     *
     ** ********************************************************************/

    // THIS DOES NOT COMPILE
    //public interface ParentComponent extends MenuManager.ParentComponent {}

    // THIS COMPILES
    public interface ParentComponent { Injectable client(); }

    /** ********************************************************************
     *
     * </Problematic Code>
     *
     ** ********************************************************************/

    @Component(modules = MainModule.class, dependencies = ParentComponent.class)
    public interface MainComponent extends MenuManager.ParentComponent {}

    @Module
    public static class MainModule {}
}
