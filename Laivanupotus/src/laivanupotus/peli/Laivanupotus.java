/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.peli;

import laivanupotus.gui.Piirtoalusta;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import laivanupotus.domain.Kentta;
import laivanupotus.domain.Laiva;
import laivanupotus.gui.Paivitettava;

public class Laivanupotus {

    private int vx = -1;
    private int vy = -1;
    private int osuttuX = -1;
    private int osuttuY = -1;
    private int ammutaanLaivaa = 0;
    private int peliJatkuu = 1;
    private Kentta omaKentta = new Kentta("Punakone");
    Kentta vastustajanKentta = new Kentta("Pelaaja-Petteri");
    private ArrayList<Integer> ammututX = new ArrayList<Integer>();
    private ArrayList<Integer> ammututY = new ArrayList<Integer>();
    private ArrayList<Integer> ohiAmmututX = new ArrayList<Integer>();
    private ArrayList<Integer> ohiAmmututY = new ArrayList<Integer>();
    private ArrayList<Integer> vastustajanAmmututX = new ArrayList<Integer>();
    private ArrayList<Integer> vastustajanAmmututY = new ArrayList<Integer>();
    private ArrayList<Integer> vastustajanOhiAmmututX = new ArrayList<Integer>();
    private ArrayList<Integer> vastustajanOhiAmmututY = new ArrayList<Integer>();
    public String t2 = "";
    public String t3 = "";
    public String t4 = "";
    public String t5 = "";
    public String t6 = timestamp() + "Laivanupotus on alkanut!";
    public String t7 = timestamp() + "Syötä haluamasi koordinaatit ja paina ampumisnappia!";
    private Piirtoalusta piirtoalusta;
    private Paivitettava paivitettava;

    public Laivanupotus(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
        omaKentta.lisaaLaivat(omaKentta);
        vastustajanKentta.lisaaLaivat(vastustajanKentta);
    }

    /**
     * Luo aikaleiman
     *
     * @return palauttaa merkkijonon, joka kertoo kellonajan
     */
    public String timestamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm");
        String timestamp = "[" + sdf.format(date) + "] ";
        return timestamp;
    }

    public Kentta getOmaKentta() {
        return this.omaKentta;
    }
    public void setPaivitettava(Paivitettava paivitettava){
        this.paivitettava=paivitettava;
    }
    public Paivitettava getPaivitettava(){
        return this.paivitettava;
    }

    public Kentta getVastustajanKentta() {
        return this.vastustajanKentta;
    }

    /**
     * Peli pyörii yhden kierroksen eteenpäin, eli suorittaa ensin pelaajan
     * vuoron ja sen jälkeen vastustajan vuoron. Kutsutaan ampumisnappia
     * painamalla.
     *
     * @param px X-koordinaatti, johon pelaaja ampuu
     * @param py Y-Koordinaatti, johon pelaaja ampuu
     */
    public void toteutaVuorot(String px, String py) {
        int vuoro = 0;
        while (vuoro == 0) {
            px = px.toUpperCase();
            int x;
            if (px.equals("A")) {
                x = 0;
            } else if (px.equals("B")) {
                x = 1;
            } else if (px.equals("C")) {
                x = 2;
            } else if (px.equals("D")) {
                x = 3;
            } else if (px.equals("E")) {
                x = 4;
            } else if (px.equals("F")) {
                x = 5;
            } else if (px.equals("G")) {
                x = 6;
            } else if (px.equals("H")) {
                x = 7;
            } else if (px.equals("I")) {
                x = 8;
            } else if (px.equals("J")) {
                x = 9;
            } else {
                ilmoitus(timestamp() + "X-koordinaatin on oltava väliltä A-I!");
                break;
            }
            int y;
            if (py.equals("1")) {
                y = 1;
            } else if (py.equals("2")) {
                y = 2;
            } else if (py.equals("3")) {
                y = 3;
            } else if (py.equals("4")) {
                y = 4;
            } else if (py.equals("5")) {
                y = 5;
            } else if (py.equals("6")) {
                y = 6;
            } else if (py.equals("7")) {
                y = 7;
            } else if (py.equals("8")) {
                y = 8;
            } else if (py.equals("9")) {
                y = 9;
            } else if (py.equals("10")) {
                y = 10;
            } else {
                ilmoitus(timestamp() + "Y-koordinaatin on oltava väliltä 1-10!");
                break;
            }
            String raportti = vastustajanKentta.ammu(x, y);
            if (raportti.equals(this.vastustajanKentta.getNimi() + " ampui koordinaatteihin (" + x + "," + y + ") onnistuneesti. Vahingoitettiin alusta!")) {
                this.ammututX.add(x);
                this.ammututY.add(y);
                ilmoitus(timestamp() + "Ammuttiin koordinaatteihin (" + px + "," + py + "). Osu muttei uponnut!");
                break;
            } else if (raportti.equals(this.vastustajanKentta.getNimi() + " ampui koordinaatteihin (" + x + "," + y + ") onnistuneesti. Tuhottiin alus!")) {
                this.ammututX.add(x);
                this.ammututY.add(y);
                ilmoitus(timestamp() + "Ammuttiin koordinaatteihin (" + px + "," + py + "). Osu ja upposi!");
                break;
            } else {
                this.ohiAmmututX.add(x);
                this.ohiAmmututY.add(y);
                ilmoitus(timestamp() + "Ammuttiin koordinaatteihin (" + px + "," + py + "). Huti!");
                vuoro = 1;
            }
        }
        while (vuoro == 1) {

            if (this.ammutaanLaivaa == 0) {
                boolean voidaankoAmpua = false;

                while (voidaankoAmpua == false) {//Tarkistetaan, ettei ammuta samaan kohtaan uudestaan
                    voidaankoAmpua = true;
                    this.vx = (int) Math.floor((Math.random() * 10) + 1) - 1;
                    this.vy = (int) Math.floor((Math.random() * 10) + 1);

                    for (int i = 0; i < this.vastustajanAmmututX.size(); i++) {
                        if (this.vastustajanAmmututX.get(i) == this.vx && this.vastustajanAmmututY.get(i) == this.vy) {
                            voidaankoAmpua = false;
                        }
                    }
                    for (int i = 0; i < this.vastustajanOhiAmmututX.size(); i++) {
                        if (this.vastustajanOhiAmmututX.get(i) == this.vx && this.vastustajanOhiAmmututY.get(i) == this.vy) {
                            voidaankoAmpua = false;
                        }
                    }
                }
            } else {
                if (this.ammutaanLaivaa == 1) {
                    if (this.vx + 1 < 10) {
                        this.vx++;
                    } else {
                        this.ammutaanLaivaa = 2;
                        this.vx = this.osuttuX;
                    }
                    this.vy = this.osuttuY;
                    System.out.println("juuh oikeelle");
                }
                if (this.ammutaanLaivaa == 2) {
                    this.vx--;

                    this.vy = this.osuttuY;
                    System.out.println("vasurii");
                }

            }
            String raportti = omaKentta.ammu(this.vx, this.vy);
            if (raportti.equals(this.omaKentta.getNimi() + " ampui koordinaatteihin (" + this.vx + "," + this.vy + ") onnistuneesti. Vahingoitettiin alusta!")) {
                this.vastustajanAmmututX.add(this.vx);
                this.vastustajanAmmututY.add(this.vy);
                ilmoitus(timestamp() + "Vastustaja ampuu... Osu muttei uponnut!");
                if (this.ammutaanLaivaa == 0) {
                    this.osuttuX = this.vx;
                    this.osuttuY = this.vy;
                    this.ammutaanLaivaa = 1;
                }
            } else if (raportti.equals(this.omaKentta.getNimi() + " ampui koordinaatteihin (" + this.vx + "," + this.vy + ") onnistuneesti. Tuhottiin alus!")) {
                this.vastustajanAmmututX.add(this.vx);
                this.vastustajanAmmututY.add(this.vy);
                ilmoitus(timestamp() + "Vastustaja ampuu... Osu ja upposi!");
                this.ammutaanLaivaa = 0;
            } else {
                this.vastustajanOhiAmmututX.add(this.vx);
                this.vastustajanOhiAmmututY.add(this.vy);
                ilmoitus(timestamp() + "Vastustaja ampuu... Huti!");
                if (this.ammutaanLaivaa == 1) {
                    this.ammutaanLaivaa = 2;
                    this.vx = this.osuttuX;
                } else if (this.ammutaanLaivaa == 2) {
                    this.ammutaanLaivaa = 0;
                }
                vuoro = 0;
                
            }
        }

    }

    /**
     * Tarkistaa jäljellä olevien laivojen määrän molemmilta kentiltä ja
     * tarvittaessa lopettaa pelin
     *
     * @return palauttaa arvon, joka kertoo mikäli toiselta kentältä on kaikki
     * laivat tuhottu
     */
    public int tarkistaTilanne() {
        int laskuri = 0;
        for (int i = 0; i < this.vastustajanKentta.getLaivat().size(); i++) {
            Laiva l = (Laiva) this.vastustajanKentta.getLaivat().get(i);
            if (l.pisteet().size() == 0) {
                laskuri++;
            }
        }
        if (laskuri == 5) {
            return 1;
        }
        laskuri = 0;
        for (int i = 0; i < this.omaKentta.getLaivat().size(); i++) {
            Laiva l = (Laiva) this.omaKentta.getLaivat().get(i);
            if (l.pisteet().size() == 0) {
                laskuri++;
            }
        }
        if (laskuri == 5) {
            return 2;
        }
        return 0;
    }

    /**
     * Lisää tekstikenttään uuden ilmoituksen
     *
     * @param t lisättävä merkkijono
     */
    public void ilmoitus(String t) {
        t2 = t3;
        t3 = t4;
        t4 = t5;
        t5 = t6;
        t6 = t7;
        t7 = t;
    }

    public ArrayList getAmmututX() {
        return this.ammututX;
    }

    public ArrayList getAmmututY() {
        return this.ammututY;
    }

    public ArrayList getOhiAmmututX() {
        return this.ohiAmmututX;
    }

    public ArrayList getOhiAmmututY() {
        return this.ohiAmmututY;
    }

    public ArrayList getVastustajanAmmututX() {
        return this.vastustajanAmmututX;
    }

    public ArrayList getVastustajanAmmututY() {
        return this.vastustajanAmmututY;
    }

    public ArrayList getVastustajanOhiAmmututX() {
        return this.vastustajanOhiAmmututX;
    }

    public ArrayList getVastustajanOhiAmmututY() {
        return this.vastustajanOhiAmmututY;
    }
}
