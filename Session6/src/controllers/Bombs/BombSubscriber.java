package controllers.Bombs;

import models.GameObject;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public interface BombSubscriber {
    public void onBombExplode();
    public GameObject getGameObject();
}
