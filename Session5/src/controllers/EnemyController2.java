package controllers;

import models.Enemy;
import models.EnemyBullet;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
public class EnemyController2 extends SingleController implements Colliable {

    private final static int MOVEMENT_SPEED = 1;
    private final static int DELAY = 50;
    private int count ;

    public EnemyController2(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = MOVEMENT_SPEED;
        this.gameVector.dy = MOVEMENT_SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        count ++;
        if (count == DELAY) {
            count = 0;
            BulletEnemyController bulletEnemyController =
                    new BulletEnemyController(
                            new EnemyBullet( this.gameObject.getMiddleX() - EnemyBullet.SIZE / 2, this.gameObject.getBottom()),
                            new ImageDrawer("resources/enemy_bullet.png")
                );
                bulletEnemyController.gameObject.setDam(5);
            CollisionPool.instance.add( bulletEnemyController);
            int dx = PlaneController.instance.getGameObject().getX() - gameObject.getX();
            int dy = PlaneController.instance.getGameObject().getY() - gameObject.getY();

            if (dy > 0) {
                double ratio = Math.sqrt(dx * dx + dy * dy) / BulletEnemyController.SPEED;

                bulletEnemyController.getGameVector().dy = (int)(dy / ratio);
                bulletEnemyController.getGameVector().dx = (int)(dx / ratio);

                BulletEnemyManager.instance.add(bulletEnemyController);
            }

        }

        if(this.gameObject.getX() >= 550 || this.gameObject.getX() <= 0) {
            this.gameVector.dx = -this.gameVector.dx;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
