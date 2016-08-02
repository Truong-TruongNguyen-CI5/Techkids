package controller;

import models.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Nguyen on 7/31/2016.
 */
public class PlaneController extends SingleController implements KeyListener, MouseMotionListener, Colliable{
    public static final int SPEED = 10;
    public static final int HP =10;
    private ControllerManager bulletControllerManager;
    private PlaneController(Plane plane, ImageDrawer imageDrawer) {
        super(plane, imageDrawer);
        this.bulletControllerManager = new ControllerManager();
        this.gameObject.setHp(HP);
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_UP:
                this.gameVector.dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                this.gameVector.dy = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                this.gameVector.dx = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameVector.dx = SPEED;
                break;
            case KeyEvent.VK_SPACE:
                BulletController bulletController = new BulletController( // moi lan new toan do y tu tru di 10, xem constructor
                        new Bullet(this.gameObject.middleX() - Bullet.WIDTH/2, this.gameObject.getY()),
                        new ImageDrawer("resources/bullet.png")
                );
                bulletControllerManager.add(bulletController);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                this.gameVector.dy = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                gameVector.dx = 0;
                break;
        }
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g); // Draw plane   gameDrawer.draw(g,gameObject);
        bulletControllerManager.draw(g); // Chay vao draw bulletManager chua vector bullet;
    }

    @Override
    public void run() {
        super.run(); // bc la cap nhat lai vi tri cua may bay
        bulletControllerManager.run(); // Chay vector cua bulletManager
    }
    private static PlaneController planeController1;
    public static PlaneController getPlaneController1(){
        if(planeController1 == null){
            planeController1 = new PlaneController(new Plane(250,600), new ImageDrawer("resources/plane3.png")); // 1 ImageDrawer
        }
        return planeController1;
    }
    public void onCollide(Colliable colliable) {
        if (colliable instanceof BulletEnemyController) {
            colliable.getGameObject().destroy();
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.gameObject.setX(mouseEvent.getX() - gameObject.getWidth()/2);
        this.gameObject.setY(mouseEvent.getY() - gameObject.getHeight()/2);

    }
}
