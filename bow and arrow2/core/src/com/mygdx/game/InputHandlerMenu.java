package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputHandlerMenu extends InputAdapter {

    public Menu menu;

    public InputHandlerMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.SPACE) {
            menu.game.setScreen(new TelaPrincipal(menu.game));
        }

        //System.out.println("keyDown: " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        return false;
    }
    
}
