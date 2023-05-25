package src;

public class Torre extends Pilha<Disco> {

    public Disco[] getAll(){
        Disco[] vetor = new Disco[itens];
        if(anterior == null){
            return vetor;
        }
        Node<Disco> ant = anterior;
        vetor[itens-1] = ant.getConteudo();
        for(int i = itens-2; i >= 0;i--){
            ant = ant.getAnterior();
            vetor[i] = ant.getConteudo();
        }
        return vetor;
    }
}