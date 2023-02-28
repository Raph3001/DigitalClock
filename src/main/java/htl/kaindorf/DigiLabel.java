package htl.kaindorf;

import javax.swing.*;
import java.awt.*;

public class DigiLabel extends JLabel {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    public DigiLabel() {
        setBackground(Color.BLACK);
        setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(this.getWidth() / 11.0, this.getHeight() / 18.0);


        for (int i = 0; i < 7; i++) {


            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setPaint(Color.LIGHT_GRAY);
            g2d.setStroke(new BasicStroke(0.1f));
            Polygon polygon = new Polygon(getXCoordsOfSegment(getSegmentsForDigit(8)[i]), getYCoordsOfSegment(getSegmentsForDigit(8)[i]), getXCoordsOfSegment(getSegmentsForDigit(8)[i]).length);
            g2d.fillPolygon(polygon);
            g2d.setPaint(Color.WHITE);
            g2d.drawPolygon(polygon);

        }
        int[] segments = getSegmentsForDigit(value);
        for (int segment : segments) {

            g2d.setPaint(Color.RED);
            Polygon polygon = new Polygon(getXCoordsOfSegment(segment), getYCoordsOfSegment(segment), getXCoordsOfSegment(segment).length);
            g2d.fillPolygon(polygon);
            g2d.setPaint(Color.WHITE);
            g2d.drawPolygon(polygon);

        }
    }

    private static int[] getXCoordsOfSegment(int segment) {
        return switch (segment) {
            case 0, 3, 6 -> new int[] {2, 3, 8, 9, 8, 3};
            case 1, 2 -> new int[] {9, 10, 10, 9, 8, 8};
            case 4, 5 -> new int[] {2, 3, 3, 2, 1, 1};
            case 7, 8 -> new int[] {5, 7, 7, 5,};
            default -> new int[] {};
        };
    }

    private static int[] getYCoordsOfSegment(int segment) {
        return switch (segment) {
            case 0 -> new int[] {2, 1, 1, 2, 3, 3};
            case 1, 5 -> new int[] {2, 3, 8, 9, 8, 3};
            case 6 -> new int[] {9, 8, 8, 9, 10, 10};
            case 2, 4 -> new int[] {9, 10, 15, 16, 15, 10};
            case 3 -> new int[] {16, 15, 15, 16, 17, 17};
            case 7 -> new int[] {5, 5, 7, 7};
            case 8 -> new int[] {11, 11, 13, 13};
            default -> new int[] {};
        };
    }

    private static int[] getSegmentsForDigit(int value) {
        return switch (value) {
            case 0 -> new int[] {0, 1, 2, 3, 4, 5};
            case 1 -> new int[] {2, 1};
            case 2 -> new int[] {0, 1, 6, 4, 3};
            case 3 -> new int[] {0, 1, 6, 2, 3};
            case 4 -> new int[] {5, 6, 1, 2};
            case 5 -> new int[] {0, 5, 6, 2, 3};
            case 6 -> new int[] {0, 5, 6, 4, 3, 2};
            case 7 -> new int[] {0, 1, 2};
            case 8 -> new int[] {0, 1, 2, 3, 4, 5, 6};
            case 9 -> new int[] {0, 1, 2, 3, 5, 6};
            default -> new int[] {7, 8};
        };
    }





}
