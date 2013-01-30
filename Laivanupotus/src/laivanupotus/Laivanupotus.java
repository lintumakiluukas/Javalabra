package laivanupotus;

import java.util.Scanner;

public class Laivanupotus {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        String komento = "";
        int vuoro = 0;
        int peliJatkuu = 1;

        Kentta omaKentta = new Kentta("Punakone");
        omaKentta.lisaaLaivat(omaKentta);
        

        Kentta vastustajanKentta = new Kentta("Pelaaja-Petteri");
        vastustajanKentta.lisaaLaivat(vastustajanKentta);

        System.out.println("Peli alkaa!");
        System.out.println("");
        while (peliJatkuu == 1) {
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
                if(komento.equals("quit")){
                    peliJatkuu=0;
                    break;
                }

            }
            while (vuoro == 1) {
                System.out.println("     Vastustajan vuoro!");          
                int x = (int) Math.floor((Math.random() * 10) + 1);
                int y = (int) Math.floor((Math.random() * 10) + 1);
                System.out.println("     "+omaKentta.ammu(x, y));
                vuoro = 0;
            }



        }
        
    }

}
   