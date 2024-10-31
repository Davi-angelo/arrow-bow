package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Balao {
    public boolean alive;
    public Texture tex;
    public float x, y;

    public Balao(int posX, int posY, Texture tex) {
        this.alive = false;
        this.x = posX;
        this.y = posY;
        this.tex = tex;
    }


    public void init(float posX, float posY){
        alive = true;
    }

    public void foraDeTela(){

    }


}
