package com.example.lian.daggertest;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Injectable is provided in Root.
 */
public class Root {
    public Root() {}

    @Component(modules = RootModule.class)
    public interface RootComponent {}

    @Module
    public static class RootModule {
        @Provides
        Injectable provideGeneric() {
            return new Injectable();
        }
    }
}
