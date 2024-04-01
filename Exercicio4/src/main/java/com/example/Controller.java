package com.example;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String raiz() {
        return "Raiz da aplicação";
    }

    @GetMapping("/meuJogador")
    public String olaMundo() {
        JogadorGerador jogadorGerador = new JogadorGerador();

        String meuNovoJogador="";

        try {
            String textoNomes = jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
            String nome = jogadorGerador.retornaElementoAleatorio(textoNomes);

            String textoSobreNomes = jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
            String sobrenome = jogadorGerador.retornaElementoAleatorio(textoSobreNomes);

            String textoPosicoes = jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
            String Posicoes = jogadorGerador.retornaElementoAleatorio(textoPosicoes.replace("\",", "").replace("\"", ""));

            String textoClubes = jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
            String Clubes = jogadorGerador.retornaElementoAleatorio(textoClubes);

            short idade = jogadorGerador.geraNumeroAleatorio(17, 40);

            Jogador meuJogador = new Jogador(nome, sobrenome, Posicoes, Clubes, idade);

            meuNovoJogador = meuJogador.getDescricao();


        } catch (Exception e) {
            e.printStackTrace();

        }
        return meuNovoJogador;
    }
}

