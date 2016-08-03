package Controller;

import models.BulletEnemy;
import models.GameObject;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by PhamTuyen on 8/2/2016.
 */
public class BulletEnemyControlller extends SingleController implements Colliable{
    public static final int SPEED = 3;
    public BulletEnemyControlller(BulletEnemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED; ///=>>>>>>>>>>>>>> sửa thành = SPEED, đạn địch bay xuống, vecto dương
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getY() < 0 ){
            gameObject.destroy();
        }
    }


    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof BulletEnemyControlller) {
            colliable.getGameObject().destroy();
            this.getGameObject().destroy();
        }
//       if(colliable instanceof  BulletEnemyControlller){
//           colliable.getGameObject().destroy();
//        this.getGameObject().destroy();
//    }
    }

}
