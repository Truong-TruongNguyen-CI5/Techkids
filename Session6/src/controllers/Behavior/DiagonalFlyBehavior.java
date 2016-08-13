package controllers.Behavior;

import controllers.SingleController;

/**
 * Created by Nguyen on 8/13/2016.
 */
public class DiagonalFlyBehavior implements FlyBehavior {
    public static int xSPEED = 2;
    public static int ySPEED = 2;
    @Override
    public void doFly(SingleController singleController) {
        singleController.getGameVector().dx = xSPEED;
        singleController.getGameVector().dy = ySPEED;
    }
}
