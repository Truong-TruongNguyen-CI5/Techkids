package controller;

import models.GameObject;
import models.ImageDrawer;

/**
 * Created by Nguyen on 8/1/2016.
 */
public class EnemyController extends
        SingleController implements  Colliable{
    public static final int SPEED1 = 1;
    public EnemyController(GameObject gameObject, ImageDrawer imageDrawer) {
        super(gameObject, imageDrawer);
        this.gameVector.dy = SPEED1;
        CollisionPool1.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
