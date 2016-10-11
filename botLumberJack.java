/**
 * Created by iamnubs on 10/7/2016.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;


public class botLumberJack {

    /**
     * Greats Setting
     * Speed 90ms       | 80ms      | 70ms      | 60ms      | 55ms      | 50ms      | 40ms      | 30ms
     * Left 993, 249    | 993, 230  | 993, 220  | 993, 220  | 993, 185  | 993, 175  | 993, 155  | 993, 150
     * Right 1056, 253  | 1056, 240 | 1056, 225 | 1056, 215 | 1056, 210 | 1056, 210 | 1056, 180 | 1056, 165
     */

    //Colour Pallet
    private static double[] axe = {206.0, 69.0, 58.0};
    private static double[] wood = {161.0, 116.0, 56.0};

    private static int[] left = {992, 150};
    private static int[] right = {1056, 165};
    
    private static int[] player = {912, 308};
    private static boolean playerLeft;

    private static Robot bot;

    public static void main(String[] args) throws Exception {
        System.out.println("Ready...");
        Thread.sleep(1000);
        System.out.println("Go!!!");
        playerLeft = Arrays.equals(RGB(player), axe);
        System.out.println(playerLeft ? "Player on Left" : "Player on Right");
        bot = new Robot();
        while (true) {
            play();
            Thread.sleep(35);
        }
    }


    private static void play() throws Exception {
        boolean isLeft = Arrays.equals(RGB(left), wood);
        boolean isRight = Arrays.equals(RGB(right), wood);

        if (playerLeft) {
            if (isLeft) {
                bot.keyPress(KeyEvent.VK_RIGHT);
                System.out.println("[i] Move Right");
                playerLeft = false;
            } else {
                bot.keyPress(KeyEvent.VK_LEFT);
                System.out.println("[i] <<");
            }
        } else {
            if (isRight) {
                bot.keyPress(KeyEvent.VK_LEFT);
                System.out.println("[i] Move Left");
                playerLeft = true;
            } else {
                bot.keyPress(KeyEvent.VK_RIGHT);
                System.out.println("[i] >>");
            }
        }
    }

    private static double[] RGB(int[] xy) throws Exception {
        Color color = new Robot().getPixelColor(xy[0], xy[1]);
        return new double[]{color.getRed(), color.getGreen(), color.getBlue()};
    }

    private static void mouseLocation() {
        double y = MouseInfo.getPointerInfo().getLocation().getY();
        double x = MouseInfo.getPointerInfo().getLocation().getX();
        System.out.printf("%.2f , %.2f\n", x, y);
    }
}
