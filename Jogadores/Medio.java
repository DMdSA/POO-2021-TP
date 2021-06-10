package Jogadores;
import java.text.DecimalFormat;
import java.util.List;

public class Medio extends JogadorFutebol{


	private double capacidadeRecuperarBolas;


//Constructors,

	public Medio(){

		super();
		this.capacidadeRecuperarBolas = 0;
		this.setOverall(this.getHabilidade());
	}


	public Medio(String nome, PosicaoCampo posicao){

		super(nome, posicao);
		this.capacidadeRecuperarBolas = 0;
		this.setOverall(this.getHabilidade());
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
        this.setOverall(this.getHabilidade());
    }

                //Sem overall - historico
    public Medio (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                   double jogoCabeca, double remate, double passe, double humor, double capacidadeRecuperarBolas){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeRecuperarBolas = capacidadeRecuperarBolas;
        this.setOverall(this.getHabilidade());
    }


	public Medio(Medio d){

		super(d);
		this.capacidadeRecuperarBolas = d.getCapacidadeRecuperarBolas();
		this.setOverall(this.getHabilidade());
	}

            //Constructor c/formato LOGS
    public Medio(String nome, int numero, double velocidade, double resistencia, double destreza, double impulsao, double cabeca, double remate, double passe, double recuperacao){

        super(nome, PosicaoCampo.M);
        this.setIdade(this.int_random_generator(16, 50));
        this.setAltura(this.double_random_generator(1.40, 2.8));
        this.setPeso(this.double_random_generator(40, 80));
        this.setHumor(this.double_random_generator(1, 100));
        this.setNumero(numero);
        this.setVelocidade(velocidade);
        this.setResistencia(resistencia);
        this.setDestreza(destreza); this.setImpulsao(impulsao); this.setJogoCabeca(cabeca); this.setRemate(remate); this.setPasse(passe);
        this.capacidadeRecuperarBolas = recuperacao;
        this.setOverall(this.getHabilidade());

    }

            //Parsed constructor
    public static Medio parse(String input){

        String[] campos = input.split(",");
        Medio medio = new Medio(campos[0], Integer.parseInt(campos[1]),
                Double.parseDouble(campos[2]),
                Double.parseDouble(campos[3]),
                Double.parseDouble(campos[4]),
                Double.parseDouble(campos[5]),
                Double.parseDouble(campos[6]),
                Double.parseDouble(campos[7]),
                Double.parseDouble(campos[8]),
                Double.parseDouble((campos[9])));
        medio.setCapacidadeRecuperarBolas(medio.double_random_generator(1, 100));
        return medio;
    }





///Getters,

	public double getCapacidadeRecuperarBolas(){ return this.capacidadeRecuperarBolas;}


//Setters,

	public void setCapacidadeRecuperarBolas(double recuperarbolas){ this.capacidadeRecuperarBolas = recuperarbolas;
	this.setOverall(this.getHabilidade());}



//equals,

	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.capacidadeRecuperarBolas == ((Medio)o).capacidadeRecuperarBolas;
    }


//clone,

    public Medio clone(){ return new Medio(this);}


//toString,

    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        final StringBuffer s = new StringBuffer(this.toString_aux());
            s.append("\t\t\t|-| Capacidade recuperar bolas: ").append(df.format(this.getCapacidadeRecuperarBolas())).append(";\n");
            s.append("\t\t\t|-| Historico equipas: ").append(this.getHistorico().toString()).append(";\n}\n");

        return s.toString();
    }



    public double getHabilidade(){

    double habilidade = 0;
    habilidade += this.getVelocidade() + this.getImpulsao() + this.getResistencia()
                                + this.getDestreza() + this.getJogoCabeca() + this.getRemate()
                                    + this.getPasse() + this.getCapacidadeRecuperarBolas();
    return habilidade/8;
}
}