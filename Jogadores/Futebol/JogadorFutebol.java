package Jogadores.Futebol;
import Jogadores.Jogador;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * JogadorFutebol Class
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */

public class JogadorFutebol extends Jogador {
    /**                                            Variáveis instância  */
    private PosicaoCampo posicao;
    private int numero;
    private double overall;
    private double velocidade;
    private double impulsao;
    private double resistencia;
    private double destreza;
    private double jogoCabeca;
    private double remate;
    private double passe;
    private double humor;                           //simulaçao comportamental
    private Collection<String> historico;

    /**
     * Construtores
     */
    public JogadorFutebol () {
        super();
        this.posicao = PosicaoCampo.NONE;
        this.numero = 0;
        this.velocidade=0.0;
        this.impulsao = 0;
        this.resistencia = 0.0;
        this.destreza = 0.0;
        this.jogoCabeca = 0.0;
        this.remate = 0.0;
        this.passe = 0.0;
        this.humor = 0.0;
        this.historico = new HashSet<>();
        this.setOverall(this.getHabilidade());
    }

     public JogadorFutebol (String nome, PosicaoCampo pc) {
        
        super(nome);
        this.posicao = pc;
        this.numero = 0;
        this.velocidade=0.0;
        this.impulsao = 0;
        this.resistencia = 0.0;
        this.destreza = 0.0;
        this.jogoCabeca = 0.0;
        this.remate = 0.0;
        this.passe = 0.0;
        this.humor = 0.0;
        this.historico = new HashSet<>();
        this.setOverall(this.getHabilidade());
    }

    /** Com Overall + historico */
    public JogadorFutebol (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, 
                             double overall, double velocidade, double impulsao, double resistencia, double destreza, double remate,
                                   double jogoCabeca, double passe, double humor, Collection<String> historico) {
       
        super (nome, idade, altura, peso);
        this.posicao = posicao;
        this.numero = numero;
        this.overall = overall;
        this.velocidade = velocidade;
        this.impulsao = impulsao;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.remate = remate;
        this.jogoCabeca = jogoCabeca;
        this.passe = passe;
        this.humor = humor;
        this.historico = new HashSet<>(historico);
    }
    
    /**Com Overall - historico  */
    public JogadorFutebol (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, double overall,
                              double velocidade, double impulsao, double resistencia, double destreza, double remate, double jogoCabeca, 
                                double passe, double humor) {
        

        super (nome, idade, altura, peso);
        this.posicao = posicao;
        this.numero = numero;
        this.overall = overall;
        this.velocidade = velocidade;
        this.impulsao = impulsao;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.remate = remate;
        this.jogoCabeca = jogoCabeca;
        this.passe = passe;
        this.humor = humor;
        this.historico = new HashSet<>();
    }

    /**Sem overall + historico  */
    public JogadorFutebol (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, 
                             double velocidade, double impulsao, double resistencia, double destreza, double remate, double jogoCabeca, 
                                double passe, double humor, Collection<String> historico) {
        
        super (nome, idade, altura, peso);
        this.posicao = posicao;
        this.numero = numero;
        this.velocidade = velocidade;
        this.impulsao = impulsao;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.remate = remate;
        this.jogoCabeca = jogoCabeca;
        this.passe = passe;
        this.humor = humor;
        this.historico = new HashSet<>(historico);
        this.setOverall(this.getHabilidade());
    }

    /**Sem overall - historico  */
    public JogadorFutebol (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero,
                             double velocidade, double impulsao, double resistencia, double destreza, double remate, double jogoCabeca, 
                                double passe, double humor) {
        
        super (nome, idade, altura, peso);
        this.posicao = posicao;
        this.numero = numero;
        this.velocidade = velocidade;
        this.impulsao = impulsao;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.remate = remate;
        this.jogoCabeca = jogoCabeca;
        this.passe = passe;
        this.humor = humor;
        this.historico = new HashSet<>();
        this.setOverall(this.getHabilidade());
    }

    public JogadorFutebol (JogadorFutebol jf) {
        super(jf);
        this.posicao = jf.getPosicaoCampo();
        this.numero = jf.getNumero();
        this.overall = jf.getOverall();
        this.velocidade = jf.getVelocidade();
        this.impulsao = jf.getImpulsao();
        this.resistencia = jf.getResistencia();
        this.destreza = jf.getDestreza();
        this.remate = jf.getRemate();
        this.jogoCabeca = jf.getJogoCabeca();
        this.passe = jf.getPasse();
        this.humor = jf.getHumor();
        this.historico = new HashSet<>(jf.getHistorico());
    }

    public JogadorFutebol(int numeroJogador){

        this();
        this.numero = numeroJogador;
    }

    /**
     * clone
     */
    public JogadorFutebol clone(){ return new JogadorFutebol(this);}

    /**
     * Getters
     */

    public PosicaoCampo getPosicaoCampo (){
        return this.posicao;
    }
    
    public int getNumero (){
        return this.numero;
    }
    
    public double getOverall () {
        return this.overall;
    }
    
    public double getVelocidade () {
        return this.velocidade;
    }

    public double getImpulsao(){ return this.impulsao;}
    
    public double getResistencia () {
        return this.resistencia;
    }
    
    public double getDestreza (){
        return this.destreza;
    }
    
    public double getRemate () {
        return this.remate;
    }
    
    public double getJogoCabeca () {
        return this.jogoCabeca;
    }
    
    public double getPasse () {
        return this.passe;
    }
    
    public double getHumor (){
        return this.humor;
    }
    
    public Collection<String> getHistorico () {
        return new HashSet<>(this.historico);
    }
    
    /**
     * Setters
     */

    public void setPosicao(PosicaoCampo pc){ this.posicao = pc; this.setOverall(this.getHabilidade());}

    public void setNumero (int numero) {
        this.numero = numero; this.setOverall(this.getHabilidade());
    }
    
    public void setOverall (double overall) {
        this.overall = overall;
    }
    
    public void setVelocidade (double velocidade) {
        this.velocidade = velocidade; this.setOverall(this.getHabilidade());
    }

    public void setImpulsao(double impulsao){ this.impulsao = impulsao; this.setOverall(this.getHabilidade());}
    
    public void setResistencia (double resistencia) {
        this.resistencia = resistencia; this.setOverall(this.getHabilidade());
    }
    
    public void setDestreza (double destreza) {
        this.destreza = destreza; this.setOverall(this.getHabilidade());
    }
    
    public void setRemate (double remate) {
        this.remate = remate; this.setOverall(this.getHabilidade());
    }
    
    public void setJogoCabeca (double jogoCabeca) {
        this.jogoCabeca = jogoCabeca; this.setOverall(this.getHabilidade());
    }
    
    public void setPasse (double passe) {
        this.passe = passe; this.setOverall(this.getHabilidade());
    }
    
    public void setHumor (double humor) {
        this.humor = humor;this.setOverall(this.getHabilidade());
    }
    
    public void setHistorico_clube(Collection<String> hist){
        this.historico = new HashSet<>(hist);
    }


    /**
     * equals
     */
    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass() || o == null) return false;
        JogadorFutebol that = (JogadorFutebol) o;

        return super.equals(that) &&
                this.posicao == that.posicao &&
                this.numero == that.numero &&
                this.overall == that.overall &&
                this.velocidade == that.velocidade &&
                this.impulsao == that.impulsao &&
                this.resistencia == that.resistencia &&
                this.destreza == that.destreza &&
                this.jogoCabeca == that.jogoCabeca &&
                this.remate == that.remate &&
                this.passe == that.passe &&
                this.humor == that.humor &&
                this.historico.equals(that.historico);
    }


    /**
     * toString
     */
    public String toString(){

        final StringBuffer s = new StringBuffer(this.toString_aux());
        s.append("\t\t\tHistorico equipas: ").append(this.historico.toString()).append(";\n\t\t}\n");
        return s.toString();
    }

    public String toString_aux(){
        DecimalFormat df = new DecimalFormat("#.##");
        final StringBuffer s = new StringBuffer("\t\tJogador \"" + this.getNome() + "\" = {\n");
            s.append("\t\t\t|-| Idade: ").append(this.getIdade()).append(" anos;\n");
            s.append("\t\t\t|-| Posicao: ").append(PosicaoCampo.printPosicao(this.getPosicaoCampo())).append(";\n");
            s.append("\t\t\t|-| Peso: ").append(df.format(this.getPeso())).append(" Kg;\n");
            s.append("\t\t\t|-| Altura: ").append(df.format(this.getAltura())).append(" cm;\n");
            s.append("\t\t\t|-| Numero: ").append(this.getNumero()).append(";\n");
            s.append("\t\t\t|-| Overall: ").append(df.format(this.getOverall())).append(";\n");
            s.append("\t\t\t|-| Velocidade: ").append(df.format(this.getVelocidade())).append(";\n");
            s.append("\t\t\t|-| Impulsao: ").append(df.format(this.getImpulsao())).append(";\n");
            s.append("\t\t\t|-| Resistencia: ").append(df.format(this.getResistencia())).append(";\n");
            s.append("\t\t\t|-| Destreza: ").append(df.format(this.getDestreza())).append(";\n");
            s.append("\t\t\t|-| Jogo Cabeca: ").append(df.format(this.getJogoCabeca())).append(";\n");
            s.append("\t\t\t|-| Remate: ").append(df.format(this.getRemate())).append(";\n");
            s.append("\t\t\t|-| Capacidade Passe: ").append(df.format(this.getPasse())).append(";\n");
            s.append("\t\t\t|-| Humor: ").append(df.format(this.getHumor())).append(";\n");
        return s.toString();
    }


    /**
     * getHabilidade, calcula a habilidade que um determinado jogador de futebol tem
     * @return double associado à sua habilidade
     */
    public double getHabilidade(){

        double habilidade = 0;
        habilidade += this.getVelocidade() + this.getImpulsao() + this.getResistencia()
                + this.getDestreza() + this.getJogoCabeca()
                    + this.getRemate() + this.getPasse();
        return habilidade/7;
    }

    /**
     * isEmpty, verifica se o objeto está vazio (void constructor)
     * @return
     */
    public boolean isEmpty(){
        return this.getNome().equals("");
    }

    /**
     * adiciona_equipa, Atualiza o histórico de equipas a que o jogador pertenceu
     * @param nome_equipa Nome da equipa a adicionar
     */
    public void adiciona_equipa(String nome_equipa){
        this.historico.add(nome_equipa);
    }


    public int int_random_generator(int min, int max){

        return (int) ((Math.random() * (max-min)) + min);
    }

    public double double_random_generator(double min, double max){

        return (double) ((Math.random() * (max-min)) + min);
    }

}