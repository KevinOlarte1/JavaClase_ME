package com.kevinolarte.propuestas.engine.core;

import javax.swing.JPanel;

import com.kevinolarte.propuestas.engine.graphics.RenderAPI;


public abstract class Game implements Runnable, Updatable{
    private double NANOS_BETWEEN_UPDATE = 1000000000;
    private double NANOS_BETWEEN_UPDATE_SIMULATION = 1000000000;

    
    private final int width;
    private final int height;
    private final float fpsLimit;
    private boolean finish;
   
    private int simulationRate;

    private RenderAPI renderAPI;

    

    public Game(int width, int height, int fpsLimit, int simulationRate, int maxEntities){
        JPanel asdas = new JPanel();
        asdas.setBounds(fpsLimit, simulationRate, width, height);
        this.fpsLimit = fpsLimit;
        this.NANOS_BETWEEN_UPDATE /=fpsLimit;
        this.height = height;
        this.width = width;
        this.simulationRate = simulationRate;
        this.NANOS_BETWEEN_UPDATE_SIMULATION /= simulationRate;
        
        this.finish = false;
        Blackboard.entityManager = creaEntityManager(maxEntities);
    }


    public abstract EntityManager creaEntityManager(int maxEntities);
    

    public void start(){
          
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(NANOS_BETWEEN_UPDATE);
        long lastFrame = System.nanoTime();
        long lastSimulation = System.nanoTime();
        
        long currentFrame = System.nanoTime();
        double deltaTime;
        
        while (!finish) {
            currentFrame = System.nanoTime(); 
            

            if (currentFrame - lastFrame > NANOS_BETWEEN_UPDATE) {
                render();
                lastFrame = currentFrame;
            }
            processInput();
            if (currentFrame - lastSimulation > NANOS_BETWEEN_UPDATE_SIMULATION) {
                deltaTime = (double)(currentFrame - lastFrame) / 1000000000;
                update(deltaTime);
                lastUpdate(deltaTime);
                postUpdate(deltaTime);
                lastSimulation = currentFrame;
            }
            
            
            
            
            
           
        }
    }

    private void render() {
      renderAPI.render();
    }

    @Override
    public void update(double deltaTime) {
        Blackboard.entityManager.update(deltaTime);
        System.out.println("BBB");
    }

    @Override
    public void lastUpdate(double deltaTime) {
        Blackboard.entityManager.lastUpdate(deltaTime);
    }

    @Override
    public void postUpdate(double deltaTime) {
        Blackboard.entityManager.postUpdate(deltaTime);
    }



    public void setRenderAPI(RenderAPI renderAPI) {
        this.renderAPI = renderAPI;
    }

    public void processInput() {
        Blackboard.entityManager.processInput();
    }
    
}