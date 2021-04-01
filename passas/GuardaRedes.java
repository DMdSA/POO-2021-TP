/**
 * Subclasse da classe JogadorFutebol.
 * Herda todas as caracteristicas de um jogador de futebol, e acrescenta-lhe a elasticidade como caracteristica deste.
 *
 * @author passas a81215@alunos.uminho.pt
 * @version 28-03-2021
 */
public class GuardaRedes extends JogadorFutebol
{
    private double elasticidade;

    /**
     * Construtores de Objetos da Classe GuardaRedes
     */
    public GuardaRedes()
    {
        super();
        this.elasticidade = 0;
    }
    
    public GuardaRedes (GuardaRedes marche) {
        super (marche);
        this.elasticidade = marche.getElasticidade();
    }
    public GuardaRedes (String nome, int idade, float altura, float peso, Posicao posicao, int numero, double overall, double velocidade, double resistencia, double destreza, 
    double remate, double cabeca, double passe, double humor, double campo, String clube, double elasticidade) 
    {
        super (nome, idade, altura, peso, posicao, numero, overall, velocidade, resistencia, destreza, remate, cabeca, passe, humor, campo, clube);
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
}