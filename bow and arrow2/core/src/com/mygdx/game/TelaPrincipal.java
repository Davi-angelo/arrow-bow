package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class TelaPrincipal implements Screen {

    final MyGdxGame game;

    public TelaPrincipal(final MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.5f, 0, 1);

        game.verificaColisao();

        game.batch.begin();

        game.player.draw(game.batch);

        game.balaoController.update();
        game.balaoController.render(game.batch);


        game.batch.end();

        if(game.balaoController.baloesAlives() == 4){
            game.setScreen(new TelaPrincipal(game));
            //dispose();
        }

        System.out.println(game.balaoController.baloesAlives());
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
        //game.viewport.update(width, height, true);
    }

    @Override
    public void dispose() {

    }
}
