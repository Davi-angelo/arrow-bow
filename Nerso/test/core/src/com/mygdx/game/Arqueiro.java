package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Arqueiro {
    public Vector2 position;
    public Vector2 positionFlecha;
    public Sprite sprite;
    public Sprite spriteFlecha;
    public float speed = 300;
    public float speedFlecha = 750;

    public Arqueiro(Texture img,Texture imgFlecha)
    {
        sprite = new Sprite(img);

        spriteFlecha = new Sprite(imgFlecha);
        position = new Vector2(sprite.getScaleX()*sprite.getWidth()/100 , Gdx.graphics.getHeight()/4);
        positionFlecha = new Vector2(10000,0);
    }
    public void update(float deltatime){
        if(Gdx.input.isButtonJustPressed(0) && positionFlecha.x >= Gdx.graphics.getWidth()){
            positionFlecha.y = position.y + spriteFlecha.getHeight()*2;
            positionFlecha.x = 0;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)) position.y -= deltatime*speed;
        if(Gdx.input.isKeyPressed(Input.Keys.W)) position.y += deltatime*speed;

        if(position.y <= 0) position.y = 0;
        if(position.y + sprite.getHeight()* sprite.getScaleY()/4 >= Gdx.graphics.getHeight()) position.y = Gdx.graphics.getHeight()-sprite.getHeight()* sprite.getScaleY()/4;

        positionFlecha.x+=deltatime*speedFlecha;
    }
    public void draw(SpriteBatch batch){
        update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
        spriteFlecha.setPosition(positionFlecha.x, positionFlecha.y);
        spriteFlecha.draw(batch);
    }
}
