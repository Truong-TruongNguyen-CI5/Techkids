package Controller;

import models.Enemy;
import models.GameObject;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by PhamTuyen on 8/1/2016.
 */
public class EnemyController extends
        SingleController implements Colliable {

    public static final int SPEED = 2;
    private ControllerManager EnemyBulletManager;
    public EnemyController(Enemy enemy, GameDrawer gameDrawer) {
        super(enemy, gameDrawer);
        this.gameVector.dy = SPEED;
        this.gameVector.dx = -SPEED;
        this.EnemyBulletManager = new ControllerManager();
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        EnemyBulletManager.run();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        EnemyBulletManager.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}

