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

        Main main = new Main(rootComponent);
    }

    @Component(modules = RootModule.class)
    public interface RootComponent extends Main.ParentComponent {

    }

    @Module
    public static class RootModule {
        @Provides
        NetworkClient<DataStore> provideGeneric() {
            return new NetworkClient<DataStore>();
        }
    }
}
