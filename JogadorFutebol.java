/**
 * Jogador Class
 *
 * @author dma_, passas, petty01
 * @version 1.0
 */


public class JogadorFutebol extends Jogador{

	private String posicao;
	private float jogoCabeca;
	private float remate;
	private float capacidadePasse;
		//Defesas, Médios, Avançados, Laterais


	public JogadorFutebol(String nome, int idade, String posicao){

		super(nome, idade);
		this.posicao = posicao;
	}

	public JogadorFutebol(String nome, int idade, String posicao, float velocidade, float resistencia, float destreza, float impulsao float jogoCabeca, float remate, float capacidadePasse){

		super(nome, idade, velocidade, resistencia, destreza, impulsao);
		this.posicao = posicao;
		this.jogoCabeca = jogoCabeca;
		this.remate = remate;
		this.capacidadePasse = capacidadePasse;
	}

	public JogadorFutebol(JogadorFutebol j){

		super(j);
		this.posicao = j.getPosicao();
		this.jogoCabeca = j.getJogoCabeca();
		this.remate = j.getRemate();
		this.capacidadePasse = j.getCapacidadePasse();
	}


	//Getters,

	public String getPosicao(){ return this.posicao;}
	public float getJogoCabeca(){ return this.jogoCabeca;}
	public float getRemate(){ return this.remate;}
	public float getCapacidadePasse(){ return this.capacidadePasse;}


	//setters,

	public void setPosicao(String posicao){ this.posicao = posicao;}
	public void setJogoCabeca(float jogoCabeca){ this.jogoCabeca = jogoCabeca;}
	public void setRemate(float remate){ this.remate = remate;}
	public void setCapacidadePasse(float capacidadePasse){ this.capacidadePasse = capacidadePasse;}


	//equals,

	public boolean equals(Object o){

		if(this == o) return true;

		if(o == null || this.getClass() != o.getClass()) return false;

		JogadorFutebol that = (JogadorFutebol) o;

		return super.equals(that) &&
				this.posicao.equals(that.posicao) &&
				this.jogoCabeca == that.jogoCabeca &&
				this.remate == that.remate &&
				this.capacidadePasse == that.capacidadePasse;
	}


	public String toString(){

		final StringBuffer finalString = new StringBuffer("JogadorFutebol " + this.getNome() + "={\n");
		finalString.append("\tIdade: " + this.getIdade() + ";\n");
		finalString.append("\tPosicao: " + this.getPosicao() + ";\n");
		finalString.append("\tVelocidade: " + this.getVelocidade() + ";\n");
		finalString.append("\tResistencia: " + this.getResistencia() + ";\n");
		finalString.append("\tDestreza: " + this.getDestreza() + ";\n");
		finalString.append("\tImpulsao: " + this.getImpulsao() + ";\n");
		finalString.append("\tJogo Cabeca: " + this.getJogoCabeca() + ";\n");
		finalString.append("\tRemate: " + this.getRemate() + ";\n");
		finalString.append("\tCapacidade Passe: " + this.getCapacidadePasse() + ";\n}\n");

		return finalString.toString();
	}


	//Clone,
	
	public JogadorFutebol clone(){

		return new JogadorFutebol(this);
	}



}