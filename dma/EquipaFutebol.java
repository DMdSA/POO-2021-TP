import java.util.ArrayList;

/**
 * EquipaFutebol Class
 *
 * @author dma_, passas, petty01
 * @version 1.0
 */


public class EquipaFutebol extends Equipa{


private List<JogadorFutebol> listaJogadores;
private double overall;
private Cor corPrimaria;
private Cor corSecundaria;


//Construtores,

public EquipaFutebol(String nome, int titulares, int suplentes, List<JogadorFutebol> listaJogadores){

	this.setNome(nome);
	this.setTitulares(titulares);
	this.setSuplentes(suplentes);
	this.listaJogadores = new ArrayList<JogadorFutebol>(titulares + suplentes);
	for(JogadorFutebol jf : listaJogadores) this.listaJogadores.add(jf);
	this.overall = 0;
	this.corPrimaria = Cor.PRETO;
	this.corSecundaria = Cor.BRANCO;
}



public EquipaFutebol(String nome, int titulares, int suplentes, List<JogadorFutebol> listaJogadores, double overall, Cor primaria, Cor secundaria){

	this.setNome(nome);
	this.setTitulares(titulares);
	this.setSuplentes(suplentes);
	this.listaJogadores = new ArrayList<JogadorFutebol>(titulares + suplentes);
	for(JogadorFutebol jf : listaJogadores) this.listaJogadores.add(jf);
	this.overall = overall;
	this.corPrimaria = primaria;
	this.corSecundaria = secundaria;
}

public EquipaFutebol(EquipaFutebol ef){

	this.setNome(ef.getNome());
	this.setTitulares(ef.getTitulares());
	this.setSuplentes(ef.getSuplentes());
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




public void adicionaTitular(JogadorFutebol jf){

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
	if(this.getTitulares() >= 1)												//Deixar, como base, sempre o mínimo de jogadores, mesmo que possa não os ter guardados
		this.setTitulares(this.getTitulares() + 1);
}



public void removeTitular(JogadorFutebol jf){

	if(this.listaJogadores.removeIf(j -> j.equals(jf))) {
		System.out.println("Jogador removido com sucesso");
		if(this.getTitulares() >= 1)											//Deixar, como base, sempre o mínimo de jogadoes, mesmo que possa não os ter guardados
			this.setTitulares(this.getTitulares() - 1);
	}

	else System.out.println("Esse jogador nao se encontrava nesta equipa");

}










}