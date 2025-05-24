/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.georgesalise.subnetcalculator;

import com.georgesalise.subnetcalculator.logic.CIDR;
import com.georgesalise.subnetcalculator.logic.VLSM;
import com.georgesalise.subnetcalculator.model.IPAddress;
import java.util.Scanner;

/**
 *
 * @author gian
 */
public class SubnetCalculator {

    public static void main(String[] args) {
        //limit subnetmask to 29
        //limit subreq to 30
//        IPAddress ipadd = new IPAddress("192.0.0.0", 7);
//        System.out.println(ipadd.getIpAddress());
//        CIDR cidr = new CIDR(ipadd, 32760);
//        System.out.println("\n" + cidr.getNewPrefix() + " " + cidr.getTotalSubnets() + " " + cidr.getIncrement());
//        cidr.calculate(ipadd);
//        cidr.print();
        
//        IPAddress ipadd = new IPAddress("192.168.0.0", 24);
//        int[] arr = {9000,400,500,200};
//        VLSM vlsm = new VLSM(ipadd, arr, 4);
//        //vlsm.findMaskAndIncrement(arr[0]);
//        //System.out.println("\n" + vlsm.getIncrement() + " " + vlsm.getMask());
//        vlsm.calculate();
//        vlsm.print();

        IPAddress ipadd = new IPAddress("203.243.192.0", 19);
        CIDR find = new CIDR();
        find.findNth(ipadd, 100, 50);
        
        
        System.out.println(ipadd.getIpAddress());
        CIDR cidr = new CIDR(ipadd, 100);
        System.out.println("\n" + cidr.getNewPrefix() + " " + cidr.getTotalSubnets() + " " + cidr.getIncrement());
        cidr.calculate(ipadd);
        cidr.print();
        
        
    }
}
