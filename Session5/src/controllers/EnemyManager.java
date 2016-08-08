package controllers;

import models.Enemy;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class EnemyManager extends ControllerManager {

    private int count;
    private static final int RESPAWN_TYPE1 = 50;
    private static final int RESPAWN_TYPE2 = 100;
    private EnemyManager() {
        super();
    }
    @Override
    public void run() {
        super.run();
        count++;
        int enX = 10;
        int enY = 10;
        if (count == RESPAWN_TYPE2) {
            count = 0;
                EnemyController2 enemyController = new EnemyController2(
                        new Enemy(new Random().nextInt(550), enY, 2),
                        new ImageDrawer("resources/enemy_plane_white_3.png")
                );
                this.add(enemyController);
        }
        else if (count == RESPAWN_TYPE1) {
            EnemyController1 enemyController1 = new EnemyController1(
                    new Enemy(new Random().nextInt(550), enY),
                    new ImageDrawer("resources/plane1.png")
            );
            this.add(enemyController1);
        }
    }

    public final static EnemyManager instance = new EnemyManager();
}
