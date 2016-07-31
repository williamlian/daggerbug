package com.example.lian.daggertest;

/**
 * Menu manager owns all menu items and will inject to each one when creating them.
 */
public class MenuManager {

    public MenuManager(ParentComponent parentComponent) {}

    public interface ParentComponent extends MenuItemA.ParentComponent, MenuItemB.ParentComponent {}
}
