/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.logic;

import com.georgesalise.subnetcalculator.model.IPAddress;
import com.georgesalise.subnetcalculator.model.IPResult;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

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
    
    public static String longToStringIP(long base){
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
    
    public static Object[][] convertToTableData(ArrayList<IPResult> arrayResult){
        Object[][] tableData = new Object[arrayResult.size()][4];

        for (int i = 0; i < arrayResult.size(); i++) {
            IPResult result = arrayResult.get(i);
            tableData[i][0] = result.getSubnetwork() + "/" + result.getPrefix();
            tableData[i][1] = result.getStartAddress();
            tableData[i][2] = result.getEndAddress();
            tableData[i][3] = result.getBroadcastAddress();
        }
        
        return tableData;
    }
    
    public static Object[][] convertToTableData(ArrayList<IPResult> arrayResult, int[] hosts){
        Object[][] tableData = new Object[arrayResult.size()][4];

        for (int i = 0; i < arrayResult.size(); i++) {
            IPResult result = arrayResult.get(i);
            tableData[i][0] = hosts[i];
            tableData[i][1] = result.getSubnetwork() + "/" + result.getPrefix();
            tableData[i][2] = result.getStartAddress() + " - " + result.getEndAddress();
            tableData[i][3] = result.getBroadcastAddress();
        }
        
        return tableData;
    }
    
    public static class DigitFilter extends DocumentFilter {
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("\\d+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

}
