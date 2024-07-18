/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtbullerresortbyaugust;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *This class servers as the entry for the MtBuller winter resort application.
 * @author August Oo
 * @version 1
 * 
 */
public class MtBullerAdmin {

    public static void main(String[] args){
            ResortGUI f = new ResortGUI();
            f.setTitle("Mt Buller Winter Resort");
            f.setVisible(true);
            f.setLocationRelativeTo(null);
            f.setSize(800,700);
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            

    }



    
}
