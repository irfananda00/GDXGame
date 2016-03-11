package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;
import com.mygdx.game.screen.GameOverScreen;
import com.mygdx.game.screen.ScreenManager;

public class GameObjectManager {

    private final Array<GameObject> gameObjectArray = new Array<GameObject>();
    private final Player player;

    public GameObjectManager(int amount){
        player = new Player(new Vector2(200,30), new Vector2(0,0));
        for (int i = 0 ; i < amount; i++){
            float x = MathUtils.random(0, MyGdxGame.WIDTH - TextureManager.ASTEROID.getWidth());
            float y = MathUtils.random(MyGdxGame.HEIGHT, MyGdxGame.HEIGHT * 3);
            float speed = MathUtils.random(3,8);
            addEntity(new Asteroid(new Vector2(x,y), new Vector2(0, -speed)));
        }
    }

    public void update(){
        for (GameObject g : gameObjectArray)
            g.update();
        player.update();
        checkCollisions();
    }

    public void render(SpriteBatch sb){
        for (GameObject g : gameObjectArray)
            g.render(sb);
        player.render(sb);
    }

    private void checkCollisions(){
        for (Asteroid a : getAsteroids()) {
            if (a.getCircle().overlaps(player.getLine())) {
                ScreenManager.setScreen(new GameOverScreen(true));
            }
        }
    }

    public void addEntity(GameObject gameObject){
        gameObjectArray.add(gameObject);
    }

    private Array<Asteroid> getAsteroids(){
        Array<Asteroid> ret = new Array<Asteroid>();
        for (GameObject g : gameObjectArray)
            if (g != null)
                ret.add((Asteroid) g);
        return ret;
    }

}
