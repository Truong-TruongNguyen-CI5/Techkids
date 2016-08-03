package Controller;

import models.BulletEnemy;
import models.Enemy;
import views.ImageDrawer;

/**
 * Created by PhamTuyen on 8/1/2016.
 */
public class EnemyManager extends ControllerManager {

    private EnemyManager() {
        super();
        int enX = 200;
        int enXX = 200;
        int enY = 10;
        int enX1 = 600;
        int enXX1 = 600;
        int enY1 = 300;
            for (int j = 0; j < 5; j++) {
                EnemyController enemyController1 = new EnemyController(
                        new Enemy(enX, enY),
                        new ImageDrawer("resources/plane1.png")
                );
                enX += 100;

               this.add(enemyController1);
            }
            for(int i = 0 ; i < 5 ; i++){
                BulletEnemyControlller bulletEnemyControlller = new BulletEnemyControlller(
                        new BulletEnemy(enXX, enY),
                        new ImageDrawer("resources/enemy_bullet.png")
                );
                enXX += 100;
                this.add(bulletEnemyControlller);
            }
            for(int i = 0; i < 5 ; i++){
                EnemyController1 enemyController1 = new EnemyController1(
                        new Enemy(enX1, enY1),
                        new ImageDrawer("resources/enemy_plane_white_2.png")
                );
                enX1 += 100;
                this.add(enemyController1);
            }
            for(int i = 0; i < 5 ; i++){
               BulletEnemyControlller bulletEnemyController1 = new BulletEnemyControlller(
                        new BulletEnemy(enXX1,enY1),
                        new ImageDrawer("resources/enemy_bullet.png")
                );
                enXX1 += 100;
                this.add(bulletEnemyController1);
            }

    }

    @Override
    public void run() {
        super.run();
        }
    public final static EnemyManager instance = new EnemyManager();

}

