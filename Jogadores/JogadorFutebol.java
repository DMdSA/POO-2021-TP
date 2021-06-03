import java.util.ArrayList;
import java.util.List;
public class JogadorFutebol extends Jogador {
    

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
    private double humor; //simulaçao comportamental
    private List<String> historico; //historico de equipas por onde passou

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
        this.historico = new ArrayList<String>();
        
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
        this.historico = new ArrayList<String>();
       
        this.setOverall(this.getHabilidade());
    }

    //Com Overall + historico
    public JogadorFutebol (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, 
                             double overall, double velocidade, double impulsao, double resistencia, double destreza, double remate,
                                   double jogoCabeca, double passe, double humor, List<String> historico) {
       
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
        this.historico = new ArrayList<String>();
        for(String clube : historico)
            this.historico.add(clube);
    }
    
    //Com Overall - historico
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
        this.historico = new ArrayList<String>();
    }


    //Sem overall + historico
    public JogadorFutebol (String nome, int idade, double altura, double peso, PosicaoCampo posicao, int numero, 
                             double velocidade, double impulsao, double resistencia, double destreza, double remate, double jogoCabeca, 
                                double passe, double humor, List<String> historico) {
        
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
        this.historico = new ArrayList<String>();
        for(String clube : historico)
            this.historico.add(clube);
        

        this.setOverall(this.getHabilidade());
    }



    //Sem overall - historico
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
        this.historico = new ArrayList<String>();        

        this.setOverall(this.getHabilidade());
    }



    public JogadorFutebol (JogadorFutebol jf) { //figo just for fun and my entertainment
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
        this.historico = new ArrayList<String>(jf.getHistorico());
    }


    public JogadorFutebol(int numeroJogador){

        this();
        this.numero = numeroJogador;
    }
    
    /**
     * Getters
     */
    
    //should we set getters from supercalss?!?
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
    
    public List<String> getHistorico () {
        return new ArrayList<>(this.historico);
    }
    
    /**
     * Setters
     */

    public void setPosicao(PosicaoCampo pc){ this.posicao = pc;}

    public void setNumero (int numero) {
        this.numero = numero;
    }
    
    public void setOverall (double overall) {
        this.overall = overall;
    }
    
    public void setVelocidade (double velocidade) {
        this.velocidade = velocidade;
    }

    public void setImpulsao(double impulsao){ this.impulsao = impulsao;}
    
    public void setResistencia (double resistencia) {
        this.resistencia = resistencia;
    }
    
    public void setDestreza (double destreza) {
        this.destreza = destreza;
    }
    
    public void setRemate (double remate) {
        this.remate = remate;
    }
    
    public void setJogoCabeca (double jogoCabeca) {
        this.jogoCabeca = jogoCabeca;
    }
    
    public void setPasse (double passe) {
        this.passe = passe;
    }
    
    public void setHumor (double humor) {
        this.humor = humor;
    }
    
    public void setHistorico (List<String> historico) {
        this.historico = historico;
    }
    
    public void setHistorico_clube(List<String> hist){
        this.historico = new ArrayList<>(hist);
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

        final StringBuffer finalString = new StringBuffer("\t\tJogador \"" + this.getNome() + "\" = {\n");
        finalString.append("\t\t\tPosicao: " + PosicaoCampo.printPosicao(this.getPosicaoCampo()) + ";\n");
        finalString.append("\t\t\tIdade: " + this.getIdade() + " anos;\n");
        finalString.append("\t\t\tPeso: " + this.getPeso() + " Kg;\n");
        finalString.append("\t\t\tAltura: " + this.getAltura() + " cm;\n");
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
        finalString.append("\t\t\tHistorico equipas: " + this.historico.toString() + ";\n\t\t}\n");

        return finalString.toString();
    }


    /**
     * clone
     */

    public JogadorFutebol clone(){
        return new JogadorFutebol(this);
    }



    public double fatorIdade(){                                 //Meramente ilustrativo

        int age = getIdade();

        if(age >= 17 && age <= 21) return 5;
        if(age >= 22 && age <= 25) return 3;
        if(age >= 26) return 1;
        return 0;
    }


    public double getHabilidade(){
    
        double habilidade = 0;
        habilidade += this.fatorIdade() + 1 + 1 + 1 + 1 + 1 + 1 + 1 + this.getHumor()*2;
        //Ilustrativo, defini 1 para todas as habilidades "comuns"
        return habilidade;
    }


}