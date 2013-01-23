
package laivanupotus;

import java.util.ArrayList;
import java.util.HashMap;


public class Kentta {
    private ArrayList<Laiva> laivat = new ArrayList<Laiva>();
   // private HashMap<Integer, Integer> koordinaatisto = new HashMap<Integer, Integer>();
    
    
    public void lisaaLaiva(Laiva laiva){
        laivat.add(laiva);
    }
    
    public String ammu(int x, int y){
        String raportti="Ammuttiin koordinaatteihin ("+x+","+y+") onnistuneesti.";
        for(Laiva l : this.laivat){
            raportti+=l.tarkistaOsumaJaTuhoa(x, y);
        }
        return raportti;
    }

}


