package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


/**
 *
 * @author obertobr
 */
public class Grafico extends JFrame implements MouseListener{

    public Grafico() {
        setTitle("teste");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(new Color(0,180,255));
        g.fillRect(0,0, 1024, 728);
        
        g.setColor(Color.BLACK);
        for(Disco i: Torre_de_Hanoi.TorreA.getAll()){
            g.fillRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
            System.out.println("X=" + i.getX());
            System.out.println("Y=" + i.getY());
            System.out.println("Width=" + i.getWidth());
            System.out.println("Height=" + i.getHeight());
        }
        for(Disco i: Torre_de_Hanoi.TorreB.getAll()){
            g.fillRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
        }
        for(Disco i: Torre_de_Hanoi.TorreC.getAll()){
            g.fillRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
        }
    }

    void desenhar() {
        calcular();
        repaint();
    }

    private void calcular() {
        int contador = 0;
        for(Disco i: Torre_de_Hanoi.TorreA.getAll()){
            i.setLocal((((1024-300)/2)*0)-(i.getWidth()/2)+150, 650-(50*contador));
            contador ++;
        }
        contador = 0;
        for(Disco i: Torre_de_Hanoi.TorreB.getAll()){
            i.setLocal((((1024-300)/2)*1)-(i.getWidth()/2)+150, 650-(50*contador));
            contador ++;
        }
        contador = 0;
        for(Disco i: Torre_de_Hanoi.TorreC.getAll()){
            i.setLocal((((1024-300)/2)*2)-(i.getWidth()/2)+150, 650-(50*contador));
            contador ++;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);
    }
    
}
