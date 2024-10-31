package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Flecha {
    public boolean alive;
    public Vector2 pos;
    public Texture tex;
    public int height, width;
    public float velocity;

    public Flecha(Vector2 pos, Texture tex){
        this.pos = pos;
        this.tex = tex;

        this.height = 30;
        this.width = 90;

        this.velocity = 3.5f;

        this.alive = false;
    }

    public void move(){
        this.pos.x += this.velocity;
        if(this.pos.x > Gdx.graphics.getWidth()){
            this.pos.x = 0;
            this.alive = false;
        }
    }

    public void draw(SpriteBatch batch){
        if(this.alive){
            batch.draw(tex, pos.x, pos.y, this.width, this.height);
        }
    }
}
