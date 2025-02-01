/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escola.sia.model;

/**
 *
 * @author Lucas98
 */
public interface Observer {
    void update(String propertyName, Object oldValue, Object newValue);
}
