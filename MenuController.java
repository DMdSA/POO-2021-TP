import Equipa.EquipaFutebol;
import Jogadores.JogadorFutebol;

public class MenuController {

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
                    this.cm.setUser(ClientView.get_string("Username"), ClientView.get_string("Email"));
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
                    //criar equipa - JogadoresGuardados ou novos?
                    int option = ClientView.criar_equipa_menu();

                    if (option == 1) {
                        int validation = this.cm.get_numero_equipas();
                        if (validation < 11) {
                            ClientView.warning("\tNão há jogadores suficientes guardados nesta conta!");
                            ClientView.pause();
                            break;
                        }
                        else {
                            int aux;
                            do {
                                JogadorFutebolView.print_jogadores_info(cm.getJogadores());
                                aux = JogadorFutebolView.consultar_jogadores(cm.getJogadores());
                                ClientView.clear_window();
                            } while(aux != 2);
                        }

                        //Aqui tem de se apresentar a lista dos jogadores (+) deixar escolhê-los (+) criar equipa
                    }

                    else {                   //Cria uma equipa

                        int njogadores = ClientView.nova_equipa();
                        //criar n jogadores novos

                        int contador = 1;
                        //String[] cores = MVC.ClientView.get_cores_equipa();       Para fazer tratamento das cores (n esta feito)

                        EquipaFutebol ef = new EquipaFutebol(ClientView.get_nome_equipa());     //Cria a equipa com o nome dado

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

                case 6: //Carregar dados
                    int escolha = ClientView.carregar_ficheiros();
                    if(escolha == 1){
                        String path = ClientView.get_string("Filepath");
                        cm.carrega_dados_log(path);
                        ClientView.pause();
                        break;
                    }
                    else{
                        //carregar OBJECTSTREAM
                        break;
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
}
