package controller;

import models.Bullet;
import models.Enemy;
import models.ImageDrawer;
import models.Plane;
import sun.dc.pr.PRError;

import java.awt.*;
import java.net.ConnectException;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Nguyen on 8/1/2016.
 */
public class EnemyManager extends ControllerManager {
    private ControllerManager enemyControllerManager;
    private ControllerManager bulletOfEnemyControllerManager;
    private SingleController singleController;
    private int enX;
    private int enY;
    public EnemyManager() {
        super();
        enemyControllerManager = new ControllerManager();
        bulletOfEnemyControllerManager = new ControllerManager();

        Thread EnemyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1500);
                        enX = new Random().nextInt(500);
                        EnemyController enemyController = new EnemyController(
                                new Enemy(enX ,0),
                                new ImageDrawer("resources/plane1.png")
                        );
                        enemyControllerManager.add(enemyController);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread bulletOfEnemy = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        Thread.sleep(1500);
                        Iterator<SingleController> enemyControllerIterator = enemyControllerManager.singleControllerVector.iterator();
                        while(enemyControllerIterator.hasNext()){
                            singleController = enemyControllerIterator.next();
                            BulletEnemyController bulletEnemyController = new BulletEnemyController(
                                    new Bullet(singleController.gameObject.getX() +10 ,singleController.gameObject.getY()),
                                    new ImageDrawer("resources/bullet_red.png")
                            );
                            bulletOfEnemyControllerManager.add(bulletEnemyController);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        EnemyThread.start();
        bulletOfEnemy.start();

    }
    public void run(){
        enemyControllerManager.run();
        bulletOfEnemyControllerManager.run();
    }
    public void draw(Graphics g) {
        enemyControllerManager.draw(g);
        bulletOfEnemyControllerManager.draw(g);
    }
}
