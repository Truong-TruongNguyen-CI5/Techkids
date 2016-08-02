import controller.CollisionPool1;
import controller.CollisionPool2;
import controller.EnemyManager;
import controller.PlaneController;
import untils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nguyen on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;

    PlaneController planeController1;
    EnemyManager enemyManager;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;
    public GameWindow() {
        this.setVisible(true);
        this.setResizable(true);
        this.setSize(600,1080);
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

        planeController1 = PlaneController.getPlaneController1();
        enemyManager = new EnemyManager();


        this.addKeyListener(planeController1);
        this.addMouseMotionListener(planeController1);
        background = Utils.loadImage("resources/background.png");
        bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_3BYTE_BGR);
        bufferedImageGraphics = bufferedImage.getGraphics();
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(background,0,0,null);
        planeController1.draw(bufferedImageGraphics); // chay draw
        enemyManager.draw(bufferedImageGraphics);
        g.drawImage(bufferedImage,0,0,null);
    }
    @Override
    public void run() {
        while(PlaneController.getPlaneController1().getGameObject().hp >=0){
            try {
                Thread.sleep(17);
                planeController1.run();
                enemyManager.run();
                CollisionPool1.instance.run();
                CollisionPool2.instance.run();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null,"GAME OVER !!!","THÔNG BÁO", JOptionPane.CANCEL_OPTION);
    }
}
