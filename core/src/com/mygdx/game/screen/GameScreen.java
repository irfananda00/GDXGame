package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.camera.OrthoCamera;
import com.mygdx.game.entity.GameObjectManager;

public class GameScreen extends Screen{

    private OrthoCamera camera;
    private GameObjectManager gameObjectManager;
//    private Sprite GmScreen;

    @Override
    public void create() {
        camera = new OrthoCamera();
        gameObjectManager = new GameObjectManager(5);
    }

    @Override
    public void update() {
//        GmScreen = new Sprite(TextureManager.BACKGROUND);
        gameObjectManager.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
//        sb.draw(GmScreen,0, 0);
        gameObjectManager.render(sb);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}
