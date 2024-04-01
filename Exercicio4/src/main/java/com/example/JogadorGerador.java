package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class JogadorGerador {
    public  String retornaTextoDoServidor(String url) throws Exception {
        // Cria um cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();
        // Cria uma requisicao HTTP
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        // Executa a requisicao e recebe uma resposta
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        // Cria uma variavel com a lista em texto
        String texto = resposta.body();
        return texto;

    }

    public  String retornaElementoAleatorio(String texto) {
        // Divide a variavel em varias strings (uma pra cada nome)
        String[] listaDeNomes = texto.split("\n");
        // Cria um numero aleatorio de acordo com o vetor
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        // Retorna uma posicao aleatoria da lista
        return listaDeNomes[indiceAleatorio];
    }
    public  short geraNumeroAleatorio(int menor, int maior) {
        short numeroAleatorio = (short) Math.floor((Math.random() * (maior-menor+1))+17);
        return numeroAleatorio;
    }


    public String getAll(){
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
    public ArrayList<String> getOnly(){
        JogadorGerador jogadorGerador = new JogadorGerador();

        ArrayList<String> meuNovoJogador=new ArrayList<>();

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

            meuNovoJogador = meuJogador.getVar();


        } catch (Exception e) {
            e.printStackTrace();

        }
        return meuNovoJogador;
    }

}
