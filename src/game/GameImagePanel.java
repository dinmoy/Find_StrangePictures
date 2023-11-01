package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GameImagePanel extends JPanel {
    Vector<ImageIcon> gameImgs = new Vector<>(8);
    Image img = new ImageIcon(GameScreen.class.getResource("../image/game/g1.png")).getImage();

    static JLabel[] touchLabel = new JLabel[5];

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public GameImagePanel() {
        for(int i = 0; i < gameImgs.size(); i++){
            gameImgs.add(new ImageIcon(GameScreen.class.getResource("../image/game/g"+(i+1)+".png")));
        }

        for(int i = 0; i < touchLabel.length; i++){
            touchLabel[i] = new JLabel();
            touchLabel[i].setLayout(null);
            touchLabel[i].setBackground(Color.red);
            touchLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
//                    GameScreen.Count--;
                    setVisible(false);
                }
            });
        }
        setLayout(null);
        setBounds(0,0,1000,100);
        setBackground(Color.CYAN);
    }

    public static void replaceTouchLabel(int[] a) {
        touchLabel[0].setBounds(a[0], a[1], 50, 50);
        touchLabel[1].setBounds(a[2], a[3], 50, 50);
        touchLabel[2].setBounds(a[4], a[5], 50, 50);
        touchLabel[3].setBounds(a[6], a[7], 50, 50);
        touchLabel[4].setBounds(a[8], a[9], 50, 50);
    }
}