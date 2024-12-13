package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MyGdxGame extends Game {
	SpriteBatch batch;

	AssetManager manager = new AssetManager();

	TelaPrincipal telaPrincipal;

	public FitViewport viewport;
	public OrthographicCamera camera;
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		int tam = 30;		
		camera = new OrthographicCamera(tam, tam * (h / w));

		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		camera.update();

		viewport = new FitViewport(w, h, camera);

		batch = new SpriteBatch();

		manager.load("flecha.png", Texture.class);
		manager.load("balao.png", Texture.class);
		manager.load("player.png", Texture.class);

		manager.finishLoading();

		setScreen(new Menu(this));
	}

	@Override
	public void render () {
		super.render();

		Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + "");
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		manager.clear();
	}
}
