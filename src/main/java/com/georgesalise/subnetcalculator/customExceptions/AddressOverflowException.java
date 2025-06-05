/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.customExceptions;

/**
 *
 * @author gian
 */
public class AddressOverflowException extends Exception{
    public AddressOverflowException(){
        super();
    }
    
    public AddressOverflowException(String message){
        super(message);
    }    
    
}
