Dagger Component Dependency Problem
===================================

TL;DR
-----
If the component and the denpendent interface both implement the same interface, 
which in turn inherits from multiple sub interfaces containing same method signatures,
then dagger could not generate code and throw compilation error.

Dependency Setting
------------------


Problem Detail
--------------
In class Main, in order to provide correct component to MenuManager, the MainComponent has extended the MenuManger.ParentCompoent.
Logically, to ensure component is passed from upper owner (Root here), we will want to make Main.ParentComponent to extend
MenuManager.ParentComponent as well.

However this will cause dagger compilation error:

    error: [com.example.lian.daggertest.MenuItemA.ParentComponent.injectable()] com.example.lian.daggertest.Injectable is bound multiple times:
    com.example.lian.daggertest.Injectable com.example.lian.daggertest.MenuItemB.ParentComponent.injectable()
    com.example.lian.daggertest.Injectable com.example.lian.daggertest.MenuItemA.ParentComponent.injectable()
  
If I extract all the dependency signature out and declared in the Main.ParentComponent without extending anything, the build will pass.

Also tried some other tests:
- If I make MenuManager.ParentComponent not extending anything, but declare Injectable alone, build will pass as well.
- If I make MenuManager.ParentComponent only extend one MenuItem, build will pass.
- If I make the Injectable provider at Main instead of Root, both way Dagger cannot build.

