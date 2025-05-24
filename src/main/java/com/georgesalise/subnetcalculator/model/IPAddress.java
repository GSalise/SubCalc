/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.model;

/**
 *
 * @author gian
 */
public class IPAddress {
    private int ipAddress;
    private int prefix;
    
    public IPAddress(){
        
    }
    
    public IPAddress (IPAddress ip){
        this.ipAddress = ip.getIpAddress();
        this.prefix = ip.getPrefix();
    }
    
    public IPAddress(String ipaddr, int prefix){
        this.prefix = prefix;
        // Split the string into octets, split them by .
        String[] octets = ipaddr.split("\\.");
        
        ipAddress = (Integer.parseInt(octets[0]) << 24) |
                    (Integer.parseInt(octets[1]) << 16) |
                    (Integer.parseInt(octets[2]) << 8)  |
                    (Integer.parseInt(octets[3]));
        /*
        Sample IP = 192.168.10.0
            
        Explaination for future reference cause I'm an idiot
            
        (Integer.parseInt(octets[0]) << 24)
            
        Breakdown: 
        1.) Integer.parseInt(octets[0])
        2.) << 24
         
        1.) Inserts the value of octets[0] into the ipAddress
        0000 0000   0000 0000   0000 0000   1100 0000
        
        2.) Shifts the inserted value 24 bits to the left
        1100 0000   0000 0000   0000 0000   0000 0000
        
        Repeat for the rest of the octets
        
        Purpose of | (bitwise or)
            - Combines each shifted octet
            - Builds the final 32-bit integer
        
        Result
        1100 0000   1010 1000   0000 1010   0000 0000
        192         168         10          0
        
        */
        
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(int ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public void setIpAddress(String ipaddr, int prefix) {
        this.prefix = prefix;
        String[] octets = ipaddr.split("\\.");
        
        ipAddress = (Integer.parseInt(octets[0]) << 24) |
                    (Integer.parseInt(octets[1]) << 16) |
                    (Integer.parseInt(octets[2]) << 8)  |
                    (Integer.parseInt(octets[3]));
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }
    
    
    
    
}



