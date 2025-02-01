/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escola.sia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lucas98
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index"; // Isso deve mapear para src/main/resources/static/index.html
    }
}
