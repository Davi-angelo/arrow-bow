package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class BalaoController {
    public ArrayList<Balao> balaos = new ArrayList<Balao>();
    public int size;


    public BalaoController(int numberBalaos, Texture balaoTexture) {
        for (int i = 0; i <= numberBalaos; i++) {
            balaos.add(new Balao(i*100 + 100, 50*i, balaoTexture));
        }

        this.size = numberBalaos;
    }

    public void init(){

    }


    public void update(){
        for (int i = 0 ; i <= this.size ; i++){
            Balao balao = balaos.get(i);

            balao.up();

        }
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i <= this.size; i++) {
            Balao balao = balaos.get(i);
            balao.draw(batch);
        }
    }
}
