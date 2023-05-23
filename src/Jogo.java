package src;

import java.awt.Color;

public class Jogo {
    Pilha[] Torre = new Pilha[3];
    Pilha selecionado = null;

    public Jogo(){
        Torre[0] = new Pilha();
        Torre[1] = new Pilha();
        Torre[2] = new Pilha();
        
        Torre[0].adicionar(new Disco(5,Color.black, 250, 30));
        Torre[0].adicionar(new Disco(4,Color.red, 200,30));
        Torre[0].adicionar(new Disco(3,Color.white, 150, 30));
        Torre[0].adicionar(new Disco(2,Color.PINK, 100, 30));
        Torre[0].adicionar(new Disco(1,Color.GREEN, 50, 30));
    }

    public Pilha getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Pilha selecionado) {
        this.selecionado = selecionado;
    }

    public void mostrarOpcoes(){
        for(Pilha p: Torre){
            if(p == selecionado){continue;}
            Disco DiscoSelecionado = selecionado.verificar().getDisco();
            if(p.verificar() == null || p.verificar().getDisco().getTamanho() > DiscoSelecionado.getTamanho()){
                p.adicionar(new Disco(DiscoSelecionado.getTamanho(), Color.blue, DiscoSelecionado.getWidth(), DiscoSelecionado.getHeight()));
            }
        }
    }

    public void escondeOpcoes(){
        for(Pilha p: Torre){
            if(p.verificar() != null && p.verificar().getDisco().getCor() == Color.blue){
                p.pegar();
            }
        }
    }

    public Pilha getTorreUnica(int index) {
        return Torre[index];
    }

    public void trocarPosicao(Pilha Torre1, Pilha Torre2) {
        if(Torre2.getItens() == 0){
            Torre2.adicionar(Torre1.pegar().getDisco());
        } else if(Torre1.verificar().getDisco().getTamanho() < Torre2.verificar().getDisco().getTamanho()){
            Torre2.adicionar(Torre1.pegar().getDisco());
        } else{
            System.out.println("erro");
        }
    }

    public Pilha[] getTorre() {
        return Torre;
    }

    public void desenhar() {
        String texto = "";
        for(Disco i: Torre[0].getAll()){
            texto += i.getTamanho();
        }
        System.out.println(padLeftZeros(texto, 5));
        texto = "";
        for(Disco i: Torre[1].getAll()){
            texto += i.getTamanho();
        }
        System.out.println(padLeftZeros(texto, 5));
        texto = "";
        for(Disco i: Torre[2].getAll()){
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
