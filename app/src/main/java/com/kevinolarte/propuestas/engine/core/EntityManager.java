package com.kevinolarte.propuestas.engine.core;

import com.kevinolarte.propuestas.engine.entities.Entity;
import com.kevinolarte.propuestas.engine.entities.PlayerEntity;

import java.util.List;
import java.util.ArrayList;

public abstract class EntityManager implements Updatable {
    private Entity[] entities;
    private final List<PlayerEntity> playerEntities;
    private int numEntities;
    private final AssetManager assetManager;
    
    public EntityManager(int cant) {
        this.entities = new Entity[cant];
        this.playerEntities = new ArrayList<>();
        this.numEntities = 0;
        this.assetManager = createAssetManager();
    }

    public abstract AssetManager createAssetManager();

    public boolean addEntity(Entity entity){
        if (numEntities == entities.length) 
            return false;
        
        entities[numEntities++] = entity;
        if (entity instanceof PlayerEntity) {
            playerEntities.add((PlayerEntity)entity);
        }
        return true;
    }

    public Entity removeEntity(Entity entity){
        //POOL

        for(int i = 0; i < numEntities; i++){
            if(entities[i].equals(entity)){
                Entity aux = entities[i];
                entities[i] = entities[this.numEntities-1];
                entities[--this.numEntities] = aux;
                return entity;
            }
        }
        return null;
    }

    public Entity[] getEntities() {
        return entities;
    }

    @Override
    public void lastUpdate(double deltaTime) {
        for(int i = 0; i < numEntities; i++){
            entities[i].lastUpdate(deltaTime);
        }
        
    }

    @Override
    public void postUpdate(double deltaTime) {
        for(int i = 0; i < numEntities; i++){
            entities[i].postUpdate(deltaTime);
        }
        
    }

    @Override
    public void update(double deltaTime) {
        for(int i = 0; i < numEntities; i++){
            entities[i].update(deltaTime);
        }
        
    }

    public void processInput(){
        for (PlayerEntity playerEntity : playerEntities) {
            playerEntity.processInput();
        }
    }
    
    public int getNumEntities() {
        return numEntities;
    }

    
    

    
}
