/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.model;

import com.georgesalise.subnetcalculator.logic.Utils;

/**
 *
 * @author gian
 */
public class IPResult{
    private String subnetwork;
    private String startAddress;
    private String endAddress;
    private String broadcastAddress;
    private int prefix;
    
    
    public IPResult(){
        
    }
    
    public IPResult(long IP, int prefix){
        this.subnetwork = Utils.longToStringIP(IP);
        this.startAddress = Utils.longToStringIP(IP + 1);
        this.endAddress = Utils.longToStringIP( (IP + (int)Math.pow(2, 32 - prefix)) - 2 );
        this.broadcastAddress = Utils.longToStringIP( (IP + (int)Math.pow(2, 32 - prefix)) - 1 );
        this.prefix = prefix;
    }

    public String getSubnetwork() {
        return subnetwork;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public String getBroadcastAddress() {
        return broadcastAddress;
    }

    public int getPrefix() {
        return prefix;
    }

    @Override
    public String toString() {
        return String.format("Subnetwork: %s/%d    Start: %s   End: %s     Broadcast: %s", 
            this.subnetwork, this.prefix, this.startAddress, 
            this.endAddress, this.broadcastAddress);
    }

    
}
