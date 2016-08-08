package models;

/**
 * Created by Nguyen on 8/8/2016.
 */
public class HpBar extends GameObject {
    public static int WIDTH = 150;
    public static int HEIGHT = 20;

    public HpBar(int x, int y, int width, int height, int maxHP) {
        super(x, y, width, height, maxHP);
    }
    public HpBar(int x, int y, int maxHP){
        super(x, y, WIDTH, HEIGHT, maxHP);
    }
}
