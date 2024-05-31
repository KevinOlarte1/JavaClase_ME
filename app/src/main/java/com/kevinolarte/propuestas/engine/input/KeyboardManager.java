package com.kevinolarte.propuestas.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener{
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean fire;
    private boolean jump;

    private char upKey;
    private char downKey;
    private char leftKey;
    private char rightKey;
    private char fireKey;
    private char jumpKey;

    

    public KeyboardManager(char upKey, char downKey, char leftKey, char rightKey, char fireKey, char jumpKey) {
        this.upKey =    Character.toUpperCase(upKey);
        this.downKey =   Character.toUpperCase(downKey);
        this.leftKey =  Character.toUpperCase(leftKey);
        this.rightKey = Character.toUpperCase(rightKey);
        this.fireKey =  Character.toUpperCase(fireKey);
        this.jumpKey =  Character.toUpperCase(jumpKey);
        up = down = left = right = fire = jump = false;
    }
  
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char eKey = e.getKeyChar();
        if (eKey == this.upKey) {
            this.up = true;
        }else if(eKey == this.downKey){
            this.down = true;
        }

        if (eKey == this.leftKey) {
            this.left = true;
        }else if (eKey == this.rightKey) {
            this.right = true;
        }

        if (eKey == this.fireKey) {
            this.fire = true;
        }

        if (eKey == this.jumpKey) {
            this.jump = true;
        }
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        char eKey = e.getKeyChar();
        if (eKey == this.upKey) {
            this.up = false;
        }else if(eKey == this.downKey){
            this.down = false;
        }

        if (eKey == this.leftKey) {
            this.left = false;
        }else if (eKey == this.rightKey) {
            this.right = false;
        }

        if (eKey == this.fireKey) {
            this.fire = false;
        }

        if (eKey == this.jumpKey) {
            this.jump = false;
        }
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
     
}
