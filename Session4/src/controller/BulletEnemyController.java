package controller;

import models.Bullet;
import models.ImageDrawer;

/**
 * Created by Nguyen on 8/1/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable {
    private static final int SPEED = 5;
    public BulletEnemyController(Bullet gameObject, ImageDrawer imageDrawer) {
        super(gameObject, imageDrawer);
        this.gameVector.dy = SPEED; // ko set lai ve 0 nen tiep tuc chay
        CollisionPool2.instance.add(this);
    }
    @Override
    public void run() {
        super.run();
        if(gameObject.getY() > 700) {
            gameObject.destroy();
        }
    }
    @Override
    public void onCollide(Colliable colliable) {

    }
}
