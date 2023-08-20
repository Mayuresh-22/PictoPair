package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import interfaces.*;

//Cards Class
class Cards{
    
} 

public class GameLayout implements ScreenStructure {
    JPanel GamePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), cardsPanel = new JPanel(), scorePanel = new JPanel();
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();

    public GameLayout(){
        createLayeredPane();

        createBgPanel("assets/images/GameLayout-bg.png");

        // Card panel
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
        cardsPanel.setBounds((int)(ScreenStructure.WIDTH*0.03),(int)(ScreenStructure.HEIGHT*0.03), (int)(ScreenStructure.WIDTH*0.7), (int)(ScreenStructure.HEIGHT*0.9));
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setOpaque(true);
        cardsPanel.setBorder(new TextBubbleBorder(new Color(200, 200, 200), 10, 70, 0));
        cardsPanel.setLayout(new GridLayout(4,6,20,20));
    }
}