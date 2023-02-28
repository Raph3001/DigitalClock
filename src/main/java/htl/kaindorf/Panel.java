package htl.kaindorf;

import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;

public class Panel extends JPanel implements Runnable {
    private DigiLabel[] labels = new DigiLabel[8];
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Thread thread;
    private int timeHour = 0;

    public Panel() {
        initLabels();
    }

    public void initLabels() {
        this.setLayout(new GridLayout(1, 8));
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new DigiLabel();
            this.add(labels[i]);
        }
    }

    public void resetThread(int timeHour) {
        if (thread != null) {
            thread.interrupt();
        }
        thread = new Thread(this);
        this.timeHour = timeHour;
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (int i = 0; i < 11; i++) {
                try {
                    Thread.sleep(50);
                    String time = LocalTime.now().plusHours(timeHour).format(DTF);
                    labels[0].setValue(Integer.parseInt(String.valueOf(time.charAt(0))));
                    labels[1].setValue(Integer.parseInt(String.valueOf(time.charAt(1))));
                    labels[2].setValue(11);
                    labels[3].setValue(Integer.parseInt(String.valueOf(time.charAt(3))));
                    labels[4].setValue(Integer.parseInt(String.valueOf(time.charAt(4))));
                    labels[5].setValue(11);
                    labels[6].setValue(Integer.parseInt(String.valueOf(time.charAt(6))));
                    labels[7].setValue(Integer.parseInt(String.valueOf(time.charAt(7))));

                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        Panel panel = new Panel();
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Thread thread = new Thread(panel);
        thread.start();
    }

}
