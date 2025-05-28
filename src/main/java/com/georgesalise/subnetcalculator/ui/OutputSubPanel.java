/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gian
 */
public class OutputSubPanel extends JPanel {
    JTable output = new JTable();
    JLabel title = new JLabel("Results");
    
    public OutputSubPanel(){
        this.setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());
        
        title.setFont(new Font("Monospaced", Font.PLAIN, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(new EmptyBorder(15, 0, 0, 0));
        
        this.add(title, BorderLayout.NORTH);
    }
    
}
