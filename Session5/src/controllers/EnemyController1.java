package controllers;

import com.sun.prism.impl.paint.PaintUtil;
import models.Enemy;
import models.EnemyBullet;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class EnemyController1 extends
        SingleController implements Colliable {
    public int count;
    public static final int SPEED = 1;
    public static final int DELAY = 50;
    public EnemyController1(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
    }
    public void run() {
        super.run();
        count ++;
        if(count == DELAY) {
            BulletEnemyController bulletEnemyController = new BulletEnemyController(
                    new EnemyBullet(this.gameObject.getMiddleX() - EnemyBullet.SIZE / 2, this.gameObject.getBottom()),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            bulletEnemyController.gameObject.setDam(5);
            CollisionPool.instance.add( bulletEnemyController);
            BulletEnemyManager.instance.add(bulletEnemyController);
            count = 0;
        }
    }
    @Override
    public void onCollide(Colliable colliable) {

    }
}
