/**
 * Jogador Class
 *
 * @author dma_, passas, petty01
 * @version 1.0
 */


public class Jogador{

	private String nome;
	private int idade;
	private float velocidade;
	private float resistencia;
	private float destreza;
	private float impulsao;
											//these are the default technical features of any player


	public Jogador(String nome, int idade){

		this.nome = nome;
		this.idade = idade;
		this.velocidade = 0;
		this.resistencia = 0;
		this.destreza = 0;
		this.impulsao = 0;
	}


	public Jogador(String nome, int idade, float velocidade, float resistencia, float destreza, float impulsao){

		this.nome = nome;
		this.idade = idade;
		this.velocidade = velocidade;
		this.resistencia = resistencia;
		this.destreza = destreza;
		this.impulsao = impulsao;
	}


	public Jogador(Jogador j){

		this.nome = j.getNome();
		this.idade = j.getIdade();
		this.velocidade = j.getVelocidade();
		this.resistencia = j.getResistencia();
		this.destreza = j.getDestreza();
		this.impulsao = j.getImpulsao();
	}

	//Getters,

	public String getNome(){ return this.nome;}
	public int getIdade(){ return this.idade;}
	public float getVelocidade(){ return this.velocidade;}
	public float getResistencia(){ return this.resistencia;}
	public float getDestreza(){ return this.destreza;}
	public float getImpulsao(){ return this.impulsao;}

	//Setters,

	public void setNome(String nome){ this.nome = nome;}
	public void setIdade(int idade){ this.idade = idade;}
	public void setVelocidade(float velocidade){ this.velocidade = velocidade;}
	public void setResistencia(float resistencia){ this.resistencia = resistencia;}
	public void setDestreza(float destreza){ this.destreza = destreza;}
	public void setImpulsao(float impulsao){ this.impulsao = impulsao;}

	//equals method

	public boolean equals(Object o){

		if (this == o) return true;

		if(o == null || this.getClass() != o.getClass()) return false;

		Jogador that = (Jogador) o;

		return this.nome.equals(that.nome) &&
				this.idade == that.idade &&
				this.velocidade == that.velocidade &&
				this.resistencia == that.resistencia &&
				this. destreza == that.destreza &&
				this.impulsao == that.impulsao;
	}

	//toString method

	public String toString(){

		final StringBuffer finalString = new StringBuffer("Jogador " + this.getNome() + "={\n");
		finalString.append("\tIdade: " + this.getIdade() + ";\n");
		finalString.append("\tVelocidade: " + this.getVelocidade() + ";\n");
		finalString.append("\tResistencia: " + this.getResistencia() + ";\n");
		finalString.append("\tDestreza: " + this.getDestreza() + ";\n");
		finalString.append("\tImpulsao: " + this.getImpulsao() + ";\n};\n");

		return finalString.toString();
	}

	//Clone,
	
	public Jogador clone(){

		return new Jogador(this);
	}

}