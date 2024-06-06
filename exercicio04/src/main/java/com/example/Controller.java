package com.example;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    @GetMapping("/")
    public String raiz() {
        return "Raiz da aplicação";
    }

    @GetMapping("/meuJogador")
    public String meuJogador() {
      JogadorGerador meujogador = new JogadorGerador();
      return meujogador.getAll();
    }

    @GetMapping("/meuJson")
    public ArrayList<String> meuJson() {

        JogadorGerador meujogador = new JogadorGerador();

        return meujogador.getOnly();

    }



}

