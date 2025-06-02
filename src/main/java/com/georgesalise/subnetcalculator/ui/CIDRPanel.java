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
    
    public CIDRPanel(){
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
        // Output SubPanel
        OutputSubPanel output = new OutputSubPanel();
        //output.setPreferredSize(new Dimension(Integer.MAX_VALUE, 500));
        
        // Visualizer SubPanel
        VisualizerSubPanel vis = new VisualizerSubPanel();
        //vis.setMaximumSize(new Dimension(Integer.MAX_VALUE, vis.getPreferredSize().height));
        
        // Address SubPanel
        AddressSubPanel addr = new AddressSubPanel(output, vis);
        addr.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        //addr.setPreferredSize(new Dimension(Integer.MAX_VALUE, -500));
        


        
        
        
        this.add(addr);
        this.add(vis);
        this.add(output);
        
    }
}
