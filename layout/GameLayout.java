package layout;

import external.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import interfaces.*;



// Main Class
public class GameLayout implements ScreenStructure {

    JPanel GamePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), cardsPanel = new JPanel(),
            scorePanel = new JPanel();
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();

    public GameLayout() {
        createLayeredPane();

        createBgPanel("assets/images/GameLayout-bg.png");

        // menu panel
        createCardsPanel();

        // Adding to layeredPane
        layeredPane.add(cardsPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Adding to HomePanel
        GamePanel.add(layeredPane);
        GamePanel.setOpaque(true);
    }

    public JPanel getGamePanel() {
        return GamePanel;
    }

    @Override
    public void createLayeredPane() {
        // layered pane
        layeredPane.setSize(ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath) {
        // bgPanel
        bg = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(ScreenStructure.WIDTH,
                ScreenStructure.HEIGHT, Image.SCALE_SMOOTH)));

        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }

    public void createCardsPanel() {

        // Creating Cards Panel
        cardsPanel.setBounds((int) (ScreenStructure.WIDTH * 0.03), (int) (ScreenStructure.HEIGHT * 0.03),
                (int) (ScreenStructure.WIDTH * 0.7), (int) (ScreenStructure.HEIGHT * 0.9));
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setOpaque(true);
        cardsPanel.setBorder(new TextBubbleBorder(new Color(200, 200, 200), 10, 70, 0));
        cardsPanel.setLayout(new GridLayout(4, 6, 20, 20));

        // Creating Cards
        Cards[] card = new Cards[24];

        // Creating defaultImgIcon Variable
        ImageIcon defaultImg = new ImageIcon(
                "E:\\DarshanStudies\\Programing\\Java\\PictoPair-Memory-Game\\assets\\images\\card-back.png");
        Image scaledImg = defaultImg.getImage().getScaledInstance((int) (ScreenStructure.WIDTH * 0.1),
                (int) (ScreenStructure.HEIGHT * 0.25), Image.SCALE_SMOOTH);
        ImageIcon defaultImgIcon = new ImageIcon(scaledImg);

         ArrayList<Integer> rand_arr = new ArrayList<>();
         ArrayList<Cards> rand_cards = new ArrayList<>();
        // Creating an array with 16 numbers
        for (int i = 0; i < 24; i++) {
            rand_arr.add(i);
        }
        // Shuffling the numbers
        Collections.shuffle(rand_arr);

        int j = 1;
        // Initializing Cards
        for (int i = 0; i < 24; i++) {
            if (j == 13) {
                j = 1;
            }
            // Creating mainImgIcon Variable
            ImageIcon mainImg = new ImageIcon(
                    "E:\\DarshanStudies\\Programing\\Java\\PictoPair-Memory-Game\\assets\\images\\card" + j + ".jpg");
            Image mainscaledImg = mainImg.getImage().getScaledInstance((int) (ScreenStructure.WIDTH * 0.1),
                    (int) (ScreenStructure.HEIGHT * 0.25), Image.SCALE_SMOOTH);
            ImageIcon mainImgIcon = new ImageIcon(mainscaledImg);

            card[i] = new Cards("hidden", mainImgIcon, defaultImgIcon,
                    "E:\\DarshanStudies\\Programing\\Java\\PictoPair-Memory-Game\\assets\\images\\card" + j + ".jpg" ,1);
            cardsPanel.add(card[i].button);

            j++;
        }
        
    }
}