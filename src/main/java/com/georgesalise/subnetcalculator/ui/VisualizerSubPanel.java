/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import com.georgesalise.subnetcalculator.logic.Utils;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gian
 */
public class VisualizerSubPanel extends JPanel{
    // octets
    private String[] octetColumn = {"Octet 1", "Octet 2", "Octet 3", "Octet 4"};
    private Object[][] octetData = { {"Octet 1", "Octet 2", "Octet 3", "Octet 4"} };
    
    // bits
    private Integer[] bitsColumn = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                    11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                                    21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                                    31, 32};
    private Integer[][] bitsData = { {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                    11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                                    21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                                    31, 32} };
    

    private JTable octet = new JTable(octetData, octetColumn);
    private JTable bits = new JTable(bitsData, bitsColumn);
    private JLabel title = new JLabel("Visualization of the Subnet");
    
    public VisualizerSubPanel(){
        this.setBackground(Color.red);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        title.setFont(new Font("Monospaced", Font.PLAIN, 20));
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // octets
        Utils.centerTableCells(octet);
        octet.setTableHeader(null);
        octet.setShowGrid(true);
        octet.setRowHeight(30);
        octet.setGridColor(Color.black);
        octet.setEnabled(false);
        
        // bits
        Utils.centerTableCells(bits);
        bits.setTableHeader(null);
        bits.setShowGrid(true);
        bits.setRowHeight(30);
        bits.setGridColor(Color.black);
        bits.setEnabled(false);
        
        
        this.add(title);
        this.add(octet);
        this.add(bits);
    }
    
}
