package com.example.lian.daggertest;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class MenuItemB {
    @Inject DataStore data;

    public MenuItemB(ParentComponent parentComponent) {
        MenuItemComponentB component = DaggerMenuItemB_MenuItemComponentB.builder()
                .parentComponent(parentComponent)
                .menuItemModule(new MenuItemModule())
                .build();
        component.inject(this);
    }

    public interface ParentComponent {
        NetworkClient<DataStore> genericTypeB();
    }

    @Component(modules = MenuItemModule.class, dependencies = ParentComponent.class)
    public interface MenuItemComponentB {
        void inject(MenuItemB menuItemB);
    }

    @Module
    static class MenuItemModule {
        @Provides
        DataStore provideType(NetworkClient<DataStore> client) {
            return new DataStore();
        }
    }
}
