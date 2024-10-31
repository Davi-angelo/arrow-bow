package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Balao {
    public Sprite sprite;
    public float speed 350;

    public Balao(Texture imgBalao, float x, float y) {

        sprite = new Sprite(imgBalao);
    }
}
