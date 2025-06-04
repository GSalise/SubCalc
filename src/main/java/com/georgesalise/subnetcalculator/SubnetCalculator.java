/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.georgesalise.subnetcalculator;

import com.formdev.flatlaf.FlatLightLaf;
import com.georgesalise.subnetcalculator.logic.VLSM;
import com.georgesalise.subnetcalculator.model.IPAddress;
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
  
//        IPAddress ipadd = new IPAddress("192.168.0.0", 24);
//
//
//        int[] arr = {20,100, 30};
//
//
//        VLSM vlsm = new VLSM(ipadd, arr, 3);
//
//
//        vlsm.findMaskAndIncrement(arr[0]);
//
//
//        System.out.println("\n" + vlsm.getIncrement() + " " + vlsm.getMask());
//
//
//        vlsm.calculate();
//
//
//        vlsm.print();
   
    }
}
