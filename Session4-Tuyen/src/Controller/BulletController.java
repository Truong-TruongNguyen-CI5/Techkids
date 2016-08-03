package Controller;

import models.Bullet;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by PhamTuyen on 7/31/2016.
 */
public class BulletController extends SingleController implements Colliable {

    private static final int SPEED = 20;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollsionPool.instance.add(this);
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
        if(colliable instanceof  EnemyController1){
            colliable.getGameObject().destroy();
            this.getGameObject().destroy();
        }
    }
}
