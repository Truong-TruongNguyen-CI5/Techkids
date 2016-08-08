import controllers.*;

import models.HpBar;
import utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


/**
 * Created by qhuydtvt on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image hpBar;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;

//    PlaneController planeController1;

    public GameWindow() {
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(600, 800);
        this.setLocation(0, 0);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        background =  Utils.loadImage("resources/background.png");
        hpBar = Utils.loadImage("resources/hp.png");

        this.addKeyListener(PlaneController.instance);

//        this.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                plane1.moveTo(e.getX() - plane2Width / 2,
//                        e.getY() - plane2Height / 2);
//
//            }
//
//        });

        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        bufferImageGraphic.drawImage(background, 0, 0, null);
        bufferImageGraphic.drawImage(hpBar, 40, 35, 200, 20, null);
        PlaneController.instance.draw(bufferImageGraphic);
        EnemyManager.instance.draw(bufferImageGraphic);
        BulletEnemyManager.instance.draw(bufferImageGraphic);
        GiftManager.instance.draw(bufferImageGraphic);
        HpBarController.instance.draw(bufferImageGraphic);
        bufferImageGraphic.drawString("Máu: ", 10, 50);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                PlaneController.instance.run();
                BulletEnemyManager.instance.run();
                //BulletEnemyManager2.instance.run();
                EnemyManager.instance.run();
                GiftManager.instance.run();
                CollisionPool.instance.run();
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
