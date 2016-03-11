package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {

    protected Texture texture;
    protected Vector2 pos, direction;

    public GameObject(Texture texture, Vector2 pos, Vector2 direction){
        this.texture = texture;
        this.pos = pos;
        this.direction = direction;
    }

    public abstract void update();

    public void render(SpriteBatch sb){
        sb.draw(texture,pos.x,pos.y);
    }

    public Vector2 getPosition(){
        return pos;
    }

    public Rectangle getCircle(){
        return new Rectangle(pos.x + Math.round(0.2 * texture.getWidth()) ,
                pos.y + Math.round(0.2 * texture.getHeight()) ,
                Math.round(0.8 * texture.getWidth()),
                Math.round(0.8 * texture.getHeight()));
    }

    public Rectangle getLine(){
        return new Rectangle(pos.x + texture.getWidth()/2,
                pos.y + texture.getHeight()/2,
                texture.getWidth()/2,
                texture.getHeight()/2);
    }

    //set the object speed
    public void setDirection(float x, float y){
        direction.set(x,y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }

    public void setPosition(float x, float y) {
        this.pos.x = x;
        this.pos.y = y;
    }
}
