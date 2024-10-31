package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class BalaoControler {
    public ArrayList<Balao> balaos = new ArrayList<Balao>();
    public int size;


    public BalaoControler(int numberBalaos, Texture balaoTexture) {
        for (int i = 0; i <= numberBalaos; i++) {
            balaos.add(new Balao(300, 50*i, balaoTexture));
        }

        this.size = numberBalaos;
    }

    public void init(){

    }


    public void update(){

    }

    public void render(SpriteBatch batch){
        for (int i = 0; i <= this.size; i++) {
            Balao balao = balaos.get(i);
            batch.draw(balao.tex, balao.x, balao.y, 40, 60);
        }
    }
}
