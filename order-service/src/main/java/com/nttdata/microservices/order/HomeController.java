package com.nttdata.microservices.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bem-vindo ao Serviço de Pedidos! (Teste)";
    }
}