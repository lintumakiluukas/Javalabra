package laivanupotus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private ArrayList laivat;
    private ArrayList vastustajanLaivat;
    private Kentta omaKentta;
    private Kentta vastustajanKentta;
    private Laivanupotus laivanupotus;
    private Image image;

    /**
     * Luo piirtoalustan, johon peli piirretään
     *
     * @param laivat Lista pelaajan kentän Laiva -olioista
     * @param vastustajanLaivat Lista vastustajan kentän Laiva -olioista
     * @param a Pelaajan kenttä -olio
     * @param b Vastustajan kenttä -olio
     * @param laivanupotus Laivanupotuspeli
     */
    public Piirtoalusta(ArrayList laivat, ArrayList vastustajanLaivat, Kentta a, Kentta b, Laivanupotus laivanupotus) {
        super.setBackground(Color.WHITE);
        this.laivat = laivat;
        this.laivanupotus = laivanupotus;
        this.vastustajanLaivat = vastustajanLaivat;
        this.omaKentta = a;
        this.vastustajanKentta = b;

        this.image = null;
        try {
            URL url = new URL("http://i.imgur.com/0pseFEJ.png");
            image = ImageIO.read(url);
        } catch (IOException e) {
        }
    }

    /**
     * Piirretään piirtoalustalle pelaajan ja vastustajan kentät, kenttien
     * reunukset, pelaajien laivat, taustakuva, merkit ammuttuihin
     * koordinaatteihin sekä pelin päätyttyä näkyvä voittajan julistusteksti
     *
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, null);
        graphics.setColor(Color.black);
        graphics.fillRect(200, 100, 1, 100);//väliviiva
        graphics.drawRect(100, 100, 200, 100);//reunat
        graphics.setColor(Color.white);
        graphics.drawRect(2, 225, 405, 75);//alapalkki

        graphics.drawString(laivanupotus.t2, 5, 236);
        graphics.drawString(laivanupotus.t3, 5, 248);
        graphics.drawString(laivanupotus.t4, 5, 260);//chatbox
        graphics.drawString(laivanupotus.t5, 5, 272);
        graphics.drawString(laivanupotus.t6, 5, 284);
        graphics.drawString(laivanupotus.t7, 5, 296);

        graphics.drawString("A", 100, 95);
        graphics.drawString("B", 110, 95);
        graphics.drawString("C", 120, 95);
        graphics.drawString("D", 130, 95);
        graphics.drawString("E", 140, 95);
        graphics.drawString("F", 150, 95);
        graphics.drawString("G", 160, 95);
        graphics.drawString("H", 170, 95);
        graphics.drawString("I", 183, 95);
        graphics.drawString("J", 190, 95);

        for (int i = 0; i < 100; i += 10) {
            if (i != 90) {
                graphics.drawString("" + (i / 10 + 1), 90, 110 + i);
            } else {
                graphics.drawString("" + (i / 10 + 1), 85, 110 + i);
            }
        }

        graphics.drawString(omaKentta.getNimi(), 110, 215);
        graphics.drawString(vastustajanKentta.getNimi(), 210, 215);

        Color harmaa = new Color(200, 220, 220);
        graphics.setColor(harmaa);
        for (int a = 0; a < 100; a += 10) {//Ruudukko
            if (a % 20 == 0) {
                for (int i = 0; i < 200; i += 20) {
                    graphics.fillRect(101 + i, 101 + a, 10, 9);
                }
            } else {
                for (int i = 0; i < 200; i += 20) {
                    graphics.fillRect(110 + i, 101 + a, 10, 9);
                }
            }
        }
        graphics.setColor(Color.black);
        for (int i = 0; i < this.laivat.size(); i++) {
            Laiva laiva = (Laiva) this.laivat.get(i);
            HashMap pisteet = laiva.pisteet();

            for (Object a : pisteet.keySet()) {
                graphics.fillRect((int) a * 10 + 200, (int) pisteet.get(a) * 10 + 90, 9, 9);
            }
        }
        for (int i = 0; i < this.vastustajanLaivat.size(); i++) {
            Laiva laiva = (Laiva) this.vastustajanLaivat.get(i);
            HashMap pisteet = laiva.pisteet();
            for (Object a : pisteet.keySet()) {
                graphics.fillRect((int) a * 10 + 100, (int) pisteet.get(a) * 10 + 90, 9, 9);
            }
        }

        graphics.setColor(Color.red);
        for (int i = 0; i < laivanupotus.getAmmututX().size(); i++) {
            graphics.drawOval((int) laivanupotus.getAmmututX().get(i) * 10 + 100, (int) laivanupotus.getAmmututY().get(i) * 10 + 90, 9, 9);
            graphics.drawOval((int) laivanupotus.getAmmututX().get(i) * 10 + 100 + 1, (int) laivanupotus.getAmmututY().get(i) * 10 + 90 + 1, 7, 7);
        }

        graphics.setColor(Color.black);
        for (int i = 0; i < laivanupotus.getOhiAmmututX().size(); i++) {
            graphics.drawLine((int) laivanupotus.getOhiAmmututX().get(i) * 10 + 100, (int) laivanupotus.getOhiAmmututY().get(i) * 10 + 90, (int) laivanupotus.getOhiAmmututX().get(i) * 10 + 109, (int) laivanupotus.getOhiAmmututY().get(i) * 10 + 99);
            graphics.drawLine((int) laivanupotus.getOhiAmmututX().get(i) * 10 + 109, (int) laivanupotus.getOhiAmmututY().get(i) * 10 + 90, (int) laivanupotus.getOhiAmmututX().get(i) * 10 + 100, (int) laivanupotus.getOhiAmmututY().get(i) * 10 + 99);
        }

        graphics.setColor(Color.red);
        for (int i = 0; i < laivanupotus.getVastustajanAmmututX().size(); i++) {
            graphics.drawOval((int) laivanupotus.getVastustajanAmmututX().get(i) * 10 + 200, (int) laivanupotus.getVastustajanAmmututY().get(i) * 10 + 90, 9, 9);
            graphics.drawOval((int) laivanupotus.getVastustajanAmmututX().get(i) * 10 + 200 + 1, (int) laivanupotus.getVastustajanAmmututY().get(i) * 10 + 90 + 1, 7, 7);
        }

        graphics.setColor(Color.black);
        for (int i = 0; i < laivanupotus.getVastustajanOhiAmmututX().size(); i++) {
            graphics.drawLine((int) laivanupotus.getVastustajanOhiAmmututX().get(i) * 10 + 200, (int) laivanupotus.getVastustajanOhiAmmututY().get(i) * 10 + 90, (int) laivanupotus.getVastustajanOhiAmmututX().get(i) * 10 + 209, (int) laivanupotus.getVastustajanOhiAmmututY().get(i) * 10 + 99);
            graphics.drawLine((int) laivanupotus.getVastustajanOhiAmmututX().get(i) * 10 + 209, (int) laivanupotus.getVastustajanOhiAmmututY().get(i) * 10 + 90, (int) laivanupotus.getVastustajanOhiAmmututX().get(i) * 10 + 200, (int) laivanupotus.getVastustajanOhiAmmututY().get(i) * 10 + 99);
        }

        if (this.laivanupotus.tarkistaTilanne() == 1) {
            graphics.drawRect(49, 124, 301, 51);
            graphics.setColor(Color.white);
            graphics.fillRect(50, 125, 300, 50);
            graphics.setColor(Color.black);
            graphics.drawString("VOITIT PELIN!", 160, 150);
        }
        if (this.laivanupotus.tarkistaTilanne() == 2) {
            graphics.drawRect(49, 124, 301, 51);
            graphics.setColor(Color.white);
            graphics.fillRect(50, 125, 300, 50);
            graphics.setColor(Color.black);
            graphics.drawString("HÄVISIT PELIN!", 160, 150);
        }
        paivita();
    }

    /**
     * Päivitetään piirtoalusta
     */
    @Override
    public void paivita() {
        repaint();
    }
}
