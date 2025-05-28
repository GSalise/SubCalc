/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.logic;

import com.georgesalise.subnetcalculator.model.IPAddress;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author gian
 */
public class Utils {
    
    public static int calculateIncrement(int prefix) {
        if (prefix < 8) {
            return (int)Math.pow(2, 8 - prefix);
        } else if (prefix < 16) {
            return (int)Math.pow(2, 16 - prefix);
        } else if (prefix < 24) {
            return (int)Math.pow(2, 24 - prefix);
        } else {
            return (int)Math.pow(2, 32 - prefix);
        }
    }
    
    public static String print(int base){
        String stringIP =   ((base >> 24) & 0xFF) + "." +
                            ((base >> 16) & 0xFF) + "." +
                            ((base >> 8) & 0xFF) + "." +
                            (base & 0xFF);
        return stringIP;
    }
    
    public static Integer[] toIntegerArray(int[] values) {
        Integer[] boxed = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            boxed[i] = values[i]; 
        }
        return boxed;
    }
    
    public static void centerTableCells(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

}
