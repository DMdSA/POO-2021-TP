package Jogadores;
import java.util.List;

/**
 * Subclasse da classe jogadoresfutebol.JogadorFutebol.
 * Herda todas as caracteristicas de um jogador de futebol, e acrescenta-lhe a elasticidade como caracteristica deste.
 *
 * @author dma_ & Petty
 * @version 
 */


public class GuardaRedes extends JogadorFutebol{


    private double elasticidade;



    /**
     * Construtores de Objetos da Classe jogadoresfutebol.GuardaRedes
     */

    public GuardaRedes(){
        
        super();
        this.elasticidade = 0;
    }
    

    public GuardaRedes(String nome, PosicaoCampo pc){
        
        super(nome, pc);
        this.elasticidade = 0;
    }



    public GuardaRedes (GuardaRedes gr) {
        
        super(gr);
        this.elasticidade = gr.getElasticidade();
    }
    
                    //Com overall + historico
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, List<String> historico, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.elasticidade = elasticidade;
    }
    
                    //Com overall - historico
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.elasticidade = elasticidade;
    }

                    //Sem overall + historico
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, List<String> historico, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.elasticidade = elasticidade;
    }

                    //Sem overall - historico
    public GuardaRedes (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor);
        this.elasticidade = elasticidade;
    }


                    //Construtor com o formato dos LOGS
    public GuardaRedes(String nome, int numero, double velocidade, double resistencia, double destreza, double impulsao, double cabeca, double remate, double passe, double elasticidade){

        super(nome, PosicaoCampo.GR);
        this.setNumero(numero);
        this.setVelocidade(velocidade);
        this.setResistencia(resistencia);
        this.setDestreza(destreza); this.setImpulsao(impulsao); this.setJogoCabeca(cabeca); this.setRemate(remate); this.setPasse(passe);
        this.elasticidade = elasticidade;
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
        this.elasticidade = elasticidade;
    }


    /**
     * toString
     */
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
        finalString.append("\t\t\tElasticidade: " + this.getElasticidade() + ";\n");
        finalString.append("\t\t\tPontos Habilidade: " + this.getHabilidade() + ";\n");
        finalString.append("\t\t\tHistorico equipas: " + this.getHistorico().toString() + ";\n}\n");

        return finalString.toString();
    }


    /**
     * equals
     */

    public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.elasticidade == ((GuardaRedes)o).elasticidade;
    }



//clone,

    public GuardaRedes clone(){ return new GuardaRedes(this);}



    public double getHabilidade(){
    
        double habilidade = 0;
        habilidade += this.fatorIdade() + 1 + 1 + 1 + 1 + 1 + 1 + 1 + this.getHumor()*2 + this.getElasticidade()* 2;
        //Ilustrativo, defini 1 para todas as habilidades "comuns"
        return habilidade;
    }



    public void add_extra(double extra){
	    this.elasticidade = extra;
    }


}