
package laivanupotus.domain;

import java.util.ArrayList;
import java.util.HashMap;


public class Kentta {
    private ArrayList<Laiva> laivat = new ArrayList<Laiva>();
    private ArrayList<ArrayList> ammututKoordinaatit = new ArrayList<ArrayList>();
    private String nimi="";
    public Kentta(String nimi){
        this.nimi=nimi;
    }
    
    /**
     * Lisätään kentälle yksittäinen laiva
     * @param laiva lisättävä laiva
     */
    public void lisaaLaiva(Laiva laiva){
        laivat.add(laiva);
    }
    /**
     * Luodaan 5 erikokoista laivaa ja lisätän ne kentälle
     * @param kentta kenttä, johon luotu laiva kuuluu
     */
    public void lisaaLaivat(Kentta kentta){
        for(int i=0; i<5; i++){
            Laiva laiva = new Laiva(i+1, kentta);
            laivat.add(laiva);
        }

    }
    /**
     * Ammutaan kentälle annettuihin koordinaatteihin, tarkistetaan osumat jokaiselta laivalta erikseen
     * @param x X-koordinaatti, johon ammutaan
     * @param y Y-koordinaatti, johon ammutaan
     * @return palautetaan merkkijono, joka kertoo, osuttiinko vastustajan alukseen.
     */
    public String ammu(int x, int y){
        String raportti=this.nimi+" ampui koordinaatteihin ("+x+","+y+") onnistuneesti.";
        for(Laiva l : this.laivat){
            raportti+=l.tarkistaOsumaJaTuhoa(x, y);
        }
        return raportti;
    }

    public ArrayList getLaivat(){
        return this.laivat;
    }
    public String getNimi(){
        return this.nimi;
    }
}


