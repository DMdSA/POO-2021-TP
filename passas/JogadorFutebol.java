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
}