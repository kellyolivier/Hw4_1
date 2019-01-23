import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener{

    private Dice[] cs = new Dice[5];


    public static void main(String[] args)
    {
        UI userInterface = new UI();
    }

    /**
     * constructor for UI class, sets up layout and other formatting of frame
     * creates and sets up labels for dice
     * adds roll button
     */
    public UI() {
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        for (int i=0; i<cs.length; i++) {
            JLabel l = new JLabel();
            cs[i] = new Dice(l);
            this.add(l);
        }

        JButton button = new JButton("Roll");
        this.add(button);
        button.addActionListener(this);

        this.setVisible(true);

    }

    /**
     * creates however many dice threads are needed based on the array of dice's length
     * one thread per die obj
     */
    public void makeDiceThreads()
    {
        for (int i=0; i< cs.length; i++) {
            Thread t = new Thread(cs[i]);
            t.start();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {;}
        }
    }

    /**
     * on button press starts rolling all 5 dice in their 5 threads
     * @param e action event of roll button click
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        makeDiceThreads();
    }
}
