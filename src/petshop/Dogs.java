package petshop;

import javax.swing.*;

public class Dogs extends JFrame {
    public Dogs(){
        setTitle("PET SHOP");
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setUndecorated(true);
        setLocationRelativeTo(null);

        JButton lr = new JButton("LABRADOR RETRIEVER");
        lr.setBounds(0,50,225,50);
        add(lr);

        JButton gr = new JButton("GOLDEN RETRIEVER");
        gr.setBounds(400,50,225,50);
        add(gr);

        JButton c = new JButton("COLLIE");
        c.setBounds(800,50,225,50);
        add(c);

        JButton gh= new JButton("GERMAN SHEPHERD");
        gh.setBounds(00,150,225,50);
        add(gh);

        JButton rt = new JButton("ROTTWEILER");
        rt.setBounds(400,150,225,50);
        add(rt);

        JButton b = new JButton("BEAGLE");
        b.setBounds(800,150,225,50);
        add(b);


        setVisible(true);
    }

    public static void main(String[] args) {
        new Dogs();
    }

}
