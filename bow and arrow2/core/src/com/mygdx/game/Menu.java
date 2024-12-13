package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class Menu implements Screen{
    final MyGdxGame game;
    private ShapeRenderer shape;
    private BitmapFont font;
	private InputHandlerMenu inputHandler;

    public Menu(final MyGdxGame game) {
        this.game = game;

        this.shape = new ShapeRenderer(); 
        this.font = new BitmapFont(Gdx.files.internal("data/arial.fnt"), Gdx.files.internal("data/arial.png"), false);
        this.font.getData().setScale(1);

		this.inputHandler = new InputHandlerMenu(this);
		Gdx.input.setInputProcessor(this.inputHandler);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.5f, 0, 1);

        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin(); //Batch principal

        game.batch.end(); //Bach acaba

        shape.setProjectionMatrix(game.camera.combined);
        shape.begin(ShapeType.Filled);
        shape.setColor(Color.SKY);
        //shape.rect(player.x, player.y, player.width, player.height);

        shape.rect(150, 220, 350, 75); // 150-500 x 220-295

        shape.rect(0, 450, 750, 35);
        shape.end();

        game.batch.begin();
        font.setColor(0, 0, 0, 1f);
        font.draw(game.batch, "JOGAR", (game.viewport.getWorldWidth()/2) - 50, 265);
        game.batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
    }

    @Override
    public void dispose() {

    }
}
