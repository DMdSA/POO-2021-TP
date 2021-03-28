import java.util.List;
public class JogadorFutebol extends Jogador {
    
    public enum Posicao {
        GK,
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
}