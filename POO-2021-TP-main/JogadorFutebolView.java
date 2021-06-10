import Equipa.EquipaFutebol;
import Jogadores.JogadorFutebol;
import Jogadores.PosicaoCampo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JogadorFutebolView {

    public static int get_idade(){
        int answer = 0; boolean flag;
        do{
            answer = ClientView.get_Int("Idade");
            flag = ClientView.not_an_option(answer, 0, 60);
        } while(!flag); //Não é para cortar os sonhos a ninguém...

        return answer;
    }

    public static double get_altura(){
        double answer = 0; boolean flag;
        do {
            answer = ClientView.get_Double("Altura (m)");
            flag = ClientView.not_an_option(answer, 0, 2.5);
            if(!flag) ClientView.warning("Essa altura nao parece ser valida!");
        } while(!flag);             //Não é para cortar os sonhos a ninguém...

        return answer;
    }

    public static double get_peso(){
        double answer = 0;
        do {
            answer = ClientView.get_Double("Peso do jogador (Kg): ");
            if(answer < 0) ClientView.warning("Esse peso nao e valido!");
        } while(answer < 0);

        return answer;
    }

    public static PosicaoCampo get_posicao(){
        PosicaoCampo posicao;
        String aux;
        do {
           aux = ClientView.get_String("Posicao do jogador");
            posicao = PosicaoCampo.transforma_Posicao(aux);
            if(!PosicaoCampo.isPosicao(posicao)) ClientView.warning("Essa posicao nao e valida!");
        } while(!PosicaoCampo.isPosicao(posicao));             //Não é para cortar os sonhos a ninguém...
        return posicao;
    }


    public static int get_numero(){
        int answer = 0;
        do {
            answer =ClientView.get_Int("Numero da camisola");
            if(answer < 0) ClientView.warning("Esse numero nao e valido!");
        } while(answer < 0);             //Não é para cortar os sonhos a ninguém...
        return answer;
    }


    public static double get_velocidade(){
        double answer = 0;
        do {
           answer = ClientView.get_Double("Velocidade: ");
            if(answer < 0 || answer > 100) ClientView.warning(" Valores para velocidade invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_resistencia(){
        double answer = 0;
        do {
            answer = ClientView.get_Double("Resistencia: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para resistencia invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_destreza(){
        double answer = 0;
        do {
           answer = ClientView.get_Double("Destreza: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para destreza invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_jogo_cabeca(){
        double answer = 0;
        do {
           answer = ClientView.get_Double("Jogo de Cabeca: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para jogo cabeca invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_remate(){
        double answer = 0;
        do {
            answer = ClientView.get_Double("Capacidade de Remate: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para capacidade remate invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_passe(){
        double answer = 0;
        do {
            answer = ClientView.get_Double("Capacidade de Passe: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para capacidade passe invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_impulsao(){
        double answer = 0;
        do {
           answer =ClientView.get_Double("Impulsao: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para impulsao invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_finalizacao(){
        double answer = 0;
        do {
            answer = ClientView.get_Double("Finalizacao: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para finalizacao invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }


    public static double get_capacidade_bloquear_bolas(){
        double answer = 0;
        do {
            answer = ClientView.get_Double("Capacidade Recuperar Bolas: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para capacidade de bloquear bolas invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_elasticidade(){
        double answer = 0;
        do {
           answer = ClientView.get_Double("Elasticidade: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para elasticidade invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }


    public static double get_capacidade_cruzamentos(){
        double answer = 0;
        do {
            answer = ClientView.get_Double("Capacidade para Cruzamentos: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para capacidade de cruzamentos invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_capacidade_recuperar_bolas(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
           answer = ClientView.get_Double("Capacidade Recuperar Bolas: ");
            if(answer < 0 || answer > 100) ClientView.warning("Valores para capacidade de recuperar bolas invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }


    public static void criacao_jogador_sucesso(){

        System.out.println("\tJogador criado com sucesso!\n");
    }

    public static void print_jogador(JogadorFutebol j){
        System.out.println(j.toString());                       //Criar uma string menos extensa para este propósito
    }


    /**
     * print_jogadores_info
     * Fornece ao cliente uma maneira de consultar os jogadores guardados
     * assim como a informação retida por cada um
     * @param js Lista de jogadores guardados até ao momento
     */
    public static void print_jogadores_info(Map<String, JogadorFutebol> js) {

            ClientView.clear_window();

            StringBuilder view = new StringBuilder("\t___________________________________\n");
            view.append("\t||     JOGADORES GUARDADOS       ||\n");
            view.append("\t|                                 |\n");
            view.append("\t||_______________________________||\n\n");
            System.out.println(view);

            for (Map.Entry<String, JogadorFutebol> entrada : js.entrySet()) {

                System.out.println("\t|Jogador : " + entrada.getKey() + " (+) Posicao : " + entrada.getValue().getPosicaoCampo().toString()
                        + " (+) Pontos Habilidade: " + entrada.getValue().getHabilidade());

            }
            System.out.println("\n\t|(+) Numero de jogadores guardados: " + js.size() + "\n");
    }

    public static int consultar_jogadores(Map<String, JogadorFutebol> js){

        int opcao;
        ClientView.SimNao("Queres consultar a informacao de algum jogador?");
        boolean flag;
        do {
           opcao = ClientView.get_Int("Opcao");
           flag = ClientView.not_an_option(opcao, 1, 2);
        } while(opcao != 1 && opcao != 2);

        if(opcao == 1) {
            String nome = ClientView.get_String("Nome do jogador");
            if (js.containsKey(nome)) {
                JogadorFutebolView.print_jogador(js.get(nome));
                ClientView.pause();
            } else {
                ClientView.warning("Esse jogador nao esta guardado!");
                ClientView.pause();
            }
        }
        return opcao;
    }


    public static int get_tamanho_equipa(){
        int tamanho;
        do {
            ClientView.warning("Qual o tamanho da equipa? (Titulares + Suplentes)");
            tamanho = ClientView.get_Int("Tamanho");
            if(tamanho < 7 || tamanho > 23) ClientView.warning("Numero minimo [7], Numero maximo [11+12]");
        } while (tamanho < 7 || tamanho > 23);

        return tamanho;
    }

    /**
     *
     * @param eqs
     */
    public static void print_equipas(Map<String, EquipaFutebol> eqs) {

            ClientView.clear_window();

            StringBuilder s = new StringBuilder("\t___________________________________\n");
            s.append("\t||       EQUIPAS GUARDADAS       ||\n");
            s.append("\t|                                 |\n");
            s.append("\t||_______________________________||\n\n");
            System.out.println(s);

            for (Map.Entry<String, EquipaFutebol> entrada : eqs.entrySet()) {
                EquipaFutebol eq = entrada.getValue();
                System.out.printf("\t|| Equipa \"%s\" ||\n\t\t[-Titulares-]:\n", eq.getNome());

                for(Map.Entry<String, JogadorFutebol> jf : eq.getJogadoresTitulares().entrySet())
                    System.out.println("\t\t\t (+) " + jf.getKey() + " ["+ jf.getValue().getNumero() + "] " + jf.getValue().getPosicaoCampo().toString());

                System.out.print("\t\t[-Suplentes-]:\n");
                for(Map.Entry<String, JogadorFutebol> jf : eq.getJogadoresSuplentes().entrySet())
                     System.out.println("\t\t\t (+) " + jf.getKey() + " ["+ jf.getValue().getNumero() + "] " + jf.getValue().getPosicaoCampo().toString());

                System.out.println("\t+ Habilidade média da equipa: " + eq.getHabilidade());
                System.out.println("\n");
            }
            System.out.println("\nNumero de equipas guardados: " + eqs.size() + "\n");
    }

    /**
     *
      * @param eqs
     * @return
     */
    public static int consultar_equipa(Map<String, EquipaFutebol> eqs){

        int opcao;
        ClientView.SimNao("Queres consultar a informacao de alguma equipa?");

        do {
           opcao = ClientView.get_Int("Opcao");
           ClientView.not_an_option(opcao, 1, 2);
        } while(opcao != 1 && opcao != 2);

        if(opcao == 1) {
            String nome = ClientView.get_String("Nome da equipa");
            if (eqs.containsKey(nome)) {
                System.out.println(eqs.get(nome).toString());
                ClientView.pause();
            } else {
                ClientView.warning("Essa equipa nao esta guardada!");
            }
        }
        return opcao;
    }


    public static void print_jogos(Set<JogoFutebol> jogos) {

            ClientView.clear_window();

            StringBuilder s = new StringBuilder("\t___________________________________\n");
            s.append("\t||        JOGOS GUARDADOS        ||\n");
            s.append("\t|                                 |\n");
            s.append("\t||_______________________________||\n\n");
            System.out.println(s);

            for(JogoFutebol jf : jogos){

               System.out.println("\t||__|-[" + jf.get_nome_equipa_casa() + "]-| VS [" + jf.get_nome_equipa_fora() + "]-|__");
               System.out.println("\t\t(+) Data: " + jf.getData().toString() + "\n");

           }

            System.out.println("\nNumero de jogos guardados: " + jogos.size() + "\n");
    }


}



