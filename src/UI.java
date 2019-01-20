import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener{

    private Dice[] cs = new Dice[5];


    public static void main(String[] args)
    {
        UI userInterface = new UI();
    }

    public UI() {
        setSize(800, 500);
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        makeDiceThreads();
    }
}
