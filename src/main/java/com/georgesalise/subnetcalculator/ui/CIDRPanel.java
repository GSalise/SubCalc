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
    JPanel b = new JPanel();
    
    public CIDRPanel(){
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // Address SubPanel
        AddressSubPanel addr = new AddressSubPanel();
        addr.setPreferredSize(new Dimension(Integer.MAX_VALUE, -500));
        
        // Visualizer SubPanel
        VisualizerSubPanel vis = new VisualizerSubPanel();
        //vis.setPreferredSize(new Dimension(Integer.MAX_VALUE, 100));
        
        // Output SubPanel
        b.setPreferredSize(new Dimension(100,100));
        b.setBackground(Color.ORANGE);
        
        
        
        
        
        this.add(addr);
        this.add(vis);
        this.add(b);
        
    }
}
