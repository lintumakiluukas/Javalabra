/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;
import laivanupotus.gui.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}