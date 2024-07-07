package Game.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener, ActionListener {
    private int[][] data = new int[4][4];
    private final int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

    // index of empty block
    int x, y;

    String path = "src/Game/image/animal/animal1/";

    int count = 0;

    //init menu bar
    JMenuBar menuBar = new JMenuBar();
    JMenu functionMenu = new JMenu("Function");
    JMenu aboutMenu = new JMenu("About us");

    //sub menu
    JMenuItem replayItem = new JMenuItem("Re-play game");
    JMenuItem reLoginItem = new JMenuItem("Re-Login");
    JMenuItem closeItem = new JMenuItem("Close game");
    JMenuItem accountItem = new JMenuItem("Group");

    public GameFrame() {
        initFrame();
        initMenuBar();
        initData();
        initImage();

        this.setVisible(true);
    }

    private void initFrame() {
        this.setSize(603, 680);
        this.setTitle("Game");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.lightGray);

        this.addKeyListener(this);
    }

    private void initMenuBar() {
        //add sub menu to menu bar
        menuBar.add(functionMenu);
        menuBar.add(aboutMenu);

        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        this.setJMenuBar(menuBar);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();

        JLabel counter = new JLabel("Counter: " + count);
        counter.setBounds(30, 20, 100, 20);
        this.getContentPane().add(counter);

        if (victory()) {
            JLabel winLabel = new JLabel(new ImageIcon("src/Game/image/win.png"));
            winLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winLabel);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel label = new JLabel(new ImageIcon(path + num + ".jpg"));
                label.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(label);
            }
        }

        JLabel background = new JLabel(new ImageIcon("src/Game/image/background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int number = e.getKeyCode();
        if (number == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            JLabel background = new JLabel(new ImageIcon("src/Game/image/background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) return;
        // left:37, up:38, right:39, down:40
        int number = e.getKeyCode();
        switch (number) {
            case 37 -> {
                if (y == 3) {
                    return;
                }
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                count++;
                initImage();
            }
            case 38 -> {
                if (x == 3) {
                    return;
                }
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                count++;
                initImage();
            }
            case 39 -> {
                if (y == 0) {
                    return;
                }
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                count++;
                initImage();
            }
            case 40 -> {
                if (x == 0) {
                    return;
                }
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                count++;
                initImage();
            }
            case 65 -> initImage();
            case 87 -> {
                data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
                initImage();
            }
        }
    }

    public boolean victory() {
        return Arrays.deepEquals(data, win);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            count = 0;
            initData();
            initImage();
        } else if (obj == reLoginItem) {
            this.setVisible(false);
            new LoginFrame();
        } else if (obj == closeItem) {
            System.exit(0);
        } else if (obj == accountItem) {
            JDialog pic = new JDialog();
            JLabel QrCode = new JLabel(new ImageIcon("src/Game/image/about.png"));
            QrCode.setBounds(0, 0, 258, 258);
            pic.getContentPane().add(QrCode);
            pic.setSize(344, 344);
            pic.setAlwaysOnTop(true);
            pic.setLocationRelativeTo(null);
            pic.setModal(true);
            pic.setVisible(true);
        }
    }
}
