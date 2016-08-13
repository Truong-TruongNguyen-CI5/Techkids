package controllers.Behavior;

import controllers.Enemy.EnemyBulletController;
import controllers.Enemy.EnemyBulletControllerManager;
import controllers.Enemy.EnemyController;
import controllers.SingleController;
import models.Bullet;
import views.ImageDrawer;

/**
 * Created by Nguyen on 8/12/2016.
 */
public class StraightShotBehavior implements ShotBehavior {
    private int count;
    private static int DELAY_SHOT = 50;
    public static int xSPEED = 0;
    public static int ySPEED = 3;
    @Override
    public void doShot(SingleController singleController) {
        count ++;
        if(count == 100){
            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new Bullet(singleController.getGameObject().getMiddleX(), singleController.getGameObject().getY()),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            enemyBulletController.getGameVector().dy = ySPEED;
            EnemyBulletControllerManager.instance.add(enemyBulletController);
            count = 0;
        }
    }
}
