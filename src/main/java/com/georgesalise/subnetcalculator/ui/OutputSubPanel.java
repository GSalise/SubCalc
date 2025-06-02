/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import com.georgesalise.subnetcalculator.logic.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

/**
 *
 * @author gian
 */
public class OutputSubPanel extends JPanel {
    private JScrollPane scroll = new JScrollPane();
    private JLabel title = new JLabel("Results");
    
    public OutputSubPanel(){
        this.setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());
        
        title.setFont(new Font("Monospaced", Font.PLAIN, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(new EmptyBorder(15, 0, 0, 0));

        
        
        this.add(title, BorderLayout.NORTH);
    }
    
    public void loadTable(JTable results){
        if(this.scroll != null){
            this.remove(this.scroll);
        }
        
        // table modifications
        Utils.centerTableCells(results);
        results.setShowGrid(true);
        results.setGridColor(Color.black);
        
        /// table header modifications
        JTableHeader header = results.getTableHeader();
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.white);
        
        // scroll pane
        scroll = new JScrollPane(results);
        this.add(scroll, BorderLayout.CENTER);

        // refreshing
        this.revalidate();
        this.repaint();
    }

    
}
