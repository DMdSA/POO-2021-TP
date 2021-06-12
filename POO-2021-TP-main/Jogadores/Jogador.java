package Jogadores;

import java.io.Serializable;

/**
 * Jogador Class
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */

public class Jogador implements Serializable {
    
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    
    /**
     * Construtores
     */
    public Jogador () {
        this.nome = "";
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
    }

    public Jogador(String nome){
        this.nome = nome;
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
    }

    public Jogador (String nome, int idade, double altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }
    
    public Jogador (Jogador j) {
        this.nome = j.getNome();
        this.idade = j.getIdade();
        this.altura = j.getAltura();
        this.peso = j.getPeso();
    }

    /**
     * Clone
     */
    public Jogador clone(){
        return new Jogador(this);
    }

    /**
     * Getters
     */
    public String getNome () {
        return this.nome;
    }
    
    public int getIdade () {
        return this.idade;
    }
    
    public double getAltura () {
        return this.altura;
    }
    
    public double getPeso () {
        return this.peso;
    }
    
    /**
     * Setters
     */
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public void setIdade (int idade) {
        this.idade = idade;
    }
    
    public void setAltura (double altura) {
        this.altura = altura;
    }
    
    public void setPeso (double peso) {
        this.peso = peso;
    }
    
    /**
     * Equals
     */
    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass() || o == null) return false;

        Jogador that = (Jogador) o;

        return this.getNome().equals(that.getNome()) &&
                this.idade == that.idade &&
                this.altura == that.altura &&
                this.peso == that.peso;
    }

    /**
     * toString
     */
    public String toString(){

        final StringBuffer s = new StringBuffer("\tJogador \"" + this.getNome() + "\" = {\n");
        s.append("\t\tIdade: ").append(this.getIdade()).append(";\n");
        s.append("\t\tAltura: ").append(this.getAltura()).append(";\n");
        s.append("\t\tPeso: ").append(this.getPeso()).append(";\n\t}\n");
        return s.toString();
    }
}