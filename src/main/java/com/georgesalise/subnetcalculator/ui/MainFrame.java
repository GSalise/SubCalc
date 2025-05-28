/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author gian
 */
public class MainFrame extends JFrame{
    
    public MainFrame(){
        this.setTitle("Subnet Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //setSize then setLocationRelativeTo so that it appears centered
        this.setSize(1040, 1000);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        // panels and cards
        CardLayout modes = new CardLayout();
        JPanel modePanel = new JPanel(modes);
        CIDRPanel cidr = new CIDRPanel();
        VLSMPanel vlsm = new VLSMPanel();
        
        modePanel.add(cidr, "CIDR");
        modePanel.add(vlsm, "VLSM");
        TopbarPanel topbar = new TopbarPanel(modes, modePanel);
        
        // layout
        this.add(topbar, BorderLayout.NORTH);
        this.add(modePanel, BorderLayout.CENTER);
        modes.show(modePanel, "CIDR");  // default mode

        // show resize size
//        this.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                int width = getWidth();
//                int height = getHeight();
//                System.out.println("Window resized: Width = " + width + ", Height = " + height);
//            }
//        });
                
                
        this.setVisible(true);
        
        
    }
    
    
    
}
