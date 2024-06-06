package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        JogadorGerador jogadorGerador = new JogadorGerador();


        String textoNomes = jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
        String nome = jogadorGerador.retornaElementoAleatorio(textoNomes);


        String textoSobreNomes =jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
        String sobrenome = jogadorGerador.retornaElementoAleatorio(textoSobreNomes);

        String textoPosicoes =jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
        String Posicoes = jogadorGerador.retornaElementoAleatorio(textoPosicoes.replace( "\",","").replace("\"",""));

        String textoClubes =jogadorGerador.retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
        String Clubes = jogadorGerador.retornaElementoAleatorio(textoClubes);

        short idade = jogadorGerador.geraNumeroAleatorio(17,40);

        Jogador meuJogador = new Jogador(nome,sobrenome,Posicoes,Clubes,idade);
        System.out.println(meuJogador.getDescricao());
    }


}