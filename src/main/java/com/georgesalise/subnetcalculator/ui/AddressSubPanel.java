/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import com.georgesalise.subnetcalculator.customExceptions.AddressOverflowException;
import com.georgesalise.subnetcalculator.customExceptions.DepartmentLimitException;
import com.georgesalise.subnetcalculator.logic.CIDR;
import com.georgesalise.subnetcalculator.logic.Utils;
import static com.georgesalise.subnetcalculator.logic.Utils.toIntegerArray;
import com.georgesalise.subnetcalculator.logic.VLSM;
import com.georgesalise.subnetcalculator.model.IPAddress;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gian
 */
public class AddressSubPanel extends JPanel implements ActionListener{
    private int[] masks = {1,2,3,4,5,6,7,8,9,10,
                           11,12,13,14,15,16,17,18,19,20,
                           21,22,23,24,25,26,27,28,29,30};
    private JTextField address = new JTextField("x.x.x.x");
    private JComboBox<Integer> mask = new JComboBox<>(toIntegerArray(masks));
    private JTextField numOfSubnets = new JTextField();
    private JLabel addressLabel = new JLabel("Address: ");
    private JLabel maskLabel = new JLabel("Subnet Mask: ");
    private JLabel numOfSubnetsLabel = new JLabel("Number of Subnetworks Needed: ");
    private JButton submitCIDR = new JButton("Submit");
    private JTable cidrTable = new JTable();
    private OutputSubPanel output;
    private VisualizerSubPanel visual;
    
    // VLSM
    private JTextField numOfDept = new JTextField();
    private JLabel numOfDeptLabel = new JLabel("Number of Departments Needed: ");
    private JButton generateHosts = new JButton("Generate");
    private JButton submitVLSM = new JButton("Submit");
    private DepartmentSubPanel dept;
    private JTable vlsmTable = new JTable();
    private JButton reset = new JButton("Reset");


    // CIDR AddressSubPanel
    public AddressSubPanel (OutputSubPanel output, VisualizerSubPanel visual){
        this.output = output;
        this.visual = visual;
        this.setBackground(new Color(244, 244, 242));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //this.setBorder(new EmptyBorder(20, 0, 0 ,0));
        
        // address
        addressLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        address.setPreferredSize(new Dimension(200,40));
        address.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // placeholder
        address.setForeground(Color.GRAY);
        address.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (address.getText().equals("x.x.x.x")) {
                    address.setText("");
                    address.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (address.getText().isEmpty()) {
                    address.setForeground(Color.GRAY);
                    address.setText("x.x.x.x");
                }
            }
            });
        
        // subnet mask
        maskLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        mask.setPreferredSize(new Dimension(80, 40));
        mask.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // number of subnets needed
        numOfSubnetsLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        numOfSubnets.setPreferredSize(new Dimension(150,40));
        numOfSubnets.setFont(new Font("Monospaced", Font.PLAIN, 15));
        ((AbstractDocument) numOfSubnets.getDocument()).setDocumentFilter(new Utils.DigitFilter());
        
        // submit
        submitCIDR.setFont(new Font("Monospaced", Font.PLAIN, 15));
        submitCIDR.setPreferredSize(new Dimension(100, 40));
        submitCIDR.addActionListener(this);
        
        
        this.add(addressLabel);
        this.add(address);
        this.add(Box.createHorizontalStrut(5));
        this.add(maskLabel);
        this.add(mask);
        this.add(Box.createHorizontalStrut(5));
        this.add(numOfSubnetsLabel);
        this.add(numOfSubnets);
        this.add(Box.createHorizontalStrut(5));
        this.add(submitCIDR);
    }
    
    public AddressSubPanel (OutputSubPanel output, DepartmentSubPanel dept){
        this.output = output;
        this.dept = dept;
        this.setBackground(new Color(244, 244, 242));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //this.setBorder(new EmptyBorder(20, 0, 0 ,0));
        
        // address
        addressLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        address.setPreferredSize(new Dimension(140,40));
        address.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // placeholder
        address.setForeground(Color.GRAY);
        address.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (address.getText().equals("x.x.x.x")) {
                    address.setText("");
                    address.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (address.getText().isEmpty()) {
                    address.setForeground(Color.GRAY);
                    address.setText("x.x.x.x");
                }
            }
            });
        
        
        // subnet mask
        maskLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        mask.setPreferredSize(new Dimension(80, 40));
        mask.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // number of subnets needed
        numOfDeptLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        numOfDept.setPreferredSize(new Dimension(100,40));
        numOfDept.setFont(new Font("Monospaced", Font.PLAIN, 15));
        ((AbstractDocument) numOfDept.getDocument()).setDocumentFilter(new Utils.DigitFilter());
        
        
        // generate host
        generateHosts.setFont(new Font("Monospaced", Font.PLAIN, 15));
        generateHosts.setPreferredSize(new Dimension(120, 40));
        generateHosts.addActionListener(this);
        
        // sumbit
        submitVLSM.setFont(new Font("Monospaced", Font.PLAIN, 15));
        submitVLSM.setPreferredSize(new Dimension(100, 40));
        
        reset.setFont(new Font("Monospaced", Font.PLAIN, 15));
        reset.setPreferredSize(new Dimension(100, 40));
        
        this.add(addressLabel);
        this.add(address);
        this.add(Box.createHorizontalStrut(5));
        this.add(maskLabel);
        this.add(mask);
        this.add(Box.createHorizontalStrut(5));
        this.add(numOfDeptLabel);
        this.add(numOfDept);
        this.add(Box.createHorizontalStrut(5));
        this.add(generateHosts);
    }

//    private static class DigitFilter extends DocumentFilter {
//        @Override
//        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
//            if (string.matches("\\d+")) {
//                super.insertString(fb, offset, string, attr);
//            }
//        }
//
//        @Override
//        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
//            if (text.matches("\\d+")) {
//                super.replace(fb, offset, length, text, attrs);
//            }
//        }
//    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String ipadd = address.getText();
        int subnet = (int) mask.getSelectedItem();
        
        
        
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1?[1-9][0-9]?))(\\.(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?|0)){3}$");
        Matcher matcher = pattern.matcher(ipadd);
        
        
        
        // CIDR BUTTON HANDLER
        if (e.getSource() == submitCIDR){
            if (matcher.matches()){
                try {
                    // Logic
                    CIDR cidr = new CIDR(new IPAddress(ipadd, subnet), Integer.parseInt(numOfSubnets.getText()));
                    
                    // Visual
                    String[] cidrColumnNames = {"Subnetwork", "Start Address", "End Address", "Broadcast Address"};
                    cidrTable = new JTable(Utils.convertToTableData(cidr.getresultsList()), cidrColumnNames);
                    visual.loadVisual(cidr.getNewPrefix(), subnet);
                    output.loadTable(cidrTable);
                    
                } catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(this, """
                                                        Missing Fields Detected!
                                                        
                                                        Please fill out all of the missing fields!""",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE);
                    
                } catch(AddressOverflowException error){
                    JOptionPane.showMessageDialog(this, """
                                                        Address Overflow Detected!
                                                        
                                                        The combination of the starting IP address and the number of required subnets
                                                        exceeds the available IPv4 address space.
                                                        
                                                        Please choose a different base address or reduce the number of requested subnets.""",
                        "Overflow Error",
                        JOptionPane.WARNING_MESSAGE
                    );

                } catch(Exception error) {
                    System.err.println("An error occurred while processing CIDR logic:");
                    error.printStackTrace(); // This prints the full stack trace to console
                    JOptionPane.showMessageDialog(this, """
                                                        Something Went Wrong!
                                                        
                                                        Please contact the developer to resolve it!
                                                        
                                                        Error: """ + error.getMessage(),
                        "Unknown Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }else{
                JOptionPane.showMessageDialog(this, """
                                                    Invalid IP Address Detected!
                                                    
                                                    Please enter a valid IPv4 address in the format:
                                                    
                                                    x.x.x.x (e.g., 192.168.1.1)""",
                    "Invalid IP Address Detected",
                    JOptionPane.WARNING_MESSAGE);
            }

            
        }
        // HOST GENERATION HANDLER
        if (e.getSource() == generateHosts){
            if(matcher.matches()){     
                try { 
                    if (Integer.parseInt(numOfDept.getText()) > 100){
                        throw new DepartmentLimitException("exceeds_100");
                    }
                    
                    if (Integer.parseInt(numOfDept.getText()) <= 0){
                        throw new DepartmentLimitException("zero_or_less");
                    }
                    this.dept.generateDeptInputs(Integer.parseInt(numOfDept.getText()));
                    
                    // prevent duplicate listeners 
                    for (ActionListener al : submitVLSM.getActionListeners()) {
                        submitVLSM.removeActionListener(al);
                    }
                    for (ActionListener al : reset.getActionListeners()) {
                        reset.removeActionListener(al);
                    }
                    
                    // locking the fields to prevent any changes until the submit button is clicked
                    this.numOfDept.setEnabled(false);
                    this.address.setEnabled(false);
                    this.mask.setEnabled(false);
                    
                    // add the sumbit button
                    submitVLSM.addActionListener(this);
                    this.add(submitVLSM);     
                    
                    reset.addActionListener(this);
                    this.add(reset);   
                    
                    
                } catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(this, """
                                                        Missing Fields Detected!
                                                        
                                                        Please fill out all of the missing fields!""",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE);
                    
                } catch(DepartmentLimitException error){
                    if("exceeds_100".equals(error.getMessage())){
                    JOptionPane.showMessageDialog(this, """
                                                        Department Limit Exceeded!
                                                        
                                                        Department limit of 100 has been exceeded! A maximum of a 100 departments 
                                                        is only allowed! 
                                                        
                                                        Please enter a smaller number and try again.""",
                        "Department Limit Exceeded",
                        JOptionPane.WARNING_MESSAGE); 
                    }
                    
                    if("zero_or_less".equals(error.getMessage())){
                    JOptionPane.showMessageDialog(this, """
                                                        Invalid Number of Departments!
                                                        
                                                        The number of departments must at least be one (1). 
                                                        
                                                        Please try again with a valid positive number.""",
                        "Invalid Number of Departments",
                        JOptionPane.WARNING_MESSAGE); 
                    }
                    
                }  catch (Exception error){
                    System.err.println("An error occurred while processing CIDR logic:");
                    error.printStackTrace(); // This prints the full stack trace to console
                    JOptionPane.showMessageDialog(this, """
                                                        Something Went Wrong!
                                                        
                                                        Please contact the developer to resolve it!
                                                        
                                                        Error: """ + error.getMessage(),
                        "Unknown Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }

            }else{
                JOptionPane.showMessageDialog(this, """
                                                    Invalid IP Address Detected!
                                                    
                                                    Please enter a valid IPv4 address in the format:
                                                    
                                                    x.x.x.x (e.g., 192.168.1.1)""",
                    "Invalid IP Address Detected",
                    JOptionPane.WARNING_MESSAGE);
            }
                  
        }
        
        // VLSM BUTTON HANDLER
        if (e.getSource() == submitVLSM){
            if(matcher.matches()){
                
                try {        
                    int[] hosts = new int[this.dept.getHostFields().size()];
                    for (int i = 0; i < this.dept.getHostFields().size(); i++){
                        hosts[i] = Integer.parseInt(this.dept.getHostFields().get(i).getText());
                    }


                    VLSM vlsm = new VLSM(new IPAddress(ipadd, subnet), hosts, Integer.parseInt(numOfDept.getText()));
                    vlsm.calculate();
                    String[] vlsmColumnNames = {"# of Hosts", "Network", "Range", "Broadcast Address"};
                    vlsmTable = new JTable(Utils.convertToTableData(vlsm.getVlsmList(), vlsm.getNumOfHosts()), vlsmColumnNames);
                    output.loadTable(vlsmTable);
                    
                    // unlocking the fields and reseting them
                    this.numOfDept.setEnabled(true);
                    this.numOfDept.setText("0");
                    this.address.setEnabled(true);
                    this.address.setText("");
                    this.mask.setEnabled(true);
                    this.mask.setSelectedIndex(0);
                    
                } catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(this, """
                                                        Missing Fields Detected!
                                                        
                                                        Please fill out all of the missing fields!""",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE);
                    
                } catch(AddressOverflowException error){
                    JOptionPane.showMessageDialog(this, """
                                                        Address Overflow Detected!
                                                        
                                                        The requested number of hosts exceeds the capacity of the address able to
                                                        be provided by your subnet mask.
                                                        
                                                        Please choose a different base address or reduce the number of requested subnets.""",
                        "Overflow Error",
                        JOptionPane.WARNING_MESSAGE
                    );

                } catch (Exception error){
                    System.err.println("An error occurred while processing VLSM logic:");
                    error.printStackTrace(); // This prints the full stack trace to console
                    JOptionPane.showMessageDialog(this, """
                                                        Something Went Wrong!
                                                        
                                                        Please contact the developer to resolve it!
                                                        
                                                        Error: """ + error.getMessage(),
                        "Unknown Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }

            }else{
                JOptionPane.showMessageDialog(this, """
                                                    Invalid IP Address Detected!
                                                    
                                                    Please enter a valid IPv4 address in the format:
                                                    
                                                    x.x.x.x (e.g., 192.168.1.1)""",
                    "Invalid IP Address Detected",
                    JOptionPane.WARNING_MESSAGE);
            }        
        }
        
        // RESET BUTTON HANDLER
        // Purpose: To prevent the user from being locked out
        if (e.getSource() == reset){
            try{  
                // unlocking the fields and reseting them
                this.numOfDept.setEnabled(true);
                this.numOfDept.setText("0");
                this.address.setEnabled(true);
                this.address.setText("");
                this.mask.setEnabled(true);
                this.mask.setSelectedIndex(0);
                
                this.dept.removeHostGeneration();
                this.remove(this.submitVLSM);
                this.remove(this.reset);
            } catch (Exception error){
                    System.err.println("An error occurred while processing RESET logic:");
                    error.printStackTrace(); // This prints the full stack trace to console
                    JOptionPane.showMessageDialog(this, """
                                                        Something Went Wrong!
                                                        
                                                        Please contact the developer to resolve it!
                                                        
                                                        Error: """ + error.getMessage(),
                        "Unknown Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
        }
        
    }

 

    


}
