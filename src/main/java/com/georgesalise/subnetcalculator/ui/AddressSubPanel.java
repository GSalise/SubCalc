/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

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
    private JTextField address = new JTextField();
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
    private JPanel addrPanel = new JPanel();
    private JPanel deptPanel = new JPanel();
    private JScrollPane deptScrollPane;
    private JButton generateHosts = new JButton("Form");
    private JButton submitVLSM = new JButton("Submit");
    private ArrayList<JTextField> hostFields = new ArrayList<>();
    private JTable vlsmTable = new JTable();




    
    public AddressSubPanel (OutputSubPanel output, VisualizerSubPanel visual){
        this.output = output;
        this.visual = visual;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //this.setBorder(new EmptyBorder(20, 0, 0 ,0));
        
        // address
        addressLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        address.setPreferredSize(new Dimension(200,40));
        address.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        
        // subnet mask
        maskLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        mask.setPreferredSize(new Dimension(80, 40));
        mask.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // number of subnets needed
        numOfSubnetsLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        numOfSubnets.setPreferredSize(new Dimension(200,40));
        numOfSubnets.setFont(new Font("Monospaced", Font.PLAIN, 15));
        ((AbstractDocument) numOfSubnets.getDocument()).setDocumentFilter(new DigitFilter());
        
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
    
    public AddressSubPanel (OutputSubPanel output){
        this.output = output;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        addrPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //this.setBorder(new EmptyBorder(20, 0, 0 ,0));
        
        // address
        addressLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        address.setPreferredSize(new Dimension(200,40));
        address.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // subnet mask
        maskLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        mask.setPreferredSize(new Dimension(80, 40));
        mask.setFont(new Font("Monospaced", Font.PLAIN, 15));
        
        // number of subnets needed
        numOfDeptLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        numOfDept.setPreferredSize(new Dimension(200,40));
        numOfDept.setFont(new Font("Monospaced", Font.PLAIN, 15));
        ((AbstractDocument) numOfDept.getDocument()).setDocumentFilter(new DigitFilter());
        
        // submit
        generateHosts.setFont(new Font("Monospaced", Font.PLAIN, 15));
        generateHosts.setPreferredSize(new Dimension(100, 40));
        generateHosts.addActionListener(this);
        
        addrPanel.add(addressLabel);
        addrPanel.add(address);
        addrPanel.add(Box.createHorizontalStrut(5));
        addrPanel.add(maskLabel);
        addrPanel.add(mask);
        addrPanel.add(Box.createHorizontalStrut(5));
        addrPanel.add(numOfDeptLabel);
        addrPanel.add(numOfDept);
        addrPanel.add(Box.createHorizontalStrut(5));
        addrPanel.add(generateHosts);
        this.add(addrPanel, BorderLayout.NORTH);
        
        // Set up deptPanel and wrap it in scroll pane
        deptPanel.setLayout(new BoxLayout(deptPanel, BoxLayout.Y_AXIS));
        deptPanel.setBackground(Color.LIGHT_GRAY);
        deptPanel.setAlignmentX(CENTER_ALIGNMENT);

        deptScrollPane = new JScrollPane(deptPanel);
        deptScrollPane.setPreferredSize(new Dimension(500, 300)); // adjust as needed
        deptScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        deptScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add it to the main panel
        this.add(deptScrollPane, BorderLayout.CENTER);

    
    }

    private static class DigitFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("\\d+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String ipadd = address.getText();
        int subnet = (int) mask.getSelectedItem();
        
        
        
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1?[1-9][0-9]?))(\\.(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?|0)){3}$");
        Matcher matcher = pattern.matcher(ipadd);
                
        if (e.getSource() == submitCIDR){
            if (matcher.matches()){
                // Logic
                int subnetworksNeeded = Integer.parseInt(numOfSubnets.getText());
                IPAddress ip = new IPAddress(ipadd, subnet);
                CIDR cidr = new CIDR(ip, subnetworksNeeded);
                
                // Visual
                String[] cidrColumnNames = {"Subnetwork", "Start Address", "End Address", "Broadcast Address"};
                cidrTable = new JTable(Utils.convertToTableData(cidr.getresultsList()), cidrColumnNames);
                visual.loadVisual(cidr.getNewPrefix());
                output.loadTable(cidrTable);
            }else{
                System.out.println("failcidr");
            }
        }
        
        if (e.getSource() == generateHosts){
            if (matcher.matches()){
                int deptsNeeded = Integer.parseInt(numOfDept.getText());
                IPAddress ip = new IPAddress(ipadd, subnet);
                generateDepartmentPanel(deptsNeeded);
            }else{
                System.out.println("failvlsm");
            }
        }
        
        if (e.getSource() == submitVLSM){
            int deptsNeeded = Integer.parseInt(numOfDept.getText());
            IPAddress ip = new IPAddress(ipadd, subnet);
            int hosts[] = new int[hostFields.size()];
            
            for (int i = 0; i < hostFields.size(); i++){
                hosts[i] = Integer.parseInt(hostFields.get(i).getText());
            }
           
            
            VLSM vlsm = new VLSM(ip, hosts, deptsNeeded);
            vlsm.calculate();
            vlsm.print();
            
            String[] vlsmColumnNames = {"# of Hosts", "Network", "Range", "Broadcast Address"};
            vlsmTable = new JTable(Utils.convertToTableData(vlsm.getVlsmList(), vlsm.getNumOfHosts()), vlsmColumnNames);
            output.loadTable(vlsmTable);
            
        }else{
            System.out.println("failvlsm2");
        }
        
    }

    private void generateDepartmentPanel(int num) {
        deptPanel.removeAll(); // Clear previous rows
        hostFields.clear();
        
        for (int i = 0; i < num; i++) {
            JLabel label = new JLabel("Hosts for Department " + (i + 1) + ": ");
            label.setFont(new Font("Monospaced", Font.PLAIN, 15));

            JTextField hosts = new JTextField();
            hosts.setPreferredSize(new Dimension(200, 30));
            hosts.setFont(new Font("Monospaced", Font.PLAIN, 15));
            ((AbstractDocument) hosts.getDocument()).setDocumentFilter(new DigitFilter());
            this.hostFields.add(hosts);
            
            JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER));
            row.setBackground(Color.LIGHT_GRAY);
            row.add(label);
            row.add(hosts);
            
            deptPanel.add(row);
        }

        submitVLSM.setFont(new Font("Monospaced", Font.PLAIN, 15));
        submitVLSM.setPreferredSize(new Dimension(100, 40));
        for (ActionListener al : submitVLSM.getActionListeners()) {
            submitVLSM.removeActionListener(al);
        }
        submitVLSM.addActionListener(this);

        
        deptPanel.add(this.submitVLSM);
        deptPanel.revalidate();
        deptPanel.repaint();
    }

    


}
