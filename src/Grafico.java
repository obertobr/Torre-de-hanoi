package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


/**
 *
 * @author obertobr
 */

public class Grafico extends JFrame implements MouseListener{
    Jogo jogo;
    int widthTela = 1024;
    int heightTela = 728;
    int numTorres = 3;
    int numDiscos = 6;
    int height = heightTela/(numDiscos*4);
    int width = widthTela / numTorres - 100;

    public Grafico(Jogo jogo) {
        this.jogo = jogo;
        setTitle("Torre de Hanoi");
        setSize(widthTela,heightTela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //pintar fundo
        g.setColor(jogo.fundo);
        g.fillRect(0,0, 1024, 728);

        g.setColor(new Color(29, 146, 64));
        g.fillRect(0,heightTela-200+height, 1024, 728);

        for(int i=0;i<numDiscos;i++){
            g.setColor(new Color(184, 133, 65));
            g.fillRect((((widthTela-300)/(numTorres-1))*i)-((width+20)/2)+150,
                  heightTela-200,
                  width+20,
                  height);
            g.setColor(new Color(198, 153, 94));
            g.fillRect((((widthTela-300)/(numTorres-1))*i)-(width/numDiscos/4)+150,
                  (heightTela-200)-((numDiscos+2)*height),
                  width/numDiscos/2,
                  height*(numDiscos+2));
        }
        
        //pintar discos
        g2.setStroke(new BasicStroke(1));
        for(Torre p: jogo.getTorre()){
            for(Disco d: p.getAll()){
                g.setColor(d.getCor());
                g.fillRect(d.getX(), d.getY(), d.getWidth(), height);
                g.setColor(Color.black);
                g.drawRect(d.getX()-1, d.getY()-1, d.getWidth(), height);
            }
        }

        //pintar borda do selecionado
        g2.setStroke(new BasicStroke(4));
        if(jogo.getSelecionado() != null){
            g.setColor(Color.red);
            g.drawRect(jogo.getSelecionado().verificar().getConteudo().getX()+1,
                       jogo.getSelecionado().verificar().getConteudo().getY()+1,
                       jogo.getSelecionado().verificar().getConteudo().getWidth()-3,
                       height-3);
        }

        //escrever numero de movimentos
        g2.setStroke(new BasicStroke(3));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.setColor(Color.white);
        g.drawString("Movimentos: " + String.valueOf(jogo.getMovimentos()), widthTela - 200, 60);
    }

    public void desenhar() {
        calcularLocal();
        repaint();
    }

    private void calcularLocal() {
        int indexDiscos = 1;
        int indexTorres = 0;
        for(Torre p: jogo.getTorre()){
            for(Disco d: p.getAll()){
                d.setWidth(width/numDiscos*d.getTamanho());
                d.setLocal((((widthTela-300)/(numTorres-1))*indexTorres)-(d.getWidth()/2)+150,
                          (heightTela-200)-(indexDiscos*height));
                indexDiscos ++;
            }
            indexTorres++;
            indexDiscos = 1;
        }
    }

    private void testarClickEmObjeto(int x, int y){
        for(Torre p: jogo.getTorre()){
            if(p.verificar() == null){ continue;}
            Disco disco = p.verificar().getConteudo();
            if(disco.getX() < x && x < disco.getX() + disco.getWidth() &&
            disco.getY() < y && y < disco.getY() + disco.getHeight()){
                if(jogo.getSelecionado() != null){
                    jogo.escondeOpcoes();
                    jogo.trocarPosicao(jogo.getSelecionado(), p);
                    jogo.setSelecionado(null);;
                } else {
                    jogo.setSelecionado(p);
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
