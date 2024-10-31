package com.mygdx.game;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, balaoTexture;

	BalaoControler balaoControler;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("player.png");
		balaoTexture = new Texture("balao.png");
		balaoControler = new BalaoControler(5, balaoTexture);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0.5f, 0, 1);
		batch.begin();
		batch.draw(img, 400, 100);
		balaoControler.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
