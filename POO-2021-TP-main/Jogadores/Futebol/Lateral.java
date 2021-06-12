package Jogadores.Futebol;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Lateral Class
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */
public class Lateral extends JogadorFutebol{
    /**                                            Variáveis instância  */
	private double capacidadeCruzamentos;

    /**
     * Construtores
     */
	public Lateral(){

		super();
		this.capacidadeCruzamentos = 0;
		this.setOverall(this.getHabilidade());
	}

	public Lateral(String nome, PosicaoCampo posicao){

		super(nome, posicao);
		this.capacidadeCruzamentos = 0;
		this.setOverall(this.getHabilidade());
	}

	/** Com overall (+) historico   */
	public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, List<String> historico, double cruzamentos){


		super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia
                , destreza, jogoCabeca, remate, passe, humor, historico);
		this.capacidadeCruzamentos = cruzamentos;
	}

	/** Com overall (-) historico   */
    public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, double cruzamentos){


        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia
                , destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeCruzamentos = cruzamentos;
    }

    /** Sem overall (+) historico   */
    public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao,
                    int numero, double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, List<String> historico, double cruzamentos){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia
                , destreza, jogoCabeca, remate, passe, humor, historico);
        this.capacidadeCruzamentos = cruzamentos;
        this.setOverall(this.getHabilidade());
    }


    /** Sem overall (-) historico   */
    public Lateral (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero
            , double velocidade, double impulsao, double resistencia, double destreza,
                     double jogoCabeca, double remate, double passe, double humor, double cruzamentos){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia
                , destreza, jogoCabeca, remate, passe, humor);
        this.capacidadeCruzamentos = cruzamentos;
        this.setOverall(this.getHabilidade());
    }

	public Lateral(Lateral d){

		super(d);
		this.capacidadeCruzamentos = d.getCapacidadeCruzamentos();
		this.setOverall(this.getHabilidade());
	}

	/**
     * clone
     */
    public Lateral clone(){ return new Lateral(this);}

	/** Constructor c/formato LOGS  */
    public Lateral(String nome, int numero, double velocidade, double resistencia, double destreza,
                                    double impulsao, double cabeca, double remate,
                                            double passe, double cruzamento){

        super(nome, PosicaoCampo.L);
        this.setIdade(this.int_random_generator(16, 50));
        this.setAltura(this.double_random_generator(1.40, 2.8));
        this.setPeso(this.double_random_generator(40, 80));
        this.setHumor(this.double_random_generator(1, 100));
        this.setNumero(numero);
        this.setVelocidade(velocidade);
        this.setResistencia(resistencia);
        this.setDestreza(destreza); this.setImpulsao(impulsao); this.setJogoCabeca(cabeca); this.setRemate(remate); this.setPasse(passe);
        this.capacidadeCruzamentos = cruzamento;
        this.setOverall(this.getHabilidade());

    }
    //Lateral:<Nome>,<NumeroCamisola>,<Velocidade>,<Resistência>,<Destreza>,<Impulsão>,<Cabeça>,<Remate>,<Passe>,<Cruzamento>

    /** Parsed Constructor  */
    public static Lateral parse(String input){

        String[] parametros = input.split(",");

        return new Lateral(parametros[0], Integer.parseInt(parametros[1]),
                Double.parseDouble(parametros[2]),
                Double.parseDouble(parametros[3]),
                Double.parseDouble(parametros[4]),
                Double.parseDouble(parametros[5]),
                Double.parseDouble(parametros[6]),
                Double.parseDouble(parametros[7]),
                Double.parseDouble(parametros[8]),
                Double.parseDouble((parametros[9])));
    }

    /**
     * getters
     */
	public double getCapacidadeCruzamentos(){ return this.capacidadeCruzamentos;}


    /**
     * setters
     */
	public void setCapacidadeCruzamentos(double cruzamentos){ this.capacidadeCruzamentos = cruzamentos;}

    /**
     * equals, Verifica se 2 objetos são iguais
     * @param o Objeto a ser comparado
     * @return True, se forem iguais
     */
	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.capacidadeCruzamentos == ((Lateral)o).capacidadeCruzamentos;
    }

    /**
     * getHabilidade, retorna a habilidade calculada para o jogador
     * @return double associado à habilidade
     */
    public double getHabilidade(){

        double habilidade = 0;
        habilidade += this.getVelocidade()*1.5 + this.getImpulsao()*1.5 + this.getResistencia()
                + this.getDestreza()/2 + this.getJogoCabeca()/2 + this.getRemate()
                    + this.getPasse()/2 + this.getCapacidadeCruzamentos()*1.5;
        return habilidade/8;
    }

    /**
     * toString
     */
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        final StringBuffer s = new StringBuffer(this.toString_aux());
            s.append("\t\t\t|-| Capacidade cruzamentos: ").append(df.format(this.getCapacidadeCruzamentos())).append(";\n");
            s.append("\t\t\t|-| Historico equipas: ").append(this.getHistorico().toString()).append(";\n}\n");

        return s.toString();
    }
}