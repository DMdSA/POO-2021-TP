package Views;

import java.util.Locale;
import java.util.Scanner;

public class ClientView {


    public static int MenuInicial(){

        clear_window();
        StringBuilder menu = new StringBuilder("\t___________________________________\n");
                                   menu.append("\t||Football Manager - Miei edition||\n");
                                   menu.append("\t|                                 |\n");
                                   menu.append("\t|       # 1) Criar conta          |\n");
                                   menu.append("\t|       # 2) Criar Jogador        |\n");
                                   menu.append("\t|       # 3) Criar Equipa         |\n");
                                   menu.append("\t|       # 4) Criar Jogo           |\n");
                                   menu.append("\t|       # 5) Consultar            |\n");
                                   menu.append("\t|       # 6) Carregar Dados       |\n");
                                   menu.append("\t|       # 7) Guardar Dados        |\n");
                                   menu.append("\t|       # 0) Sair                 |\n");
                                   menu.append("\t|_________________________________|\n\n");
        menu.append("\tSelecione a sua opcao: ");
        System.out.println(menu.toString());
        int aux;
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        while(!input.hasNextInt()){
            input.next();
        }
        aux =  input.nextInt();
        return aux;
    }

    /**
     * clear_window
     * Apresenta a ilusão de que a consola foi limpa
     */
    public static void clear_window(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

    /**
     * criar_conta
     * @return Novo utilizador com os dados do cliente
     */
    public static void criar_conta(){

        clear_window();

        StringBuilder conta = new StringBuilder("\t___________________________________\n");
                                   conta.append("\t||       NOVO UTILIZADOR         ||\n");
                                   conta.append("\t|                                 |\n");
                                   conta.append("\t|       |Username, email|         |\n");
                                   conta.append("\t||_______________________________||\n\n");
        System.out.println(conta.toString());
    }

    public static String get_username(){
        Scanner name = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\tUsername: ");
        return name.nextLine();
    }

    public static String get_email(){
        Scanner mail = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\tMail: ");
        String aux = mail.nextLine();
        return aux;
    }


    public static void criar_jogador(){

        clear_window();

        StringBuilder criarmenu = new StringBuilder("\t___________________________________\n");
                                   criarmenu.append("\t||         NOVO JOGADOR          ||\n");
                                   criarmenu.append("\t|                                 |\n");
                                   criarmenu.append("\t|     #1 ) Jogadores guardados    |\n");
                                   criarmenu.append("\t|     #2 ) Criar Jogadores        |\n");
                                   criarmenu.append("\t||_______________________________||\n\n");
        System.out.println(criarmenu.toString());

    }


    /**
     * criar_equipa_menu
     * Menu de criação de nova equipa
     */
    public static int criar_equipa_menu(){

        clear_window();

        StringBuilder criarmenu = new StringBuilder("\t___________________________________\n");
                                   criarmenu.append("\t||         NOVA EQUIPA           ||\n");
                                   criarmenu.append("\t|                                 |\n");
                                   criarmenu.append("\t|     #1 ) Jogadores guardados    |\n");
                                   criarmenu.append("\t|     #2 ) Criar Jogadores        |\n");
                                   criarmenu.append("\t||_______________________________||\n\n");
        System.out.println(criarmenu.toString());

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        while(!input.hasNextInt()){
            input.next();
        }
        return input.nextInt();
    }

    /**
     * warning
     * @param warning Aviso a ser enviado ao utilizador
     */
    public static void warning(String warning){

        System.out.println("\n + " + warning + "\n\n");
    }

    public static int nova_equipa(){

        clear_window();

        StringBuilder view = new StringBuilder("\t___________________________________\n");
                                   view.append("\t||         NOVA EQUIPA           ||\n");
                                   view.append("\t|                                 |\n");
                                   view.append("\t||_______________________________||\n\n");
        System.out.println(view.toString());

        System.out.println("\tQuantos jogadores (titulares + suplentes) : ");

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int n;
        do {
            while (!input.hasNextInt()) {
                input.next();
            }
            n = input.nextInt();
            if(n < 7 || n > 23) warning("\tO numero de jogadores para esta equipa e invalido!");
        } while(n < 7 || n > 23);

        return n;
    }

    public static String get_nome_equipa(){

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\tNome da equipa: ");
        return input.nextLine();
    }

    public static String[] get_cores_equipa(){

        String[] answer = new String[2];
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\tCor primaria: ");
        answer[0] = input.next();
        System.out.println("\tCor secundaria: ");
        answer[1] = input.nextLine();
        return answer;
    }


    public static String pause(){

        System.out.println("\t Pressiona alguma tecla para continuar...");
        Scanner wait = new Scanner(System.in);
        return wait.nextLine();

    }

}
