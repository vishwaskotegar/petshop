package petshop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Cats extends JFrame {
    public Cats(){
        setTitle("PET SHOP");
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setUndecorated(true);
        setLocationRelativeTo(null);

        JButton asl = new JButton("ASIAN SEMI-LONGHAIR");
        asl.setBounds(0,50,225,50);
        /*BufferedImage img = null;
        try {
            img = ImageIO.read(new File("resources\\createUser.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(asl.getWidth(), asl.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);

        asl.setIcon(imageIcon);*/
        add(asl);

        JButton bls = new JButton("BALINESE");
        bls.setBounds(400,50,225,50);
        add(bls);

        JButton kb = new JButton("KURILIAN BOBTAIL");
        kb.setBounds(800,50,225,50);
        add(kb);

        JButton  mk = new JButton("MUNCHKIN");
        mk.setBounds(0,150,225,50);
        add(mk);

        JButton p = new JButton("PERSIAN");
        p.setBounds(400,150,225,50);
        add(p);

        JButton s = new JButton("SIBERIAN");
        s.setBounds(800,150,225,50);
        add(s);

        bls.addActionListener(e -> {
            try{
                Connector con = new Connector();
                con.s.executeUpdate("INSERT INTO inventory(tyoe,breed,quantity) ");
            }catch(Exception ae){

            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new Cats();
    }
}
