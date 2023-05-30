package src;

import java.awt.Color;

public class Jogo {
    private Torre[] Torre = new Torre[3];
    private Torre selecionado = null;
    private int movimentos = 0;
    private boolean ganhou = false;
    Color fundo = new Color(0,180,255);
    Color corSelecionado = new Color(100, 100, 100, 100);

    public Jogo(){
        iniciar();
    }

    public void iniciar() {
        ganhou = false;
        movimentos = 0;

        Torre[0] = new Torre();
        Torre[1] = new Torre();
        Torre[2] = new Torre();
        
        Torre[0].adicionar(new Disco(6,Color.GRAY));
        Torre[0].adicionar(new Disco(5,Color.ORANGE));
        Torre[0].adicionar(new Disco(4,Color.MAGENTA));
        Torre[0].adicionar(new Disco(3,Color.BLUE));
        Torre[0].adicionar(new Disco(2,Color.PINK));
        Torre[0].adicionar(new Disco(1,Color.GREEN));
    }

    public Torre getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Torre selecionado) {
        this.selecionado = selecionado;
    }

    public int getMovimentos() {
        return movimentos;
    }

    public void mostrarOpcoes(){
        for(Torre p: Torre){
            if(p == selecionado){continue;}
            Disco DiscoSelecionado = selecionado.verificar().getConteudo();
            if(p.verificar() == null || p.verificar().getConteudo().getTamanho() > DiscoSelecionado.getTamanho()){
                p.adicionar(new Disco(DiscoSelecionado.getTamanho(), corSelecionado));
            }
        }
    }

    public void escondeOpcoes(){
        for(Torre p: Torre){
            if(p.verificar() != null && p.verificar().getConteudo().getCor() == corSelecionado){
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
            movimentos++;
            testeSeGanhou();
        } else if(Torre1.verificar().getConteudo().getTamanho() < Torre2.verificar().getConteudo().getTamanho()){
            Torre2.adicionar(Torre1.pegar().getConteudo());
            movimentos++;
            testeSeGanhou();
        }
    }

    public boolean isGanhou() {
        return ganhou;
    }

    public Torre[] getTorre() {
        return Torre;
    }
    
    private void testeSeGanhou() {
        ganhou = Torre[2].getItens() == 6;
    }
}
