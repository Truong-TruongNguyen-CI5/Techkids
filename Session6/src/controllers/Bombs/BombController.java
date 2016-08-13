package controllers.Bombs;

import controllers.Behavior.DiagonalFlyBehavior;
import controllers.Behavior.FlyBehavior;
import controllers.Behavior.StraightFlyBehavior;
import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.Bomb;
import utils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class BombController extends SingleController implements Colliable {
    private FlyBehavior flyBehavior;
    public BombController(Bomb gameObject, GameDrawer gameDrawer, FlyBehavior flyBehavior) {
        super(gameObject, gameDrawer);
        this.flyBehavior = flyBehavior;
        CollsionPool.instance.add(this);
    }
    public static BombController create(int x, int y) {
        return new BombController(
                new Bomb(x, y),
                new ImageDrawer("resources/bomb.png"),
                new StraightFlyBehavior()
                );
    }
    public void run(){
        super.run();
        flyBehavior.doFly(this);
    }
    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {

            NotificationCenter.instance
                    .onBomExpode(gameObject.getX(), gameObject.getY());
            Utils.playSound("resources/explosion.wav", false);
            gameObject.destroy();
        }
    }
}
