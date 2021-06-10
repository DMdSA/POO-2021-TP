package Jogadores;
import java.text.DecimalFormat;
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
		this.setOverall(this.getHabilidade());
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
        this.setOverall(this.getHabilidade());
    }


            //Sem overall - historico
    public Defesa (String nome, int idade, float altura, float peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                    double jogoCabeca, double remate, double passe, double humor, double capacidadeBloquearBolas){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeBloquearBolas = capacidadeBloquearBolas;
        this.setOverall(this.getHabilidade());
    }

	public Defesa(Defesa d){

		super(d);
		this.capacidadeBloquearBolas = d.getCapacidadeBloquearBolas();
		this.setOverall(this.getHabilidade());
	}

    /**
     * Logs text file constructor
     */
    public Defesa(String nome, int numero, double velocidade, double resistencia, double destreza, double impulsao
            , double cabeca, double remate, double passe){

        super(nome, PosicaoCampo.D);
        this.setIdade(this.int_random_generator(16, 50));
        this.setAltura(this.double_random_generator(1.40, 2.8));
        this.setPeso(this.double_random_generator(40, 80));
        this.setHumor(this.double_random_generator(1, 100));
        this.setNumero(numero);
        this.setVelocidade(velocidade);
        this.setResistencia(resistencia);
        this.setDestreza(destreza); this.setImpulsao(impulsao); this.setJogoCabeca(cabeca); this.setRemate(remate); this.setPasse(passe);
        this.setOverall(this.getHabilidade());
    }

    //Parsed constructor
    public static Defesa parse(String input){

        String[] parametros = input.split(",");
        Defesa defesa = new Defesa(parametros[0], Integer.parseInt(parametros[1]),
                Double.parseDouble(parametros[2]),
                Double.parseDouble(parametros[3]),
                Double.parseDouble(parametros[4]),
                Double.parseDouble(parametros[5]),
                Double.parseDouble(parametros[6]),
                Double.parseDouble(parametros[7]),
                Double.parseDouble(parametros[8]));
        defesa.setCapacidadeBloquearBolas(defesa.double_random_generator(1, 100));
        return defesa;
    }




///Getters,

	public double getCapacidadeBloquearBolas(){ return this.capacidadeBloquearBolas;}


//Setters,

	public void setCapacidadeBloquearBolas(double bloquearbolas){ this.capacidadeBloquearBolas = bloquearbolas; this.setOverall(this.getHabilidade());}



//equals,

	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.capacidadeBloquearBolas == ((Defesa)o).capacidadeBloquearBolas;
    }


//clone,

    public Defesa clone(){ return new Defesa(this);}


//toString,

    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        final StringBuffer s = new StringBuffer(this.toString_aux());
            s.append("\t\t\t|-| Capacidade bloquear bolas: ").append(df.format(this.getCapacidadeBloquearBolas())).append(";\n");
            s.append("\t\t\t|-| Historico equipas: ").append(this.getHistorico().toString()).append(";\n}\n");

        return s.toString();
    }


    public double getHabilidade(){

        double habilidade = 0;
        habilidade += this.getVelocidade() + this.getImpulsao() + this.getResistencia() + this.getDestreza()
                             + this.getJogoCabeca() + this.getRemate() + this.getPasse()
                                    + this.getCapacidadeBloquearBolas();
        return habilidade/8;
    }
}