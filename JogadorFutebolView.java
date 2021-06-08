import Jogadores.JogadorFutebol;
import Jogadores.PosicaoCampo;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class JogadorFutebolView {

    public static String get_nome(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\tNome do jogador: ");
        String aux = input.nextLine();

        return aux;
    }

    public static int get_idade(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int answer = 0;
        do {
            System.out.println("\tIdade: ");
            while (!input.hasNextInt()) {
                input.nextLine();;
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 60) ClientView.warning("\t Essa pessoa ja nao devia estar a jogar");
        } while(answer < 0 || answer > 60); //Não é para cortar os sonhos a ninguém...

        return answer;
    }

    public static double get_altura(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tAltura (m): ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextDouble();
            if(answer < 0 || answer > 2.5) ClientView.warning("\tEssa altura nao parece ser valida!");
        } while(answer < 0 || answer > 2.5);             //Não é para cortar os sonhos a ninguém...

        return answer;
    }

    public static double get_peso(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tPeso do jogador (Kg): ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextDouble();
            if(answer < 0) ClientView.warning("\t Esse peso nao e valido!");
        } while(answer < 0);

        return answer;
    }

    public static PosicaoCampo get_posicao(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        PosicaoCampo posicao;
        String aux;
        do {
            System.out.println("\tPosicao do Jogador: ");
            aux = input.nextLine();
            posicao = PosicaoCampo.transforma_Posicao(aux);
            if(!PosicaoCampo.isPosicao(posicao)) ClientView.warning("\t Essa posicao nao e valida!");
        } while(!PosicaoCampo.isPosicao(posicao));             //Não é para cortar os sonhos a ninguém...
        return posicao;
    }


    public static int get_numero(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int answer = 0;
        do {
            System.out.println("\tNumero da camisola: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0) ClientView.warning("\t Esse numero nao e valido!");
        } while(answer < 0);             //Não é para cortar os sonhos a ninguém...
        return answer;
    }


    public static double get_velocidade(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tVelocidade: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para velocidade invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_resistencia(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tResistencia: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para resistencia invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_destreza(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tDestreza: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para destreza invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_jogo_cabeca(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tJogo Cabeca: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para jogo cabeca invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_remate(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tCapacidade remate: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para capacidade remate invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_passe(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tCapacidade passe: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para capacidade passe invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_impulsao(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
           System.out.println("\tImpulsao: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para impulsao invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_finalizacao(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tFinalizacao: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para finalizacao invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }


    public static double get_capacidade_bloquear_bolas(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tCapacidade Bloquear Bolas: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para capacidade de bloquear bolas invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_elasticidade(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tElasticidade: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para elasticidade invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }


    public static double get_capacidade_cruzamentos(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tCapacidade Cruzamentos: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para capacidade de cruzamentos invalidos! [0..100]");
        } while(answer < 0 || answer > 100);
        return answer;
    }

    public static double get_capacidade_recuperar_bolas(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double answer = 0;
        do {
            System.out.println("\tCapacidade Recuperar Bolas: ");
            while (!input.hasNextDouble()) {
                input.next();
            }
            answer = input.nextInt();
            if(answer < 0 || answer > 100) ClientView.warning("\t Valores para capacidade de recuperar bolas invalidos! [0..100]");
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
        int opcao;
        do {
            ClientView.clear_window();

            StringBuilder view = new StringBuilder("\t___________________________________\n");
                                      view.append("\t||     JOGADORES GUARDADOS       ||\n");
                                      view.append("\t|                                 |\n");
                                      view.append("\t||_______________________________||\n\n");
            System.out.println(view.toString());

            for (Map.Entry<String, JogadorFutebol> entrada : js.entrySet()) {

                System.out.println("Jogador : " + entrada.getKey() + " | Posicao : " + entrada.getValue().getPosicaoCampo().toString()
                        + " | Pontos Habilidade: " + entrada.getValue().getHabilidade());

            }
            System.out.println("\nNumero de jogadores guardados: " + js.size() + "\n");
            Scanner input = new Scanner(System.in);


            JogadorFutebolView.consultar_jogadores(js);
            view.append("\t___________________________________\n");
            view.append("\t||            VOLTAR             ||\n");
            view.append("\t|                                 |\n");
            view.append("\t|             1) SIM              |\n");
            view.append("\t|             2) NAO              |\n");
            view.append("\t||_______________________________||\n\n");

            do {
                System.out.println("\tOpcao: ");
                while (!input.hasNextInt()) {
                    input.next();
                }
                opcao = input.nextInt();
            } while (opcao != 1 && opcao != 2);
        } while (opcao != 1);
    }

    public static void consultar_jogadores(Map<String, JogadorFutebol> js){

        Scanner input = new Scanner(System.in);

        int opcao;
        System.out.println("\tQueres consultar a informacao de algum jogador?\n");

        StringBuilder view = new StringBuilder("\t___________________________________\n");
                                  view.append("\t||                               ||\n");
                                  view.append("\t|             1) SIM              |\n");
                                  view.append("\t|             2) NAO              |\n");
                                  view.append("\t||_______________________________||\n\n");
        System.out.println(view.toString());

        do {
            System.out.println("\tOpcao: ");
            while (!input.hasNextInt()) {
                input.next();
            }
            opcao = input.nextInt();
        } while(opcao != 1 && opcao != 2);

        switch (opcao){
            case 1:
                String nome;
                System.out.println("\tNome do jogador: ");
                nome = input.nextLine();
                if(js.containsKey(nome)){
                    JogadorFutebolView.print_jogador(js.get(nome));
                    ClientView.pause();
                }
                else{
                    ClientView.warning("\tEsse jogador nao esta guardado!");
                }
                break;
            case 2:
                break;
        }
        ClientView.pause();
    }


}
