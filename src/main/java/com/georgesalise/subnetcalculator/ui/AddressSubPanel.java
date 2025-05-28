/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.ui;

import com.georgesalise.subnetcalculator.logic.CIDR;
import static com.georgesalise.subnetcalculator.logic.Utils.toIntegerArray;
import com.georgesalise.subnetcalculator.model.IPAddress;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
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
    private JButton submit = new JButton("Submit");
    
    public AddressSubPanel (){
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
        
        // submit
        submit.setFont(new Font("Monospaced", Font.PLAIN, 15));
        ((AbstractDocument) numOfSubnets.getDocument()).setDocumentFilter(new DigitFilter());
        submit.setPreferredSize(new Dimension(100, 40));
        submit.addActionListener(this);
        
        
        this.add(addressLabel);
        this.add(address);
        this.add(Box.createHorizontalStrut(5));
        this.add(maskLabel);
        this.add(mask);
        this.add(Box.createHorizontalStrut(5));
        this.add(numOfSubnetsLabel);
        this.add(numOfSubnets);
        this.add(Box.createHorizontalStrut(5));
        this.add(submit);
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
        int subnetworksNeeded = Integer.parseInt(numOfSubnets.getText());
        
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1?[1-9][0-9]?))(\\.(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?|0)){3}$");
        Matcher matcher = pattern.matcher(ipadd);
                
        if (e.getSource() == submit){
            if(matcher.matches()){
                IPAddress ip = new IPAddress(ipadd, subnet);
                CIDR cidr = new CIDR(ip, subnetworksNeeded);
                System.out.println("\n" + cidr.getNewPrefix() + " " + cidr.getTotalSubnets() + " " + cidr.getIncrement());
                cidr.print();
            }else{
                System.out.println("fail");
            }
        }
        
        
        
        
        
    }
}
