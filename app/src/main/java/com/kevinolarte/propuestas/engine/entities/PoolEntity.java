package com.kevinolarte.propuestas.engine.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class PoolEntity {
    private final Entity[] poolObjects;
    private final Entity entity;
    private final int maxEntities;
    private int cantEntities;
    private static final HashMap<String, Stack<Entity>> pool = new HashMap<>();
    

    public PoolEntity(int maxEntities) {
        this.poolObjects = new Entity[maxEntities];
        this.entity = null;
        this.maxEntities = maxEntities;
        this.cantEntities =  0;
        
        
    }

    public void start(Entity entity){
        for (int i = 0; i < maxEntities; i++) {
            poolObjects[cantEntities++] = entity;
        }
    }

    public boolean addEntity(Entity entity) {
        if (cantEntities == maxEntities) 
            return false;

        poolObjects[cantEntities++] = entity;
        return true;
    }


    public Entity getEntity() {
        if (cantEntities == 0) 
            return null;

        Entity entity = poolObjects[cantEntities - 1];
        poolObjects[--cantEntities] = null;
        cantEntities--;
        return entity; 
    }
}
