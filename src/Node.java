package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class Node {
    private Disco disco;
    private Node anterior;

    public Disco getDisco() {
        return disco;
    }

    public Node getAnterior() {
        return anterior;
    }

    public Node(Disco disco, Node anterior) {
        this.disco = disco;
        this.anterior = anterior;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }
}
