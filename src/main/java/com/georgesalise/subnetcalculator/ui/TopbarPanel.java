/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gian
 */
public class TopbarPanel extends JPanel implements ActionListener{
    private JLabel title = new JLabel();
    private JButton cidrMode = new JButton("CIDR");
    private JButton vlsmMode = new JButton("VLSM");
    private CardLayout modes;
    private JPanel modesPanel;
    
    public TopbarPanel(CardLayout modes, JPanel modesPanel){
        // topbar styling and format
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(100,100));
        this.modes = modes;
        this.modesPanel = modesPanel;
        this.setLayout(new BorderLayout());
        
        // title
        title.setText("Subnet Calculator");
        title.setFont(new Font("Monospaced", Font.PLAIN, 18));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        // cidrBtn
        cidrMode.setFocusable(false);
        cidrMode.addActionListener(this);
        
        //vlsmBtn
        vlsmMode.setFocusable(false);
        vlsmMode.addActionListener(this);
                
        // panel holding the btns
        JPanel btnContainer = new JPanel(new GridLayout(1, 2, 5, 0));
        btnContainer.setBackground(Color.white);
        btnContainer.add(cidrMode);
        btnContainer.add(vlsmMode);
        btnContainer.setPreferredSize(new Dimension(50,50));
        
        
        this.add(title, BorderLayout.NORTH);
        this.add(btnContainer, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cidrMode){
            System.out.println("CIDR MODE");
            this.modes.show(modesPanel, "CIDR");
        }else if(e.getSource()==vlsmMode){
            System.out.println("VLSM MODE");
            this.modes.show(modesPanel, "VLSM");
        }
    }
    

}
