
public enum PosicaoCampo {
    GR,
    D,
    M,
    A,
    L,
    NONE;

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

        switch(pc){

            case GR:
                return GR.textFormat;

            case D:
                return D.textFormat;

            case M:
                return M.textFormat;

            case A:
                return A.textFormat;

            case L:
                return L.textFormat;
        
            default: return NONE.textFormat;
        }
    }


    /**
     * Transforma uma string num tipo ENUM de jogadoresfutebol.PosicaoCampo
     * @param s String que deverá ser transformada
     * @return jogadoresfutebol.PosicaoCampo relacionada com a string recebida
     */

    public static PosicaoCampo transforma_Posicao(String s){

        switch(s){

            case "Guarda-Redes":
            case "GR":
            case "GuardaRedes":
            case "gr":
            case "Gr":
            case "guarda redes":
                return PosicaoCampo.GR;

            case "Atacante":
            case "A":
            case "atacante":
            case "a":
                return PosicaoCampo.A;

            case "Medio":
            case "M":
            case "medio":
            case "m":
                return PosicaoCampo.M;

            case "Defesa":
            case "defesa":
            case "d":
            case "D":
                return PosicaoCampo.D;

            case "Lateral":
            case "lateral":
            case "l":
            case "L":
                return PosicaoCampo.L;

            default:
                return PosicaoCampo.NONE;
        }
    }
}
