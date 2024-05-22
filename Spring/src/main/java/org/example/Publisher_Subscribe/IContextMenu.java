package org.example.Publisher_Subscribe;

import org.example.State.MenuState;

public interface IContextMenu extends Publisher{
    void setState(MenuState state);
    MenuState getState();
    void handle();
}
