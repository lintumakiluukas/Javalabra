package laivanupotus;

public class Laivanupotus {

    public static void main(String[] args) {
        Kentta omaKentta = new Kentta();

        Laiva laiva5 = new Laiva(2, 0,0);

        omaKentta.lisaaLaiva(laiva5);
      
        System.out.println(laiva5);
        System.out.println(omaKentta.ammu(0,0));
        System.out.println(omaKentta.ammu(1,0));
        //   Kentta vastustajanKentta = new Kentta();

//        Laiva lentotukialus = new Laiva(5);
//        Laiva taistelulaiva = new Laiva(4);
//        Laiva risteilija1 = new Laiva(3);
//        Laiva risteilija2 = new Laiva(3);
//        Laiva havittaja = new Laiva(2);
//        Laiva sukellusvene = new Laiva(1);
//        
//        omaKentta.lisaaLaiva(lentotukialus);

    }
}
