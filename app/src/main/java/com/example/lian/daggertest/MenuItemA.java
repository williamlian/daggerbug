package com.example.lian.daggertest;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class MenuItemA {
    @Inject DataStore data;

    public MenuItemA(ParentComponent parentComponent) {
        MenuItemComponentA component = DaggerMenuItemA_MenuItemComponentA.builder()
                .parentComponent(parentComponent)
                .menuItemModule(new MenuItemModule())
                .build();
        component.inject(this);
    }

    public interface ParentComponent {
        NetworkClient<DataStore> genericTypeA();
    }

    @Component(modules = MenuItemModule.class, dependencies = ParentComponent.class)
    public interface MenuItemComponentA {
        void inject(MenuItemA menuItemA);
    }

    @Module
    static class MenuItemModule {
        @Provides
        DataStore provideType(NetworkClient<DataStore> client) {
            return new DataStore();
        }
    }
}
