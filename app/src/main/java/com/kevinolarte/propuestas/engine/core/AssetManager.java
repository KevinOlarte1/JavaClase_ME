package com.kevinolarte.propuestas.engine.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.kevinolarte.propuestas.engine.sound.Sound;

public abstract class AssetManager {
    private final Map<String, BufferedImage> assets;
    private final Map<String, Sound> sounds;

    public AssetManager(){
        this.assets = new  HashMap<>();
        this.sounds = new HashMap<>();
    }

    public void loadSprite(String name, String path) {
       try {
        BufferedImage bufferedImage = ImageIO.read(getClass().getResourceAsStream(path));
        assets.put(name, bufferedImage);
        System.out.println( "\u001B[31m");
    } catch (IOException e) {
        throw new RuntimeException("Error loading asset: " + name + " at path: " + path, e);
    }
    }

    public void loadSound(String name, String path) {
         String fullPath = getClass().getResource(path).getPath();
         Sound sound  = new Sound(fullPath);
         sounds.put(name, sound);     
     }

    public BufferedImage getSprite(String name){
        return assets.get(name);
    }

    /**
     * Cargar todas las imagenes en memoria al principio.
     */
    public abstract void start();
}
