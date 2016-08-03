package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by PhamTuyen on 8/1/2016.
 */
public interface GameDrawer {
    void draw(Graphics g, GameObject gameObject);
}
