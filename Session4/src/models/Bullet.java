package models;

/**
 * Created by Nguyen on 7/28/2016.
 */
public class Bullet extends GameObject{
    public final static int WIDTH = 13;
    public final static int HEIGHT =30;

    public Bullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
