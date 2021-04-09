import java.util.ArrayList;

/**
 * EquipaFutebol Class
 *
 * @author dma_, passas, petty01
 * @version 1.0
 */


public class EquipaFutebol extends Equipa{


private ArrayList<JogadorFutebol> listaJogadores;
private double overall;
private Cor corPrimaria;
private Cor corSecundaria;


//Construtores,

public EquipaFutebol(String nome){

	this.setNome(nome);
	this.setTitulares(0);
	this.setSuplentes(0);
	this.listaJogadores = new ArrayList<JogadorFutebol>();
	this.overall = 0;
	this.corPrimaria = Cor.NONE;
	this.corSecundaria = Cor.NONE;
}



public EquipaFutebol(String nome, int titulares, int suplentes, ArrayList<JogadorFutebol> listaJogadores){

	super(nome, titulares, suplentes);
	this.listaJogadores = new ArrayList<JogadorFutebol>(titulares + suplentes);
	for(JogadorFutebol jf : listaJogadores) this.listaJogadores.add(jf);
	this.overall = 0;
	this.corPrimaria = Cor.NONE;
	this.corSecundaria = Cor.NONE;
}



public EquipaFutebol(String nome, int titulares, int suplentes, ArrayList<JogadorFutebol> listaJogadores, double overall, Cor primaria, Cor secundaria){

	super(nome, titulares, suplentes);
	this.listaJogadores = new ArrayList<JogadorFutebol>(titulares + suplentes);
	for(JogadorFutebol jf : listaJogadores) this.listaJogadores.add(jf);
	this.overall = overall;
	this.corPrimaria = primaria;
	this.corSecundaria = secundaria;
}



public EquipaFutebol(EquipaFutebol ef){

	super(ef);
	this.listaJogadores = new ArrayList<>(ef.getListaJogadores());
	this.overall = ef.getOverall();
	this.corPrimaria = ef.getCorPrimaria();
	this.corSecundaria = ef.getCorSecundaria();
}



//Getters,

public ArrayList<JogadorFutebol> getListaJogadores(){

	return this.listaJogadores;
}

public double getOverall(){ return this.overall;}

public Cor getCorPrimaria(){ return this.corPrimaria;}

public Cor getCorSecundaria(){ return this.corSecundaria;}


//Setters,

public void setListaJogadores(ArrayList<JogadorFutebol> listaJogadores){

	this.listaJogadores = new ArrayList<JogadorFutebol>();
	for(JogadorFutebol jf : listaJogadores) this.listaJogadores.add(jf);
}


public void serOverall(double overall){ this.overall = overall;}

public void setCorPrimaria(Cor c){ this.corPrimaria = c;}

public void setCorSecundaria(Cor c){ this.corSecundaria = c;}



//equals,

public boolean equals(Object o){

	if(this == o) return true;
	if(o == null || o.getClass() != this.getClass()) return false;

	EquipaFutebol that = (EquipaFutebol) o;

	return this.getNome().equals(that.getNome()) &&
			this.listaJogadores.equals(that.listaJogadores) &&
			this.overall == that.overall &&
			this.corPrimaria == that.corPrimaria &&
			this.corSecundaria == that.corSecundaria;
}




//toString,

public String toString(){

	StringBuilder finalstring = new StringBuilder("Equipa Futebol [" + this.getNome() + "]:\n");
	for(JogadorFutebol jf : this.listaJogadores)
		finalstring.append(jf.toString());

	finalstring.append("\n");

	return finalstring.toString();
}




//clone,
public EquipaFutebol clone(){

	return new EquipaFutebol(this);
}










public void adicionaTitular(JogadorFutebol jf){							//Confirmar que funciona, só para lembrar que é preciso fazer distinção entre titulares/suplentes

	//verificar,
	if(this.getTitulares() == 11){										//errado, porque neste array estarão N titulares + M suplentes

		System.out.println("erro_ Esta equipa ja esta cheia");
		return;
	}

	for(JogadorFutebol j : this.listaJogadores){

		if (j.equals(jf)){
			System.out.println("Esse jogador ja se encontra nesta equipa!");
			return;
		}
	}
	

	this.listaJogadores.add(jf);
	if(this.getTitulares() >= 1)
		this.setTitulares(this.getTitulares() + 1);
}



public void removeTitular(JogadorFutebol jf){

	if(this.listaJogadores.removeIf(j -> j.equals(jf))) {
		System.out.println("Jogador removido com sucesso");
		if(this.getTitulares() >= 1)
			this.setTitulares(this.getTitulares() - 1);
	}

	else System.out.println("Esse jogador nao se encontrava nesta equipa");

}

}
