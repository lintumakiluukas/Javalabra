/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Luce
 */
public class Laiva {

    private int koko;
    private int x;
    private int y;
    private int hitpoints;
    private Kentta kentta;
    private HashMap<Integer, Integer> pisteet;

    public Laiva(int koko, Kentta kentta) {
        this.koko = koko;
        this.hitpoints = koko;
        this.kentta = kentta;
        maaritaSijainti();
    }

//    public Laiva(int koko, int x, int y) {
//        this.koko = koko;
//        this.hitpoints = koko;
//        this.x=x;
//        this.y=y;
//        this.pisteet = varatutPisteet();
//    }
    public void maaritaSijainti() {
        this.x = (int) Math.floor((Math.random() * 10) + 1) - this.koko;
        if (this.x < 0) {
            maaritaSijainti();
        }
        this.y = (int) Math.floor((Math.random() * 10) + 1);
   
            //for (int i = 0; i < 5; i++) {
        for(int i=0; i<this.kentta.getLaivat().size(); i++){
                Laiva laiva = (Laiva) this.kentta.getLaivat().get(i);
                for (int a : laiva.pisteet.keySet()) {
                    if (a == x && laiva.pisteet.get(a) == y) {
                        maaritaSijainti();
                        System.out.println("Jouduttiin määrittämään sijainti uudelleen");
                    }
                }

            }
        
        this.pisteet = varatutPisteet();
    }

    public String tarkistaOsumaJaTuhoa(int x, int y) {
        String raportti = "";
        if (pisteet.containsKey(x)) {
            for (int a : this.pisteet.keySet()) {
                if (a == x && this.pisteet.get(a) == y) {
                    pisteet.remove(a);
                    if (pisteet.size() > 0) {
                        raportti += " Vahingoitettiin alusta!";
                    } else {
                        raportti += " Tuhottiin alus!";
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
