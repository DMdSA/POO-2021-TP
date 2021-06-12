package Jogadores.Futebol;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Avancado Class
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */
public class Avancado extends JogadorFutebol{
    /**                                            Variáveis instância  */
	private double finalizacao;


    /**
     * Construtores
     */
	public Avancado(){

		super();
		this.finalizacao = 0;
		this.setOverall(this.getHabilidade());
	}

	public Avancado(String nome, PosicaoCampo posicao){

		super(nome, posicao);

		this.finalizacao = 0;
		this.setOverall(this.getHabilidade());
	}

	/** Com overall (+) historico */
	public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero
            , double overall, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, List<String> historico, double finalizacao){


		super(nome, idade, altura, peso, posicao, numero, overall, velocidade
                , impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
		this.finalizacao = finalizacao;
	}

	/** Com overall (-) historico */
    public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero
            , double overall, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, double finalizacao){


        super(nome, idade, altura, peso, posicao, numero, overall
                , velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.finalizacao = finalizacao;
    }

    /** Sem overall (+) historico */
    public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, List<String> historico, double finalizacao){


        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao
                , resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.finalizacao = finalizacao;
        this.setOverall(this.getHabilidade());
    }

    /** Sem overall (-) historico */
    public Avancado (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double velocidade, double impulsao, double resistencia, double destreza,
                      double jogoCabeca, double remate, double passe, double humor, double finalizacao){


        super(nome, idade, altura, peso, posicao, numero, velocidade
                , impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.finalizacao = finalizacao;
        this.setOverall(this.getHabilidade());
    }


	public Avancado(Avancado av){

		super(av);
		this.finalizacao = av.getFinalizacao();
		this.setOverall(this.getHabilidade());
	}

	/**
     * clone
     */
    public Avancado clone(){ return new Avancado(this);}

	/** Construtor c/Formato dos LOGS   */
    public Avancado (String nome, int numero, double velocidade, double resistencia
            , double destreza, double impulsao, double cabeca, double remate, double passe){

        super(nome, PosicaoCampo.A);
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

    /** Parsed Constructor  */
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

    /**
     * getters
     */
	public double getFinalizacao(){ return this.finalizacao;}


    /**
     * setters
     */
	public void setFinalizacao(double finalizacao){ this.finalizacao = finalizacao; this.setOverall(this.getHabilidade());}

    /**
     * equals, Verifica se 2 objetos são iguais
     * @param o Objeto a ser comparado
     * @return True, se forem iguais
     */
	public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.finalizacao == ((Avancado)o).finalizacao;
    }

    /**
     * getHabilidade, retorna a habilidade calculada para o jogador
     * @return double associado à habilidade
     */
    public double getHabilidade(){

        double habilidade = 0;
        habilidade += this.getVelocidade()*1.5 + this.getImpulsao() + this.getResistencia()/2
                + this.getDestreza()/2 + this.getJogoCabeca() + this.getRemate()
                    + this.getPasse() + this.getFinalizacao()*1.5;
        return habilidade/8;
    }

    /**
     * toString
     */
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        final StringBuffer s = new StringBuffer(this.toString_aux());
            s.append("\t\t\t|-| Finalizacao: ").append(df.format(this.getFinalizacao())).append(";\n");
            s.append("\t\t\t|-| Historico equipas: ").append(this.getHistorico().toString()).append(";\n}\n");
        return s.toString();
    }
}