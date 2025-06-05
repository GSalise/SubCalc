/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgesalise.subnetcalculator.customExceptions;

/**
 *
 * @author gian
 */
public class DepartmentLimitException extends Exception{
    public DepartmentLimitException(){
        super();
    }   
    
    public DepartmentLimitException(String message){
        super(message);
    }
}
