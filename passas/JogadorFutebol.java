import java.util.List;
public class JogadorFutebol extends Jogador {
    
    public enum Posicao {
        GR,
        D,
        M,
        A
    }
    private Posicao posicao;
    private int numero;
    private double overall;
    private double velocidade;
    private double resistencia;
    private double destreza;
    private double cabeca;
    private double remate;
    private double passe;
    private double humor; //simulaçao comportamental
    private double campo; //simulaçao de condiçoes metereologicas
    private List<String> historico; //historico de equipas por onde passou

    /**
     * Construtores
     */
    public JogadorFutebol () {
        super();
        this.posicao = null;
        this.numero = 0;
        this.overall = 0.0;
        this.velocidade=0.0;
        this.resistencia = 0.0;
        this.destreza = 0.0;
        this.cabeca = 0.0;
        this.remate = 0.0;
        this.passe = 0.0;
        this.humor = 0.0;
        this.campo = 0.0;
        this.historico.add(""); //neste momento nao sei melhor ahah
    }
    
    public JogadorFutebol (String nome, int idade, float altura, float peso, Posicao posicao, int numero, double overall, double velocidade, double resistencia, double destreza, double remate, double cabeca, double passe, double humor, double campo, String clube) {
        super (nome, idade, altura, peso);
        this.posicao = posicao;
        this.numero = numero;
        this.overall = overall;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.remate = remate;
        this.cabeca = cabeca;
        this.passe = passe;
        this.humor = humor;
        this.campo = campo;
        this.historico.add(clube);
    }
    
    public JogadorFutebol (JogadorFutebol figo) { //figo just for fun and my entertainment
        super(figo);
        this.posicao = figo.getPosicao();
        this.numero = figo.getNumero();
        this.velocidade = figo.getVelocidade();
        this.resistencia = figo.getResistencia();
        this.destreza = figo.getDestreza();
        this.remate = figo.getRemate();
        this.cabeca = figo.getCabeca();
        this.passe = figo.getPasse();
        this.humor = figo.getHumor();
        this.campo = figo.getCampo();
        this.historico = figo.getHistorico();
    }
    
    /**
     * Getters
     */
    
    //should we set getters from supercalss?!?
    public Posicao getPosicao (){
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
    
    public double getResistencia () {
        return this.resistencia;
    }
    
    public double getDestreza (){
        return this.destreza;
    }
    
    public double getRemate () {
        return this.remate;
    }
    
    public double getCabeca () {
        return this.cabeca;
    }
    
    public double getPasse () {
        return this.passe;
    }
    
    public double getHumor (){
        return this.humor;
    }
    
    public double getCampo (){
        return this.campo;
    }
    
    public List<String> getHistorico () {
        return this.historico; //should we clone?
    }
    
    /**
     * Setters
     */
    public void setNumero (int numero) {
        this.numero = numero;
    }
    
    public void setOverall (double overall) {
        this.overall = overall;
    }
    
    public void setVelocidade (double velocidade) {
        this.velocidade = velocidade;
    }
    
    public void setResistencia (double resistencia) {
        this.resistencia = resistencia;
    }
    
    public void setDestreza (double destreza) {
        this.destreza = destreza;
    }
    
    public void setRemate (double remate) {
        this.remate = remate;
    }
    
    public void setCabeca (double cabeca) {
        this.cabeca = cabeca;
    }
    
    public void setPasse (double passe) {
        this.passe = passe;
    }
    
    public void setHumor (double humor) {
        this.humor = humor;
    }
    
    public void setCampo (double campo) {
        this.campo = campo;
    }
    
    public void setHistorico (List<String> historico) {
        this.historico = historico;
    }
    
    public void setHistorico_clube (String clube) {
        this.historico.add(clube);
    }
}