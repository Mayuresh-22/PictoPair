package layout;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import external.TextBubbleBorder;

public class DialogBox {

    // Settings Box Function
    public static void createSettingsBox() {
        layeredPane.remove(menuPanel);
        layeredPane.revalidate();
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
        dialog.setBackground(new Color(131, 0, 255, 255));
        dialog.getRootPane().setBorder(new TextBubbleBorder(new Color(131, 0, 255, 255), 4, 70, 0));

        JLabel message = new JLabel("SETTINGS");
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setForeground(new Color(131, 0, 255, 255));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        // Setting Options Panel
        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 15));
        JPanel gridOptionPanel = new JPanel(new FlowLayout());
        JPanel musicOptionPanel = new JPanel(new FlowLayout());

        JLabel gridOptionLabel = new JLabel("Grid Size: ");
        gridOptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        gridOptionLabel.setForeground(Color.WHITE);
        gridOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        gridOptionLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel musicOptionLabel = new JLabel("Music: ");
        musicOptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        musicOptionLabel.setForeground(Color.WHITE);
        musicOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        musicOptionLabel.setVerticalAlignment(JLabel.CENTER);

        // grid size button
        gridOptionButton = createButton(gridOptionButton, "3x3", new Color(77, 0, 206, 255), 0, 0, 200, 100, 20);

        musicOptionButton = createButton(musicOptionButton, "", null, 0, 0, 200, 100, 20);
        musicOptionButton.setIcon(def);
        musicOptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (musicOptionButton.getIcon().equals(musicOn)) {
                    musicOptionButton.setIcon(musicOff);
                    def = musicOff;
                    synchronized (musicPlayer) {
                        try {
                            musicPlayer.stopMusic();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    musicOptionButton.setIcon(musicOn);
                    def = musicOn;
                    synchronized (musicPlayer) {
                        musicPlayer.startMusic();
                    }
                }
            }
        });

        gridOptionPanel.add(gridOptionLabel);
        gridOptionPanel.add(gridOptionButton);
        gridOptionPanel.setBackground(new Color(131, 0, 255, 255));

        musicOptionPanel.add(musicOptionLabel);
        musicOptionPanel.add(musicOptionButton);
        musicOptionPanel.setBackground(new Color(131, 0, 255, 255));

        optionsPanel.add(gridOptionPanel);
        optionsPanel.add(musicOptionPanel);
        optionsPanel.setBackground(new Color(131, 0, 255, 255));

        JButton back = new JButton();
        back = createButton(back, "BACK", new Color(77, 0, 206, 255), 0, 0, 200, 100, 20);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                menuPanel.setBorder(new TextBubbleBorder(new Color(131, 0, 255, 255), 10, 70, 0));
                layeredPane.remove(bgPanel);
                layeredPane.add(menuPanel);
                layeredPane.add(bgPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        buttonPanel.add(back);
        buttonPanel.setBackground(new Color(131, 0, 255, 255));
        buttonPanel.setOpaque(true);

        dialog.add(message, BorderLayout.NORTH);
        dialog.add(optionsPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    // Dialog Box for Quit function
    public static void createQuitBox() {
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
        dialog.getRootPane().setBorder(new TextBubbleBorder(new Color(131, 0, 255, 255), 4, 20, 0));

        JLabel message = new JLabel("Are you sure you want to quit?");
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setForeground(new Color(131, 0, 255, 255));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        JButton yes = new JButton();
        yes = createButton(yes, "YES", new Color(77, 0, 206, 255), 0, 0, 200, 100, 20);
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("Thank you for playing! Exiting...");
                Timer t = new Timer(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                t.setRepeats(false);
                t.start();
            }
        });

        JButton no = new JButton();
        no = createButton(no, "NO", new Color(77, 0, 206, 255), 0, 0, 200, 100, 20);
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                menuPanel.setBorder(new TextBubbleBorder(new Color(131, 0, 255, 255), 10, 70, 0));
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
