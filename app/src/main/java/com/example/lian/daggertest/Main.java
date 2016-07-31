package com.example.lian.daggertest;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class Main {
    public Main(ParentComponent parentComponent) {
        MenuComponent menuComponent = DaggerMain_MenuComponent.builder()
                .parentComponent(parentComponent)
                .build();

        MenuItemA menuItemA = new MenuItemA(menuComponent);
        MenuItemB menuItemB = new MenuItemB(menuComponent);
    }


    // THIS DOES NOT WORK
    // public interface ParentComponent extends MenuRegistry.ParentComponent {}

    // THIS WORKS
    public interface ParentComponent {
        NetworkClient<DataStore> client();
    }

    @Component(modules = MenuModule.class, dependencies = ParentComponent.class)
    public interface MenuComponent extends MenuRegistry.ParentComponent {}

    @Module
    public static class MenuModule {}
}
