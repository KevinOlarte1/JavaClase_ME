package com.kevinolarte.propuestas.game;

import java.awt.Color;
import java.awt.Graphics2D;

import com.kevinolarte.propuestas.engine.core.Blackboard;
import com.kevinolarte.propuestas.engine.entities.Entity;
import com.kevinolarte.propuestas.engine.graphics.swing.SwingRenderer;

public class SnakeSwingRenderer extends SwingRenderer{

    public SnakeSwingRenderer(int width, int height) {
        super(width, height);
        
    }

    @Override
    public void drawBackground(Graphics2D g) {
        g.setColor(Settings.COLOR_BACKGROUND);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        for (int i = 0; i < Settings.ROWS; i++) {
            for (int j = 0; j < Settings.COLS; j++) {
                
                g.drawRect(j * Blackboard.cellSize, i * Blackboard.cellSize, Blackboard.cellSize, Blackboard.cellSize);
            }
        }
    }

    @Override
    public void drawEntity(Graphics2D g, Entity entity) {
        System.out.println("asdasd");
        g.setColor(Color.orange);
        g.fillRect((int) entity.getX(),(int) entity.getY(), (int) entity.getWidth(), (int) entity.getHeight());
    }
     
}
