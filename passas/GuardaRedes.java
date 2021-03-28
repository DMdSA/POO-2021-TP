
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
    
    public GuardaRedes (double elasticidade)
    {
        this.elasticidade = elasticidade;
    }
    
}
