package controllers;

import models.GameObject;
import models.HpBar;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Nguyen on 8/8/2016.
 */
public class HpBarController extends SingleController {
    public static int SPEED = 10;
    public HpBarController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = - SPEED;
    }
    public void run(){
        super.run();
        if(gameObject.getWidth() % 10 == 0){
            SPEED = 0;
        }
    }
    public static final HpBarController instance = new HpBarController(
            new HpBar(240, 35, 200, 20, 1),
            new ImageDrawer("resources/background.png")
    );
}
