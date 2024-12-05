package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;

	AssetManager manager = new AssetManager();

	BalaoController balaoController;

	Player player;

	InputHandler inputHandler;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		manager.load("flecha.png", Texture.class);
		manager.load("balao.png", Texture.class);
		manager.load("player.png", Texture.class);

		manager.finishLoading();

		balaoController = new BalaoController(5, manager);

		player = new Player(0, 0, manager);

		inputHandler = new InputHandler(player);
		Gdx.input.setInputProcessor(inputHandler);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0.5f, 0, 1);

		verificaColisao();

		batch.begin();

		player.draw(batch);

		balaoController.update();
		balaoController.render(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		manager.clear();
	}

	public void verificaColisao(){
		ArrayList<Vector2> array = player.flechaController.getHitboxFlechas();
		final int len = array.size();

		for(int i = 0; i < len; i++){
			Vector2 posicoes = array.get(i);

			balaoController.verificaColisaoFlecha(posicoes);
		}
	}
}
