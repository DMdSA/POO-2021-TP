package Jogadores;

import java.util.List;

public class Medio extends JogadorFutebol{


	private double capacidadeRecuperarBolas;


//Constructors,

	public Medio(){

		super();
		this.capacidadeRecuperarBolas = 0;
	}


	public Medio(String nome, PosicaoCampo posicao){

		super(nome, posicao);
		this.capacidadeRecuperarBolas = 0;
	}

                //Com overall + historico
	public Medio (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                  double jogoCabeca, double remate, double passe, double humor, List<String> historico, double capacidadeRecuperarBolas){


		super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
		this.capacidadeRecuperarBolas = capacidadeRecuperarBolas;
	}

                //Com overall - historico
public Medio (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
              double jogoCabeca, double remate, double passe, double humor, double capacidadeRecuperarBolas){


        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeRecuperarBolas = capacidadeRecuperarBolas;
    }


                //Sem overall + historico
    public Medio (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                  double jogoCabeca, double remate, double passe, double humor, List<String> historico, double capacidadeRecuperarBolas){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.setOverall(this.getHabilidade());
        this.capacidadeRecuperarBolas = capacidadeRecuperarBolas;
    }

                //Sem overall - historico
    public Medio (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                  double jogoCabeca, double remate, double passe, double humor, double capacidadeRecuperarBolas){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeRecuperarBolas = capacidadeRecuperarBolas;
    }


	public Medio(Medio d){

		super(d);
		this.capacidadeRecuperarBolas = d.getCapacidadeRecuperarBolas();
	}



///Getters,

	public double getCapacidadeRecuperarBolas(){ return this.capacidadeRecuperarBolas;}


//Setters,

	public void setCapacidadeRecuperarBolas(double recuperarbolas){ this.capacidadeRecuperarBolas = recuperarbolas;}



//equals,

	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.capacidadeRecuperarBolas == ((Medio)o).capacidadeRecuperarBolas;
    }


//clone,

    public Medio clone(){ return new Medio(this);}


//toString,

    public String toString(){

        final StringBuffer finalString = new StringBuffer("\tJogadores.Jogador \"" + this.getNome() + "\" = {\n");
        finalString.append("\t\t\tPosicao: " + PosicaoCampo.printPosicao(this.getPosicaoCampo()) + ";\n");
        finalString.append("\t\t\tIdade: " + this.getIdade() + ";\n");
        finalString.append("\t\t\tPeso: " + this.getPeso() + ";\n");
        finalString.append("\t\t\tAltura: " + this.getAltura() + ";\n");
        finalString.append("\t\t\tNumero: " + this.getNumero() + ";\n");
        finalString.append("\t\t\tOverall: " + this.getOverall() + ";\n");
        finalString.append("\t\t\tVelocidade: " + this.getVelocidade() + ";\n");
        finalString.append("\t\t\tImpulsao: " + this.getImpulsao() + ";\n");
        finalString.append("\t\t\tResistencia: " + this.getResistencia() + ";\n");
        finalString.append("\t\t\tDestreza: " + this.getDestreza() + ";\n");
        finalString.append("\t\t\tJogo Cabeca: " + this.getJogoCabeca() + ";\n");
        finalString.append("\t\t\tRemate: " + this.getRemate() + ";\n");
        finalString.append("\t\t\tCapacidade Passe: " + this.getPasse() + ";\n");
        finalString.append("\t\t\tHumor: " + this.getHumor() + ";\n");
        finalString.append("\t\t\tCapacidade recuperar bolas: " + this.getCapacidadeRecuperarBolas() + ";\n");
        finalString.append("\t\t\tHistorico equipas: " + this.getHistorico().toString() + ";\n}\n");

        return finalString.toString();
    }


//getHabilidade
    public double getHabilidade(){
    
        double habilidade = 0;
        habilidade += this.fatorIdade() + 1 + 1 + 1 + 1 + 1 + 1 + 1 + this.getHumor()*2 + this.getCapacidadeRecuperarBolas()* 2;
        //Ilustrativo, defini 1 para todas as habilidades "comuns"
        return habilidade;
    }




}