package constants;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Constants {
    // create a constant for file path
    public static final String MUSIC_FILE_PATH = "assets/sounds/bgm.wav";
    public static final String SOUND_EFFECT_FILE_PATH = "assets/sounds/intro.wav";
    public static final String CARD_BACK_IMAGE_PATH = "assets/images/card-back.png";
    public static final String ENDING_SCREEN_IMAGE_PATH = "assets/images/EndingScreen-bg.png";
    public static final String HOME_SCREEN_IMAGE_PATH = "assets/images/HomeScreen-bg.png";
    public static final String LOADING_SCREEN_IMAGE_PATH = "assets/images/LoadingScreen-bg.png";

    // create a constant for default image icon
    public static ImageIcon defaultMusicIcon = new ImageIcon(new ImageIcon("assets/images/sound-on.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

    // create a constant for color
    public static final Color COLOR_PRIMARY = new Color(131, 0, 255, 255);
    public static final Color COLOR_BUTTON = new Color(77, 0, 206, 255);

    // create a constant for font
    public static final String FONT_FAMILY = "Comic Sans MS";
    public static final int FONT_SIZE = 20;
    public static final int FONT_STYLE = 1;
}
