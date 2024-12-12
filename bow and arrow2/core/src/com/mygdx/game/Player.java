package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    public float x, y;
    public int height, width;
    public float worldHeight;
    public Texture tex;
    public float mov = 0;
    public float speed;
    public int numFlechas;
    public int maxFlechas;
    public int pontos;
    public FlechaController flechaController;

    private int delayToShoot = 0;

    Flecha flecha;

    public Player(float posX, float posY, float height, AssetManager manager){
        this.x = posX;
        this.y = posY;
        this.height = 110;
        this.width = 72;
        this.worldHeight = height;
        this.speed = 5;
        this.numFlechas = 0;
        this.maxFlechas = 12;
        this.pontos = 0;

        if (manager.isLoaded("player.png")) {
            this.tex = manager.get("player.png", Texture.class);
        }

        this.flechaController = new FlechaController(manager);
    }

    public void movimento(){
        this.y += mov;

        if(this.y >= worldHeight - this.height){
            this.y = worldHeight - this.height;
        }
        if(this.y <= 0) {
            this.y = 0;
        }
    }

    public void update(){
        this.movimento();

        if(delayToShoot > 0){ delayToShoot--; }

    }

    public void shootArrow(){
        if(numFlechas <= maxFlechas && delayToShoot == 0){
            flechaController.shoot(this.x, this.y + height/2 + 10);
            numFlechas++;

            delayToShoot = 50;
        }

    }

    public void draw(SpriteBatch batch){
        batch.draw(this.tex, this.x, this.y, this.width, this.height);

        update();

        this.flechaController.update();
        this.flechaController.render(batch);
    }
}
