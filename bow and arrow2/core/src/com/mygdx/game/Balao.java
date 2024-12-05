package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Balao {
    public boolean alive;
    public Texture tex;
    public float x, y;
    public int height, width;
    public float velocity;

    public Balao(int posX, int posY, AssetManager manager) {
        this.alive = true;
        this.x = posX;
        this.y = posY;
        this.velocity = 1.5f;
        this.height = 60;
        this.width = 40;

        if (manager.isLoaded("balao.png")) {
            this.tex = manager.get("balao.png", Texture.class);
        }
    }

    public void init(float posX, float posY){
        alive = true;
    }

    public boolean verificaColisao(Vector2 posicao){
        if (posicao.x > this.x && posicao.x < this.x + width &&
            posicao.y > this.y + height/2 && posicao.y < this.y + height) {
            
            this.alive = false;
            return true;
        }
        

        return false;
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
