package controllers.Bombs;

import models.GameObject;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public interface FreezeSubcriber {
    void onFreeze();
    GameObject getGameObject();
}
