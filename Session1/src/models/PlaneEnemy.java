package models;

/**
 * Created by Nguyen on 7/29/2016.
 */
public class PlaneEnemy {
    public int x;
    public  int y;
    public PlaneEnemy(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
}
