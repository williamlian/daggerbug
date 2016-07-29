package com.example.lian.daggertest;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class Menu {
    @Inject
    NetworkClient<DataStore> genericType;
    @Inject
    DataStore riderData;

    public Menu(ParentComponent parentComponent) {
        TestComponent testComponent = DaggerMainActivity_TestComponent.builder()
                .parentComponent(parentComponent)
                .build();
        testComponent.inject(this);


    }

    // chain up children injections up to root
    public interface ParentComponent extends MenuItemA.ChildComponentA, MenuItemB.ChildComponentB {}

    @Component(modules = TestModule.class, dependencies = ParentComponent.class)
    public interface TestComponent {
        void inject(Menu activity);
    }

    @Module
    public static class TestModule {
        @Provides
        DataStore provideType(NetworkClient<DataStore> generic) {
            return new DataStore();
        }

    }
}
