/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import java.awt.BorderLayout;
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
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        
        OutputSubPanel output = new OutputSubPanel();
        
        DepartmentSubPanel dept = new DepartmentSubPanel();
        
        AddressSubPanel addr = new AddressSubPanel(output, dept);
        
        
        //
        
        
        
        
        this.add(addr, BorderLayout.NORTH);
        this.add(dept, BorderLayout.WEST);
        this.add(output, BorderLayout.CENTER);
    }
}
