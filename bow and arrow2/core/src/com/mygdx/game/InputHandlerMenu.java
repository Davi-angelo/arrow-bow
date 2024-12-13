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

    public boolean touchUp (int x, int y, int pointer, int button) {

        if(button == Input.Buttons.LEFT) {// 150-500 x 220-295
            if(x >= 150 && x <= 500){
                int yMundo = (int)menu.game.viewport.getWorldHeight() - y;
                if(yMundo >= 220 && yMundo <= 295){
                    menu.game.setScreen(new TelaPrincipal(menu.game));
                }
            }
        }

        System.out.println(x + "    " + (menu.game.viewport.getWorldHeight() - y));

        return false;
    }
    
}
