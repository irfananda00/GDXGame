package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

    public static Texture BACKGROUND = new Texture(Gdx.files.internal("Background.png"));
    public static Texture PLAYER = new Texture(Gdx.files.internal("Player.png"));
    public static Texture ASTEROID = new Texture(Gdx.files.internal("Asteroids.png"));
    public static Texture GAME_OVER = new Texture(Gdx.files.internal("GameOver.png"));

}
