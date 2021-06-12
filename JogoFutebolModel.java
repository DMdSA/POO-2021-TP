import Jogadores.Futebol.JogadorFutebol;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class JogoFutebolModel {


    public static int executaJogo(Utilizador user, JogoFutebol jogoFutebol) throws InterruptedException {

        int escolhe_quem_comeca = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        double fator_chances = jogoFutebol.getEquipaCasa().getHabilidade()/jogoFutebol.getEquipaFora().getHabilidade() * 1.2;
        int chances_casa; int chances_fora;
        int chances_fora_aux; int chances_casa_aux;
        int equipa_atacar; int answer = 0;
        JogadorFutebol atacante = new JogadorFutebol();

        jogoFutebol.getEquipaCasa().reinicia_golos();
        jogoFutebol.getEquipaFora().reinicia_golos();

        //Calculo de quantas chances cada equipa tem
        if((int) (3*fator_chances)>5){chances_casa = 5;}
        else if((int) (3*fator_chances)<1){chances_casa = 1;}
        else{chances_casa = (int) (3*fator_chances);}

        if((int) (3/fator_chances)>5){chances_fora = 5;}
        else if((int) (3/fator_chances)<1){chances_fora = 1;}
        else{chances_fora = (int) (3/fator_chances);}

        chances_casa_aux = chances_casa;
        chances_fora_aux = chances_fora;
        //-------------------------------------------------------

        if(escolhe_quem_comeca == 1){
            ClientView.warning("(+) A equipa " + jogoFutebol.get_nome_equipa_casa() + " comeca com a bola");
            equipa_atacar = 1;
        }
        else{
            ClientView.warning("(+) A equipa " + jogoFutebol.get_nome_equipa_fora() + " comeca com a bola");
            equipa_atacar = 2;
        }

        TimeUnit.SECONDS.sleep(2);
        for(int j = 0; j < 2; j++) {
            if(j == 0) {
                ClientView.warning("(+) Comecou a 1a parte do jogo Q('-')Q");
            }
            else {
                substituicoes(jogoFutebol);
                ClientView.pause();
                ClientView.warning("(+) Comecou a 2a parte do jogo Q('-')Q");
                chances_casa_aux = chances_casa;
                chances_fora_aux = chances_casa;
                if(escolhe_quem_comeca == 1){
                    equipa_atacar = 2;
                }
                else {
                    equipa_atacar = 1;
                }
            }
            TimeUnit.SECONDS.sleep(2);
            for (int i = 0; i < Math.max(chances_casa, chances_fora) * 2; i++) {
                if (equipa_atacar == 1) {

                    if (chances_casa_aux != 0) {
                        ClientView.warning("(+) A equipa " + jogoFutebol.get_nome_equipa_casa() + " está a atacar");
                        TimeUnit.SECONDS.sleep(2);

                        if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaCasa().getOverallMedios(), jogoFutebol.getEquipaFora().getOverallMedios())) {
                            equipa_casa_ultrapassa_medios(jogoFutebol);

                            if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaCasa().getOverallAvancados(), jogoFutebol.getEquipaFora().getOverallDefesas())) {
                                atacante = equipa_casa_ultrapassa_defesas(jogoFutebol, atacante);

                                if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(atacante.getHabilidade(), jogoFutebol.getEquipaFora().getGoalKeeper().getHabilidade() * 2)) {
                                    ClientView.warning("(+) GOOOOOOOOOOOLO. Magnifico golo de " + atacante.getNome() + " a favor da equipa " + jogoFutebol.get_nome_equipa_casa());
                                    jogoFutebol.getEquipaCasa().addGolo();
                                    chances_casa_aux--;
                                    equipa_atacar = 2;
                                    TimeUnit.SECONDS.sleep(1);
                                } else {
                                    ClientView.warning("(+) Foi por um triz, o guarda redes " + jogoFutebol.getEquipaFora().getGoalKeeper().getNome() + " conseguiu defender");
                                    equipa_atacar = 2;
                                    chances_casa_aux--;
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            } else {
                                ClientView.warning("(+) Corte estupendo por parte de " + jogoFutebol.getEquipaFora().getRandomDefesa());
                                equipa_atacar = 2;
                                chances_casa_aux--;
                                TimeUnit.SECONDS.sleep(1);
                            }
                        } else {
                            ClientView.warning("(+) " + jogoFutebol.getEquipaCasa().getRandomMedio() + " perdeu a bola");
                            equipa_atacar = 2;
                            chances_casa_aux--;
                            TimeUnit.SECONDS.sleep(1);
                        }
                    }
                } else {
                    if (chances_fora_aux != 0) {
                        ClientView.warning("(+) A equipa " + jogoFutebol.get_nome_equipa_fora() + " está a atacar");
                        TimeUnit.SECONDS.sleep(2);
                        if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaFora().getOverallMedios(), jogoFutebol.getEquipaCasa().getOverallMedios())) {
                            equipa_fora_ultrapassa_medios(jogoFutebol);
                            if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaFora().getOverallAvancados(), jogoFutebol.getEquipaCasa().getOverallDefesas())) {
                                atacante = equipa_fora_ultrapassa_defesas(jogoFutebol, atacante);
                                if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(atacante.getHabilidade(), jogoFutebol.getEquipaCasa().getGoalKeeper().getHabilidade() * 2)) {
                                    ClientView.warning("(+) GOOOOOOOOOOOLO. Magnifico golo de " + atacante.getNome() + " a favor da equipa " + jogoFutebol.get_nome_equipa_fora());
                                    jogoFutebol.getEquipaFora().addGolo();
                                    chances_fora_aux--;
                                    equipa_atacar = 1;
                                    TimeUnit.SECONDS.sleep(1);
                                } else {
                                    ClientView.warning("(+) Foi por um triz, o guarda redes " + jogoFutebol.getEquipaCasa().getGoalKeeper().getNome() + " conseguiu defender");
                                    equipa_atacar = 1;
                                    chances_fora_aux--;
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            } else {
                                ClientView.warning("(+) Corte estupendo por parte de " + jogoFutebol.getEquipaCasa().getRandomDefesa());
                                equipa_atacar = 1;
                                chances_fora_aux--;
                                TimeUnit.SECONDS.sleep(1);
                            }
                        } else {
                            ClientView.warning("(+) " + jogoFutebol.getEquipaFora().getRandomMedio() + " perdeu a bola");
                            equipa_atacar = 1;
                            chances_fora_aux--;
                            TimeUnit.SECONDS.sleep(1);
                        }

                    }
                }
            }
            if(j == 0){
                ClientView.warning("(-) Terminou a 1a parte com " + jogoFutebol.getEquipaCasa().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_casa()
                        + " e " + jogoFutebol.getEquipaFora().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_fora());
            }
            else{
                ClientView.warning("(-) Terminou o jogo com " + jogoFutebol.getEquipaCasa().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_casa()
                        + " e " + jogoFutebol.getEquipaFora().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_fora());

                    if(jogoFutebol.getEquipaCasa().getGolos() > jogoFutebol.getEquipaFora().getGolos()){
                        ClientView.warning("(-) Parabéns a equipa " + jogoFutebol.get_nome_equipa_casa());
                        user.setPoints(user.getPoints() + 30 + 15*jogoFutebol.getEquipaCasa().getGolos());
                        ClientView.warning("(-) Recebeste " + (30 + 15*jogoFutebol.getEquipaCasa().getGolos()) + " pontos pela vitoria");
                        answer = 1;
                    }
                    else if(jogoFutebol.getEquipaFora().getGolos() > jogoFutebol.getEquipaCasa().getGolos()){
                        ClientView.warning("(-) Parabéns a equipa " + jogoFutebol.get_nome_equipa_fora());
                        ClientView.warning("(-) Nao ganhaste pontos. Better luck next time");
                    }
                    else{
                        ClientView.warning("(-) O jogo acabou com um empate");
                    }
            }
        }
        if(answer == 1){
            answer = (30 + 15*jogoFutebol.getEquipaCasa().getGolos());
        }
        jogoFutebol.getEquipaCasa().reinicia_golos();
        jogoFutebol.getEquipaFora().reinicia_golos();
        return answer;
    }

    public static void equipa_casa_ultrapassa_medios(JogoFutebol jogoFutebol) throws InterruptedException {
        ClientView.warning("(-) " + jogoFutebol.getEquipaCasa().getRandomMedio() + " fintou " + jogoFutebol.getEquipaFora().getRandomMedio() + " e passa para o ataque");
        TimeUnit.SECONDS.sleep(1);
        ClientView.warning("(-) " + jogoFutebol.getEquipaCasa().getRandomAvancado() + " recebeu a bola");
        TimeUnit.SECONDS.sleep(3);
    }

    public static void equipa_fora_ultrapassa_medios(JogoFutebol jogoFutebol) throws InterruptedException{
        ClientView.warning("(-) " + jogoFutebol.getEquipaFora().getRandomMedio() + " fintou " + jogoFutebol.getEquipaCasa().getRandomMedio() + " e passa para o ataque");
        TimeUnit.SECONDS.sleep(1);
        ClientView.warning("(-) " + jogoFutebol.getEquipaFora().getRandomAvancado() + " recebeu a bola");
        TimeUnit.SECONDS.sleep(3);
    }

    public static JogadorFutebol equipa_casa_ultrapassa_defesas(JogoFutebol jogoFutebol, JogadorFutebol atacante) throws InterruptedException {
        atacante = jogoFutebol.getEquipaCasa().getJogadorByName(jogoFutebol.getEquipaCasa().getRandomAvancado());
        ClientView.warning("(-) " + atacante.getNome() + " ultrapassou os defesas e prepara-se para o remate");
        TimeUnit.SECONDS.sleep(3);
        return atacante;
    }

    public static JogadorFutebol equipa_fora_ultrapassa_defesas(JogoFutebol jogoFutebol, JogadorFutebol atacante) throws InterruptedException {
        atacante = jogoFutebol.getEquipaFora().getJogadorByName(jogoFutebol.getEquipaFora().getRandomAvancado());
        ClientView.warning("(-) " + atacante.getNome() + " ultrapassou os defesas e prepara-se para o remate");
        TimeUnit.SECONDS.sleep(3);
        return atacante;
    }

    public static int conta(double eq_atacar, double eq_defender){
        return (int) ((eq_atacar * 100)/(eq_defender + eq_atacar));
    }

    public static void substituicoes(JogoFutebol jogoFutebol){
        int subs;
        boolean flag;
        String titular,suplente;

        do {
            ClientView.warning("(-) Quantas substituicoes queres fazer? ");
            subs = ClientView.get_Int("(-)  Numero de substituicoes ");
            flag = ClientView.not_an_option(subs,0,3);
        }while (!flag);

        JogadorFutebolView.print_jogadores_jogo(jogoFutebol);
        for(int i = 0; i < subs; i++){
            do {
                 titular = ClientView.get_String("Jogador que vai sair ");
                 suplente = ClientView.get_String("Jogador que vai entrar ");
                 flag = (jogoFutebol.getEquipaCasa().hasJogador(titular) && jogoFutebol.getEquipaCasa().hasJogador(suplente));
                 if(!flag){
                     ClientView.warning("Um dos jogadores nao esta presente na equipa ou os jogadores nao jogam na mesma posicao");
                 }
            }while (!flag);

            flag = jogoFutebol.substitui(jogoFutebol.getEquipaCasa().getJogadorByName(titular),
                    jogoFutebol.getEquipaCasa().getJogadorByName(suplente));
            if(flag){
                ClientView.warning("Substituicao efetuada com sucesso");

            }
            else{
                ClientView.warning("Ocorreu um erro");
            }

        }
    }


}