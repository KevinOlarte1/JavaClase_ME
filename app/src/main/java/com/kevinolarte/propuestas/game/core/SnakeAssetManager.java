package com.kevinolarte.propuestas.game.core;

import com.kevinolarte.propuestas.engine.core.AssetManager;

public class SnakeAssetManager extends AssetManager{

    @Override
    public void start() {
        loadSprite("player", "Sprites");
        loadSound("shoot", "/sounds/sound.wav");
        
    }
    
}
