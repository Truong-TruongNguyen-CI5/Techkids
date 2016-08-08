package models;

import java.lang.reflect.Type;

/**
 * Created by Nguyen on 8/7/2016.
 */
public class Gift extends GameObject {
    public static int WIDTH = 40;
    public static int HEIGHT = 40;
    public Gift(int x, int y, int width, int height) {
        super(x, y, width, height,1);
    }
    public Gift(int x, int y){
        super(x, y, WIDTH, HEIGHT,1);
    }
}
