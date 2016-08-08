package models;

import javafx.scene.shape.*;

import java.awt.*;
import java.awt.Rectangle;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public abstract class GameObject {
    public static final int RADIUS = 250;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected  int dam;
    protected boolean isAlive;
    public boolean big_gift = false;
    private int hp;
    private static int maxHP = 100 ;

    public GameObject(int x, int y, int width, int height, int maxHP) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
        this.hp = maxHP;
        this.hp = maxHP;
    }

    public int getDam() {
        return dam;
    }

    public void setDam(int dam) {
        this.dam = dam;
    }

    public int getHp() {
        return hp;
    }

    public void increaseHP(int amount) {
        this.hp += amount;
        if(this.hp > maxHP)
            this.hp = maxHP;
    }
    public void decreaseHP (int amount)
    {
        this.hp -= amount;
        if(this.hp <= 0) {
            destroy();
        }
    }

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

    public int getMiddleX() {
        return this.x + this.width / 2;
    }

    public int getMiddleY() {
        return this.x + this.height / 2;
    }

    public int getBottom() {
        return  this.y + this.height;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(GameVector gameVector) {
        this.x += gameVector.dx;
        this.y += gameVector.dy;
    }

    public boolean overlap(GameObject gameObject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }
    public Circle setCircle(){
        return new Circle(getMiddleX(), getMiddleY(), RADIUS);
    }
    public void destroyInCircle(GameObject gameObject){
        double distance = Math.sqrt((this.x - gameObject.x)*(this.x - gameObject.x) + (this.y - gameObject.y)* (this.y - gameObject.y));
        if(distance <= RADIUS){
            gameObject.destroy();
        }
    }
    private Rectangle getRect() {
        return new Rectangle(x, y, width -10 , height -10 );
    }

    public void destroy() {
        this.isAlive = false;
    }
}
