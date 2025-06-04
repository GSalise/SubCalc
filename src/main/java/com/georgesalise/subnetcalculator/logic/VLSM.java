/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.logic;

import com.georgesalise.subnetcalculator.model.IPAddress;
import com.georgesalise.subnetcalculator.model.IPResult;
import java.util.ArrayList;
import java.util.Arrays;

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
    ArrayList<IPResult> vlsmList = new ArrayList<IPResult>();
    
    public VLSM(){
        
    }
    
    public VLSM(IPAddress ipaddr, int[] hosts, int departments){
        this.ipadd = ipaddr;
        this.numOfHosts = hosts;
        this.numOfDepartments = departments;
        this.sort();
    }
    
    public void findMaskAndIncrement(int numHost){
        int i = 0;
        while (Math.pow(2, i) < numHost + 2){
            i++;
        }
        
        this.mask = 32-i;
        
        this.increment = Utils.calculateIncrement(this.mask);
    }
    
    public void calculate(){
        int base = ipadd.getIpAddress();
        for(int i = 0 ; i < this.numOfDepartments ; i++){
            System.out.println(" Hosts:  " + this.numOfHosts[i] + "\n");
            this.findMaskAndIncrement(this.numOfHosts[i]);
            this.vlsmList.add(new IPResult(base, this.mask));
            base +=  (int)Math.pow(2, 32 - this.mask);
        }

    }
    
    public void print(){
        for(int i = 0 ; i < this.numOfDepartments ; i++){
            this.findMaskAndIncrement(this.numOfHosts[i]);
            System.out.println("Subnet: " + this.vlsmList.get(i) + "/" + this.mask + " Hosts:  " + this.numOfHosts[i] + "\n");
        }
    }

    public int getIncrement() {
        return increment;
    }

    public int getMask() {
        return mask;
    }

    public ArrayList<IPResult> getVlsmList() {
        return vlsmList;
    }

    public int[] getNumOfHosts() {
        return numOfHosts;
    }
    
    private void sort(){
        Arrays.sort(this.numOfHosts);

        // Reverse the array manually
        for (int i = 0; i < this.numOfDepartments / 2; i++) {
            int temp = this.numOfHosts[i];
            this.numOfHosts[i] = this.numOfHosts[this.numOfDepartments - 1 - i];
            this.numOfHosts[this.numOfDepartments - 1 - i] = temp;
        }
    }
    

}
