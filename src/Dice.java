import javax.swing.*;
import java.util.Random;

public class Dice implements Runnable
{
    private Random rand = new Random();
    private JLabel label;
    ImageIcon one = new ImageIcon("src/one.png");
    ImageIcon two = new ImageIcon("src/two.png");
    ImageIcon three = new ImageIcon("src/three.png");
    ImageIcon four = new ImageIcon("src/four.png");
    ImageIcon five = new ImageIcon("src/five.png");
    ImageIcon six = new ImageIcon("src/six.png");


    public Dice(JLabel label2) {
        label = label2;
    }

    public void run() {
        int stop = rand.nextInt(20);
        stop += 10;

        for (int i = 0; i <= stop; i++)
        {
            changeFace();
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException ex) {;}

        }

    }

    public void changeFace()
    {
        int randFace = rand.nextInt(6);
        randFace++; //make range turn out to 1-6

        switch (randFace)
        {
            case 1:
                label.setIcon(one);
                break;
            case 2:
                label.setIcon(two);
                break;
            case 3:
                label.setIcon(three);
                break;
            case 4:
                label.setIcon(four);
                break;
            case 5:
                label.setIcon(five);
                break;
            case 6:
                label.setIcon(six);
                break;

        }
    }
}

