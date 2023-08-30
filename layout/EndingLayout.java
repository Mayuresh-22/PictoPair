package layout;

import external.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaces.*;

public class EndingLayout implements ScreenStructure{
    JPanel HomePanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), menuPanel = new JPanel(new BorderLayout());
    JLabel bg;
    JLayeredPane layeredPane = new JLayeredPane();
    JButton play, settings, quite, yes, no;
    JFrame app;
    EndingLayout thisLayout;
    public EndingLayout(JFrame app){
        this.app = app;
        createLayeredPane();

        createBgPanel("assets/images/EndingScreen-bg.png");

        // menu panel
        createMenuPanel();

        // Adding to layeredPane
        layeredPane.add(menuPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Adding to HomePanel
        HomePanel.add(layeredPane);
        HomePanel.setOpaque(true);
    }

    public void getthisLayout(EndingLayout thisLayout){
        this.thisLayout = thisLayout;
    }
    
    public JPanel getHomePanel() {
        return HomePanel;
    }

    @Override
    public void createLayeredPane(){
        // layered pane
        layeredPane.setSize(ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        layeredPane.setBackground(Color.GRAY);
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

    public void createMenuPanel(){

        JLabel tempJLabel = new JLabel("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        tempJLabel.setFont(new Font("Arial",Font.BOLD,50));
        tempJLabel.setOpaque(false);


        Font scoreFont = new Font("Arial",Font.BOLD,35);
        JLabel scoreLabel = new JLabel("You matched "+GameLayout.matches+" Cards in "+GameLayout.turns+" Turns !");
        scoreLabel.setFont(scoreFont);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,40, 40));
        buttonsPanel.setBackground(null);
        buttonsPanel.setOpaque(false);

        play = createButton(play, "PLAY", 0, 0, 200, 50, 20);
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Play GameLayout
                GameLayout gameLayout = new GameLayout();
                app.remove(thisLayout.getHomePanel());
                app.add(gameLayout.getGamePanel(), BorderLayout.CENTER);
                app.revalidate();
                app.repaint();
            }
        });

        

        quite = createButton(quite, "QUIT", 0, 0, 200, 50, 20);
        quite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Quit DialogBox
                createDialogBox();
            }
        });

        buttonsPanel.add(play);
        buttonsPanel.add(quite);

        // Adding to menuPanel with flow layout
        menuPanel.add(tempJLabel,BorderLayout.NORTH);
        menuPanel.add(scoreLabel,BorderLayout.CENTER);
        menuPanel.add(buttonsPanel,BorderLayout.SOUTH);

        menuPanel.setBounds((ScreenStructure.WIDTH/2)-350, (ScreenStructure.HEIGHT/2)-150, 700, 300);
        menuPanel.setBackground(new Color(131,0,255,255));
        menuPanel.setOpaque(true);
        menuPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
    }

    public JButton createButton(JButton button, String text, int x, int y, int width, int height, int fontSize){
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(77,0,206,255));
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));

        return button;
    }

     // Settings Box Function
    public void createSettingsBox(){
        layeredPane.remove(menuPanel);
        layeredPane.repaint();

        // Settings Box
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(800, 500);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());
        dialog.setUndecorated(true);
        dialog.getRootPane().setBorder(new TextBubbleBorder(new Color(131,0,255,255), 4, 20, 0));
        
        JLabel message = new JLabel("SETTINGS");
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setForeground(new Color(131,0,255,255));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        // Setting Options Panel
        JPanel optionsPanel = new JPanel(new GridLayout(2,1,10,0));
        JPanel gridOptionPanel = new JPanel(new FlowLayout()); 
        JPanel musicOptionPanel = new JPanel(new FlowLayout()); 

        JLabel gridOptionLabel = new JLabel("Grid Size: ");
        gridOptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        gridOptionLabel.setForeground(new Color(131,0,255,255));
        gridOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        gridOptionLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel musicOptionLabel = new JLabel("Music: ");
        musicOptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        musicOptionLabel.setForeground(new Color(131,0,255,255));
        musicOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        musicOptionLabel.setVerticalAlignment(JLabel.CENTER);

        JButton gridOptionButton = new JButton("4x4");
        gridOptionButton.setSize(50,50);
        gridOptionButton.setFocusPainted(false);
        gridOptionButton.setBorderPainted(false);
        gridOptionButton.setFont(new Font("Arial", Font.BOLD, 20));
        gridOptionButton.setForeground(new Color(131,0,255,255));

        JButton musicOptionButton = new JButton("OFF");
        musicOptionButton.setFocusPainted(false);
        musicOptionButton.setBorderPainted(false);
        musicOptionButton.setFont(new Font("Arial", Font.BOLD, 20));
        musicOptionButton.setForeground(new Color(131,0,255,255));

        gridOptionPanel.add(gridOptionLabel);
        gridOptionPanel.add(gridOptionButton);

        musicOptionPanel.add(musicOptionLabel);
        musicOptionPanel.add(musicOptionButton);

        optionsPanel.add(gridOptionPanel);
        optionsPanel.add(musicOptionPanel);

        JButton yes = new JButton();
        yes = createButton(yes, "YES", 0, 0, 200, 100, 30);
        yes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                message.setText("Thank you for playing! Exiting...");
                Timer t = new Timer(1500, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                });
                t.setRepeats(false);
                t.start();
            }
        });

        JButton no = new JButton();
        no = createButton(no, "NO", 0, 0, 200, 100, 30);
        no.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dialog.dispose();
                menuPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
                layeredPane.remove(bgPanel);
                layeredPane.add(menuPanel);
                layeredPane.add(bgPanel);
                layeredPane.repaint();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        buttonPanel.add(yes);
        buttonPanel.add(no);
        buttonPanel.setOpaque(true);

        dialog.add(message, BorderLayout.NORTH);
        dialog.add(optionsPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    // Dialog Box for Quit function
    public void createDialogBox(){
        layeredPane.remove(menuPanel);
        layeredPane.repaint();

        // dialog box to ask confirmation to quit
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());
        dialog.setUndecorated(true);
        dialog.getRootPane().setBorder(new TextBubbleBorder(new Color(131,0,255,255), 4, 20, 0));
        
        JLabel message = new JLabel("Are you sure you want to quit?");
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setForeground(new Color(131,0,255,255));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        JButton yes = new JButton();
        yes = createButton(yes, "YES", 0, 0, 200, 100, 30);
        yes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                message.setText("Thank you for playing! Exiting...");
                Timer t = new Timer(1500, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                });
                t.setRepeats(false);
                t.start();
            }
        });

        JButton no = new JButton();
        no = createButton(no, "NO", 0, 0, 200, 100, 30);
        no.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dialog.dispose();
                menuPanel.setBorder(new TextBubbleBorder(new Color(131,0,255,255), 10, 70, 0));
                layeredPane.remove(bgPanel);
                layeredPane.add(menuPanel);
                layeredPane.add(bgPanel);
                layeredPane.repaint();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        buttonPanel.add(yes);
        buttonPanel.add(no);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setOpaque(true);

        dialog.add(message, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

   
}