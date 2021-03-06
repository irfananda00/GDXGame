package com.mygdx.game.entity;


import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;

public class Asteroid extends GameObject {

    public Asteroid(Vector2 pos, Vector2 direction) {
        super(TextureManager.ASTEROID, pos, direction);
    }

    @Override
    public void update() {
        pos.add(direction);

        if (pos.y <= -TextureManager.ASTEROID.getHeight()){
            float x = MathUtils.random(0, MyGdxGame.WIDTH - TextureManager.ASTEROID.getWidth());
            pos.set(x,MyGdxGame.HEIGHT);
        }
    }
}
