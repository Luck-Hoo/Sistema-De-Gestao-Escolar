package com.escola.sia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPController {

    @GetMapping("/jsp")
    public String jspPage(Model model) {
        model.addAttribute("message", "Bem-vindo ao JSP!");
        return "jspPage"; // Nome do arquivo JSP (jspPage.jsp)
    }
}
