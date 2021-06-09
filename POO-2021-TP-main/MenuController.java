import Equipa.EquipaFutebol;
import Jogadores.Jogador;
import Jogadores.JogadorFutebol;

import java.util.Map;

public class MenuController {
/**                                            Variáveis instância  */
    private ClientModel cm;

    public MenuController(){
        this.cm = new ClientModel();
    }



    public void run() {

        int user_option = -1;
        do {
            do {
                user_option = ClientView.MenuInicial();
            } while (user_option < 0 && user_option > 7);

            switch (user_option) {

                case 0:
                    System.exit(0);
                    break;

                case 1:
                    this.cm.setUser(ClientView.get_String("Username"), ClientView.get_String("Email"));
                    ClientView.warning("\tUtilizador registado com sucesso. Recebeste 100 pontos para comecar");
                    ClientView.pause();
                    break;

                case 2:
                    //criar jogador
                    JogadorFutebol jogador = this.cm.create_jogador();
                    JogadorFutebolView.criacao_jogador_sucesso();
                    JogadorFutebolView.print_jogador(jogador);
                    ClientView.pause();
                    if (!this.cm.addJogador(jogador)) ClientView.warning("\tEsse jogador ja existe!");
                    break;

                case 3:
                    //criar equipa - JogadoresGuardados ou novos
                    int option = ClientView.criar_equipa_menu();
                    int tamanho_equipa = JogadorFutebolView.get_tamanho_equipa();
                    if (option == 1) {                                                  //Utilizar jogadores guardados
                        int validation = this.cm.get_numero_jogadores();
                        if (validation < 11) {
                            ClientView.warning("\tNão há jogadores suficientes guardados nesta conta!");
                            ClientView.pause();
                            break;
                        }
                        else {
                            int aux;
                            EquipaFutebol ef = new EquipaFutebol(ClientView.get_String("\tNome da equipa"));
                            this.ConsultaJogadores();

                            int contador_aux = 0;
                            do{
                                aux = 1;
                                JogadorFutebolView.print_jogadores_info(cm.getJogadores());
                                String adicionar = ClientView.get_String("Nome do jogador a adicionar");

                                if(cm.hasJogador(adicionar)){

                                    if(!cm.get_jogador(adicionar).isEmpty()){
                                        if(ef.get_numero_titulares()<11){
                                            ef.adicionaTitular(cm.get_jogador(adicionar));
                                            contador_aux++;
                                            ClientView.warning("\t Adicionados " + contador_aux + " jogadores.");ClientView.pause();
                                        }
                                        else if(ef.get_numero_suplentes() < 12){
                                            ef.adicionaSuplente(cm.get_jogador(adicionar));
                                            contador_aux++;
                                            ClientView.warning("\t Adicionados " + contador_aux + " jogadores.");ClientView.pause();
                                        }
                                        else {
                                            ClientView.warning("\tEsta equipa ja nao aguenta mais jogadores!");
                                            aux = 0;
                                        }
                                    }
                                }
                                else{ClientView.warning("\tEsse jogador nao esta guardado!"); ClientView.pause();}
                            } while(aux != 0 && contador_aux < tamanho_equipa);

                            this.cm.addEquipa(ef);
                            break;
                        }

                        //Aqui tem de se apresentar a lista dos jogadores (+) deixar escolhê-los (+) criar equipa
                    }

                    else {                                              //Cria uma equipa

                        int njogadores = ClientView.nova_equipa();
                        int contador = 1;
                        EquipaFutebol ef = new EquipaFutebol(ClientView.get_String("\tNome da equipa"));     //Cria a equipa com o nome dado
                        if(this.cm.getEquipas().containsKey(ef.getNome())){
                            ClientView.warning("\tEssa equipa ja existe!!");
                            break;
                        }
                        while (contador <= njogadores) {                                        //Cria n jogadores e adiciona-os
                            ClientView.warning("\n\t [Jogador " + contador + "]\n\n");
                            JogadorFutebol current = this.cm.create_jogador();
                            boolean flag = this.cm.addJogador(current);
                            if (flag) {
                                contador++;
                                if (contador < 11) ef.adicionaTitular(current);                 //Até 11 jogadores, adiciona titulares
                                else ef.adicionaSuplente(current);                              //A partir daí, suplentes
                            }
                            this.cm.addEquipa(ef);
                        }
                        break;
                    }

                case 5:
                    int escolha_consulta = ClientView.painel_consulta();
                    switch (escolha_consulta){
                        case 1:
                            if(this.cm.get_numero_jogadores() == 0){
                                ClientView.warning("\tNao ha dados carregados/disponiveis!");ClientView.pause(); break;
                            }
                            this.ConsultaJogadores();
                            break;
                        case 2:
                            if(this.cm.get_numero_equipas() == 0){
                                ClientView.warning("\tNao ha dados carregados/disponiveis!");ClientView.pause(); break;
                            }
                            this.ConsultaEquipas();
                            break;
                        case 3: //consulta jogos
                            break;
                        default: break;
                    }
                    break;


                case 6: //Carregar dados
                    int escolha_carregamento = ClientView.carregar_ficheiros();
                    if(escolha_carregamento == 1){
                        String path = ClientView.get_String("Filepath");
                        cm.carrega_dados_log(path);
                        ClientView.warning("\tDados carregados!");
                        ClientView.pause();
                        break;
                    }
                    else{
                        //carregar OBJECTSTREAM
                        break;
                    }

                case 7: //Guardar Dados
                    int escolha_guardar = ClientView.guardar_ficheiros();
                    if(escolha_guardar == 1){
                        String file = ClientView.get_string("Filepath");
                        cm.guarda_Dados(file);
                    }

                case 8:
                    if(cm.user_isEmpty()){
                        ClientView.warning("\tAinda nao criaste a tua conta!\n");
                    }
                    else{
                        ClientView.show_profile(cm.get_user_name(), cm.get_user_mail(), cm.get_user_level(), cm.get_user_points(),
                                cm.get_user_date());
                    }
                    ClientView.pause();
                    break;

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
            ClientView.clear_window();
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


}
