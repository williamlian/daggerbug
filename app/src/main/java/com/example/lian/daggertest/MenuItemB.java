package com.example.lian.daggertest;

public class MenuItemB {
    public MenuItemB(ParentComponent parentComponent) {}

    public interface ParentComponent {
        Injectable injectable();
    }
}
