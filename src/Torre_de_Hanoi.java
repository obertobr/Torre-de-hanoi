package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class Torre_de_Hanoi {
        
        
    public static void main(String[] args) throws InterruptedException {
        Jogo jogo = new Jogo();
        Grafico grafico = new Grafico(jogo);

        grafico.desenhar();
        //Thread.sleep(1000);
        //grafico.desenhar();
        //jogo.desenhar();
    }
    
}
