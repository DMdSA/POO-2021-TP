import Equipa.EquipaFutebol;
import Jogadores.JogadorFutebol;
import Views.ClientView;
import Views.JogadorFutebolView;

public class MenuController {

    private ClientModel clientmodel;

    public MenuController(){
        this.clientmodel = new ClientModel();
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
                    this.clientmodel.setUser(ClientView.get_username(), ClientView.get_email());
                    ClientView.warning("\t MVC.Utilizador guardado");
                    ClientView.pause();
                    break;

                case 2:
                    //criar jogador
                    JogadorFutebol jogador = this.clientmodel.create_jogador();
                    JogadorFutebolView.criacao_jogador_sucesso();
                    JogadorFutebolView.print_jogador(jogador);
                    ClientView.pause();
                    if (!this.clientmodel.addJogador(jogador)) ClientView.warning("\tEsse jogador ja existe!");
                    break;

                case 3:
                    //criar equipa - JogadoresGuardados ou novos?
                    int option = ClientView.criar_equipa_menu();

                    if (option == 1) {
                        int validation = this.clientmodel.get_numero_equipas();
                        if (validation < 11) {
                            ClientView.warning("\tNão há jogadores suficientes guardados nesta conta!");
                            return;
                            //Neste ponto, ele tem de voltar para o menu exatamente anterior..
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
                            JogadorFutebol current = this.clientmodel.create_jogador();
                            boolean flag = this.clientmodel.addJogador(current);
                            if (flag) {
                                contador++;
                                if (contador < 11) ef.adicionaTitular(current);                 //Até 11 jogadores, adiciona titulares
                                else ef.adicionaSuplente(current);                              //A partir daí, suplentes
                            }
                            this.clientmodel.addEquipa(ef);
                        }
                        break;
                    }

            }
        } while(user_option != 0);
    }
}
