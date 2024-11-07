package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class FlechaController {
    public ArrayList<Flecha> flechas = new ArrayList<Flecha>();
    public int size;

    public FlechaController(int numberFlechas, Texture tex){
        for(int i = 0; i < numberFlechas; i++) {
            Vector2 pos = new Vector2(0, 100*i + 100);
            flechas.add(new Flecha(pos, tex));
        }
        this.size = numberFlechas;
    }

    public void update(){
        for(int i = 0; i < this.size; i++){
            Flecha flecha = flechas.get(i);
            if(flecha.alive){
                flecha.move();
            }
        }
    }

    public void render(SpriteBatch batch){
        for(int i = 0; i < this.size; i++){
            Flecha flecha = flechas.get(i);
            flecha.draw(batch);
        }
    }
}
