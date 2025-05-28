/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.georgesalise.subnetcalculator;

import com.formdev.flatlaf.FlatLightLaf;
import com.georgesalise.subnetcalculator.ui.MainFrame;
import javax.swing.UIManager;
/**
 *
 * @author gian
 */
public class SubnetCalculator {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
        MainFrame frame = new MainFrame();
  
   
    }
}
