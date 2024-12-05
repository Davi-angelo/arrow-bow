package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class BalaoController {
    public ArrayList<Balao> balaos = new ArrayList<Balao>();
    public int size;


    public BalaoController(int numberBalaos, AssetManager manager) {
        for (int i = 0; i <= numberBalaos; i++) {
            balaos.add(new Balao(i*100 + 100, 50*i, manager));
        }
        this.size = numberBalaos;
    }

    public void init(){

    }

    public void verificaColisaoFlecha(Vector2 posicaoFlecha){
        for (int i = 0 ; i <= this.size ; i++){
            Balao balao = balaos.get(i);

            if(balao.alive && balao.verificaColisao(posicaoFlecha)) { System.out.println("Bateu"); };
        }
    }

    public void update(){
        for (int i = 0 ; i <= this.size ; i++){
            Balao balao = balaos.get(i);

            if (balao.alive) {
                balao.up();
            }
        }
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i <= this.size; i++) {
            Balao balao = balaos.get(i);

            if (balao.alive) {
                balao.draw(batch);
            }
        }
    }
}
