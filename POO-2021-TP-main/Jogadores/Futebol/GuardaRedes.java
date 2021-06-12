package Jogadores.Futebol;
import java.text.DecimalFormat;
import java.util.List;

/**
 * GuardaRedes Class
 * Herda todas as caracteristicas de um jogador de futebol, e acrescenta-lhe a elasticidade como caracteristica única deste.
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */

public class GuardaRedes extends JogadorFutebol{
    /**                                            Variáveis instância  */
    private double elasticidade;

    /**
     * Construtores
     */
    public GuardaRedes(){
        
        super();
        this.elasticidade = 0;
        this.setOverall(this.getHabilidade());
    }

    public GuardaRedes(String nome, PosicaoCampo pc){
        
        super(nome, pc);
        this.elasticidade = 0;
        this.setOverall(this.getHabilidade());
    }

    public GuardaRedes (GuardaRedes gr) {
        
        super(gr);
        this.elasticidade = gr.getElasticidade();
        this.setOverall(this.getHabilidade());
    }
    
    /** Com overall (+) historico   */
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, List<String> historico, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao
                , resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.elasticidade = elasticidade;
    }
    
    /** Com overall (-) historico   */
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao
                , resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.elasticidade = elasticidade;
    }

    /** Sem overall (+) historico   */
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, List<String> historico, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia
                , destreza, jogoCabeca, remate, passe, humor, historico);
        this.elasticidade = elasticidade;
        this.setOverall(this.getHabilidade());
    }

    /** Sem overall (-) historico   */
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao
            , int numero, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.elasticidade = elasticidade;
        this.setOverall(this.getHabilidade());
    }

    /**
     * clone
     */
    public GuardaRedes clone(){ return new GuardaRedes(this);}

    /** Construtor com o formato dos LOGS   */
    public GuardaRedes(String nome, int numero, double velocidade, double resistencia
                            , double destreza, double impulsao, double cabeca, double remate
                                , double passe, double elasticidade){

        super(nome, PosicaoCampo.GR);
        this.setIdade(this.int_random_generator(16, 50));
        this.setAltura(this.double_random_generator(1.40, 2.8));
        this.setPeso(this.double_random_generator(40, 80));
        this.setHumor(this.double_random_generator(1, 100));
        this.setNumero(numero);
        this.setVelocidade(velocidade);
        this.setResistencia(resistencia);
        this.setDestreza(destreza); this.setImpulsao(impulsao); this.setJogoCabeca(cabeca); this.setRemate(remate); this.setPasse(passe);
        this.elasticidade = elasticidade;
        this.setOverall(this.getHabilidade());
    }

    /**
     *  Parsed constructor
     */
    public static GuardaRedes parse(String input){

        String[] campos = input.split(",");
        
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
                Double.parseDouble(campos[2]),
                Double.parseDouble(campos[3]),
                Double.parseDouble(campos[4]),
                Double.parseDouble(campos[5]),
                Double.parseDouble(campos[6]),
                Double.parseDouble(campos[7]),
                Double.parseDouble(campos[8]),
                Double.parseDouble((campos[9])));
    }    //Guarda-Redes:<Nome>,<NumeroCamisola>,<Velocidade>,<Resistência>,<Destreza>,<Impulsão>,<Cabeça>,<Remate>,<Passe>,<Elasticidade>


    /**
     * Getter
     */

    public double getElasticidade () {
        return this.elasticidade;
    }
    
    /**
     * Setter
     */

    public void setElasticidade (double elasticidade) {
        this.elasticidade = elasticidade; this.setOverall(this.getHabilidade());
    }

    /**
     * equals
     */
    public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.elasticidade == ((GuardaRedes)o).elasticidade;
    }

    /**
     * getHabilidade, retorna a habilidade calculada para o jogador
     * @return double associado à habilidade
     */
    public double getHabilidade(){

        double habilidade = 0;
        habilidade += this.getVelocidade()/2 + this.getImpulsao() + this.getResistencia()/2
                + this.getDestreza() + this.getJogoCabeca()/2 + this.getRemate()
                    + this.getPasse() + this.getElasticidade()*2.5;
        return habilidade/8;
    }

    /**
     * toString
     */
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        final StringBuffer s = new StringBuffer(this.toString_aux());
        s.append("\t\t\t|-| Elasticidade: ").append(df.format(this.getElasticidade())).append(";\n");
        s.append("\t\t\t|-| Historico equipas: ").append(this.getHistorico().toString()).append(";\n}\n");

        return s.toString();
    }
}