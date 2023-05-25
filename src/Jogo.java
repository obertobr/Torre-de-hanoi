package src;

import java.awt.Color;

public class Jogo {
    Torre[] Torre = new Torre[3];
    Torre selecionado = null;
    Color fundo = new Color(0,180,255);

    public Jogo(){
        Torre[0] = new Torre();
        Torre[1] = new Torre();
        Torre[2] = new Torre();
        
        Torre[0].adicionar(new Disco(5,Color.black, 250, 30));
        Torre[0].adicionar(new Disco(4,Color.red, 200,30));
        Torre[0].adicionar(new Disco(3,Color.white, 150, 30));
        Torre[0].adicionar(new Disco(2,Color.PINK, 100, 30));
        Torre[0].adicionar(new Disco(1,Color.GREEN, 50, 30));
    }

    public Torre getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Torre selecionado) {
        this.selecionado = selecionado;
    }

    public void mostrarOpcoes(){
        for(Torre p: Torre){
            if(p == selecionado){continue;}
            Disco DiscoSelecionado = selecionado.verificar().getConteudo();
            if(p.verificar() == null || p.verificar().getConteudo().getTamanho() > DiscoSelecionado.getTamanho()){
                p.adicionar(new Disco(DiscoSelecionado.getTamanho(), fundo, DiscoSelecionado.getWidth(), DiscoSelecionado.getHeight()));
            }
        }
    }

    public Color getFundo() {
        return fundo;
    }

    public void escondeOpcoes(){
        for(Torre p: Torre){
            if(p.verificar() != null && p.verificar().getConteudo().getCor() == fundo){
                p.pegar();
            }
        }
    }

    public Torre getTorreUnica(int index) {
        return Torre[index];
    }

    public void trocarPosicao(Torre Torre1, Torre Torre2) {
        if(Torre2.getItens() == 0){
            Torre2.adicionar(Torre1.pegar().getConteudo());
        } else if(Torre1.verificar().getConteudo().getTamanho() < Torre2.verificar().getConteudo().getTamanho()){
            Torre2.adicionar(Torre1.pegar().getConteudo());
        } else{
            System.out.println("erro");
        }
    }

    public Torre[] getTorre() {
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
