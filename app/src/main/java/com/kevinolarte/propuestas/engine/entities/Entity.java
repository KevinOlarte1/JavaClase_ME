package com.kevinolarte.propuestas.engine.entities;

import java.awt.image.BufferedImage;

import org.checkerframework.checker.units.qual.h;

import com.kevinolarte.propuestas.engine.core.Updatable;
import com.kevinolarte.propuestas.engine.core.Collider;
import com.kevinolarte.propuestas.engine.math.Vector2;

public abstract class Entity implements Updatable {
    private static int autoincremental = 0;
    private int id;
    private  Vector2 postion;
    private final float width;
    private final float height;
    private  Collider collider;
    private float hp;
    private float damage;
    
    private BufferedImage sprite;

    public Entity(float positionX, float positionY, float width, float height, 
                  float colliderXRight, float ColliderXLefit, float ColliderYUp, float ColliderYDown, 
                  int colliderMask, BufferedImage sprite, float hp, float damage){
        this(positionX,positionY,width,height, sprite, hp, damage);
        this.collider = new Collider(colliderXRight, ColliderXLefit, ColliderYUp, ColliderYDown, colliderMask);
            
    }

    public Entity(float positionX, float positionY, float width, float height,
                  float colliderOffset,int colliderMask, BufferedImage sprite, float hp, float damage){
        this(positionX, positionY, width, height,  colliderOffset, colliderOffset, colliderOffset, colliderOffset, colliderMask, sprite, hp, damage);
    }

    public Entity(float positionX, float positionY, float width, float height,
                  float colliderOffsetX, float colliderOffsetY, int colliderMask, BufferedImage sprite,float hp, float damage){
        this(positionX, positionY, width,height, colliderOffsetX, colliderOffsetX, colliderOffsetY, colliderOffsetY, colliderMask, sprite, hp, damage);
    }

    public Entity(float positionX, float positionY, float width, float height,
                  BufferedImage sprite, float hp, float damage){
        this.id = ++autoincremental;
        this.postion = new Vector2(positionX, positionY);
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.hp = hp;
        this.damage = damage;
    }
    
    

    public int getId() {
        return id;
    }

    public Vector2 getPostion() {
        return postion;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Collider getCollider() {
        return collider;
    }

    public BufferedImage getSprite() {
        return sprite;
    }


    public void setCollider(float colliderXRight, float colliderXLefit, float colliderYUp, float colliderYDown, int colliderMask){
        if (collider == null) {
            collider = new Collider(colliderXRight, colliderXLefit, colliderYUp, colliderYDown, colliderMask);
        }
        else{
            collider.setxRight(colliderXRight);
            collider.setxLeft(colliderXLefit);
            collider.setyUp(colliderYUp);
            collider.setyDown(colliderYDown);
        }

    }

    
    public void setCollider(float colliderOffsetX, float colliderOffsetY, int colliderMask){
        setCollider(colliderOffsetX, colliderOffsetX, colliderOffsetY, colliderOffsetY, colliderMask);
    }

    public void setCollider(float colliderOffset, int colliderMask){
        setCollider(colliderOffset, colliderOffset, colliderOffset, colliderOffset, colliderMask);
    }

    public void setSprite(BufferedImage sprite){
        this.sprite = sprite;
    }

    public void setPosition(float x, float y){
        postion.setX(x);
        postion.setY(y);
    }

    public void setDamage(float damage){
        this.damage = damage;
    }

    public void hit(Entity e, float damage){
        e.hp -= damage;
    }
    public void hit(Entity e){
        hit(e, damage);
    }

    public float getX(){
        return postion.getX();
    }

    public float getY(){
        return postion.getY();
    }

    
    @Override
    public abstract void update(double deltaTime);

    @Override
    public abstract void lastUpdate(double deltaTime);

    @Override
    public abstract void postUpdate(double deltaTime);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entity other = (Entity) obj;
        if (id != other.id)
            return false;
        return true;
    }
   

}
