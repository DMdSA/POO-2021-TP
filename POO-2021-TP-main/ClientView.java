import java.time.LocalDate;
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
                                   menu.append("\t|       # 8) Perfil               |\n");
                                   menu.append("\t|       # 0) Sair                 |\n");
                                   menu.append("\t|_________________________________|\n\n");
        System.out.println(menu.toString());
        int aux; boolean flag;
        do {
            aux = ClientView.get_Int("Selecione a sua opcao: ");
            flag = ClientView.not_an_option(aux, 0, 8);
        } while(!flag);
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
     * get_double Recebe um Double atribuído pelo utilizador
     * @param output String utilizada para contextualizar o momento do pedido
     * @return input do utilizador
     */
    public static double get_Double(String output){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\t" + output + ": ");
        while (!input.hasNextDouble()) {
            input.next();
        }
        return input.nextDouble();
    }

    /**
     * get_string Recebe uma String atribuída pelo utilizador
     * @param request String utilizada para contextualizar o momento do pedido
     * @return input do utilizador
     */
    public static String get_String(String request){
        Scanner answer = new Scanner(System.in);
        System.out.println("\t"+request+" : ");
        return answer.nextLine();
    }

    /**
     * get_string Recebe um Integer atribuído pelo utilizador
     * @param output String utilizada para contextualizar o momento do pedido
     * @return input do utilizador
     */
    public static int get_Int(String output){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("\t" + output + ": ");
            while (!input.hasNextInt()) {
                input.next();
            }
            return input.nextInt();
    }

    /**
     * warning
     * @param warning Aviso a ser enviado ao utilizador
     */
    public static void warning(String warning){

        System.out.println("\n\t " + warning + "\n\n");
    }

    /**
     * pause, Simulação do comando pause()
     * @return string meramente auxiliar da execução da função
     */
    public static String pause(){

        System.out.println("\tPressiona alguma tecla para continuar...");
        Scanner wait = new Scanner(System.in);
        return wait.nextLine();
    }

    public static boolean not_an_option(double escolha, double min, double max){

        if(escolha < min || escolha > max) {
            ClientView.warning("\tEssa opcao nao esta disponivel!");
            return false;
        }
        return true;
    }


    /**
     * criar_conta
     * @return Novo utilizador com os dados do cliente
     */
    public static void criar_conta(){

        clear_window();

        StringBuilder s = new StringBuilder("\t___________________________________\n");
                                   s.append("\t||       NOVO UTILIZADOR         ||\n");
                                   s.append("\t|                                 |\n");
                                   s.append("\t|       |Username, email|         |\n");
                                   s.append("\t||_______________________________||\n\n");
        System.out.println(s.toString());
    }



    public static void criar_jogador(){

        clear_window();

        StringBuilder s = new StringBuilder("\t___________________________________\n");
                                   s.append("\t||         NOVO JOGADOR          ||\n");
                                   s.append("\t|                                 |\n");
                                   s.append("\t|     #1 ) Jogadores guardados    |\n");
                                   s.append("\t|     #2 ) Criar Jogadores        |\n");
                                   s.append("\t||_______________________________||\n\n");
        System.out.println(s.toString());
    }


    /**
     * criar_equipa_menu
     * Menu de criação de nova equipa
     */
    public static int criar_equipa_menu(){

        clear_window();

        StringBuilder s = new StringBuilder("\t___________________________________\n");
                                   s.append("\t||         NOVA EQUIPA           ||\n");
                                   s.append("\t|                                 |\n");
                                   s.append("\t|     #1 ) Jogadores guardados    |\n");
                                   s.append("\t|     #2 ) Criar Jogadores        |\n");
                                   s.append("\t|     #3 ) Voltar                 |\n");
                                   s.append("\t||_______________________________||\n\n");
        System.out.println(s.toString());
        int opcao; boolean flag;
        do {
            opcao = ClientView.get_Int("Opcao");
            flag = ClientView.not_an_option(opcao, 1, 3);
        } while (!flag);
        return opcao;
    }

    public static int nova_equipa(){

        clear_window();

        StringBuilder s = new StringBuilder("\t___________________________________\n");
                                   s.append("\t||         NOVA EQUIPA           ||\n");
                                   s.append("\t|                                 |\n");
                                   s.append("\t||_______________________________||\n\n");
        System.out.println(s.toString());

        int n; boolean flag;
        do {
            n = ClientView.get_Int("Quantos jogadores (titulares + suplentes)");
            flag = ClientView.not_an_option(n, 7, 23);
        } while(!flag);

        return n;
    }


    public static void show_profile(String nome, String mail, int level, double points, LocalDate date){

        clear_window();

        StringBuilder s = new StringBuilder("\t______________________________________________\n");
                                   s.append("\t||             Perfil                       ||\n");
                                   s.append("\t|                                            |\n");
                                   s.append("\t        #Username: ").append(nome).append("\n");
                                   s.append("\t        #Email: ").append(mail).append("\n");
                                   s.append("\t        #Level: ").append(level).append("\n");
                                   s.append("\t        #Points: ").append(points).append("\n");
                                   s.append("\t        #Since: ").append(date.toString()).append("\n");
                                   s.append("\t|                                            |\n");
                                   s.append("\t||__________________________________________||\n\n");
        System.out.println(s.toString());
    }


    public static int carregar_ficheiros(){

        clear_window();
        int opcao; boolean flag;

        StringBuilder s = new StringBuilder("\t___________________________________\n");
                                   s.append("\t||      CARREGAMENTO DADOS       ||\n");
                                   s.append("\t|                                 |\n");
                                   s.append("\t|       #1 ) Ficheiro logs        |\n");
                                   s.append("\t|       #2 ) Estado Jogo          |\n");
                                   s.append("\t|       #3 ) Voltar               |\n");
                                   s.append("\t||_______________________________||\n\n");
        System.out.println(s.toString());
        do{
            opcao = ClientView.get_Int("Opcao");
            flag = ClientView.not_an_option(opcao, 1, 3);
        } while (!flag);

        return opcao;
    }

    public static int guardar_ficheiros(){

        clear_window();
        int opcao; boolean flag;

        StringBuilder s = new StringBuilder("\t___________________________________\n");
        s.append("\t||        GUARDAR DADOS          ||\n");
        s.append("\t|                                 |\n");
        s.append("\t|      #1 ) Guardar Estado        |\n");
        s.append("\t|      #2 ) Voltar                |\n");
        s.append("\t||_______________________________||\n\n");
        System.out.println(s);
        do{
            opcao = ClientView.get_Int("Opcao");
            flag = ClientView.not_an_option(opcao, 1, 2);
        }while (!flag);
        return opcao;
    }

    public static int painel_consulta(){

        clear_window();
        StringBuilder s = new StringBuilder("\t___________________________________\n");
                                   s.append("\t||    CONSULTA DADOS GUARDADOS   ||\n");
                                   s.append("\t|                                 |\n");
                                   s.append("\t|       #1 ) Jogadores            |\n");
                                   s.append("\t|       #2 ) Equipas              |\n");
                                   s.append("\t|       #3 ) Jogos                |\n");
                                   s.append("\t|       #4 ) Voltar               |\n");
                                   s.append("\t||_______________________________||\n\n");
        System.out.println(s);

        int opcao; boolean flag;
        do{
            opcao = ClientView.get_Int("Opcao");
            flag = ClientView.not_an_option(opcao, 1, 4);;
        } while (!flag);

        return opcao;
    }

    /**
     * SimNao Apresenta ao utilizador um menu de escolha Sim/Nao
     * @param pergunta
     */
    public static void SimNao(String pergunta){

        System.out.println("\t" + pergunta + "\n");

        StringBuilder s = new StringBuilder("\t___________________________________\n");
                                  s.append("\t||                               ||\n");
                                  s.append("\t|             1) SIM              |\n");
                                  s.append("\t|             2) NAO              |\n");
                                  s.append("\t||_______________________________||\n\n");
        System.out.println(s);
    }


}
