package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Color;

/**
 *
 * @author aluno
 */
public class Disco {
    private int tamanho;
    private Color cor;
    private int x;
    private int y;
    private int width;
    private int height;

    public int getTamanho() {
        return tamanho;
    }

    public Color getCor() {
        return cor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setLocal(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Disco(int tamanho, Color cor, int width, int height) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.width = width;
        this.height = height;
    }
}
