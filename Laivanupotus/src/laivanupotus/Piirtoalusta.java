package laivanupotus;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {

    private ArrayList laivat;
    private ArrayList vastustajanLaivat;

    public Piirtoalusta(ArrayList laivat, ArrayList vastustajanLaivat) {
        super.setBackground(Color.WHITE);
        this.laivat = laivat;
        this.vastustajanLaivat = vastustajanLaivat;

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        graphics.fillRect(200, 100, 1, 100);
        graphics.drawRect(100, 100, 200, 100);
        
        for(int i=0; i<this.laivat.size(); i++){
            Laiva laiva = (Laiva)this.laivat.get(i);
            HashMap pisteet = laiva.varatutPisteet();
            for(Object a : pisteet.keySet()){
                graphics.fillRect((int)a*10+200, (int)pisteet.get(a)*10+90, 9, 9);
            }    
        }
        for(int i=0; i<this.vastustajanLaivat.size(); i++){
            Laiva laiva = (Laiva)this.vastustajanLaivat.get(i);
            HashMap pisteet = laiva.varatutPisteet();
            for(Object a : pisteet.keySet()){
                graphics.fillRect((int)a*10+100, (int)pisteet.get(a)*10+90, 9, 9);
            }
            
            
        }
    }
}
