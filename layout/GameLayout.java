package layout;

import external.*;
import javax.swing.*;

import constants.Constants;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import interfaces.*;


// Main Class
public class GameLayout implements ScreenStructure, ActionListener {

    JPanel GamePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), cardsPanel = new JPanel(),
            scorePanel = new JPanel();
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();
    JButton quitButton = new JButton("QUIT");
    public static JFrame app;

    public static int matches,turns;

    // Creating Score Labels
    public static JLabel matchesLabel;
    public static JLabel turnsLabel;

    public GameLayout() {

        // reseting matches and turns
        matches = 0;
        turns = 30;
        matchesLabel = new JLabel("Matches : "+matches);
        turnsLabel = new JLabel("Turns left : "+turns);
        
        // Creating Layered Pane
        createLayeredPane();

        // Creating Background Panel
        createBgPanel("assets/images/GameLayout-bg.png");

        // Cards Panel
        createCardsPanel();

        // score panel
        createScorePanel();

        // quit button
        quitButton.setBounds((int) (ScreenStructure.WIDTH * 0.95), (int) (ScreenStructure.HEIGHT * 0.0),(int) (ScreenStructure.WIDTH * 0.05), (int) (ScreenStructure.HEIGHT * 0.03));
        quitButton.setBackground(Color.red);
        quitButton.setOpaque(true);
        quitButton.setBorderPainted(false);
        quitButton.setFocusPainted(false);
        quitButton.setForeground(Color.WHITE);
        quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == quitButton) {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit? All game data will be lost", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });

        // Adding to layeredPane
        layeredPane.add(cardsPanel, BorderLayout.CENTER);
        layeredPane.add(scorePanel, BorderLayout.CENTER);
        layeredPane.add(quitButton, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Adding to HomePanel
        GamePanel.add(layeredPane);
        GamePanel.setOpaque(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== quitButton){
            System.exit(0); // Close the application
        }
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
        bg = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(ScreenStructure.WIDTH,ScreenStructure.HEIGHT, Image.SCALE_SMOOTH)));
        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }
    
    public void createCardsPanel() {

        // Generating Deck Number
        // Create a Random object
        Random random = new Random();

        // Generate a random integer between 1 and 5 (inclusive)
        int deckNo = random.nextInt(3) + 1; 

        Cards.getthisLayout(this);
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
                Constants.CARD_BACK_IMAGE_PATH);
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
                    "assets/images/deck"+deckNo+"/card" + j + ".jpg");
            Image mainscaledImg = mainImg.getImage().getScaledInstance((int) (ScreenStructure.WIDTH * 0.1),
                    (int) (ScreenStructure.HEIGHT * 0.25), Image.SCALE_SMOOTH);
            ImageIcon mainImgIcon = new ImageIcon(mainscaledImg);

            card[i] = new Cards("hidden", mainImgIcon, defaultImgIcon,
                     "assets/images/deck"+deckNo+"/card" + j + ".jpg" ,rand_arr.get(i));
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
                (int) (ScreenStructure.WIDTH * 0.18), (int) (ScreenStructure.HEIGHT * 0.2));
        scorePanel.setOpaque(false);
        scorePanel.setLayout(new GridLayout(2, 1, 0, 20));

        // Creating Fonts for Labels
        Font labelFont = new Font("SansSerif",Font.BOLD,20);
        
        // Styling Score Labels
        matchesLabel.setFont(labelFont);
        turnsLabel.setFont(labelFont);

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
    }
}
