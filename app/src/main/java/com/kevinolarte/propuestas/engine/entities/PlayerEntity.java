package com.kevinolarte.propuestas.engine.entities;

import java.awt.image.BufferedImage;

import com.kevinolarte.propuestas.engine.input.KeyboardManager;

public abstract class PlayerEntity  extends Entity{

    private final KeyboardManager keyBoardManager;

    public PlayerEntity(float positionX, float positionY, float width, float height, float colliderOffset,
            int colliderMask, BufferedImage sprite, float hp, float damage, KeyboardManager keyboardManager) {
        super(positionX, positionY, width, height, colliderOffset, colliderMask, sprite, hp, damage);
        this.keyBoardManager = keyboardManager;
        
    }

    
    public PlayerEntity(float positionX, float positionY, float width, float height, float colliderOffsetX,
            float colliderOffsetY, int colliderMask, BufferedImage sprite, float hp, float damage, KeyboardManager keyboardManager) {
        super(positionX, positionY, width, height, colliderOffsetX, colliderOffsetY, colliderMask, sprite, hp, damage);
        this.keyBoardManager = keyboardManager;
        
    }

    


    public PlayerEntity(float positionX, float positionY, float width, float height, BufferedImage sprite, float hp,
            float damage, KeyboardManager keyboardManager) {
        super(positionX, positionY, width, height, sprite, hp, damage);
        this.keyBoardManager = keyboardManager;
        
    }
    

    public PlayerEntity(float positionX, float positionY, float width, float height, float colliderXRight,
            float ColliderXLefit, float ColliderYUp, float ColliderYDown, int colliderMask, BufferedImage sprite,
            float hp, float damage, KeyboardManager keyboardManager) {
        super(positionX, positionY, width, height, colliderXRight, ColliderXLefit, ColliderYUp, ColliderYDown, colliderMask,
                sprite, hp, damage);
                this.keyBoardManager = keyboardManager;
        
    }

    public abstract void processInput();
    
    
}
