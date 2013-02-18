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
    private int x = 0;
    private int y = 0;
    private Kentta kentta;
    private HashMap<Integer, Integer> pisteet;

    /**
     * Luo uuden laivan ja määrittää sille satunnaisen sijainnin
     *
     * @param koko Laivan pituus
     * @param kentta Kenttä, johon laiva kuuluu
     */
    public Laiva(int koko, Kentta kentta) {
        this.koko = koko;
        this.kentta = kentta;
        maaritaSijainti();
    }

    /**
     * Luo uuden laivan annettuihin koordinaatteihin
     *
     * @param koko Laivan pituus
     * @param kentta Kenttä, johon laiva kuuluu
     * @param x Laivan X koordinaatti
     * @param y Laivan Y koordinaatti
     */
    public Laiva(int koko, Kentta kentta, int x, int y) {
        this.koko = koko;
        this.kentta = kentta;
        this.pisteet = varatutPisteet();
    }

    /**
     * Arpoo laivalle sijainnin kentällä. Suorittaa arvonnan uudestaan mikäli
     * laiva sattuu osumaan toisen laivan päälle tai kentän ulkopuolelle.
     */
    public void maaritaSijainti() {
        this.x = (int) Math.floor((Math.random() * 10) + 1) - this.koko;
        if (this.x < 0) {
            maaritaSijainti();
        }
        this.y = (int) Math.floor((Math.random() * 10) + 1);
        for (int i = 0; i < this.kentta.getLaivat().size(); i++) {
            Laiva laiva = (Laiva) this.kentta.getLaivat().get(i);
            for (int a : laiva.pisteet.keySet()) {
                for (int b = 0; b < this.koko; b++) {
                    if (a == this.x + b && laiva.pisteet.get(a) == this.y) {
                        maaritaSijainti();
                        System.out.println("No nyt siirretää");
                        break;
                    }
                }
            }

        }

        this.pisteet = varatutPisteet();
    }

    /**
     * Tarkistaa, onko laivan jokin osa ammutun koordinaatin kohdalla
     *
     * @param x Ammutun kohdan X koordinaatti
     * @param y Ammutun kohdan Y koordinaatti
     */
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

    /**
     * Luo listan laivan eri osien koordinaateista
     *
     * @return Listan laivan eri osien koordinaateista
     */
    public HashMap varatutPisteet() {
        HashMap<Integer, Integer> lista = new HashMap<Integer, Integer>();
        for (int i = 0; i < this.koko; i++) {
            lista.put(x + i, y);
        }
        return lista;
    }
}
