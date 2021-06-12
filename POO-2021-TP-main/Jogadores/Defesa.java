package Jogadores;
import java.util.List;

public class Defesa extends JogadorFutebol{


	private double capacidadeBloquearBolas;


//Constructors,

	public Defesa(){

		super();
		this.capacidadeBloquearBolas = 0;
	}


	public Defesa(String nome, PosicaoCampo posicao){

		super(nome, posicao);
		this.capacidadeBloquearBolas = 0;
	}


                //Com overall + historico
	public Defesa (String nome, int idade, float altura, float peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                    double jogoCabeca, double remate, double passe, double humor, List<String> historico, double capacidadeBloquearBolas){


		super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
		this.capacidadeBloquearBolas = capacidadeBloquearBolas;
	}


                //Com overall - historico
    public Defesa (String nome, int idade, float altura, float peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                    double jogoCabeca, double remate, double passe, double humor, double capacidadeBloquearBolas){


        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeBloquearBolas = capacidadeBloquearBolas;
    }


            //Sem overall + historico
    public Defesa (String nome, int idade, float altura, float peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                    double jogoCabeca, double remate, double passe, double humor, List<String> historico, double capacidadeBloquearBolas){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.capacidadeBloquearBolas = capacidadeBloquearBolas;
    }


            //Sem overall - historico
    public Defesa (String nome, int idade, float altura, float peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                    double jogoCabeca, double remate, double passe, double humor, double capacidadeBloquearBolas){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeBloquearBolas = capacidadeBloquearBolas;
    }

	public Defesa(Defesa d){

		super(d);
		this.capacidadeBloquearBolas = d.getCapacidadeBloquearBolas();
	}

            //Constructor c/formato LOGS
    public Defesa(String nome, int numero, double velocidade, double resistencia, double destreza, double impulsao, double cabeca, double remate, double passe){

        super(nome, PosicaoCampo.D);
        this.setNumero(numero);
        this.setVelocidade(velocidade);
        this.setResistencia(resistencia);
        this.setDestreza(destreza); this.setImpulsao(impulsao); this.setJogoCabeca(cabeca); this.setRemate(remate); this.setPasse(passe);
    }
    //Defesa:<Nome>,<NumeroCamisola>,<Velocidade>,<Resistência>,<Destreza>,<Impulsão>,<Cabeça>,<Remate>,<Passe>


            //Parsed constructor
    public static Defesa parse(String input){

        String[] parametros = input.split(",");

        return new Defesa(parametros[0], Integer.parseInt(parametros[1]),
                Double.parseDouble(parametros[2]),
                Double.parseDouble(parametros[3]),
                Double.parseDouble(parametros[4]),
                Double.parseDouble(parametros[5]),
                Double.parseDouble(parametros[6]),
                Double.parseDouble(parametros[7]),
                Double.parseDouble(parametros[8]));
    }




///Getters,

	public double getCapacidadeBloquearBolas(){ return this.capacidadeBloquearBolas;}


//Setters,

	public void setCapacidadeBloquearBolas(double bloquearbolas){ this.capacidadeBloquearBolas = bloquearbolas;}



//equals,

	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.capacidadeBloquearBolas == ((Defesa)o).capacidadeBloquearBolas;
    }


//clone,

    public Defesa clone(){ return new Defesa(this);}


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
        finalString.append("\t\t\tCapacidade bloquear bolas: " + this.getCapacidadeBloquearBolas() + ";\n");
        finalString.append("\t\t\tHistorico equipas: " + this.getHistorico().toString() + ";\n}\n");

        return finalString.toString();
    }



    public double getHabilidade(){

        double habilidade = 0;
        habilidade += this.getVelocidade() + this.getImpulsao() + this.getResistencia() + this.getDestreza()*1.5 + this.getJogoCabeca()/2 + this.getRemate()/2 + this.getPasse() + this.getCapacidadeBloquearBolas()*1.5;
        //Ilustrativo, defini 1 para todas as habilidades "comuns"
        return habilidade/8;
    }

    public void add_extra(double extra){
	    this.capacidadeBloquearBolas = extra;
    }


}