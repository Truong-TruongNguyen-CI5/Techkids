package Controller;

        import models.GameObject;

/**
 * Created by PhamTuyen on 8/1/2016.
 */
public interface Colliable {
    GameObject  getGameObject();
    void onCollide(Colliable colliable);
}
