/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.Scanner;

/**
 *
 * @author Luce
 */
public class Laivanupotus {

    private Kentta omaKentta = new Kentta("Punakone");
    Kentta vastustajanKentta = new Kentta("Pelaaja-Petteri");

    public Laivanupotus() {
        omaKentta.lisaaLaivat(omaKentta);
        vastustajanKentta.lisaaLaivat(vastustajanKentta);
        System.out.println("Peli alkaa!");
        System.out.println(vastustajanKentta.getLaivat());

    }

    public Kentta getOmaKentta() {
        return this.omaKentta;
    }
    public Kentta getVastustajanKentta() {
        return this.vastustajanKentta;
    }

    public void toteutaVuorot() {
        System.out.println(this.vastustajanKentta.getLaivat());
        Scanner lukija = new Scanner(System.in);
        String komento = "";

        int vuoro = 0;
        while (vuoro == 0) {
            System.out.println("Sinun vuorosi!");
            System.out.println("Komento: ");
            komento = lukija.nextLine();
            try {
                if (komento.equals("ammu")) {
                    System.out.print("X:");
                    int x = Integer.parseInt(lukija.nextLine());
                    System.out.print("Y:");
                    int y = Integer.parseInt(lukija.nextLine());
                    if (x < 0 || x > 10 || y < 0 || y > 10) {
                        throw new IllegalArgumentException("");
                    }
                    System.out.println(vastustajanKentta.ammu(x, y));
                    vuoro = 1;
                }
            } catch (Exception e) {
                System.out.println("Virheellinen koordinaatti!");
            }

        }
        while (vuoro == 1) {
            System.out.println("     Vastustajan vuoro!");
            int x = (int) Math.floor((Math.random() * 10) + 1);
            int y = (int) Math.floor((Math.random() * 10) + 1);
            System.out.println("     " + omaKentta.ammu(x, y));
            vuoro = 0;
        }



    }
}

