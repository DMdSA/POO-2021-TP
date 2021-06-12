package Equipa;
import java.io.Serializable;

/**
 * Equipa Class
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */

public class Equipa implements Serializable {
    /**                                            Variáveis instância  */
    private String nome;
    private int titulares;
    private int suplentes;


    /**
     * Construtores
     */
    public Equipa(){
        
        this.nome = "none_";
        this.titulares = 0;
        this.suplentes = 0;
    }

    public Equipa(String nome) {
        
        this.nome = nome;
        this.titulares = 0;
        this.suplentes = 0;
    }

    public Equipa(String nome, int titulares, int suplentes) {
        
        this.nome = nome;
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public Equipa(Equipa equipa) {
        
        this.nome = equipa.getNome();
        this.titulares = equipa.getTitulares();
        this.suplentes = equipa.getSuplentes();
    }

    /**
     * clone
     */
    public Equipa clone(){
        return new Equipa(this);
    }

    /**
     * getters e setters
     */
    public String getNome() {
        return this.nome;
    }

    public int getTitulares() {
        return titulares;
    }

    public int getSuplentes() {
        return suplentes;
    }

    public void setNome(String nome) { this.nome = nome;}

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
    }

    /**
     * equals
     * @param o Objeto a ser comparado
     * @return True, se os objetos forem iguais
     */
    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass() || o == null) return false;
        Equipa that = (Equipa) o;
        return this.nome.equals(that.getNome()) &&
                this.titulares == that.getTitulares() &&
                this.suplentes == that.getSuplentes();
    }

    /**
     * toString
     */
    public String toString() {
       

        StringBuilder finalstring = new StringBuilder("Equipa [" + this.getNome() + "] = \n\t");
        finalstring.append("Numero Titulares : ").append(this.getTitulares()).append("\n\t");
        finalstring.append("Numero Suplentes : ").append(this.getSuplentes()).append("\n");
        return finalstring.toString();
    }
}
