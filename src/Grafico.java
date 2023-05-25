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
    Jogo jogo;

    public Grafico(Jogo jogo) {
        this.jogo = jogo;
        setTitle("Torre de Hanoi");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g){
        //pintar fundo
        g.setColor(jogo.fundo);
        g.fillRect(0,0, 1024, 728);

        //pintar selecionado
        if(jogo.selecionado != null){
            g.setColor(Color.red);
            g.fillRect(jogo.selecionado.verificar().getConteudo().getX()-5,
                       jogo.selecionado.verificar().getConteudo().getY()-5,
                       jogo.selecionado.verificar().getConteudo().getWidth()+10,
                       jogo.selecionado.verificar().getConteudo().getHeight()+10);
            
            //pintar opções
            g.setColor(new Color(255, 0, 0, 100));
            for(Torre p: jogo.getTorre()){
                if(p.verificar() != null && p.verificar().getConteudo().getCor() == jogo.fundo){
                    g.fillRect(p.verificar().getConteudo().getX() -5,
                               p.verificar().getConteudo().getY()-5,
                               p.verificar().getConteudo().getWidth()+10,
                               p.verificar().getConteudo().getHeight()+10);
                }
            }
        }
        
        //pintar discos
        for(Torre p: jogo.getTorre()){
            for(Disco d: p.getAll()){
                g.setColor(d.getCor());
                g.fillRect(d.getX(), d.getY(), d.getWidth(), d.getHeight());
            }
        }
    }

    public void desenhar() {
        calcularLocal();
        repaint();
    }

    private void calcularLocal() {
        int contador = 0;
        for(Disco i: jogo.getTorreUnica(0).getAll()){
            i.setLocal((((1024-300)/2)*0)-(i.getWidth()/2)+150, 650-(50*contador));
            contador ++;
        }
        contador = 0;
        for(Disco i: jogo.getTorreUnica(1).getAll()){
            i.setLocal((((1024-300)/2)*1)-(i.getWidth()/2)+150, 650-(50*contador));
            contador ++;
        }
        contador = 0;
        for(Disco i: jogo.getTorreUnica(2).getAll()){
            i.setLocal((((1024-300)/2)*2)-(i.getWidth()/2)+150, 650-(50*contador));
            contador ++;
        }
    }

    private void testarClickEmObjeto(int x, int y){
        for(Torre p: jogo.getTorre()){
            if(p.verificar() == null){ continue;}
            Disco disco = p.verificar().getConteudo();
            if(disco.getX() < x && x < disco.getX() + disco.getWidth() &&
            disco.getY() < y && y < disco.getY() + disco.getHeight()){
                if(jogo.selecionado != null){
                    jogo.escondeOpcoes();
                    jogo.trocarPosicao(jogo.selecionado, p);
                    jogo.selecionado = null;
                } else {
                    jogo.selecionado = p;
                    jogo.mostrarOpcoes();
                }
                desenhar();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        testarClickEmObjeto(e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
