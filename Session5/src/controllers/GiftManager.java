package controllers;

import models.Enemy;
import models.GameObject;
import models.Gift;
import views.ImageDrawer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Nguyen on 8/7/2016.
 */
public class GiftManager extends ControllerManager {
    private static int randomSmallGift = 700;
    private static int randomBigGift = 1500;
    private GiftManager() {
        super();
    }
    @Override
    public void run() {
        super.run();
        if (new Random().nextInt(randomSmallGift) == 1) {
            GiftController giftController = new GiftController(
                    new Gift(new Random().nextInt(540), 0),
                    new ImageDrawer("resources/gift_boom.png")
            );
            giftController.gameObject.big_gift = false;
            this.add(giftController);
        }
        else if(new Random().nextInt(randomBigGift) == 1){
            GiftController giftController = new GiftController(
                    new Gift(new Random().nextInt(540), 0, 70, 70),
                    new ImageDrawer("resources/gift_boom2.png")
            );
            giftController.gameObject.big_gift = true;
            this.add(giftController);
        }
    }

    public final static GiftManager instance = new GiftManager();
}
