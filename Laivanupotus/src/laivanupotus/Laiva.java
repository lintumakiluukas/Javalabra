/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.HashMap;
import java.util.List;
import java.awt.Graphics;

/**
 *
 * @author Luce
 */
public class Laiva {

    private int koko;
    private int x=0;
    private int y=0;
    private int hitpoints;
    private Kentta kentta;
    private HashMap<Integer, Integer> pisteet;

    public Laiva(int koko, Kentta kentta) {
        this.koko = koko;
        this.hitpoints = koko;
        this.kentta = kentta;
        maaritaSijainti();
    }
    public Laiva(int koko, Kentta kentta, int x, int y) {
        this.koko = koko;
        this.hitpoints = koko;
        this.kentta = kentta;
       this.pisteet=varatutPisteet();
    }

//    public Laiva(int koko, int x, int y) {
//        this.koko = koko;
//        this.hitpoints = koko;
//        this.x=x;
//        this.y=y;
//        this.pisteet = varatutPisteet();
//    }
    
 
/**
 * Metodi kertoo mikä on onnistumistodennäköisyys syöteluvulla
 * ottaen huomioon olion konstruktorissa asetetun kalibrointiarvon
 *
 * @param   syote   Käyttäjän antama syöte
 * 
 * @return todennäköisyys kalibroituna
 */
    public void maaritaSijainti() {
        this.x = (int) Math.floor((Math.random() * 10) + 1) - this.koko;
        if (this.x < 0) {
            maaritaSijainti();
        }
        this.y = (int) Math.floor((Math.random() * 10) + 1);
 
        for(int i=0; i<this.kentta.getLaivat().size(); i++){ //         Tarkistetaan päällekkäisyydet
                Laiva laiva = (Laiva) this.kentta.getLaivat().get(i);
                for (int a : laiva.pisteet.keySet()) {
                    if (a == x && laiva.pisteet.get(a) == y) {
                        System.out.println(laiva);
                       maaritaSijainti();
                        System.out.println("No nyt siirretää");
                    }else{
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
    public HashMap pisteet() {

        return this.pisteet;
    }

    public HashMap varatutPisteet() {
        HashMap<Integer, Integer> lista = new HashMap<Integer, Integer>();
        for (int i = 0; i < this.koko; i++) {
            lista.put(x + i, y);


        }
        return lista;
    }

    public String toString() {
        return "Koko: " + this.pisteet.size() + ". " + this.pisteet+", "+this.kentta.getNimi();
    }
}
