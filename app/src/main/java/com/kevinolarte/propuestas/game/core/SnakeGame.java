package com.kevinolarte.propuestas.game.core;

import com.kevinolarte.propuestas.engine.core.Blackboard;
import com.kevinolarte.propuestas.engine.core.EntityManager;
import com.kevinolarte.propuestas.engine.core.Game;
import com.kevinolarte.propuestas.game.Settings;

public class SnakeGame extends Game{

    private final int rows;
    private final int cols;
    private final SnakeEntityManager snakeEntityManager;
    public SnakeGame(int width, int height, int fpsLimit, int simulationRate, int maxEntities, int rows, int cols) {
        super(width, height, fpsLimit, simulationRate, maxEntities);
        this.rows = rows;
        this.cols = cols;
        this.snakeEntityManager =(SnakeEntityManager) Blackboard.entityManager;

    }

    
    @Override
    public EntityManager creaEntityManager(int maxEntities) {
        return new SnakeEntityManager(maxEntities);
    }
    
}
