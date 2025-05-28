/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import static com.georgesalise.subnetcalculator.logic.Utils.toIntegerArray;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gian
 */
public class AddressSubPanel extends JPanel{
    private int[] masks = {1,2,3,4,5,6,7,8,9,10,
                           11,12,13,14,15,16,17,18,19,20,
                           21,22,23,24,25,26,27,28,29,30};
    private JTextField address = new JTextField();
    private JComboBox<Integer> mask = new JComboBox<>(toIntegerArray(masks));
    private JTextField numOfSubnets = new JTextField();
    private JLabel addressLabel = new JLabel("Address: ");
    private JLabel maskLabel = new JLabel("Subnet Mask: ");
    private JLabel numOfSubnetsLabel = new JLabel("Number of Subnetworks Needed: ");
    
    
    public AddressSubPanel (){
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(20, 0, 0 ,0));
        
        // address
        addressLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        addressLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        address.setPreferredSize(new Dimension(200,40));
        address.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // subnet mask
        maskLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        maskLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        mask.setPreferredSize(new Dimension(80, 40));
        mask.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // number of subnets needed
        numOfSubnetsLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        numOfSubnetsLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        numOfSubnets.setPreferredSize(new Dimension(200,40));
        numOfSubnets.setFont(new Font("Monospaced", Font.PLAIN, 15));
        numOfSubnets.setBorder(new EmptyBorder(0, 0, 0, 10));
        
        
        this.add(addressLabel);
        this.add(address);
        this.add(maskLabel);
        this.add(mask);
        this.add(numOfSubnetsLabel);
        this.add(numOfSubnets);
        // label error here
        //this.add();
    }
}
