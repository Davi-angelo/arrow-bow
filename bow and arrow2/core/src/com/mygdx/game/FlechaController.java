package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

import java.util.ArrayList;

public class FlechaController {
    public ArrayList<Flecha> flechasAtivas;

    private final Pool<Flecha> flechaPool;

    public Texture tex;


    public FlechaController(Texture tex){
        this.tex = tex;

        flechasAtivas  = new ArrayList<Flecha>();

        flechaPool = new Pool<Flecha>() {
            @Override
            protected Flecha newObject() {
                return new Flecha(tex);
            }
        };

    }

    public void shoot(float x, float y){
        Flecha flecha = flechaPool.obtain();  //Usa uma flecha da pool quando o controller manda
        flecha.init(x, y);
        flechasAtivas.add(flecha);
    }

    public void update(){
        final int len = flechasAtivas.size();

        Flecha flecha;

        for(int i = len; --i >= 0;){ //joga flechas mortas pra pool e movimenta flechas vivas
            flecha = flechasAtivas.get(i);

            if(flecha.alive) {
                flecha.move();
            } else {
                flechasAtivas.remove(i);
                flechaPool.free(flecha);
            }
        }
    }

    public void render(SpriteBatch batch){
        final int len = flechasAtivas.size();
        Flecha flecha;

        for(int i = 0; i < len; i++) {
            flecha = flechasAtivas.get(i);

            if(flecha.alive) {
                flecha.draw(batch);
            }
        }

    }
}
