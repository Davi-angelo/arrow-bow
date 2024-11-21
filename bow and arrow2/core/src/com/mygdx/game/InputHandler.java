package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {
    public Player player;

    public InputHandler(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.W) {
            player.mov += player.speed;
        }

        if (keycode == Input.Keys.S) {
            player.mov -= player.speed;
        }

        if (keycode == Input.Keys.SPACE) {
            player.shootArrow();
        }


        System.out.println("keyDown: " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if(keycode == Input.Keys.W) {
            player.mov -= player.speed;
        }

        if(keycode == Input.Keys.S) {
            player.mov += player.speed;
        }

        return false;
    }

}
