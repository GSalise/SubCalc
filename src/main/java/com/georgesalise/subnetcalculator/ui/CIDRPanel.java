/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


/**
 *
 * @author gian
 */
public class CIDRPanel extends JPanel{
    JPanel a = new JPanel();
    JPanel b = new JPanel();
    
    public CIDRPanel(){
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        AddressSubPanel addr = new AddressSubPanel();
        addr.setPreferredSize(new Dimension(100, -100));
        
        a.setPreferredSize(new Dimension(100,100));
        b.setPreferredSize(new Dimension(100,100));
        a.setBackground(Color.red);
        b.setBackground(Color.ORANGE);
        
        
        
        
        
        this.add(addr);
        this.add(a);
        this.add(b);
        
    }
}
