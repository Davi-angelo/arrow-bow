package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class TelaPrincipal implements Screen {

    final MyGdxGame game;
    private ShapeRenderer shape;

    public TelaPrincipal(final MyGdxGame game) {
        this.game = game;

    this.shape = new ShapeRenderer(); 
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.5f, 0, 1);

        

        game.batch.setProjectionMatrix(game.camera.combined);

        game.verificaColisao();


        game.batch.begin(); //Batch principal

        game.player.draw(game.batch);

        game.balaoController.update();
        game.balaoController.render(game.batch);

        game.batch.end(); //Bach acaba

        shape.setProjectionMatrix(game.camera.combined);
        shape.begin(ShapeType.Line);
        shape.setColor(Color.RED);
        shape.rect(game.player.x, game.player.y, game.player.width, game.player.height);

        shape.rect(50, 200, 500, 10);
        shape.end();

        
        if((game.player.y - game.camera.position.y - game.player.worldHeight/2) > 100 || 
            (game.player.y - game.camera.position.y - game.player.worldHeight/2) < -100){
            float lerp = 0.1f;
            Vector3 position = game.camera.position;

            position.y += (game.player.y - (position.y)) * lerp;

            game.camera.update();
        }

        System.out.println(game.camera.position + "  " + game.player.y);

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
