import java.util.ArrayList;

/**
 * Equipa class
 *
 * @author dma_, passas, petty01
 * @version 1.0
 */


public abstract class Equipa{															//Sendo uma classe abstrata, nunca será um objeto, daí não ter construtores


private String nome;
private int titulares; //de 7 até 11
private int suplentes; //de 7 até 12



//Getters,

public String getNome(){ return this.nome;}

public int getTitulares(){ return this.titulares;}

public int getSuplentes(){ return this.suplentes;}



//Setters,

public void setNome(String nome){ this.nome = nome;}

public void setTitulares(int titulares){ this.titulares = titulares;}

public void setSuplentes(int suplentes){ this.suplentes = suplentes;}



//Equals,

public abstract boolean equals(Object o);



//toString,

public abstract String toString();

}