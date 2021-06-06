package Views;

import Jogadores.JogadorFutebol;
import Jogadores.PosicaoCampo;

import java.util.Locale;
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

}

