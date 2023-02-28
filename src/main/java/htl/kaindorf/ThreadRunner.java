package htl.kaindorf;

import javax.swing.*;

public class ThreadRunner implements Runnable{
    private static DigiLabel digiLabel;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (int i = 0; i < 11; i++) {

            try {
                Thread.sleep(500);
                digiLabel.setValue(i);
            } catch (InterruptedException e) {
                break;
            }
            }
        }
    }

    public static void main(String[] args) {
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(200, 400);
        gui.setLocationRelativeTo(null);

        digiLabel = new DigiLabel();
        gui.getContentPane().add(digiLabel);
        gui.setVisible(true);

        ThreadRunner rt = new ThreadRunner();
        Thread thread = new Thread(rt);
        thread.start();
    }

}
