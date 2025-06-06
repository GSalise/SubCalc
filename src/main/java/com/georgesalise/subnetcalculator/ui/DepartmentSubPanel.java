/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import com.georgesalise.subnetcalculator.logic.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author gian
 */
public class DepartmentSubPanel extends JPanel {
    private JPanel deptInputs = new JPanel();
    private JScrollPane scroll;
    private ArrayList<JTextField> hostFields = new ArrayList<>();

    public DepartmentSubPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLUE);
        //this.setBorder(new EmptyBorder(20, 0, 0 ,0));
        

        
        // Set vertical layout
        deptInputs.setLayout(new BoxLayout(deptInputs, BoxLayout.Y_AXIS));
        deptInputs.setBackground(new Color(187, 191, 202));

        // Scroll pane wraps deptInputs
        scroll = new JScrollPane(deptInputs);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setMaximumSize(new Dimension(400, 300)); // Adjust as needed
        
        this.add(scroll, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void generateDeptInputs(int num) {
        deptInputs.removeAll();
        deptInputs.add(Box.createVerticalStrut(5));
        JLabel title = new JLabel("Hosts");
        title.setFont(new Font("Monospaced", Font.PLAIN, 15));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        deptInputs.add(title);
        deptInputs.add(Box.createVerticalStrut(5));
        
        for (int i = 0; i < num; i++) {
            JLabel label = new JLabel("Hosts for Department " + (i + 1) + ": ");
            label.setFont(new Font("Monospaced", Font.PLAIN, 15));

            JTextField host = new JTextField();
            host.setMaximumSize(new Dimension(200, 30)); 
            host.setFont(new Font("Monospaced", Font.PLAIN, 15));
            ((AbstractDocument) host.getDocument()).setDocumentFilter(new Utils.DigitFilter());
            this.hostFields.add(host);

            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5)); 
            row.setAlignmentX(Component.CENTER_ALIGNMENT);
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); 
            row.setBackground(new Color(187, 191, 202));
            row.add(label);
            row.add(host);

            deptInputs.add(row);
            deptInputs.add(Box.createVerticalStrut(5));
        }

        deptInputs.revalidate();
        deptInputs.repaint();
        this.revalidate();
        this.repaint();
    }
    
    public void removeHostGeneration(){
        deptInputs.removeAll();
        deptInputs.revalidate();
        deptInputs.repaint();
        this.revalidate();
        this.repaint();
    }

    public ArrayList<JTextField> getHostFields() {
        return hostFields;
    }
    
    
    
}

