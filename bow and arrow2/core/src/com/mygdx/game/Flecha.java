package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

public class Flecha implements Pool.Poolable {
    public boolean alive;
    public Vector2 pos;
    public Texture tex;
    public int height, width;
    public float velocity;

    public Flecha(AssetManager manager){
        this.pos = new Vector2();
        this.height = 15;
        this.width = 45;
        this.velocity = 3.5f;
        this.alive = false;

        if (manager.isLoaded("flecha.png")) {
            this.tex = manager.get("flecha.png", Texture.class);
        }
    }

    public void init(float posX, float posY){
        pos.set(posX, posY);
        alive = true;
    }

    @Override
    public void reset() {
        pos.set(0, 0);
        alive = false;
    }

    public void move(){
        this.pos.x += this.velocity;

        if(this.pos.x > Gdx.graphics.getWidth()){
            this.alive = false;
        }
    }

    public void draw(SpriteBatch batch){
        if(this.alive){
            batch.draw(tex, pos.x, pos.y, this.width, this.height);
        }
    }
}
