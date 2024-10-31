package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public float x, y;
    public int height, width;
    public Texture tex;
    public int numFlechas;
    public int pontos;

    public Player(float posX, float posY, Texture tex){
        this.tex = tex;
        this.x = posX;
        this.y = posY;
        this.height = 100;
        this.width = 50;
    }

    public void movimento(float mov){
        this.y += mov;
    }

    public void update(FlechaController flechaController){


        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            movimento(4);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) { movimento(-4); }

        if(this.y >= Gdx.graphics.getHeight() - this.height){
            this.y = Gdx.graphics.getHeight() - this.height;
        }

        if(this.y <= 0) {
            this.y = 0;
        }


        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){

            for (int i = 0; i < flechaController.size; i++) {
                Flecha flecha = flechaController.flechas.get(i);

                if (!flecha.alive) {
                    flecha.alive = true;
                    flecha.pos.set(this.x, this.y);
                    break;
                }
            }





        }


    }

    public void draw(SpriteBatch batch, FlechaController flechaController){
        update(flechaController);
        batch.draw(this.tex, this.x, this.y, this.width, this.height);
    }


}
