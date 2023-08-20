package external;

import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

// Card Class
public class Cards implements ActionListener {

    // Global selected cards vector
    public static Vector<Cards> selected = new Vector<>();

    public int id;
    public JButton button;
    public String status, path;
    public ImageIcon defaultImg, mainImg;



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

                        // Playing Correct Sound Effect
                        MusicPlayerThread soundEffect1 = new MusicPlayerThread();
                        soundEffect1.filePath = "assets/sounds/correct.wav";
                        soundEffect1.loop = false;
                        soundEffect1.start();

                        // Setting Cards disabled
                        c1.button.setEnabled(false);
                        c2.button.setEnabled(false);

                    }
                });

                timer.start();
            } else {
                Timer timer = new Timer(500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Storing selected cards into temporary card objects and clearing the selected
                        // Vector
                        Cards c3 = selected.get(0);
                        Cards c4 = selected.get(1);
                        selected.clear();

                        // Playing Wrong Sound Effect
                        MusicPlayerThread soundEffect2 = new MusicPlayerThread();
                        soundEffect2.filePath = "assets/sounds/wrong.wav";
                        soundEffect2.loop = false;
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

}