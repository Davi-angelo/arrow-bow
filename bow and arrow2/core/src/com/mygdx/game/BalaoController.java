package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class BalaoController {
    public ArrayList<Balao> balaos = new ArrayList<Balao>();
    public int size;


    public BalaoController(int numberBalaos, float height, AssetManager manager) {
        for (int i = 0; i <= numberBalaos; i++) {
            balaos.add(new Balao(i*100 + 100, 50*i, height, manager));
        }
        this.size = numberBalaos;
    }

    public void init(){

    }

    public int baloesAlives(){
        int count = 0;
        for (Balao balao : balaos) {
            if (balao.alive) {
                count++;
            }
        }

        return count;
    }

    public int verificaColisaoFlecha(Vector2 posicaoFlecha){
        int count = 0;
        for (int i = 0 ; i <= this.size ; i++){
            Balao balao = balaos.get(i);

            if(balao.alive && balao.verificaColisao(posicaoFlecha)) { 
                count++;
                System.out.println("Bateu"); 
            };
        }
        return count;
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
