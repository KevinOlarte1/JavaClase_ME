package com.kevinolarte.propuestas.game.core;

import com.kevinolarte.propuestas.engine.core.AssetManager;
import com.kevinolarte.propuestas.engine.core.EntityManager;

public class SnakeEntityManager extends EntityManager {

    public SnakeEntityManager(int cant) {
        super(cant);
        //TODO Auto-generated constructor stub
    }

    @Override
    public AssetManager createAssetManager() {
        return new SnakeAssetManager();
    }
    
}
