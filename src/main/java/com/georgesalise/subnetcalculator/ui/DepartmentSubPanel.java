/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author gian
 */
public class DepartmentSubPanel extends JFrame{
    private JScrollPane deptInputs = new JScrollPane();
    
    public DepartmentSubPanel(int num){
        this.setTitle("Subnet Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //setSize then setLocationRelativeTo so that it appears centered
        this.setSize(1264, 1000);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        this.setBackground(Color.blue);
        this.setLayout(new BorderLayout());
        
        for (int i = 0; i < num; i++){
            JLabel label = new JLabel("Hosts for Department " + (i + 1) + ": ");
            label.setFont(new Font("Monospaced", Font.PLAIN, 15));

            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(200, 30));
            textField.setFont(new Font("Monospaced", Font.PLAIN, 15));

            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.setBackground(Color.LIGHT_GRAY);
            row.add(label);
            row.add(textField);
            
            this.add(row);
        }
        
        this.setVisible(true);
    }
    
    public void generateDeptInputs(int num){
        deptInputs.removeAll();
        
        
        for (int i = 0; i < num; i++){
            JLabel label = new JLabel("Hosts for Department " + (i + 1) + ": ");
            label.setFont(new Font("Monospaced", Font.PLAIN, 15));

            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(200, 30));
            textField.setFont(new Font("Monospaced", Font.PLAIN, 15));

            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.setBackground(Color.LIGHT_GRAY);
            row.add(label);
            row.add(textField);
            
            deptInputs.add(row);
        }
        
        deptInputs.add(new JButton("Calculate"));
        
        this.add(deptInputs, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    
    
}
