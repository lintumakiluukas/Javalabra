/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.HashMap;
import java.util.List;
import laivanupotus.Suunta;

/**
 *
 * @author Luce
 */
public class Laiva {

    private int koko;
    private int x;
    private int y;
    private int hitpoints;
    private HashMap<Integer, Integer> pisteet;

    public Laiva(int koko) {
        this.koko = koko;
        this.hitpoints = koko;
        maaritaSijainti();
    }

    public Laiva(int koko, int x, int y) {
        this.koko = koko;
        this.hitpoints = koko;
        this.x=x;
        this.y=y;
        this.pisteet = varatutPisteet();
    }

    public void maaritaSijainti() {
        this.x = (int) Math.floor((Math.random() * 10) + 1) - this.koko;
        if (this.x < 0) {
            maaritaSijainti();
        }
        this.y = (int) Math.floor((Math.random() * 10) + 1);
        this.pisteet = varatutPisteet();
    }

    public String tarkistaOsumaJaTuhoa(int x, int y) {
        String raportti = "";
        if (pisteet.containsKey(x)) {
            for (int a : this.pisteet.keySet()) {
                if (a == x && this.pisteet.get(a) == y) {
                    pisteet.remove(a);
                    if (pisteet.size() > 0) {
                        raportti += " Vahingoitettiin vihollisalusta!";
                    } else {
                        raportti += " Tuhottiin vihollisalus!";
                    }
                    return raportti;

                }
            }
        }
        return "";
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getPituus() {
        return this.pisteet.size();
    }

    public HashMap varatutPisteet() {
        HashMap<Integer, Integer> lista = new HashMap<Integer, Integer>();
        for (int i = 0; i < this.koko; i++) {
            lista.put(x + i, y);


        }
        return lista;
    }

    public String toString() {
        return "Koko: " + this.pisteet.size() + ". " + this.pisteet;
    }
}
