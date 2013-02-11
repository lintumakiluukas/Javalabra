
package laivanupotus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NappiKuuntelija implements ActionListener{
    private Laivanupotus l;
    private Piirtoalusta p;
    public NappiKuuntelija(Laivanupotus l, Piirtoalusta p){
        this.l=l;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        l.toteutaVuorot();
      // p.paivita();
    
        System.out.println("Viesti vastaanotettu!");
    }
    
}
