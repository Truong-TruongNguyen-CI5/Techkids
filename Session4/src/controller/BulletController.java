package controller;

import models.*;

/**
 * Created by Nguyen on 7/31/2016.
 */
public class BulletController extends SingleController  implements  Colliable{
    private static final int SPEED = 5;
    public BulletController(Bullet gameObject, ImageDrawer imageDrawer) {
        super(gameObject, imageDrawer);
        this.gameVector.dy = -SPEED; // ko set lai ve 0 nen tiep tuc chay
        CollisionPool1.instance.add(this);
    }
    @Override
    public void run() {
        super.run();
        if(gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }
    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            this.getGameObject().destroy();
        }
    }
}
