package com.example.lian.daggertest;

public class MenuItemA {
    public MenuItemA(ParentComponent parentComponent) {}

    public interface ParentComponent {
        Injectable injectable();
    }
}
