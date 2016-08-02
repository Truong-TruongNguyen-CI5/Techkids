package models;

/**
 * Created by Nguyen on 7/29/2016.
 */
public class Enemy extends GameObject {
    public static final int DEFAULT_WIDTH = 32;
    public static final int DEFAULT_HEIGHT = 32;

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Enemy(int x, int y){
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT );
    }
}
