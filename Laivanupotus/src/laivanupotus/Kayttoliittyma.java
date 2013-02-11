/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private Laivanupotus laivanupotus;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        
        this.laivanupotus = new Laivanupotus();
       
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

        private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton nappi = new JButton("Ammu");
        nappi.addActionListener(new NappiKuuntelija(this.laivanupotus, this.piirtoalusta));
        panel.add(nappi);
        
        panel.add(new JButton("Lopeta peli"));
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