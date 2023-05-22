package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.awt.Color;

/**
 *
 * @author aluno
 */
public class Torre_de_Hanoi {
        public static final Pilha TorreA = new Pilha();
        public static final Pilha TorreB = new Pilha();
        public static final Pilha TorreC = new Pilha();
        
    public static void main(String[] args) throws InterruptedException {
        Grafico teste = new Grafico();
        TorreA.adicionar(new Disco(5,Color.black, 250, 30));
        TorreA.adicionar(new Disco(4,Color.black, 200,30));
        TorreA.adicionar(new Disco(3,Color.black, 150, 30));
        TorreA.adicionar(new Disco(2,Color.black, 100, 30));
        TorreA.adicionar(new Disco(1,Color.black, 50, 30));

        trocarPosicao(TorreA,TorreB);

        desenhar();
        teste.desenhar();
        Thread.sleep(100);
        trocarPosicao(TorreA,TorreC);
        teste.desenhar();
        desenhar();
    }
    
    public static void trocarPosicao(Pilha Torre1, Pilha Torre2) {
        if(Torre2.getItens() == 0){
            Torre2.adicionar(Torre1.pegar().getDisco());
        } else if(Torre1.verificar().getDisco().getTamanho() < Torre2.verificar().getDisco().getTamanho()){
            Torre2.adicionar(Torre1.pegar().getDisco());
        } else{
            System.out.println("erro");
        }
    }
    
    public static void desenhar() {
        String texto = "";
        for(Disco i: TorreA.getAll()){
            texto += i.getTamanho();
        }
        System.out.println(padLeftZeros(texto, 5));
        texto = "";
        for(Disco i: TorreB.getAll()){
            texto += i.getTamanho();
        }
        System.out.println(padLeftZeros(texto, 5));
        texto = "";
        for(Disco i: TorreC.getAll()){
            texto += i.getTamanho();
        }
        System.out.println(padLeftZeros(texto, 5));
        System.out.println("");
    }
    
    public static String padLeftZeros(String inputString, int length) {
    if (inputString.length() >= length) {
        return inputString;
    }
    String novo = inputString;
    while (novo.length() < length) {
        novo += "-";
    }

    return novo;
}
    
}
