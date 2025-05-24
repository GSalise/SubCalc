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
public class VLSM {
    private IPAddress ipadd;
    private int[] numOfHosts;
    private int numOfDepartments;
    private int mask;
    private int increment;
    ArrayList<String> vlsmList = new ArrayList<String>();
    
    public VLSM(){
        
    }
    
    public VLSM(IPAddress ipaddr, int[] hosts, int departments){
        this.ipadd = ipaddr;
        this.numOfHosts = hosts;
        this.numOfDepartments = departments;
    }
    
    public void findMaskAndIncrement(int numHost){
        int i = 0;
        while (Math.pow(2, i) < numHost){
            i++;
        }
        
        this.mask = 32-i;
        
        this.increment = Utils.calculateIncrement(this.mask);
    }
    
    public void calculate(){
        int base = ipadd.getIpAddress();
        for(int i = 0; i < this.numOfDepartments; i++){
            this.findMaskAndIncrement(this.numOfHosts[i]);
            this.vlsmList.add(Utils.print(base));
            base +=  (int)Math.pow(2, 32 - this.mask);
        }

    }
    
    public void print(){
        for(int i = 0; i < this.numOfDepartments; i++){
            this.findMaskAndIncrement(this.numOfHosts[i]);
            System.out.println("Subnet: " + this.vlsmList.get(i) + "/" + this.mask + "\n");
        }
    }

    public int getIncrement() {
        return increment;
    }

    public int getMask() {
        return mask;
    }
    

}
