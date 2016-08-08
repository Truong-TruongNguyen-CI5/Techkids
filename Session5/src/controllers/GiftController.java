package controllers;

import models.Bullet;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by Nguyen on 8/7/2016.
 */
public class GiftController extends SingleController implements Colliable {
    public static int SPEED = 4;

    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
    }

    public void run() {
        super.run();
        if (gameObject.getY() == 650) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.gameObject.destroy();
            if( this.gameObject.big_gift == false) {
                for (int i = 0; i < EnemyManager.instance.singleControllerVector.size(); i++) {
                    PlaneController.instance.gameObject.destroyInCircle(EnemyManager.instance.singleControllerVector.get(i).gameObject);
                }
            }
            else if(this.gameObject.big_gift == true){
                for (int i = 0; i < EnemyManager.instance.singleControllerVector.size(); i++) {
                    EnemyManager.instance.singleControllerVector.get(i).gameObject.destroy();
                }
                BulletEnemyManager.instance.singleControllerVector.clear();
            }
        }
    }
}
