import models.Bullet;
import models.Plane;
import models.PlaneEnemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Nguyen on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image plane1Image;
    Image plane2Image;
    Image bullletImage;
    Image enemy3Image;
    Image enemy4Image;
    Plane plane1;
    Plane plane2;
    Vector<PlaneEnemy> planeEnemyVector;
    Vector<Bullet> bulletVector;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;
    public GameWindow() {
        this.setVisible(true);
        this.setResizable(true);
        this.setSize(800,600);
        plane1 = new Plane(200,300);
        plane2 = new Plane(300,200);
        planeEnemyVector = new Vector<PlaneEnemy>();
        bulletVector = new Vector<Bullet>();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane1Image = ImageIO.read(new File("resources/plane4.png"));
            plane2Image = ImageIO.read(new File("resources/plane2.png"));
            bullletImage = ImageIO.read(new File("resources/bullet.png"));
            enemy3Image = ImageIO.read(new File("resources/enemy_plane_white_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch(keyEvent.getKeyCode()){
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane2.x + plane2Image.getWidth(null)/2 - 7 , plane2.y - plane2Image.getHeight(null)/2);
                        bulletVector.add(bullet);
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.x  -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        plane1.y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.y += 10;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                plane2.moveTo(mouseEvent.getX() - plane2Image.getWidth(null)/2,mouseEvent.getY()- plane2Image.getHeight(null)/2);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_3BYTE_BGR);
        bufferedImageGraphics = bufferedImage.getGraphics();
        Thread thread = new Thread(this);
        Thread planeEnemyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                        PlaneEnemy planeEnemy = new PlaneEnemy(new Random().nextInt(500),2);
                        planeEnemyVector.add(planeEnemy);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        planeEnemyThread.start();
    }
    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(background,0,0,null);
        //bufferedImageGraphics.drawImage(plane1Image,plane1.x,plane1.y,null);
        bufferedImageGraphics.drawImage(plane2Image,plane2.x,plane2.y,null);
//        for(Bullet bullet : bulletVector){
//            bufferedImageGraphics.drawImage(bullletImage,bullet.x, bullet.y, null);
//        }
        for(int i = 0; i < bulletVector.size(); i++){
            Bullet bullet= bulletVector.get(i);
            bufferedImageGraphics.drawImage(bullletImage,bullet.x, bullet.y, null);
        }
        for(int i = 0; i < planeEnemyVector.size(); i++){
            PlaneEnemy planeEnemy= planeEnemyVector.get(i);
            bufferedImageGraphics.drawImage(enemy3Image,planeEnemy.x, planeEnemy.y, null);
        }
//        for(PlaneEnemy planeEnemy : planeEnemyVector){
//            bufferedImageGraphics.drawImage(enemyImage,planeEnemy.x, planeEnemy.y, null);
//        }
        g.drawImage(bufferedImage,0,0,null);
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(27);
                checkCollision();
                Iterator<Bullet> bulletIterator = bulletVector.iterator();
                Iterator<PlaneEnemy> planeEnemyIterator1 = planeEnemyVector.iterator();
                while(planeEnemyIterator1.hasNext()){
                    PlaneEnemy planeEnemy = planeEnemyIterator1.next();
                    planeEnemy.y += 2;
                    if(planeEnemy.y >=400 ){
                        planeEnemyIterator1.remove();
                    }
                }
                while(bulletIterator.hasNext()){
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    if(bullet.y < 0){
                        bulletIterator.remove();
                    }
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void checkCollision(){
        Iterator<PlaneEnemy> planeEnemyIterator = planeEnemyVector.iterator();
        while(planeEnemyIterator.hasNext()){
            PlaneEnemy planeEnemy = planeEnemyIterator.next();
            Rectangle planeEnemyRectangle = new Rectangle(planeEnemy.x, planeEnemy.y, enemy3Image.getHeight(null), enemy3Image.getWidth(null));
            Iterator<Bullet> bulletIterator = bulletVector.iterator();
            while(bulletIterator.hasNext()){
                Bullet bullet = bulletIterator.next();
                Rectangle bulletRectangle = new Rectangle(bullet.x, bullet.y, bullletImage.getHeight(null), bullletImage.getWidth(null));
                if (planeEnemyRectangle.intersects(bulletRectangle)) {
                    bulletIterator.remove();
                    planeEnemyIterator.remove();
                    break;
                }
            }
        }
    }
}
