package com.example.lian.daggertest;

public class MenuRegistry {

    public MenuRegistry(ParentComponent parentComponent) {
        //MenuItemA menuItemA = new MenuItemA(parentComponent);
        //MenuItemB menuItemB = new MenuItemB(parentComponent);
    }

    public interface ParentComponent extends MenuItemA.ParentComponent, MenuItemB.ParentComponent {}
}
