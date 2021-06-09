package Jogadores;
import java.util.List;

public class Avancado extends JogadorFutebol{


	private double finalizacao;


//Constructors,

	public Avancado(){

		super();
		this.finalizacao = 0;
	}


	public Avancado(String nome, PosicaoCampo posicao){

		super(nome, posicao);

		this.finalizacao = 0;
	}

                    //Com overall + historico
	public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, List<String> historico, double finalizacao){


		super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
		this.finalizacao = finalizacao;
	}

                    //Com overall - historico
    public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, double finalizacao){


        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.finalizacao = finalizacao;
    }

                    //Sem overall + historico
    public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, List<String> historico, double finalizacao){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.finalizacao = finalizacao;
    }

                    //Sem overall - historico
    public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, double finalizacao){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.finalizacao = finalizacao;
    }


	public Avancado(Avancado av){

		super(av);
		this.finalizacao = av.getFinalizacao();
	}

                //Construtor c/Formato dos LOGS
    public Avancado (String nome, int numero, double velocidade, double resistencia, double destreza, double impulsao, double cabeca, double remate, double passe){

        super(nome, PosicaoCampo.A);
        this.setNumero(numero);
        this.setVelocidade(velocidade);
        this.setResistencia(resistencia);
        this.setDestreza(destreza); this.setImpulsao(impulsao); this.setJogoCabeca(cabeca); this.setRemate(remate); this.setPasse(passe);
    }
    //Avancado:<Nome>,<NumeroCamisola>,<Velocidade>,<Resistência>,<Destreza>,<Impulsão>,<Cabeça>,<Remate>,<Passe>


    //Parsed Constructor
    public static Avancado parse(String input){

        String[] campos = input.split(",");
        
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Double.parseDouble(campos[2]),
                Double.parseDouble(campos[3]),
                Double.parseDouble(campos[4]),
                Double.parseDouble(campos[5]),
                Double.parseDouble(campos[6]),
                Double.parseDouble(campos[7]),
                Double.parseDouble(campos[8]));
    }


///Getters,

	public double getFinalizacao(){ return this.finalizacao;}


//Setters,

	public void setFinalizacao(double finalizacao){ this.finalizacao = finalizacao;}



//equals,

	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.finalizacao == ((Avancado)o).finalizacao;
    }


//clone,

    public Avancado clone(){ return new Avancado(this);}


//toString,

    public String toString(){

        final StringBuffer finalString = new StringBuffer("\tJogador \"" + this.getNome() + "\" = {\n");
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
        finalString.append("\t\t\tFinalizacao: " + this.getFinalizacao() + ";\n");
        finalString.append("\t\t\tHistorico equipas: " + this.getHistorico().toString() + ";\n}\n");

        return finalString.toString();
    }



    public double getHabilidade(){
    
        double habilidade = 0;
        habilidade += this.fatorIdade() + 1 + 1 + 1 + 1 + 1 + 1 + 1 + this.getHumor()*2 + this.getFinalizacao() * 2;
        //Ilustrativo, defini 1 para todas as habilidades "comuns"
        return habilidade;
    }

    public void add_extra(double extra){
	    this.finalizacao = extra;
    }

}