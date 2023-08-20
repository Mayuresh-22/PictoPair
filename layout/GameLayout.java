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
    ImageIcon defaultImg;

    Cards(String status, String path, ImageIcon defaultImg) {

        button = new JButton(defaultImg);
        button.addActionListener(this);

        this.status = status;
        this.path = path;
        this.defaultImg = defaultImg;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPath() {
        return this.path;
    }

    public void actionPerformed(ActionEvent e) {
        if (selected.size() < 2 && this.status.equals("hidden")) {
            // Creating imgIcon Variable
            ImageIcon img = new ImageIcon(getClass().getResource(path));
            Image scaledImg = img.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
            ImageIcon imgIcon = new ImageIcon(scaledImg);
            button.setIcon(imgIcon);
            this.status = "revealed";
            selected.add(this);

            checkMatch();
        }
    }

    public void checkMatch() {
        if (selected.size() == 2) {
            if (selected.get(0).path.equals(selected.get(1).path)) {

                Timer timer = new Timer(500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Cards c1 = selected.get(0);
                        Cards c2 = selected.get(1);
                        selected.clear();
                    
                        c1.button.setEnabled(false);
                        c2.button.setEnabled(false);
                    }
                });

                timer.start();
            } else {
                Timer timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Cards c1 = selected.get(0);
                        Cards c2 = selected.get(1);
                        selected.clear();
                    
                        c1.button.setIcon(defaultImg);
                        c2.button.setIcon(defaultImg);
                        c1.status = "hidden";
                        c2.status = "hidden";
                    }
                });

                timer.start();
            }
        }
    }
}

public class GameLayout implements ScreenStructure {

    JPanel GamePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), cardsPanel = new JPanel(), scorePanel = new JPanel();
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();

    public GameLayout(){
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
    public void createLayeredPane(){
        // layered pane
        layeredPane.setSize(ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath){
        // bgPanel
        bg = new JLabel(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(ScreenStructure.WIDTH, ScreenStructure.HEIGHT, Image.SCALE_SMOOTH)));

        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }

    public void createCardsPanel(){
        // Creating Cards Panel
        cardsPanel.setBounds((int)(ScreenStructure.WIDTH*0.03),(int)(ScreenStructure.HEIGHT*0.03), (int)(ScreenStructure.WIDTH*0.7), (int)(ScreenStructure.HEIGHT*0.9));
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setOpaque(true);
        cardsPanel.setBorder(new TextBubbleBorder(new Color(200, 200, 200), 10, 70, 0));
        cardsPanel.setLayout(new GridLayout(4,6,20,20));

        // Creating Cards
         Cards[] card = new Cards[24];

        // Creating defaultImgIcon Variable
        ImageIcon defaultImg = new ImageIcon("E:\\DarshanStudies\\Programing\\Java\\PictoPair-Memory-Game\\assets\\imagescard-back.png");
        Image scaledImg = defaultImg.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        ImageIcon defaultImgIcon = new ImageIcon(scaledImg);

        // Initializing Cards
        for (int i = 0; i < 24; i++) {
            card[i] = new Cards("hidden", ("assets/images/card-back.png"), defaultImgIcon);
            cardsPanel.add(card[i].button);
        }
    }
}