package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class Node<T> {
    private T conteudo;
    private Node<T> anterior;

    public T getConteudo() {
        return conteudo;
    }

    public Node<T> getAnterior() {
        return anterior;
    }

    public Node(T conteudo, Node<T> anterior) {
        this.conteudo = conteudo;
        this.anterior = anterior;
    }

    public void setDisco(T conteudo) {
        this.conteudo = conteudo;
    }
}
