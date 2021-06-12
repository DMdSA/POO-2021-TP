package Jogadores.Futebol;

/**
 * ENUM PosicaoCampo
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */
public enum PosicaoCampo {
    GR,                     /**     Guarda Redes    */
    D,                      /**     Defesa          */
    M,                      /**     Medio           */
    A,                      /**     Avancado        */
    L,                      /**     Lateral         */
    NONE;                   /**     None            */

    private String textFormat;

    static{
    	GR.textFormat = "Guarda-Redes";
    	D.textFormat = "Defesa";
    	M.textFormat = "Medio";
    	A.textFormat = "Atacante";
        L.textFormat = "Lateral";
    	NONE.textFormat = "error_ not a football position";
    }

    /**
     * Imprime posição do jogador
     * @param pc Posição do jogo em que o jogador se encontra.
     * @return String que melhor explicita a respetiva posição no jogo.
     */
    public static String printPosicao(PosicaoCampo pc){

        return switch (pc) {
            case GR -> GR.textFormat;
            case D -> D.textFormat;
            case M -> M.textFormat;
            case A -> A.textFormat;
            case L -> L.textFormat;
            default -> NONE.textFormat;
        };
    }

    /**
     * Transforma uma string num tipo ENUM de jogadoresfutebol.PosicaoCampo
     * @param s String que deverá ser transformada
     * @return jogadoresfutebol.PosicaoCampo relacionada com a string recebida
     */
    public static PosicaoCampo transforma_Posicao(String s){

        return switch (s) {
            case "Guarda-Redes", "GR", "Guarda Redes", "gr", "Gr", "guarda redes", "guarda-redes" -> PosicaoCampo.GR;
            case "Avancado", "A", "avancado", "a" -> PosicaoCampo.A;
            case "Medio", "M", "medio", "m" -> PosicaoCampo.M;
            case "Defesa", "defesa", "d", "D" -> PosicaoCampo.D;
            case "Lateral", "lateral", "l", "L" -> PosicaoCampo.L;
            default -> PosicaoCampo.NONE;
        };
    }

    /**
     * isPosicao, Verifica se uma posição é valida
     * @param a Posicao a verificar
     * @return True, Se for uma posição de jogo válida
     */
    public static boolean isPosicao(PosicaoCampo a){
            if(a != PosicaoCampo.NONE) return true;
            return false;
    }
}
