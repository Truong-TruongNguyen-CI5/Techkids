package controller;

import models.GameObject;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Nguyen on 8/2/2016.
 */
public class CollisionPool2 implements BaseController {
    private Vector<Colliable> colliableVector2;

    public CollisionPool2() {
        colliableVector2 = new Vector<Colliable>();
    }

    public void add(Colliable colliable) {
        colliableVector2.add(colliable);
    }

    @Override
    public void run() {
        for (Colliable colliable : colliableVector2) {
            if (PlaneController.getPlaneController1().gameObject.overlap(colliable.getGameObject())) {
                PlaneController.getPlaneController1().onCollide(colliable);
                PlaneController.getPlaneController1().getGameObject().hp -= 1;
            }
        }
        Iterator<Colliable> colliableIterator2 = colliableVector2.iterator();
        while (colliableIterator2.hasNext()) {
            Colliable colliable = colliableIterator2.next();
            if (!colliable.getGameObject().isAlive()) {
                colliableIterator2.remove();
            }
        }
    }

    @Override
    public void draw(Graphics g) {

    }

    public static final CollisionPool2 instance = new CollisionPool2();
}
