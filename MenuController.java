import Equipa.EquipaFutebol;
import Jogadores.Futebol.JogadorFutebol;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

public class MenuController {
/**                                            Variáveis instância  */
    private ClientModel cm;

    public MenuController(){
        this.cm = new ClientModel();
    }



    public void run() throws IOException, ClassNotFoundException, InterruptedException {

        int user_option = -1;
        do {
            do {
                user_option = ClientView.MenuInicial();
            } while (user_option < 0 && user_option > 7);

            switch (user_option) {
                case 0 -> System.exit(0);
                case 1 -> {
                    this.cm.setUser(ClientView.get_String("Username"), ClientView.get_String("Email"));
                    ClientView.warning("\tUtilizador registado com sucesso. Recebeste 100 pontos para comecar");
                    ClientView.pause();
                }
                case 2 -> {
                    //criar jogador
                    JogadorFutebol jogador = this.cm.create_jogador();
                    JogadorFutebolView.criacao_jogador_sucesso();
                    JogadorFutebolView.print_jogador(jogador);
                    ClientView.pause();
                    if (!this.cm.addJogador(jogador)) ClientView.warning("\tEsse jogador ja existe!");
                }
                case 3 -> {
                    int option = ClientView.criar_equipa_menu();
                    switch (option) {                                                 //Utilizar jogadores guardados
                        case 1:
                            int validation = this.cm.get_numero_jogadores();
                            if (validation < 11) {
                                ClientView.warning("\tNão há jogadores suficientes guardados nesta conta!");
                                ClientView.pause();
                                break;
                            } else {

                                int aux;
                                EquipaFutebol ef = new EquipaFutebol(ClientView.get_String("\tNome da equipa"));
                                int tamanho_equipa = JogadorFutebolView.get_tamanho_equipa();
                                this.ConsultaJogadores();

                                int contador_aux = 0;
                                do {
                                    aux = 1;
                                    JogadorFutebolView.print_jogadores_info(cm.getJogadores());
                                    String adicionar = ClientView.get_String("Nome do jogador a adicionar");

                                    if (cm.hasJogador(adicionar)) {

                                        if (!cm.get_jogador(adicionar).isEmpty()) {
                                            if (ef.get_numero_titulares() < 11) {
                                                ef.adicionaTitular(cm.get_jogador(adicionar));
                                                contador_aux++;
                                                ClientView.warning("\t Adicionados " + contador_aux + " jogadores.");
                                                ClientView.pause();
                                            } else if (ef.get_numero_suplentes() < 12) {
                                                ef.adicionaSuplente(cm.get_jogador(adicionar));
                                                contador_aux++;
                                                ClientView.warning("\t Adicionados " + contador_aux + " jogadores.");
                                                ClientView.pause();
                                            } else {
                                                ClientView.warning("\tEsta equipa ja nao aguenta mais jogadores!");
                                                aux = 0;
                                            }
                                        }
                                    } else {
                                        ClientView.warning("\tEsse jogador nao esta guardado!");
                                        ClientView.pause();
                                    }
                                } while (aux != 0 && contador_aux < tamanho_equipa);

                                this.cm.addEquipa(ef);
                                break;
                            }

                        case 2:
                            //Cria uma equipa

                            int njogadores = ClientView.nova_equipa();
                            int contador = 1;
                            EquipaFutebol ef = new EquipaFutebol(ClientView.get_String("\tNome da equipa"));     //Cria a equipa com o nome dado
                            if (this.cm.getEquipas().containsKey(ef.getNome())) {
                                ClientView.warning("\tEssa equipa ja existe!!");
                                break;
                            }
                            while (contador <= njogadores) {                                        //Cria n jogadores e adiciona-os
                                ClientView.warning("\n\t[Jogador " + contador + "]");
                                JogadorFutebol current = this.cm.create_jogador();
                                boolean flag = this.cm.addJogador(current);
                                if (flag) {
                                    contador++;
                                    if (contador < 11)
                                        ef.adicionaTitular(current);                                //Até 11 jogadores, adiciona titulares
                                    else
                                        ef.adicionaSuplente(current);                              //A partir daí, suplentes
                                }
                            }
                            if(!ef.isReady()) {
                                ClientView.warning("Esta equipa nao tem guarda-redes! Nao podera realizar jogos");
                            }
                            this.cm.addEquipa(ef);
                            ClientView.warning("Equipa criada com sucesso!");
                            ClientView.pause();

                            break;
                        default:
                            break;
                    }
                }
                case 4 -> {
                    //criar jogo
                    if (this.cm.get_numero_equipas() < 2) {
                        ClientView.warning("Nao ha equipas suficientes para criar um jogo!");
                        ClientView.pause();
                        break;
                    }
                    String eq_casa;
                    String eq_fora;
                    EquipaFutebol casa;
                    EquipaFutebol fora;
                    this.ConsultaEquipas();
                    boolean confirm;
                    do {
                        eq_casa = ClientView.get_String("Equipa a jogar em casa: ");
                        confirm = this.cm.hasEquipa(eq_casa);
                        if (!confirm) {
                            ClientView.warning("Essa equipa nao esta disponivel nos dados guardados!!");
                        }
                    } while (!confirm);
                    do {
                        eq_fora = ClientView.get_String("Equipa a jogar fora: ");
                        confirm = this.cm.hasEquipa(eq_fora);
                        if (!confirm) {
                            ClientView.warning("Essa equipa nao esta disponivel nos dados guardados!!");
                        }
                    } while (!confirm);
                    casa = new EquipaFutebol(this.cm.get_equipa(eq_casa));
                    fora = new EquipaFutebol(this.cm.get_equipa(eq_fora));
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String datefrominput;
                    LocalDate data_do_jogo;
                    do {
                        do {
                            datefrominput = ClientView.get_String("Data do jogo {dd/MM/yyyy}: ");
                            confirm = datefrominput.matches("[0-3][0-9]/[0-1][0-9]/[1-9][0-9][0-9][0-9]");
                        } while (!confirm);

                        data_do_jogo = LocalDate.parse(datefrominput, myFormatObj);
                        if (data_do_jogo.isBefore(LocalDate.now())) {
                            //System.out.println(data_do_jogo.toString() + " " + LocalDateTime.now().toString());
                            ClientView.warning("Nao parece ser possivel haver um jogo nessa data...");
                            confirm = false;
                        } else confirm = true;
                    } while (!confirm);
                    JogoFutebol jogo_atual = new JogoFutebol(casa, fora, data_do_jogo);
                    this.cm.addJogo(jogo_atual);
                    ClientView.warning("Jogo criado com sucesso!");
                    int points = JogoFutebolModel.executaJogo(this.cm.getUser(), jogo_atual);
                    this.cm.add_points(points);
                    ClientView.pause();
                }
                case 5 -> {
                    int escolha_consulta = ClientView.painel_consulta();
                    switch (escolha_consulta) {
                        case 1:
                            if (this.cm.get_numero_jogadores() == 0) {
                                ClientView.warning("\tNao ha dados carregados/disponiveis!");
                                ClientView.pause();
                                break;
                            }
                            this.ConsultaJogadores();
                            ClientView.SimNao("Queres trocar algum jogador de equipa?");
                            int trocar_de_equipa;
                            boolean flag;
                            do {
                                trocar_de_equipa = ClientView.get_Int("Opcao");
                                flag = ClientView.not_an_option(trocar_de_equipa, 1, 2);
                            } while (!flag);
                            if (trocar_de_equipa != 2) {
                                JogadorFutebol aux;
                                do {
                                    String nome = ClientView.get_String("Nome do jogador");
                                    if (this.cm.hasJogador(nome)) {
                                        flag = true;
                                        JogadorFutebolView.print_jogador(this.cm.get_jogador(nome));
                                        aux = this.cm.get_jogador(nome);
                                        ClientView.pause();
                                        JogadorFutebolView.print_equipas(this.cm.getEquipas());
                                        String nome_equipa;
                                        do {
                                            nome_equipa = ClientView.get_String("Nome da nova equipa");
                                            if (!this.cm.hasEquipa(nome_equipa)) {
                                                flag = false;
                                                ClientView.warning("Essa equipa nao esta guardada!");
                                            } else flag = true;
                                        } while (!flag);

                                        flag = this.cm.get_equipa(nome_equipa).adiciona_jogador(aux);
                                        if (!flag) ClientView.warning("\tEssa equipa estava cheia!...");
                                        else {
                                            JogadorFutebolView.print_jogador(aux);
                                            ClientView.pause();
                                        }
                                    } else {
                                        flag = false;
                                        ClientView.warning("Esse jogador nao esta guardado!");
                                        ClientView.pause();
                                    }
                                } while (!flag);


                            }

                            break;
                        case 2:
                            if (this.cm.get_numero_equipas() == 0) {
                                ClientView.warning("\tNao ha dados carregados/disponiveis!");
                                ClientView.pause();
                                break;
                            }
                            this.ConsultaEquipas();
                            break;
                        case 3:
                            if (this.cm.get_numero_jogos() == 0) {
                                ClientView.warning("\tNao ha dados carregados/disponiveis!");
                                ClientView.pause();
                                break;
                            }
                            this.ConsultaJogos();
                            break;
                        default:
                            break;
                    }
                }
                case 6 -> { //Carregar dados
                    int escolha_carregamento = ClientView.carregar_ficheiros();
                    switch (escolha_carregamento) {
                        case 1:
                            String path = ClientView.get_String("Filepath");
                            cm.carrega_dados_log(path);
                            ClientView.warning("\tDados carregados!");
                            ClientView.pause();
                            break;

                        case 2:
                            String pathobj = ClientView.get_String("Filepath");
                            ObjectFileProcessing.carrega_dados_obj(this.cm, pathobj);       //Aq o encapsulamento..
                            ClientView.warning("Ficheiro carregado com sucesso!");
                            ClientView.pause();
                            break;
                        default:
                            break;
                    }
                }
                case 7 -> { //Guardar Dados
                    int escolha_guardar = ClientView.guardar_ficheiros();
                    if (escolha_guardar == 1) {
                        String file = ClientView.get_String("Filepath");
                        cm.guarda_Dados(file);
                        ClientView.warning("Ficheiro criado com sucesso");
                        ClientView.pause();
                    }
                }
                case 8 -> {
                    if (cm.user_isEmpty()) {
                        ClientView.warning("\tAinda nao criaste a tua conta!\n");
                    } else {
                        ClientView.show_profile(cm.get_user_name(), cm.get_user_mail(), cm.get_user_level(), cm.get_user_points(),
                                cm.get_user_date());
                    }
                    ClientView.pause();
                }
            }
        } while(user_option != 0);
    }


    /**
     * ConsultaJogadores
     * Permite a consulta dos jogadores guardados no sistema, assim como informação extra sobre cada um
     */
    public void ConsultaJogadores(){

        int aux;
        do {
            JogadorFutebolView.print_jogadores_info(cm.getJogadores());
            aux = JogadorFutebolView.consultar_jogadores(cm.getJogadores());
        } while(aux != 2);
    }

    /**
     * ConsultaEquipas
     * Automatiza o processo de leitura de equipas guardadas, assim como a apresentação das mesmas
     * E até uma possivel necessidade de aceder à informação intrínseca da mesma
     */
    public void ConsultaEquipas() {

        Map<String, EquipaFutebol> equipas = this.cm.getEquipas();
        int aux;
        do {
            JogadorFutebolView.print_equipas(equipas);
            aux = JogadorFutebolView.consultar_equipa(equipas);
        } while (aux != 2);
    }

    /**
     *
     */
    public void ConsultaJogos() {

        Set<JogoFutebol> jogos = this.cm.getJogos();
        JogadorFutebolView.print_jogos(jogos);
        ClientView.pause();
    }




}
