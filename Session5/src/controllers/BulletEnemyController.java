package controllers;

import models.GameObject;
import views.GameDrawer;

import javax.swing.*;

/**
 * Created by Nguyen on 8/8/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable {
    public static int SPEED = 5;
    public BulletEnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
    }
    public void run(){
        super.run();
        if(gameObject.getY() > 650 ){
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController){
            this.gameObject.destroy();
            (colliable.getGameObject()).decreaseHP(this.gameObject.getDam());
            HpBarController.SPEED = 1;
            HpBarController.instance.run();
            if(!PlaneController.instance.getGameObject().isAlive()){
                JOptionPane.showMessageDialog(null,"GAME OVER !!!","THÔNG BÁO", JOptionPane.CANCEL_OPTION);
                System.exit(0);
            }
        }
    }
}
