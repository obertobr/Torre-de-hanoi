package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class Pilha {
    private Node anterior = null;
    private int itens = 0;

    public int getItens() {
        return itens;
    }

    public Node adicionar(Disco disco) {
        Node novo = new Node(disco, anterior);
        anterior = novo;
        itens++;
        return novo;
    }
    
    public Node verificar(){
        return anterior;
    }
    
    public Node pegar(){
        Node atual = anterior;
        anterior = atual.getAnterior();
        itens--;
        return atual;
    }
    
    public Disco[] getAll(){
        Disco[] vetor = new Disco[itens];
        if(anterior == null){
            return vetor;
        }
        Node ant = anterior;
        vetor[itens-1] = ant.getDisco();
        for(int i = itens-2; i >= 0;i--){
            ant = ant.getAnterior();
            vetor[i] = ant.getDisco();
        }
        return vetor;
    }
}
