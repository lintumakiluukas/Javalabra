
package laivanupotus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class NappiKuuntelija implements ActionListener{
    private Laivanupotus l;

    private JTextField x;
    private JTextField y;
    private int nappi;
    public NappiKuuntelija(Laivanupotus l, JTextField x, JTextField y, int nappi){
        this.l=l;
        this.x=x;
        this.y=y;
        this.nappi=nappi;
  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(nappi==1){
        l.toteutaVuorot(this.x.getText(),this.y.getText());
        this.x.setText("");
        this.y.setText("");
        }else if(nappi==2){
            System.exit(0); 
        }
    }
    
}
