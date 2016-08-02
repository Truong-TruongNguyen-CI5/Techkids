package controller;

import models.GameObject;

/**
 * Created by Nguyen on 8/2/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
