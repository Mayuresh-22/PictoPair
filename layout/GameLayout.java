package layout;

import external.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import interfaces.*;

import java.awt.geom.Point2D;


// Main Class
public class GameLayout implements ScreenStructure {

    JPanel GamePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), cardsPanel = new JPanel(),
            scorePanel = new JPanel();
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();

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
        GradientLabel matches = new GradientLabel("Matches : 0", new Color(71, 88, 250), new Color(85, 240, 255));
        GradientLabel turns = new GradientLabel("Turns : 0", new Color(71, 88, 250), new Color(85, 240, 255));
        matches.setFont(labelFont);
        turns.setFont(labelFont);

        // Styling Labels
        matches.setForeground(Color.WHITE); // Set text color
        // matches.setBackground(new Color(71, 88, 250));
        matches.setHorizontalAlignment(SwingConstants.CENTER);
        matches.setBorder(new TextBubbleBorder(new Color(71, 88, 250), 5, 40, 0));
        matches.setOpaque(true);

        turns.setForeground(Color.WHITE); // Set text color
        // turns.setBackground(new Color(71, 88, 250));
        turns.setHorizontalAlignment(SwingConstants.CENTER);
        turns.setBorder(new TextBubbleBorder(new Color(71, 88, 250), 5,40, 0));
        turns.setOpaque(true);

        scorePanel.add(matches);
        scorePanel.add(turns);

        cardsPanel.setLayout(new GridLayout(4,6,20,20));
    }

    static class GradientLabel extends JLabel {
        private Color startColor;
        private Color endColor;

        public GradientLabel(String text, Color startColor, Color endColor) {
            super(text);
            this.startColor = startColor;
            this.endColor = endColor;
            setOpaque(false); // Make sure the label is transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Call the original paintComponent method first

            // Create a gradient background
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setPaint(new GradientPaint(
                    new Point2D.Float(0, 0), startColor,
                    new Point2D.Float(0, getHeight()), endColor
            ));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose(); // Dispose of the graphics context
        }
    }
}
