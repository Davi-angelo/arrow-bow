package com.mygdx.game;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture flechaTexture, balaoTexture, playerTexture;

	BalaoController balaoController;
	FlechaController flechaController;

	Player player;

	InputHandler inputHandler;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		flechaTexture = new Texture("flecha.png");
		balaoTexture = new Texture("balao.png");
		playerTexture = new Texture("player.png");

		balaoController = new BalaoController(5, balaoTexture);

		player = new Player(0, 0, playerTexture, flechaTexture);

		inputHandler = new InputHandler(player);
		Gdx.input.setInputProcessor(inputHandler);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0.5f, 0, 1);

		batch.begin();

		player.draw(batch);

		balaoController.update();
		balaoController.render(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		balaoTexture.dispose();
		flechaTexture.dispose();
		playerTexture.dispose();
	}
}
