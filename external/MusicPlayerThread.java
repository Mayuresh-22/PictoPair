package external;

import javax.sound.sampled.*;
import java.io.*;

// MusicPlayer Class for sound effects
public class MusicPlayerThread extends Thread {

    public String filePath;
    public Boolean loop, stop = false;

    @Override
    public void run() {
        if (loop == false) {
            try {
                File audioFile = new File(filePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();

                int bufferSize = 4096;
                byte[] buffer = new byte[bufferSize];
                int bytesRead = 0;

                while ((bytesRead = audioStream.read(buffer, 0, buffer.length)) != -1) {
                    line.write(buffer, 0, bytesRead);
                }

                line.drain();
                line.close();
                audioStream.close();

            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        } else {
            while (true) {
                try {
                    if (stop == true) {
                        break;
                    }

                    File audioFile = new File(filePath);
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                    AudioFormat format = audioStream.getFormat();
                    DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

                    SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                    line.open(format);
                    line.start();

                    int bufferSize = 4096;
                    byte[] buffer = new byte[bufferSize];
                    int bytesRead = 0;

                    while ((bytesRead = audioStream.read(buffer, 0, buffer.length)) != -1) {
                        line.write(buffer, 0, bytesRead);
                    }

                    line.drain();
                    line.close();
                    audioStream.close();

                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopMusic() {
        Thread.currentThread().interrupt();
    }
}