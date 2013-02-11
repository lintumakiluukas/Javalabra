
package laivanupotus;

import java.util.ArrayList;
import java.util.HashMap;


public class Kentta {
    private ArrayList<Laiva> laivat = new ArrayList<Laiva>();
    private ArrayList<ArrayList> ammututKoordinaatit = new ArrayList<ArrayList>();
    private String nimi="";
    public Kentta(String nimi){
        this.nimi=nimi;
    }
    
    public void lisaaLaiva(Laiva laiva){
        laivat.add(laiva);
    }
    public void lisaaLaivat(Kentta kentta){
        for(int i=0; i<5; i++){
            Laiva laiva = new Laiva(i+1, kentta);
            laivat.add(laiva);
        }

    }
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


