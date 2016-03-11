package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;

public class Player extends GameObject implements GestureDetector.GestureListener{

    private boolean isPanning;
    private float dX;
    private Vector2 direction;

    public Player(Vector2 pos, Vector2 direction) {
        super(TextureManager.PLAYER, pos, direction);
        this.direction = direction;
        Gdx.input.setInputProcessor(new GestureDetector(this));
    }

    @Override
    public void update() {
        pos.add(direction);

        //when the screen panned
        if (isPanning){
            setDirection((direction.x + dX)*5,0);
            System.out.println("NOW DIRECTION = "+direction.x);
            System.out.println("NOW POS = "+pos.x);
        }

        //when reach the edge
        if (pos.x < 0)
            setPosition(0, 30);
        if ( pos.x > MyGdxGame.WIDTH - TextureManager.PLAYER.getWidth())
            setPosition(MyGdxGame.WIDTH - TextureManager.PLAYER.getWidth(), 30);
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        //deltaX equal to how much the user pan the screen in x vector
        this.dX = deltaX;
        isPanning = true;
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        isPanning = false;
        return true;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
