package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

public class Flecha implements Pool.Poolable {
    public boolean alive;
    public Vector2 pos;
    public Texture tex;
    public int height, width;
    public float velocity;

    public Pixmap pixmap;
    public Texture bitmap;

    public Flecha(AssetManager manager){
        this.pos = new Vector2();
        this.height = 15;
        this.width = 45;
        this.velocity = 3.5f;
        this.alive = false;

        if (manager.isLoaded("flecha.png")) {
            this.tex = manager.get("flecha.png", Texture.class);
        }

        pixmap = new Pixmap(3, 3, Format.RGB888);

        bitmap = new Texture(pixmap);
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

    public Vector2 getHitboxFlecha(){
        Vector2 posicoes = new Vector2(pos.x + this.width, pos.y + this.height/2);
        return posicoes;
    }

    public void draw(SpriteBatch batch){
        if(this.alive){
            batch.draw(tex, pos.x, pos.y, this.width, this.height);
            batch.draw(bitmap, pos.x + this.width - 1, pos.y + height/2 );
        }
    }
}
