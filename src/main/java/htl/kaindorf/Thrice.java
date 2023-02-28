package htl.kaindorf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Thrice extends JFrame {

    public Thrice() throws HeadlessException {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));
        this.setSize(1200, 600);
        Panel firstPanel = new Panel();
        JLabel startLabel = new JLabel("Graz");
        firstPanel.resetThread(0);
        startLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(startLabel);
        this.add(firstPanel);

        for (int i = 0; i < 2; i++) {
            JLabel label = new JLabel("Enter Location");
            final Panel panel = new Panel();

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);


                    String location = JOptionPane.showInputDialog("Enter Location");
                    label.setText(location);
                    String timeOffset = JOptionPane.showInputDialog("Enter Time Offset");

                    try {
                        panel.resetThread(Integer.parseInt(timeOffset));
                    } catch (Exception exc) {
                        panel.resetThread(0);
                    }
                }
            });
            label.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(label);
            this.add(panel);
        }

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Thrice();
    }

}
