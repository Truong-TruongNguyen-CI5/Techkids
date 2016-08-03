package Controller;

import models.Enemy;
import models.GameObject;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by PhamTuyen on 8/2/2016.
 */
public class EnemyController1 extends SingleController implements Colliable{
    public static final int SPEED = 3;
    private ControllerManager  EnemyBulletManager1;
    public EnemyController1(Enemy enemy, GameDrawer gameDrawer) {
        super(enemy, gameDrawer);
        this.gameVector.dx = - SPEED;
        this.EnemyBulletManager1 = new ControllerManager();
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        EnemyBulletManager1.run();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        EnemyBulletManager1.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
