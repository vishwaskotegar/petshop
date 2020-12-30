package petshop;

import javax.swing.*;
import java.awt.*;

public class Selling extends JFrame {
    public Selling(){
        setTitle("PET SHOP");
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);

        /*JButton b = new JButton("b");
        b.setBounds(0,0,25,25);
        add(b);

        b.addActionListener(e -> {
            Dimension x = getSize();
            System.out.println(x);
        });*/

        JButton cats = new JButton("CATS");
        cats.setBounds(0,50,225,50);
        add(cats);

        JButton dogs = new JButton("DOGS");
        dogs.setBounds(300,50,225,50);
        add(dogs);

        JButton fishes = new JButton("FISHES");
        fishes.setBounds(600,50,225,50);
        add(fishes);

        JButton birds = new JButton("BIRDS");
        birds.setBounds(200,250,225,50);
        add(birds);

        JButton acc = new JButton("ACCESSORIES");
        acc.setBounds(500,250,225,50);
        add(acc);

        cats.addActionListener(e -> {
            new Cats();
            dispose();
        });

        dogs.addActionListener(e -> {

        });

        setVisible(true);
    }


    public static void main(String[] args) {
        new Selling();
    }
}
