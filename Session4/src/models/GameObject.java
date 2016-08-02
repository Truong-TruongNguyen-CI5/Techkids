package models;

import java.awt.*;

/**
 * Created by Nguyen on 7/30/2016.
 */
public class GameObject {
    public int x;
    public int y;
    protected int width;
    protected int height;
    protected boolean isAlive;
    public int hp;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHp() {
        return hp;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
    }
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void move(GameVector gameVector){
        this.x += gameVector.dx;
        this.y += gameVector.dy;
    }
    public int middleX(){
        return this.x + this.width/2;
    }
    public void destroy(){
        this.isAlive = false;
    }

    public boolean isAlive() {
       return isAlive;
    }
    public boolean overlap(GameObject gameObject){
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }
    private Rectangle getRect(){
        return new Rectangle(x, y, width, height);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
