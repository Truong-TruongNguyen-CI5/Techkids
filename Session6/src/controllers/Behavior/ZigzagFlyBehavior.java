package controllers.Behavior;

import controllers.SingleController;

/**
 * Created by Nguyen on 8/12/2016.
 */
public class ZigzagFlyBehavior implements FlyBehavior {
    public static int xSPEED = 2;
    public static int ySPEED = 2;
    private int count;
    @Override
    public void doFly(SingleController enemyController) {
        if(enemyController.getGameVector().dx >= 0){
            enemyController.getGameVector().dy = xSPEED;
            enemyController.getGameVector().dx = ySPEED;
        }
        if(enemyController.getGameObject().getX() >= 400){
            enemyController.getGameVector().dx = - xSPEED ;
        }
        if(enemyController.getGameObject().getX() <= 100){
            enemyController.getGameVector().dx = xSPEED ;
        }
    }
}
