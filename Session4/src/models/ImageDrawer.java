package models;

import untils.Utils;

import java.awt.*;

/**
 * Created by Nguyen on 7/31/2016.
 */
public class ImageDrawer implements GameDrawer {

    private Image img;

    public ImageDrawer(String url) {
        this.img = Utils.loadImage(url);
    }

    public void draw(Graphics g, GameObject gameObject) {
        g.drawImage(img, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(), null);
    }
}
