package Equipa;
import Jogadores.GuardaRedes;
import Jogadores.JogadorFutebol;

import java.util.*;
import java.util.stream.Collectors;

/**
 * EquipaFutebol Class
 *
 * @author dma_, passas, petty01
 * @version 1.0
 */


public class EquipaFutebol extends Equipa {

	private int substituicoes;
	private Map<String, JogadorFutebol> jogadoresTitulares;
	private Map<String, JogadorFutebol> jogadoresSuplentes;
	private double overall;
	private Cor corPrimaria;
	private Cor corSecundaria;
	private int golos;


//Construtores,


	public EquipaFutebol() {

		super();
		this.substituicoes = 3;																	//Confirmar regras!
		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
		this.golos = 0;
	}

	public EquipaFutebol(String nome) {

		super(nome);
		this.substituicoes = 3;
		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
		this.golos = 0;
	}


	public EquipaFutebol(String nome, Cor p, Cor s) {

		super(nome);
		this.substituicoes = 3;
		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = p;
		this.corSecundaria = s;
		this.golos = 0;
	}



	public EquipaFutebol(String nome, int titulares, int suplentes, int substituicoes, List<JogadorFutebol> jTitulares, List<JogadorFutebol> jSuplentes) {

		super(nome, titulares, suplentes);
		this.substituicoes = substituicoes;

		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();

		for (JogadorFutebol jf : jTitulares)
			this.jogadoresTitulares.put(jf.getNome(), jf.clone());

		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		for (JogadorFutebol jf : jSuplentes)
			this.jogadoresSuplentes.put(jf.getNome(), jf.clone());

		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
		this.golos = 0;
	}


	public EquipaFutebol(String nome, int titulares, int suplentes, int substituicoes, List<JogadorFutebol> jTitulares, List<JogadorFutebol> jSuplentes, double overall, Cor primaria, Cor secundaria) {

		super(nome, titulares, suplentes);
		this.substituicoes = substituicoes;

		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		for (JogadorFutebol jf : jTitulares)
			this.jogadoresTitulares.put(jf.getNome(), jf.clone());

		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		for (JogadorFutebol jf : jSuplentes)
			this.jogadoresSuplentes.put(jf.getNome(), jf.clone());

		this.overall = overall;
		this.corPrimaria = primaria;
		this.corSecundaria = secundaria;
		this.golos = 0;
	}


	public EquipaFutebol(EquipaFutebol ef) {

		super(ef);
		this.substituicoes = ef.getSubstituicoes();

		this.jogadoresTitulares = ef.getJogadoresTitulares().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));

		this.jogadoresSuplentes = ef.getJogadoresSuplentes().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));

		this.overall = ef.getOverall();
		this.corPrimaria = ef.getCorPrimaria();
		this.corSecundaria = ef.getCorSecundaria();
		this.golos = ef.getGolos();
	}



	public static EquipaFutebol parse(String input){

		String[] parametro = input.split(",");
		return new EquipaFutebol(parametro[0]);
	}





//Getters,

	public int getSubstituicoes(){ return this.substituicoes;}


	public Map<String, JogadorFutebol> getJogadoresTitulares() {

		return this.jogadoresTitulares.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
	}


	public Map<String, JogadorFutebol> getJogadoresSuplentes() {

		return this.jogadoresSuplentes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
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

	public int getGolos(){ return this.golos;}

	public int get_numero_titulares(){ return this.jogadoresTitulares.size();}

	public int get_numero_suplentes(){ return this.jogadoresSuplentes.size();}


//Setters,

	public void setSubstituicoes(int substituicoes){ this.substituicoes = substituicoes;}

	public void setJogadoresTitulares(Map<String, JogadorFutebol> jTitulares) {

		this.jogadoresTitulares = jTitulares.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
	}


	public void setJogadoresSuplentes(Map<String, JogadorFutebol> jSuplentes) {

		this.jogadoresSuplentes = jSuplentes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
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

	public void setGolos(int golos){ this.golos = golos;}


//equals,

	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || o.getClass() != this.getClass()) return false;

		EquipaFutebol that = (EquipaFutebol) o;

		return super.equals(that) &&
				this.substituicoes == that.substituicoes &&
				this.jogadoresTitulares.equals(that.jogadoresTitulares) &&
				this.jogadoresSuplentes.equals(that.jogadoresSuplentes) &&
				this.overall == that.overall &&
				this.corPrimaria == that.corPrimaria &&
				this.corSecundaria == that.corSecundaria &&
				this.golos == that.golos;
	}


//toString,

	public String toString() {

		StringBuilder finalstring = new StringBuilder("Equipa Futebol [" + this.getNome() + "]:\n");

		finalstring.append("\tNumero Titulares: ").append(this.getTitulares()).append(", Numero Suplentes: ").append(this.getSuplentes()).append(", Numero substituicoes: ").append(this.getSubstituicoes()).append("\n");

		finalstring.append("\tTitulares:\n");
		for (Map.Entry<String, JogadorFutebol> jf : this.jogadoresTitulares.entrySet())
			finalstring.append(jf.toString());

		finalstring.append("\tSuplentes:\n");
		for (Map.Entry<String, JogadorFutebol> jf : this.jogadoresSuplentes.entrySet())
			finalstring.append(jf.toString());

		finalstring.append("\tGolos: ").append(this.golos).append("\n");

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


		if (this.jogadoresTitulares.containsKey(jf.getNome()))                                //se o jogador já se encontra na equipa, return false
			return false;

		if (jf instanceof GuardaRedes) {                                            //Se o jogador a adicionar é GR &&

			for (Map.Entry<String, JogadorFutebol> j : this.jogadoresTitulares.entrySet()) {                    //Se a equipa já tem um guarda-redes, return false
				if (j.getValue() instanceof GuardaRedes)
					return false;
			}
		}

		this.jogadoresTitulares.put(jf.getNome(), jf.clone());
		this.setTitulares(this.getTitulares() + 1);
		return true;
	}


//Remove titular,

	public boolean removeTitular(JogadorFutebol jf) {

		if (this.getTitulares() == 0) return false;

		if (this.jogadoresTitulares.containsKey(jf.getNome())) {
			this.jogadoresTitulares.remove(jf.getNome(), jf);
			this.setTitulares(this.getTitulares() - 1);
			return true;
		} 

		else return false;
	}


//Adiciona Suplente,

	public boolean adicionaSuplente(JogadorFutebol jf) {

		if (this.getSuplentes() == 12)                                                //Se o limite de jogadores tiver sido alcançado, return false
			return false;


		if (this.jogadoresSuplentes.containsKey(jf.getNome()))                                //se o jogador já se encontra na equipa, return false
			return false;

		this.jogadoresSuplentes.put(jf.getNome(), jf.clone());
		this.setSuplentes(this.getSuplentes() + 1);
		return true;
	}


//Remove Suplente,

	public boolean removeSuplente(JogadorFutebol jf) {

		if (this.getSuplentes() == 0) return false;

		if (this.jogadoresSuplentes.containsKey(jf.getNome())) {
			this.jogadoresSuplentes.remove(jf.getNome(), jf);
			this.setSuplentes(this.getSuplentes() - 1);
			return true;
		} else return false;
	}


//Confirma se equipa tem os jogadores necessários

	public boolean isReady(){													//Confirma se a equipa tem o número de jogadores necessários para começar


		if(this.getTitulares() >= 7 && this.getTitulares() <= 11){

			if(this.getSuplentes() <= 12){

				for(Map.Entry<String, JogadorFutebol> j : this.jogadoresTitulares.entrySet())
					if(j.getValue() instanceof GuardaRedes)
						return true;
			}
		}

		return false;
	}


//Substituicao

	public boolean substitui(JogadorFutebol jCampo, JogadorFutebol jBanco){

		if(jCampo instanceof GuardaRedes && jBanco instanceof JogadorFutebol) return false;

		if(this.jogadoresTitulares.containsKey(jCampo.getNome()) && this.jogadoresSuplentes.containsKey(jBanco.getNome()) && substituicoes > 0){

			this.removeTitular(jCampo);

			this.adicionaTitular(jBanco);
			this.removeSuplente(jBanco);
			this.adicionaSuplente(jCampo);

			this.substituicoes--;
			return true;
		}

		return false;
	}




//getHabilidade

	public double getHabilidade(){

		double habilidade = 0;

		for(Map.Entry<String, JogadorFutebol> jf : this.jogadoresTitulares.entrySet())
			habilidade += jf.getValue().getHabilidade();

		return habilidade;
	}


//addGolo
	public void addGolo(){
		this.golos++;
	}


	public JogadorFutebol getJogador(int numero){


		for(Map.Entry<String, JogadorFutebol> jf : this.jogadoresTitulares.entrySet()){
			if(jf.getValue().getNumero() == numero) return jf.getValue().clone();
		}

		for(Map.Entry<String, JogadorFutebol> jf : this.jogadoresSuplentes.entrySet()){
			if(jf.getValue().getNumero() == numero) return jf.getValue().clone();
		}

		return new JogadorFutebol();			//Aqui devem-se tratar exceptions iguess, visto q em poo "n existe null"
	}


	public boolean hasJogador(String j){

		if(this.jogadoresTitulares.containsKey(j)) return true;
		return this.jogadoresSuplentes.containsKey(j);
	}

	public boolean hasTitular(String j){

		return this.jogadoresTitulares.containsKey(j);
	}

	public boolean hasSuplente(String j){

		return this.jogadoresSuplentes.containsKey(j);
	}


	public boolean substituir(String j1, String j2){

        if(!this.hasTitular(j1) || !this.hasSuplente(j2)){
            return false;   //neste caso não é feita nenhuma substituição
        }

        return this.substitui(this.jogadoresTitulares.get(j1), this.jogadoresSuplentes.get(j2));

    }
}