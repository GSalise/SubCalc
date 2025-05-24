/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.logic;

import com.georgesalise.subnetcalculator.model.IPAddress;
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
    ArrayList<String> cidrList = new ArrayList<String>();
    
    public CIDR(){
    
    }
    
    public CIDR(IPAddress ipadd, int requestS){
        this.requestedSubnets = requestS;
        calculateRequirements(ipadd);
        this.increment = Utils.calculateIncrement(newPrefix);
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

    public void calculate(IPAddress ipadd){
        int base = ipadd.getIpAddress();

        // Limit to 1024
        for(int i = 0; i < this.totalSubnets && i < 1024; i++){
            this.cidrList.add(Utils.print(base));
            base +=  (int)Math.pow(2, 32 - this.newPrefix);

        }
    }
    
    public void findNth(IPAddress ipadd, int subnetValue, int nth){
        this.requestedSubnets = subnetValue;
        this.calculateRequirements(ipadd);
        this.increment = Utils.calculateIncrement(newPrefix);
        
        int a = nth * this.increment;
        int base = ipadd.getIpAddress();
        base +=  a;
        System.out.println(Utils.print(base) + "\n\n");
        
        
    }
    
    public void print(){
        for(int i = 0; i < this.totalSubnets && i < 1024; i++){
            System.out.println("Subnet " + i + ": " + this.cidrList.get(i) + "/" + this.newPrefix + "\n");
        }
    }

}
