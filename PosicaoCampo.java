public enum PosicaoCampo {
    GR,
    D,
    M,
    A,
    NONE;

    private String textFormat;

    static{
    	GR.textFormat = "Guarda-Redes";
    	D.textFormat = "Defesa";
    	M.textFormat = "Medio";
    	A.textFormat = "Atacante";
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
        
            default: return NONE.textFormat;
        }
    }


    /**
     * Transforma uma string num tipo ENUM de PosicaoCampo
     * @param s String que deverá ser transformada
     * @return PosicaoCampo relacionada com a string recebida
     */

    public static PosicaoCampo transforma_Posicao(String s){

        switch(s){

            case "Guarda-Redes":
            case "GR":
            case "GuardaRedes":
                return PosicaoCampo.GR;

            case "Atacante":
            case "A":
                return PosicaoCampo.A;

            case "Medio":
            case "M":
                return PosicaoCampo.M;

            case "Defesa":
            case "D":
                return PosicaoCampo.D;

            default:
                return PosicaoCampo.NONE;
        }
    }
}
