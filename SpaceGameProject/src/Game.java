
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Shooting {

    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Shooting(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Game extends JPanel implements KeyListener, ActionListener {

    public Game() {
        setBackground(Color.BLACK);

        try {
            image = ImageIO.read(new FileImageInputStream(new File("spaceship.png")));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "IOException", "Exception", HEIGHT);
        }
    }

    ActionListener spaceShipMoveListenerAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            spaceShipMoveListener();
        }
    };

    Timer timer = new Timer(5, this);
    Timer spaceShipMoveTimer = new Timer(20, spaceShipMoveListenerAction);
    private int elapsedTime = 0, shootingCount = 0;
    private BufferedImage image;
    private ArrayList<Shooting> shots = new ArrayList<>();
    private int shootingDirY = 1;
    private int ballX = 0, ballDirX = 2;
    private int spaceShipX = 0, dirSpaceX = 20;
    private HashSet<Integer> setOfPressedKeys = new HashSet<>();

    @Override
    public void paint(Graphics g) {
        elapsedTime += 5;
        super.paint(g); //Oyun ekranının elementləri.

        // Oyun elementlərinin daxil edilməsi.
        g.setColor(Color.red);
        g.fillOval(ballX, 0, 20, 20);
        g.drawImage(image, spaceShipX, 490, image.getWidth() / 10, image.getHeight() / 10, this);
        g.setColor(Color.blue);

        Thread painterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (Shooting shooting : shots) {
                        g.fillRect(shooting.getX(), shooting.getY(), 10, 20);
                    }
                } catch (ConcurrentModificationException ex) {
                }
            }
        });

        Thread eraserThread = new Thread(new Runnable() {
            @Override
            public void run() {
                deleteUnnecessaryShots();
            }
        });

        Thread checkIntersectsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (checkIntersects()) {
                    String message = "Qazandınız...\n"
                            + "Atış sayı : " + shootingCount
                            + "\nSərf olunan zaman : " + elapsedTime / 1000.0 + " saniyə";

                    setOfPressedKeys = null;
                    shots = null;
                    Intersects intersects = new Intersects(message);
                    intersects.setVisible(true);
                    timer.stop();
                    spaceShipMoveTimer.stop();
                    eraserThread.interrupt();
                    painterThread.interrupt();
                }
            }
        });

        eraserThread.start();

        painterThread.start();

        checkIntersectsThread.start();

        try {
            eraserThread.join();
            painterThread.join();
            checkIntersectsThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        timer.start();
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressedKeyCode = e.getKeyCode();

        if (pressedKeyCode == KeyEvent.VK_A || pressedKeyCode == KeyEvent.VK_D || pressedKeyCode == KeyEvent.VK_SPACE
                || pressedKeyCode == KeyEvent.VK_LEFT || pressedKeyCode == KeyEvent.VK_RIGHT) {
            spaceShipMoveTimer.start();
            setOfPressedKeys.add(pressedKeyCode);
        }
        /*
        if (pressedKey == KeyEvent.VK_LEFT || pressedKey == KeyEvent.VK_A) {
            if (spaceShipX <= 0) {
                spaceShipX = 0;
            } else {
                spaceShipX -= dirSpaceX;
            }
        } else if (pressedKey == KeyEvent.VK_RIGHT || pressedKey == KeyEvent.VK_D) {
            if (spaceShipX >= 750) {
                spaceShipX = 750;
            } else {
                spaceShipX += dirSpaceX;
            }
        } else if (pressedKey == KeyEvent.VK_CONTROL) {
            shots.add(new Shooting(spaceShipX + 15, 470));
            shootingCount++;
        }
         */
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int pressedKeyCode = e.getKeyCode();
        //int setOfPressedKeysSize = setOfPressedKeys.size();
        //System.out.println(setOfPressedKeysSize);

        //System.out.println("Removing ...");
        setOfPressedKeys.remove(pressedKeyCode);
        //System.out.println(setOfPressedKeysSize);

        if (setOfPressedKeys.isEmpty()) {
            // System.out.println("Stoped.");
            //System.out.println(setOfPressedKeys.size());
            spaceShipMoveTimer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += ballDirX;

        if (ballX >= 785) {
            ballDirX *= -1;
        }
        if (ballX <= -1) {
            ballDirX *= - 1;
        }

        for (Shooting shooting : shots) {
            shooting.setY(shooting.getY() - shootingDirY);
        }

        repaint();
    }

    public void spaceShipMoveListener() {
        if (setOfPressedKeys.size() > 0) {
            for (int key : setOfPressedKeys) {
                switch (key) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        if (spaceShipX <= 0) {
                            spaceShipX = 0;
                        } else {
                            spaceShipX -= dirSpaceX;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        if (spaceShipX >= 750) {
                            spaceShipX = 750;
                        } else {
                            spaceShipX += dirSpaceX;
                        }
                        break;
                    case KeyEvent.VK_SPACE:
                        shots.add(new Shooting(spaceShipX + 15, 470));
                        shootingCount++;
                        break;
                }
            }
        }
    }

    public void deleteUnnecessaryShots() {
        try {
            for (Shooting shooting : shots) {
                if (shooting.getY() < 0) {
                    shots.remove(shooting);
                }
            }
        } catch (ConcurrentModificationException ex) {
        }
    }

    public boolean checkIntersects() {
        for (Shooting shooting : shots) {
            if (new Rectangle(shooting.getX(), shooting.getY(), 10, 20).intersects(new Rectangle(ballX, 0, 20, 20))) {
                return true;
            }
        }
        return false;
    }

}
