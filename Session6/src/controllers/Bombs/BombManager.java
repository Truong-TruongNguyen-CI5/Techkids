package controllers.Bombs;

import controllers.ControllerManager;

import java.util.Random;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class BombManager extends ControllerManager {

    private int count;
    private static final int BOMB_PERIOD = 300;
    private static final int LOCK_PERIOD = 500;

    public static final BombManager instance = new BombManager();

    @Override
    public void run() {
        count++;
        Random r = new Random();
        int x = r.nextInt(600);
        int y = r.nextInt(800);
        if(count >= LOCK_PERIOD) {
            count = 0;
            LockController lockController = LockController
                    .create(x, y);
            this.add(lockController);
        }
        else if(count == BOMB_PERIOD) {
            /*  Generate bomb */
            BombController bombController = BombController
                    .create(x, y);
            this.add(bombController);
        }
        super.run();
    }
}
