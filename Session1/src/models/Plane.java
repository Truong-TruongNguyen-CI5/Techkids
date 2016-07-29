package models;

/**
 * Created by Nguyen on 7/28/2016.
 */
public class Plane {
    public int x;
    public int y;
    public int dx;
    public int dy;
    public void move(){
        this.x += dx;
        this.y += dy;
    }
    public Plane(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
}
