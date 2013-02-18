/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private Laivanupotus laivanupotus;
    private ArrayList<Integer> ammututX = new ArrayList<Integer>();
    private ArrayList<Integer> ammututY = new ArrayList<Integer>();

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        
        this.laivanupotus = new Laivanupotus();
       
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(425, 370));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

        private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 5));
        JTextField x = new JTextField("A");
        JTextField y = new JTextField("1");
        JButton nappi = new JButton("Ammu");
        JButton lopetusnappi = new JButton("Lopeta peli");
        nappi.addActionListener(new NappiKuuntelija(this.laivanupotus, x, y,1));
        lopetusnappi.addActionListener(new NappiKuuntelija(this.laivanupotus, x, y,2));
        panel.add(x);
        panel.add(y);
        panel.add(nappi);
        panel.add(lopetusnappi);
        
        return panel;
    }
        
    private void luoKomponentit(Container container) {
    
        
        Kentta omaKentta = this.laivanupotus.getOmaKentta();
        Kentta vastustajanKentta = this.laivanupotus.getVastustajanKentta();
        this.piirtoalusta = new Piirtoalusta(omaKentta.getLaivat(), vastustajanKentta.getLaivat(), omaKentta, vastustajanKentta, this.laivanupotus);
        container.add(this.piirtoalusta);
        container.add(luoValikko(), BorderLayout.SOUTH);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}