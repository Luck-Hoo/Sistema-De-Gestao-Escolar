/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escola.sia.model;

/**
 *
 * @author Lucas98
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }

    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String propertyName, Object oldValue, Object newValue) {
        for (Observer observer : observers) {
            observer.update(propertyName, oldValue, newValue);
        }
    }
}
