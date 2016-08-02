package controller;

import models.GameDrawer;
import models.GameObject;
import models.GameVector;
import models.ImageDrawer;

import java.awt.*;

/**
 * Created by Nguyen on 7/31/2016.
 */
public class SingleController implements BaseController {
    protected GameObject gameObject;
    private ImageDrawer imageDrawer;
    protected GameVector gameVector;

    public SingleController(GameObject gameObject, ImageDrawer imageDrawer) {
        this.gameObject = gameObject;
        this.imageDrawer = imageDrawer;
        this.gameVector = new GameVector();
    }
    @Override
    public void draw(Graphics g) {
        imageDrawer.draw(g,gameObject);
    }

    @Override
    public void run() {
        gameObject.move(this.gameVector); // Cap nhat vi tri cua gameObject
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
