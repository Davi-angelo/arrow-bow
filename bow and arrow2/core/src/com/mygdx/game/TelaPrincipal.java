package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class TelaPrincipal implements Screen {

    final MyGdxGame game;
    private ShapeRenderer shape;
    private BitmapFont font;
	private BalaoController balaoController;
	private Player player;
	private InputHandler inputHandler;

    public TelaPrincipal(final MyGdxGame game) {
        this.game = game;

        float worldHeight = game.viewport.getWorldHeight();
        float worldWidth = game.viewport.getWorldWidth();

        this.shape = new ShapeRenderer();
        this.font = new BitmapFont();
        this.font.getData().setScale(1);

        this.balaoController = new BalaoController(5, worldHeight, game.manager);

		this.player = new Player(0, 0, worldHeight, worldWidth, game.manager);

		this.inputHandler = new InputHandler(this.player, game);
		Gdx.input.setInputProcessor(this.inputHandler);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.5f, 0, 1);

        game.batch.setProjectionMatrix(game.camera.combined);

        verificaColisao();

        game.batch.begin(); //Batch principal

        player.draw(game.batch);

        balaoController.update();
        balaoController.render(game.batch);

        game.batch.end(); //Bach acaba

        shape.setProjectionMatrix(game.camera.combined);
        shape.begin(ShapeType.Filled);
        shape.setColor(Color.SKY);
        //shape.rect(player.x, player.y, player.width, player.height);

        shape.rect(0, 450, 750, 35);
        shape.end();

        game.batch.begin();
        font.setColor(0, 0, 0, 1f);
        font.draw(game.batch, "Pontos: " + player.pontos + "        Flechas restantes: " + player.numFlechas, 25, 470);
        game.batch.end();

        if(verificaGameOver()){
            game.setScreen(new TelaPrincipal(game));
        }
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

    public void verificaColisao(){
		ArrayList<Vector2> array = player.flechaController.getHitboxFlechas();
		int baloesEstourados = 0;

        for (Vector2 posicoes : array) {
            baloesEstourados += balaoController.verificaColisaoFlecha(posicoes);
        }
		player.pontos += baloesEstourados;
	}

    public boolean verificaGameOver(){
        if(player.numFlechas == 0){
            if(!player.flechaController.existeFlechaAlive()){
                return true;
            }
        }
        return false;
    }

}
