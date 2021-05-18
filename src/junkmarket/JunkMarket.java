/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junkmarket;

import junk.frontend.MainFrame;

/**
 *
 * @author kiedr
 */
public class JunkMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainFrame mf=new MainFrame();
        mf.setSize(640,480);
        mf.setTitle("Main Frame");
        mf.setVisible(true);
    }
    
}
