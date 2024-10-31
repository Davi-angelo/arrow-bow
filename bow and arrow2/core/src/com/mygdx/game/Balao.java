package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Balao {
    public boolean alive;
    public Texture tex;
    public float x, y;
    public int height, width;
    public float velocity;

    public Balao(int posX, int posY, Texture tex) {
        this.alive = false;
        this.x = posX;
        this.y = posY;
        this.tex = tex;
        this.velocity = 1.5f;
        this.height = 60;
        this.width = 40;
    }


    public void init(float posX, float posY){
        alive = true;
    }

    public void up(){

        this.y += this.velocity;
        if(this.y > Gdx.graphics.getHeight()){
            this.y = -this.height;
        }
    }

    public void foraDeTela(){

    }

    public void draw(SpriteBatch batch){
        batch.draw(this.tex, this.x, this.y, this.width, this.height);
    }


}
