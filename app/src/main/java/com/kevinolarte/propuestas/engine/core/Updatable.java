package com.kevinolarte.propuestas.engine.core;

public interface Updatable {

    void update(double deltaTime);
    void lastUpdate(double deltaTime);
    void postUpdate(double deltaTime);
    
}