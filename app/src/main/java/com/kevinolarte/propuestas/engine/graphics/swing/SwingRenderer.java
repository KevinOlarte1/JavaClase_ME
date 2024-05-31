package com.kevinolarte.propuestas.engine.graphics.swing;

import com.kevinolarte.propuestas.engine.core.Blackboard;
import com.kevinolarte.propuestas.engine.entities.Entity;
import com.kevinolarte.propuestas.engine.graphics.RenderAPI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class SwingRenderer extends JPanel implements RenderAPI{

    public SwingRenderer(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setDoubleBuffered(true);
        setFocusable(true);
    }
    @Override
    public void render() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawBackground(g2d);
        Entity entities[] = Blackboard.entityManager.getEntities();
        for (int i = 0; i < Blackboard.entityManager.getNumEntities(); i++) {
            drawEntity(g2d, entities[i]);
        }
    }

    public abstract void drawBackground(Graphics2D g);
    public abstract void drawEntity(Graphics2D g, Entity entity);
    
}
