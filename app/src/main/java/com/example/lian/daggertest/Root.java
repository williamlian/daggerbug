package com.example.lian.daggertest;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class Root {
    public RootComponent rootComponent;

    public Root() {
        rootComponent = DaggerRoot_RootComponent.builder()
                .rootModule(new RootModule())
                .build();

        Menu menu = new Menu(rootComponent);
    }

    @Component(modules = RootModule.class)
    public interface RootComponent extends Menu.ParentComponent {}

    @Module
    public static class RootModule {
        @Provides
        DataStoreNetworkClient provideGeneric() {
            return new DataStoreNetworkClient();
        }
    }
}
