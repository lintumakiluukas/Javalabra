/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luce
 */
public class Laivanupotus {

    private Kentta omaKentta = new Kentta("Punakone");
    Kentta vastustajanKentta = new Kentta("Pelaaja-Petteri");
    private ArrayList<Integer> ammututX = new ArrayList<Integer>();
    private ArrayList<Integer> ammututY = new ArrayList<Integer>();
    private ArrayList<Integer> ohiAmmututX = new ArrayList<Integer>();
    private ArrayList<Integer> ohiAmmututY = new ArrayList<Integer>();
    public Laivanupotus() {
        omaKentta.lisaaLaivat(omaKentta);
        vastustajanKentta.lisaaLaivat(vastustajanKentta);

    }

    public Kentta getOmaKentta() {
        return this.omaKentta;
    }
    public Kentta getVastustajanKentta() {
        return this.vastustajanKentta;
    }

    public void toteutaVuorot(String px, String py) {
        int vuoro = 0;
        while (vuoro == 0) {
            px=px.toUpperCase();
            int x;
            if(px.equals("A")){
                x=0;
            }else if(px.equals("B")){
                x=1;
            }else if(px.equals("C")){
                x=2;
            }else if(px.equals("D")){
                x=3;
            }else if(px.equals("E")){
                x=4;
            }else if(px.equals("F")){
                x=5;
            }else if(px.equals("G")){
                x=6;
            }else if(px.equals("H")){
                x=7;
            }else if(px.equals("I")){
                x=8;
            }else if(px.equals("J")){
                x=9;
            }else{
                System.out.println("Virheellinen X-koordinaatti!");
                break;
            }

            int y;
            if(py.equals("1")){
                y=1;
            }else if(py.equals("2")){
                y=2;
            }else if(py.equals("3")){
                y=3;
            }else if(py.equals("4")){
                y=4;
            }else if(py.equals("5")){
                y=5;
            }else if(py.equals("6")){
                y=6;
            }else if(py.equals("7")){
                y=7;
            }else if(py.equals("8")){
                y=8;
            }else if(py.equals("9")){
                y=9;
            }else if(py.equals("10")){
                y=10;
            }else{
                System.out.println("Virheellinen Y-koordinaatti!");
                break;
            }
            String raportti=vastustajanKentta.ammu(x,y);
            if(raportti.equals(this.vastustajanKentta.getNimi()+" ampui koordinaatteihin ("+x+","+y+") onnistuneesti. Vahingoitettiin alusta!") || raportti.equals(this.vastustajanKentta.getNimi()+" ampui koordinaatteihin ("+x+","+y+") onnistuneesti. Tuhottiin alus!")){
                this.ammututX.add(x);
                this.ammututY.add(y);
            }else{
                this.ohiAmmututX.add(x);
                this.ohiAmmututY.add(y);
            }

            vuoro=1;

        }
        while (vuoro == 1) {
           // System.out.println("     Vastustajan vuoro!");
            int x = (int) Math.floor((Math.random() * 10) + 1);
            int y = (int) Math.floor((Math.random() * 10) + 1);
            //System.out.println("     " + omaKentta.ammu(x, y));
            vuoro = 0;
        }



    }
    
    public ArrayList getAmmututX(){
        return this.ammututX;
    }   
    public ArrayList getAmmututY(){
        return this.ammututY;
    }  
    public ArrayList getOhiAmmututX(){
        return this.ohiAmmututX;
    }  
    public ArrayList getOhiAmmututY(){
        return this.ohiAmmututY;
    }
}

