package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {
    public Player player;
    public MyGdxGame game;

    public InputHandler(Player player, final MyGdxGame game) {
        this.player = player;
        this.game = game;
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

        if (keycode == Input.Keys.R) {
            game.setScreen(new TelaPrincipal(game));
        }

        //System.out.println("keyDown: " + keycode);
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
