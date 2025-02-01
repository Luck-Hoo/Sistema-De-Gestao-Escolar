package com.escola.sia.controller.apis;

import com.escola.sia.service.apis.CamaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamaraController {

    @Autowired
    private CamaraService camaraService;

    @GetMapping("/deputados")
    public String getDeputados() {
        return camaraService.getDeputados(); // Retorna os dados JSON dos deputados
    }
}
