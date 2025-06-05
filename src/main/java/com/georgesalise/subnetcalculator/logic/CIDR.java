/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.logic;

import com.georgesalise.subnetcalculator.customExceptions.AddressOverflowException;
import com.georgesalise.subnetcalculator.model.IPAddress;
import com.georgesalise.subnetcalculator.model.IPResult;
import java.util.ArrayList;

/**
 *
 * @author gian
 */
public class CIDR {
    private int totalSubnets;
    private int newPrefix;
    private int requestedSubnets;
    private int increment;
    ArrayList<IPResult> resultsList = new ArrayList<IPResult>();
    
    public CIDR(){
    
    }
    
    public CIDR(IPAddress ipadd, int requestS) throws AddressOverflowException{
        this.requestedSubnets = requestS;
        calculateRequirements(ipadd);
        this.increment = Utils.calculateIncrement(newPrefix);
        this.calculate(ipadd);
    }

    public int getTotalSubnets() {
        return totalSubnets;
    }

    public int getNewPrefix() {
        return newPrefix;
    }

    public int getRequestedSubnets() {
        return requestedSubnets;
    }

    public int getIncrement() {
        return increment;
    }
    
    public void calculateRequirements(IPAddress ipadd){
        int i = 1;
        while ((i + ipadd.getPrefix() + 1 < 31) && ((int) Math.pow(2, i) <= this.requestedSubnets)){              
            i++;
        }
        this.totalSubnets = (int) Math.pow(2, i);
        this.newPrefix = ipadd.getPrefix() + i;
    }

    public void calculate(IPAddress ipadd) throws AddressOverflowException{
        long base = ipadd.getIpAddress();

        // Limit to 1024
        for(int i = 0; i < this.totalSubnets && i < 1024; i++){
            if(base > 0xFFFFFFFFL){
                throw new AddressOverflowException("Overflow detected! Halting calculation.");
            }
            this.resultsList.add(new IPResult(base, this.newPrefix));
            System.out.println(base + " == " + Utils.longToStringIP(base));
            //this.cidrList.add(Utils.intToStringIP(base));
            base +=  (long)Math.pow(2, 32 - this.newPrefix);
 
        }
    }
    
    public void findNth(IPAddress ipadd, int subnetValue, int nth){
        this.requestedSubnets = subnetValue;
        this.calculateRequirements(ipadd);
        this.increment = Utils.calculateIncrement(newPrefix);
        
        int a = nth * this.increment;
        long base = ipadd.getIpAddress();
        base +=  a;
        System.out.println(Utils.longToStringIP(base) + "\n\n");
        
        
    }
    
    public void print(){
        for(int i = 0; i < this.totalSubnets && i < 1024; i++){
//            System.out.println("Subnet " + i + ": " + this.cidrList.get(i) + "/" + this.newPrefix + "\n");
            System.out.println("Subnet " + i + ": " + this.resultsList.get(i) + "/" + this.newPrefix + "\n");
        }
    }

    public ArrayList<IPResult> getresultsList() {
        return resultsList;
    }

}
