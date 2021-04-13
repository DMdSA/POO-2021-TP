import java.util.List;

/**
 * Subclasse da classe JogadorFutebol.
 * Herda todas as caracteristicas de um jogador de futebol, e acrescenta-lhe a elasticidade como caracteristica deste.
 *
 * @author passas a81215@alunos.uminho.pt
 * @version 28-03-2021
 */


public class GuardaRedes extends JogadorFutebol{


    private double elasticidade;



    /**
     * Construtores de Objetos da Classe GuardaRedes
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
    

    public GuardaRedes (String nome, int idade, float altura, float peso, PosicaoCampo posicao, int numero, double overall, double velocidade, double impulsao, double resistencia, double destreza,
                        double jogoCabeca, double remate, double passe, double humor, List<String> historico, double elasticidade){

        super(nome, idade, altura, peso, posicao, numero, overall, velocidade, impulsao, resistencia, destreza, jogoCabeca, remate, passe, humor, historico);
        this.elasticidade = elasticidade;
    }
    

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
        finalString.append("\t\tPosicao: " + this.printPosicao(this.getPosicaoCampo()) + ";\n");
        finalString.append("\t\tIdade: " + this.getIdade() + ";\n");
        finalString.append("\t\tPeso: " + this.getPeso() + ";\n");
        finalString.append("\t\tAltura: " + this.getAltura() + ";\n");
        finalString.append("\t\tNumero: " + this.getNumero() + ";\n");
        finalString.append("\t\tOverall: " + this.getOverall() + ";\n");
        finalString.append("\t\tVelocidade: " + this.getVelocidade() + ";\n");
        finalString.append("\t\tImpulsao: " + this.getImpulsao() + ";\n");
        finalString.append("\t\tResistencia: " + this.getResistencia() + ";\n");
        finalString.append("\t\tDestreza: " + this.getDestreza() + ";\n");
        finalString.append("\t\tJogo Cabeca: " + this.getJogoCabeca() + ";\n");
        finalString.append("\t\tRemate: " + this.getRemate() + ";\n");
        finalString.append("\t\tCapacidade Passe: " + this.getPasse() + ";\n");
        finalString.append("\t\tHumor: " + this.getHumor() + ";\n");
        finalString.append("\t\tElasticidade: " + this.getElasticidade() + ";\n");
        finalString.append("\t\tHistorico equipas: " + this.getHistorico().toString() + ";\n}\n");

        return finalString.toString();
    }


    /**
     * equals
     */

    public boolean equals(Object o){

        if (this.getClass() != o.getClass()) return false;
        return super.equals(o) && this.elasticidade == ((GuardaRedes)o).elasticidade;
    }

}