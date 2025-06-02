/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author gian
 */
public class VLSMPanel extends JPanel{
    public VLSMPanel(){
        this.setBackground(Color.green);
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //AddressSubPanel addr = new AddressSubPanel();
        //this.add(addr);
    }
}
