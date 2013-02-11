package laivanupotus;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel implements Paivitettava{

    private ArrayList laivat;
    private ArrayList vastustajanLaivat;
    private Kentta omaKentta;
    private Kentta vastustajanKentta;
    private Laivanupotus laivanupotus;

    public Piirtoalusta(ArrayList laivat, ArrayList vastustajanLaivat, Kentta a, Kentta b, Laivanupotus laivanupotus) {
        super.setBackground(Color.WHITE);
        this.laivat = laivat;
        this.laivanupotus=laivanupotus;
        this.vastustajanLaivat = vastustajanLaivat;
        this.omaKentta=a;
        this.vastustajanKentta=b;
    }
    
  
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.fillRect(200, 100, 1, 100);//väliviiva
        graphics.drawRect(100, 100, 200, 100);//reunat

        graphics.drawString("A", 100, 95);
        graphics.drawString("B", 110, 95);
        graphics.drawString("C", 120, 95);
        graphics.drawString("D", 130, 95);
        graphics.drawString("E", 140, 95);
        graphics.drawString("F", 150, 95);
        graphics.drawString("G", 160, 95);
        graphics.drawString("H", 170, 95);
        graphics.drawString("I", 183, 95);
        graphics.drawString("J", 190, 95);
        for (int i = 0; i < 100; i += 10) {
            if (i != 90) {
                graphics.drawString("" + (i / 10 + 1), 90, 110 + i);
            } else {
                graphics.drawString("" + (i / 10 + 1), 85, 110 + i);
            }
        }

        graphics.drawString(omaKentta.getNimi(), 110, 215);
        graphics.drawString(vastustajanKentta.getNimi(), 210, 215);
        
        Color harmaa = new Color(200, 220, 220);
        graphics.setColor(harmaa);
        for (int a = 0; a < 100; a += 10) {//Ruudukko
            if (a % 20 == 0) {
                for (int i = 0; i < 200; i += 20) {
                    graphics.fillRect(101 + i, 101 + a, 10, 9);
                }
            } else {
                for (int i = 0; i < 200; i += 20) {
                    graphics.fillRect(110 + i, 101 + a, 10, 9);
                }
            }
        }

        graphics.setColor(Color.black);
        for (int i = 0; i < this.laivat.size(); i++) {
            Laiva laiva = (Laiva) this.laivat.get(i);
            HashMap pisteet = laiva.varatutPisteet();
          
            for (Object a : pisteet.keySet()) {
                graphics.fillRect((int) a * 10 + 200, (int) pisteet.get(a) * 10 + 90, 9, 9);
            }
        }
        for (int i = 0; i < this.vastustajanLaivat.size(); i++) {
            Laiva laiva = (Laiva) this.vastustajanLaivat.get(i);
            HashMap pisteet = laiva.pisteet(); 
            for (Object a : pisteet.keySet()) {
                graphics.fillRect((int) a * 10 + 100, (int) pisteet.get(a) * 10 + 90, 9, 9);
            }


        }
  paivita();
     
        } 
    @Override
    public void paivita() {
        repaint();
      //  System.out.println("jee");
    }
    }

