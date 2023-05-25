package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class Pilha<T> {
    Node<T> anterior = null;
    int itens = 0;

    public int getItens() {
        return itens;
    }

    public Node<T> adicionar(T conteudo) {
        Node<T> novo = new Node<>(conteudo, anterior);
        anterior = novo;
        itens++;
        return novo;
    }
    
    public Node<T> verificar(){
        return anterior;
    }
    
    public Node<T> pegar(){
        Node<T> atual = anterior;
        anterior = atual.getAnterior();
        itens--;
        return atual;
    }
}
