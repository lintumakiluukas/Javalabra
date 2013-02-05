/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(400, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
                
        Kentta omaKentta = new Kentta("Punakone");
        omaKentta.lisaaLaivat(omaKentta);
                
        Kentta vastustajanKentta = new Kentta("Pelaajapetteri");
        vastustajanKentta.lisaaLaivat(vastustajanKentta);
        
        this.piirtoalusta = new Piirtoalusta(omaKentta.getLaivat(), vastustajanKentta.getLaivat());
        container.add(this.piirtoalusta);  


    }

    public JFrame getFrame() {
        return frame;
    }
}