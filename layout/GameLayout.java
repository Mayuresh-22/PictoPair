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

    public static int matches = 0,turns = 20;

    public GameLayout() {
        createLayeredPane();

        createBgPanel("assets/images/GameLayout-bg.png");

        // Cards Panel
        createCardsPanel();

        // score panel
        createScorePanel();

        // Adding to layeredPane
        layeredPane.add(cardsPanel, BorderLayout.CENTER);
        layeredPane.add(scorePanel, BorderLayout.CENTER);
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
                "assets/images/card-back.png");
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
                    "assets/images/card" + j + ".jpg");
            Image mainscaledImg = mainImg.getImage().getScaledInstance((int) (ScreenStructure.WIDTH * 0.1),
                    (int) (ScreenStructure.HEIGHT * 0.25), Image.SCALE_SMOOTH);
            ImageIcon mainImgIcon = new ImageIcon(mainscaledImg);

            card[i] = new Cards("hidden", mainImgIcon, defaultImgIcon,
                    "assets/images/card" + j + ".jpg" ,rand_arr.get(i));
            j++;
        }
        // Storing objects into array
        for (int i = 0; i < 24; i++) {
            rand_cards.add(card[i]);
        }
        // Sorting based on ID
        Collections.sort(rand_cards, (o1, o2) -> Integer.compare(o1.id, o2.id));
        // Adding to panels
        for (int i = 0; i < 24; i++) {
            cardsPanel.add(rand_cards.get(i).button);
        }
    }
    public void createScorePanel() {

        // Creating Score Panel
        scorePanel.setBounds((int) (ScreenStructure.WIDTH * 0.8), (int) (ScreenStructure.HEIGHT * 0.35),
                (int) (ScreenStructure.WIDTH * 0.15), (int) (ScreenStructure.HEIGHT * 0.2));
        scorePanel.setOpaque(false);
        scorePanel.setLayout(new GridLayout(2, 1, 0, 20));

        // Creating Fonts for Labels
        Font labelFont = new Font("SansSerif",Font.BOLD,25);

        
        // Creating Score Labels
        JLabel matchesLabel = new JLabel("Matches : "+matches);
        JLabel turnsLabel = new JLabel("Turns : "+turns);
        matchesLabel.setFont(labelFont);
        turnsLabel.setFont(labelFont);

        // Styling Labels
        matchesLabel.setForeground(Color.WHITE); // Set text color
        matchesLabel.setBackground(new Color(71, 125, 250));
        matchesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        matchesLabel.setBorder(new TextBubbleBorder(new Color(71, 125, 250), 5, 40, 0));
        matchesLabel.setOpaque(true);

        turnsLabel.setForeground(Color.WHITE); // Set text color
        turnsLabel.setBackground(new Color(71, 125, 250));
        turnsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnsLabel.setBorder(new TextBubbleBorder(new Color(71, 125, 250), 5,40, 0));
        turnsLabel.setOpaque(true);

        scorePanel.add(matchesLabel);
        scorePanel.add(turnsLabel);

        cardsPanel.setLayout(new GridLayout(4,6,20,20));
    }
}
