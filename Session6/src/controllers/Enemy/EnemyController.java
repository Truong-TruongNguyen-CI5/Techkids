package controllers.Enemy;

import controllers.Bombs.FreezeSubcriber;
import controllers.Bombs.NotificationCenter;
import controllers.Bombs.BombSubscriber;
import controllers.Colliable;
import controllers.CollsionPool;
import controllers.SingleController;
import controllers.Behavior.*;
import models.Enemy;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */

public class EnemyController extends
        SingleController implements
        Colliable, BombSubscriber, FreezeSubcriber {
    private EnemyState enemyState;
    private int frezzeCount;
    private int FREZZE_PERIOD = 200;
    private FreezeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private FlyBehavior flyBehavior;
    public EnemyController(Enemy gameObject, GameDrawer gameDrawer,FlyBehavior flyBehavior,
                           FreezeBehavior freezeBehavior,
                           ShotBehavior shotBehavior) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        NotificationCenter.instance
                .subsribe(this);
        NotificationCenter.instance
                .subsribeFrezze(this);
        enemyState = EnemyState.NORMAL;
        this.freezeBehavior = freezeBehavior;
        this.shotBehavior = shotBehavior;
        this.flyBehavior = flyBehavior;
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }
    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"),
                        new DiagonalFlyBehavior(),
                        new FreezeBehavior(200),
                        new FollowShotBehavior()
                );
                break;
            case WHITE:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_1.png"),
                        new ZigzagFlyBehavior(),
                        new FreezeBehavior(300),
                        new StraightShotBehavior()
                );
                break;
        }
        return enemyController;
    }

    @Override
    public void onBombExplode() {
        gameObject.destroy();
    }

    @Override
    public void run() {
        switch (this.enemyState) {
            case NORMAL:
                super.run();
                break;
            case FREZZED:
                break;
        }

        if (freezeBehavior != null)
            freezeBehavior.run(this);
        if(shotBehavior != null)
            shotBehavior.doShot(this);
        if(flyBehavior != null)
            flyBehavior.doFly(this);
    }
    @Override
    public void onFreeze() {
        enemyState = EnemyState.FREZZED;
        frezzeCount = 0;
    }
}
