import java.util.ArrayList;
import java.util.List;

/**
 * EquipaFutebol Class
 *
 * @author dma_, passas, petty01
 * @version 1.0
 */


public class EquipaFutebol extends Equipa {

	private int substituicoes;
	private List<JogadorFutebol> jogadoresTitulares;
	private List<JogadorFutebol> jogadoresSuplentes;
	private List<JogadorFutebol> jogadoresSubstituidos;
	private double overall;
	private Cor corPrimaria;
	private Cor corSecundaria;


//Construtores,


	public EquipaFutebol() {

		super();
		this.substituicoes = 3;																	//Confirmar regras!
		this.jogadoresTitulares = new ArrayList<JogadorFutebol>();
		this.jogadoresSuplentes = new ArrayList<JogadorFutebol>();
		this.jogadoresSubstituidos = new ArrayList<JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
	}

	public EquipaFutebol(String nome) {

		super(nome);
		this.substituicoes = 3;
		this.jogadoresTitulares = new ArrayList<JogadorFutebol>();
		this.jogadoresSuplentes = new ArrayList<JogadorFutebol>();
		this.jogadoresSubstituidos = new ArrayList<JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
	}


	public EquipaFutebol(String nome, Cor p, Cor s) {

		super(nome);
		this.substituicoes = 3;
		this.jogadoresTitulares = new ArrayList<JogadorFutebol>();
		this.jogadoresSuplentes = new ArrayList<JogadorFutebol>();
		this.jogadoresSubstituidos = new ArrayList<JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = p;
		this.corSecundaria = s;
	}



	public EquipaFutebol(String nome, int titulares, int suplentes, int substituicoes, List<JogadorFutebol> jTitulares, List<JogadorFutebol> jSuplentes, List<JogadorFutebol> jSubstituidos) {

		super(nome, titulares, suplentes);
		this.substituicoes = substituicoes;

		this.jogadoresTitulares = new ArrayList<JogadorFutebol>();

		for (JogadorFutebol jf : jTitulares)
			this.jogadoresTitulares.add(jf);

		this.jogadoresSuplentes = new ArrayList<JogadorFutebol>();
		for (JogadorFutebol jf : jSuplentes)
			this.jogadoresSuplentes.add(jf);

		this.jogadoresSubstituidos = new ArrayList<JogadorFutebol>();
		for (JogadorFutebol jf : jSubstituidos)
			this.jogadoresSubstituidos.add(jf);

		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
	}


	public EquipaFutebol(String nome, int titulares, int suplentes, int substituicoes, List<JogadorFutebol> jTitulares, List<JogadorFutebol> jSuplentes, List<JogadorFutebol> jSubstituidos, double overall, Cor primaria, Cor secundaria) {

		super(nome, titulares, suplentes);
		this.substituicoes = substituicoes;

		this.jogadoresTitulares = new ArrayList<JogadorFutebol>();
		for (JogadorFutebol jf : jTitulares)
			this.jogadoresTitulares.add(jf);

		this.jogadoresSuplentes = new ArrayList<JogadorFutebol>();
		for (JogadorFutebol jf : jSuplentes)
			this.jogadoresSuplentes.add(jf);

		this.jogadoresSubstituidos = new ArrayList<JogadorFutebol>();
		for (JogadorFutebol jf : jSubstituidos)
			this.jogadoresSubstituidos.add(jf);

		this.overall = overall;
		this.corPrimaria = primaria;
		this.corSecundaria = secundaria;
	}


	public EquipaFutebol(EquipaFutebol ef) {

		super(ef);
		this.substituicoes = ef.getSubstituicoes();

		this.jogadoresTitulares = new ArrayList<>();
		for (JogadorFutebol jf : ef.getJogadoresTitulares())
			this.jogadoresTitulares.add(jf.clone());

		this.jogadoresSuplentes = new ArrayList<>();
		for (JogadorFutebol jf : ef.getJogadoresSuplentes())
			this.jogadoresSuplentes.add(jf.clone());

		this.jogadoresSubstituidos = new ArrayList<>();
		for (JogadorFutebol jf : ef.getJogadoresSubstituidos())
			this.jogadoresSubstituidos.add(jf.clone());

		this.overall = ef.getOverall();
		this.corPrimaria = ef.getCorPrimaria();
		this.corSecundaria = ef.getCorSecundaria();
	}


//Getters,

	public int getSubstituicoes(){ return this.substituicoes;}


	public List<JogadorFutebol> getJogadoresTitulares() {

		return new ArrayList<JogadorFutebol>(this.jogadoresTitulares);
	}


	public List<JogadorFutebol> getJogadoresSuplentes() {

		return new ArrayList<JogadorFutebol>(this.jogadoresSuplentes);
	}


	public List<JogadorFutebol> getJogadoresSubstituidos() {

		return new ArrayList<JogadorFutebol>(this.jogadoresSubstituidos);
	}


	public double getOverall() {
		return this.overall;
	}


	public Cor getCorPrimaria() {
		return this.corPrimaria;
	}


	public Cor getCorSecundaria() {
		return this.corSecundaria;
	}


//Setters,

	public void setSubstituicoes(int substituicoes){ this.substituicoes = substituicoes;}

	public void setJogadoresTitulares(List<JogadorFutebol> jTitulares) {

		this.jogadoresTitulares = new ArrayList<JogadorFutebol>(jTitulares);
	}


	public void setJogadoresSuplentes(List<JogadorFutebol> jSuplentes) {

		this.jogadoresSuplentes = new ArrayList<JogadorFutebol>(jSuplentes);
	}


	public void setJogadoresSubstituidos(List<JogadorFutebol> jSubstituidos) {

		this.jogadoresSubstituidos = new ArrayList<JogadorFutebol>(jSubstituidos);
	}


	public void serOverall(double overall) {
		this.overall = overall;
	}


	public void setCorPrimaria(Cor c) {
		this.corPrimaria = c;
	}


	public void setCorSecundaria(Cor c) {
		this.corSecundaria = c;
	}


//equals,

	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || o.getClass() != this.getClass()) return false;

		EquipaFutebol that = (EquipaFutebol) o;

		return super.equals(that) &&
				this.substituicoes == that.substituicoes &&
				this.jogadoresTitulares.equals(that.jogadoresTitulares) &&
				this.jogadoresSuplentes.equals(that.jogadoresSuplentes) &&
				this.jogadoresSubstituidos.equals(that.jogadoresSubstituidos) &&
				this.overall == that.overall &&
				this.corPrimaria == that.corPrimaria &&
				this.corSecundaria == that.corSecundaria;
	}


//toString,

	public String toString() {

		StringBuilder finalstring = new StringBuilder("Equipa Futebol [" + this.getNome() + "]:\n");

		finalstring.append("\tNumero Titulares: " + this.getTitulares() + ", Numero Suplentes: " + this.getSuplentes() + ", Numero substituicoes: " + this.getSubstituicoes() + "\n");

		finalstring.append("\tTitulares:\n");
		for (JogadorFutebol jf : this.jogadoresTitulares)
			finalstring.append(jf.toString());

		finalstring.append("\tSuplentes:\n");
		for (JogadorFutebol jf : this.jogadoresSuplentes)
			finalstring.append(jf.toString());

		finalstring.append("\tSubstituidos:\n");
		for (JogadorFutebol jf : this.jogadoresSubstituidos)
			finalstring.append(jf.toString());

		finalstring.append("\n");

		return finalstring.toString();
	}


	//clone,
	public EquipaFutebol clone() {

		return new EquipaFutebol(this);
	}


//Adiciona Titular,

	public boolean adicionaTitular(JogadorFutebol jf) {

		if (this.getTitulares() == 11)                                                //Se o limite de jogadores tiver sido alcançado, return false
			return false;


		if (this.jogadoresTitulares.contains(jf))                                //se o jogador já se encontra na equipa, return false
			return false;

		if (jf instanceof GuardaRedes) {                                            //Se o jogador a adicionar é GR &&

			for (JogadorFutebol j : this.jogadoresTitulares) {                    //Se a equipa já tem um guarda-redes, return false
				if (j instanceof GuardaRedes)
					return false;
			}
		}


		this.jogadoresTitulares.add(jf);
		this.setTitulares(this.getTitulares() + 1);
		return true;
	}


//Remove titular,

	public boolean removeTitular(JogadorFutebol jf) {

		if (this.getTitulares() == 0) return false;

		if (this.jogadoresTitulares.contains(jf)) {
			this.jogadoresTitulares.remove(jf);
			this.setTitulares(this.getTitulares() - 1);
			return true;
		} 

		else return false;
	}


//Adiciona Suplente,

	public boolean adicionaSuplente(JogadorFutebol jf) {

		if (this.getSuplentes() == 12)                                                //Se o limite de jogadores tiver sido alcançado, return false
			return false;


		if (this.jogadoresSuplentes.contains(jf))                                //se o jogador já se encontra na equipa, return false
			return false;

		this.jogadoresSuplentes.add(jf);
		this.setSuplentes(this.getSuplentes() + 1);
		return true;
	}


//Remove Suplente,

	public boolean removeSuplente(JogadorFutebol jf) {

		if (this.getSuplentes() == 0) return false;

		if (this.jogadoresSuplentes.contains(jf)) {
			this.jogadoresSuplentes.remove(jf);
			this.setSuplentes(this.getSuplentes() - 1);
			return true;
		} else return false;
	}


//Confirma se equipa tem os jogadores necessários

	public boolean isReady(){													//Confirma se a equipa tem o número de jogadores necessários para começar


		if(this.getTitulares() >= 7 && this.getTitulares() <= 11){

			if(this.getSuplentes() <= 12){

				for(JogadorFutebol j : this.jogadoresTitulares)
					if(j instanceof GuardaRedes)
						return true;
			}
		}

		return false;
	}


//Adiciona Substituido

	public boolean adicionaSubstituido(JogadorFutebol j){

		if(this.jogadoresSubstituidos.contains(j)) 
			return false;

		this.jogadoresSubstituidos.add(j);
		return true;
	}



//Remove Substituido

	public boolean removeSubstituido(JogadorFutebol j){

		if(this.jogadoresSubstituidos.isEmpty()) return false;

		if(this.jogadoresSubstituidos.contains(j)){
			this.jogadoresSubstituidos.remove(j);
			return true;
		}
		
		return false;
	}



//Substituicao

	public boolean substitui(JogadorFutebol jCampo, JogadorFutebol jBanco){

		if(jCampo instanceof GuardaRedes && jBanco instanceof JogadorFutebol) return false;

		if(this.jogadoresTitulares.contains(jCampo) && this.jogadoresSuplentes.contains(jBanco) && substituicoes > 0){

			this.adicionaTitular(jBanco);
			this.removeSuplente(jBanco);
			this.adicionaSubstituido(jCampo);
			this.substituicoes--;
			this.removeTitular(jCampo);
			return true;
		}

		return false;
	}




//getHabilidade

	public double getHabilidade(){

		double habilidade = 0;

		for(JogadorFutebol jf : this.jogadoresTitulares)
			habilidade += jf.getHabilidade();

		return habilidade;
	}


}