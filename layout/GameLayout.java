package layout;

import external.*;

import javax.swing.*;
import java.awt.*;
import interfaces.*;
import java.awt.event.*;
import java.util.Vector;

// Card Class
class Cards implements ActionListener {

    // Global selected cards vector
    public static Vector<Cards> selected = new Vector<>();

    int id;
    JButton button;
    String status, path;
    ImageIcon defaultImg, mainImg;
    static MusicPlayerThread soundEffect1 = new MusicPlayerThread();
    static MusicPlayerThread soundEffect2 = new MusicPlayerThread();

    Cards(String status, ImageIcon mainImg, ImageIcon defaultImg, String path) {

        button = new JButton(defaultImg);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(this);

        this.status = status;
        this.path = path;
        this.mainImg = mainImg;
        this.defaultImg = defaultImg;
    }

    public String getStatus() {
        return this.status;
    }

    public void actionPerformed(ActionEvent e) {
        if (selected.size() < 2 && this.status.equals("hidden")) {
            button.setIcon(mainImg);
            selected.add(this);
            checkMatch();

            this.status = "revealed";

        }
    }

    public void checkMatch() {
        if (selected.size() == 2) {
            if (selected.get(0).path.equals(selected.get(1).path)) {

                Timer timer = new Timer(500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Storing selected cards into temporary card objects and clearing the selected
                        // Vector
                        Cards c1 = selected.get(0);
                        Cards c2 = selected.get(1);
                        selected.clear();

                        // // Playing Correct Sound Effect
                        soundEffect1.start();

                        // Setting Cards disabled
                        c1.button.setEnabled(false);
                        c2.button.setEnabled(false);

                    }
                });

                timer.start();
            } else {
                Timer timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Storing selected cards into temporary card objects and clearing the selected
                        // Vector
                        Cards c3 = selected.get(0);
                        Cards c4 = selected.get(1);
                        selected.clear();

                        // Playing Wrong Sound Effect
                        soundEffect2.start();

                        // Setting Cards to hidden
                        c3.button.setIcon(defaultImg);
                        c4.button.setIcon(defaultImg);
                        c3.status = "hidden";
                        c4.status = "hidden";

                    }
                });

                timer.start();
            }
        }
    }
    public static void setSoundEffects(){
        soundEffect1.filePath = "assets/sounds/correct.wav";
        soundEffect1.loop = false;
        soundEffect2.filePath = "assets/sounds/wrong.wav";
        soundEffect2.loop = false;
    }
}

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
                    "E:\\DarshanStudies\\Programing\\Java\\PictoPair-Memory-Game\\assets\\images\\card" + j + ".jpg");
            cardsPanel.add(card[i].button);

            j++;
        }

        // Setting Sound Effects for cards
        Cards.setSoundEffects();
    }
}