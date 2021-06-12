import java.io.Serializable;

/**
 * Avancado Class
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */
public class Jogo implements Serializable {
/**                                            Variáveis instância  */
    private int nEquipas;
    private double duracao;
    private int nPartes;

    /**
     * Construtores
     */
    public Jogo(){

        this.nEquipas = 1;
        this.duracao = 0;
        this.nPartes = 1;
    }

    public Jogo(double duracao){

        this.nEquipas = 1;
        this.duracao = 0;
        this.nPartes = 1;
    }

    public Jogo(int nPartes){

        this.nEquipas = 1;
        this.duracao = 0;
        this.nPartes = 1;
    }

    public Jogo(int nEquipas, double duracao, int nPartes){

        this.nEquipas = nEquipas;
        this.duracao = duracao;
        this.nPartes = nPartes;
    }

    public Jogo(Jogo j){
        this.nEquipas = j.get_NEquipas();
        this.duracao = j.get_Duracao();
        this.nPartes = j.get_NPartes();
    }

    public Jogo clone(){
        return new Jogo(this);
    }

    /**
     * getters
     */
    public int get_NEquipas(){ return this.nEquipas;}
    public double get_Duracao(){ return this.duracao;}
    public int get_NPartes(){ return this.nPartes;}

    /**
     * setters
     */
    public void set_NEquipas(int n){ this.nEquipas = n;}
    public void set_Duracao(double d){ this.duracao = d;}
    public void set_NPartes(int n){ this.nPartes = n;}

    /**
     * equals, Verifica se 2 objetos são iguais
     * @param o Objeto a ser comparado
     * @return True, se forem iguais
     */
    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass() || o == null) return false;

        Jogo that = (Jogo) o;
        return this.nEquipas == that.nEquipas &&
                this.duracao == that.duracao &&
                this.nPartes == that.nPartes;
    }

    /**
     * toString
     */
    public String toString(){

        StringBuilder s = new StringBuilder("\tJogo:\t(+)Numero de equipas: " + this.nEquipas
                + "\n\t\tDuracao: " + this.duracao + "\n\t\tNumero de Partes: " + this.nPartes);
        return s.toString();
    }
}
