package views;

import models.GameObject;
import untils.Utils;

import java.awt.*;

/**
 * Created by PhamTuyen on 8/1/2016.
 */
public class ImageDrawer implements GameDrawer {

    private Image img;

    public ImageDrawer(Image img) {
        this.img = img;
    }
    public ImageDrawer(String url) {
        this.img = Utils.loadImage(url);
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        g.drawImage(img, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(), null);
    }
}