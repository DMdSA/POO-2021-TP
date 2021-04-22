import java.util.List;

public class Lateral extends JogadorFutebol{


	private double capacidadeCruzamentos;


//Constructors,

	public Lateral(){

		super();
		this.capacidadeCruzamentos = 0;
	}


	public Lateral(String nome, PosicaoCampo posicao){

		super(nome, posicao);
		this.capacidadeCruzamentos = 0;
	}

            //Com overall + historico
	public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, List<String> historico, double cruzamentos){


		super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
		this.capacidadeCruzamentos = cruzamentos;
	}

            //Com overall - historico
    public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, double cruzamentos){


        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeCruzamentos = cruzamentos;
    }

            //Sem overall + historico
    public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, List<String> historico, double cruzamentos){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.capacidadeCruzamentos = cruzamentos;
    }


            //Sem overall - historico
    public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, double cruzamentos){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeCruzamentos = cruzamentos;
    }



	public Lateral(Lateral d){

		super(d);
		this.capacidadeCruzamentos = d.getCapacidadeCruzamentos();
	}



///Getters,

	public double getCapacidadeCruzamentos(){ return this.capacidadeCruzamentos;}


//Setters,

	public void setCapacidadeCruzamentos(double cruzamentos){ this.capacidadeCruzamentos = cruzamentos;}



//equals,

	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.capacidadeCruzamentos == ((Lateral)o).capacidadeCruzamentos;
    }


//clone,

    public Lateral clone(){ return new Lateral(this);}


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
        finalString.append("\t\t\tCapacidade cruzamentos: " + this.getCapacidadeCruzamentos() + ";\n");
        finalString.append("\t\t\tHistorico equipas: " + this.getHistorico().toString() + ";\n}\n");

        return finalString.toString();
    }


    public double getHabilidade(){

        double habilidade = 0;
        habilidade += this.fatorIdade() + 1 + 1 + 1 + 1 + 1 + 1 + 1 + this.getHumor()*2 + this.capacidadeCruzamentos * 2;
        //Ilustrativo, defini 1 para todas as habilidades "comuns"
        return habilidade;
    }


}