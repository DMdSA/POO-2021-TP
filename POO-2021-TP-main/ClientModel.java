import Equipa.EquipaFutebol;
import Jogadores.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ClientModel{
    /**                                            Variáveis instância  */
    private Utilizador user;
    private Map<String, JogadorFutebol> jogadores_guardados;
    private Map<String, EquipaFutebol> equipas_guardadas;
    private Set<JogoFutebol> jogos_guardados;


    public ClientModel(){

        this.user = new Utilizador();
        this.jogadores_guardados = new HashMap<>();
        this.equipas_guardadas = new HashMap<>();
        this.jogos_guardados = new TreeSet<JogoFutebol>(jogo_comparator);
    }


    public ClientModel(Utilizador u, Map<String, JogadorFutebol> jogadores, Map<String, EquipaFutebol> equipas,
                       Set<JogoFutebol> jogos){

        this.user = u.clone();
        this.setJogadores_guardados(jogadores);
        this.setEquipas_guardadas(equipas);
        this.setJogos_guardados(jogos);
    }


    /**
     * Getters
     */


    public String get_user_name(){return this.user.getUsername();}
    public String get_user_mail(){ return this.user.getMail();}
    public int get_user_level(){ return this.user.getLevel();}
    public double get_user_points(){return this.user.getPoints();}
    public LocalDate get_user_date(){ return this.user.getDate();}


    public Utilizador getUser(){
        return this.user.clone();
    }

    public Map<String, JogadorFutebol> getJogadores(){

        return this.jogadores_guardados.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public Map<String, EquipaFutebol> getEquipas(){

        return this.equipas_guardadas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public Set<JogoFutebol> getJogos(){

        return this.jogos_guardados.stream().map(JogoFutebol::clone).collect(Collectors.toCollection(HashSet :: new));
    }

    public int get_numero_jogadores(){
        return this.jogadores_guardados.size();
    }

    public int get_numero_equipas(){
        return this.equipas_guardadas.size();
    }

    public int get_numero_jogos(){
        return this.jogos_guardados.size();
    }

    /**
     * Setters
     */
    public boolean setUser(Utilizador u){     //Apenas se adiciona se o user guardado for diferente
        if(!this.user.equals(u)){
            this.user = u.clone();
            return true;
        }
        return false;
    }

    public boolean setUser(String name, String mail){     //Apenas se adiciona se o user guardado for diferente

        Utilizador current = new Utilizador(name, mail);
        if(!this.user.equals(current)){
            this.user = current.clone();
            return true;
        }
        return false;
    }

    public void setJogadores_guardados(Map<String, JogadorFutebol> jogadores){

        this.jogadores_guardados = jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public void setEquipas_guardadas(Map<String, EquipaFutebol> equipas){

        this.equipas_guardadas = equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public void setJogos_guardados(Set<JogoFutebol> jogos){

        this.jogos_guardados = jogos.stream().map(JogoFutebol::clone).collect(Collectors.toCollection(TreeSet :: new));
    }


    public boolean user_isEmpty(){
        if(this.user.equals(new Utilizador())){return true;};
        return false;
    }


    /**
     * addJogador
     * @param jf Jogador de Futebol a adicionar
     */
    public boolean addJogador(JogadorFutebol jf){

        if(this.jogadores_guardados.containsKey(jf.getNome())){
            return false;
        }

        this.jogadores_guardados.put(jf.getNome(), jf.clone());
        return true;
    }

    public static void addHabilidadeExtra(JogadorFutebol jf, double extra){}

    public JogadorFutebol create_jogador(){

        PosicaoCampo pc = JogadorFutebolView.get_posicao();
        JogadorFutebol aux = switch (pc) {
            case A -> cria_avancado();
            case D -> cria_defesa();
            case GR -> cria_guardaredes();
            case L -> cria_lateral();
            case M -> cria_medio();
            default -> null;
        };
        return aux;
    }


    /**
     * addEquipa
     * @param ef Equipa de Futebol a ser adicionada
     * @return True, se for uma nova equipa, False, caso contrário
     */
    public boolean addEquipa(EquipaFutebol ef){

        if(this.equipas_guardadas.containsKey(ef.getNome())){   //Se a equipa já existir, não adiciona
            return false;
        }

        for(Map.Entry<String, JogadorFutebol> jf : ef.getJogadoresTitulares().entrySet()){    //Para cada jogador, se for novo adiciona aos jogadores
            this.addJogador(jf.getValue());                                //presentes na conta deste user
        }

        for(Map.Entry<String, JogadorFutebol> jf : ef.getJogadoresSuplentes().entrySet()){    //Para cada jogador, se for novo adiciona aos jogadores
            this.addJogador(jf.getValue());                                //presentes na conta deste user
        }

        this.equipas_guardadas.put(ef.getNome(), ef.clone());   //Adicionar a nova equipa a esta conta
        return true;
    }

    /**
     * addJogo
     * @param jf Jogo de Futebol a ser adicionado
     * @return True, se for um novo jogo, False, caso contrário
     */
    public boolean addJogo(JogoFutebol jf){

        EquipaFutebol casa = jf.getEquipaCasa();
        EquipaFutebol fora = jf.getEquipaFora();    //Tem de verificar se essas equipas estão no sistema..

        if(this.equipas_guardadas.containsKey(casa.getNome()) && this.equipas_guardadas.containsKey(fora.getNome())) {

            if (this.jogos_guardados.contains(jf)) return false;
            this.jogos_guardados.add(jf.clone());
            return true;
        }
        return false;
    }


    Comparator<JogoFutebol> jogo_comparator = new Comparator<JogoFutebol>() {   //Estudar isto, está ligeiramente ao calhas
        @Override
        public int compare(JogoFutebol o1, JogoFutebol o2) {

            if(o1.get_nome_equipa_casa().equals(o2.get_nome_equipa_fora()) &&
                    o1.get_nome_equipa_fora().equals(o2.get_nome_equipa_fora())) {
                return o1.getData().compareTo(o2.getData());
            }

            return o1.get_nome_equipa_casa().compareTo(o2.get_nome_equipa_casa()) +
                    o1.get_nome_equipa_fora().compareTo(o2.get_nome_equipa_fora());
        }
    };


    public Avancado cria_avancado(){

        Avancado novo = new Avancado(ClientView.get_String("Nome do jogador"), PosicaoCampo.A);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setFinalizacao(JogadorFutebolView.get_finalizacao());
        novo.setOverall(novo.getHabilidade());
        return novo;
    }

        public GuardaRedes cria_guardaredes(){

        GuardaRedes novo = new GuardaRedes(ClientView.get_String("Nome do jogador"), PosicaoCampo.GR);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setElasticidade(JogadorFutebolView.get_elasticidade());
        novo.setOverall(novo.getHabilidade());
        return novo;
    }


        public Defesa cria_defesa(){

        Defesa novo = new Defesa(ClientView.get_String("Nome do jogador"), PosicaoCampo.D);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setCapacidadeBloquearBolas(JogadorFutebolView.get_capacidade_bloquear_bolas());
        novo.setOverall(novo.getHabilidade());
        return novo;
    }


        public Lateral cria_lateral(){

        Lateral novo = new Lateral(ClientView.get_String("Nome do jogador"), PosicaoCampo.L);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setCapacidadeCruzamentos(JogadorFutebolView.get_capacidade_cruzamentos());
        novo.setOverall(novo.getHabilidade());
        return novo;
    }


        public Medio cria_medio(){

        Medio novo = new Medio(ClientView.get_String("Nome do jogador"), PosicaoCampo.M);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setCapacidadeRecuperarBolas(JogadorFutebolView.get_capacidade_recuperar_bolas());
        novo.setOverall(novo.getHabilidade());
        return novo;
    }

    /**
     * carrega_dados_log
     * Carrega os dados presentes numa file de logs
     * @param filename Filepath do ficheiro
     */
    public void carrega_dados_log(String filename){

        LogParser parsed_info = new LogParser(filename);
        Map<String, EquipaFutebol> equipas = parsed_info.getEquipas();
        Collection<JogoFutebol> jogos = parsed_info.getJogos();

        for(Map.Entry<String, EquipaFutebol> entrada : equipas.entrySet()){
            this.addEquipa(entrada.getValue());
        }

        this.jogos_guardados = new HashSet<JogoFutebol>();
        for(JogoFutebol jf : jogos) this.addJogo(jf);
    }

    /**
     * guarda_dados Guarda os dados do programa num ficheiro de objetos
     * @param filename Nome do ficheiro
     * @throws IOException
     */
    public void guarda_Dados(String filename) throws IOException {
        ArrayList<Object> tofile = new ArrayList<>();
        tofile.add(user);
        for(Map.Entry<String,JogadorFutebol> entrada : jogadores_guardados.entrySet()){
            tofile.add(entrada.getValue());
        }
        //tofile.add(jogadores_guardados);
        for(Map.Entry<String,EquipaFutebol> entrada2 : equipas_guardadas.entrySet()){
            tofile.add(entrada2.getValue());
        }
            tofile.add(jogos_guardados);

        WriteToFile writeToFile = new WriteToFile();
        writeToFile.WriteObjectToFile(tofile,filename);
    }

    public void carrega_dados_obj(String filename) throws IOException, ClassNotFoundException {

        this.jogadores_guardados = new HashMap<>();
        this.equipas_guardadas = new HashMap<>();
        this.jogos_guardados = new HashSet<>();
        this.user = new Utilizador();

        FileInputStream fileStream = new FileInputStream(filename);
        ObjectInputStream input = new ObjectInputStream(fileStream);
        ArrayList<Object> fromfile;

        fromfile =(ArrayList<Object>) input.readObject();
        for(int i = 0; i < fromfile.size(); i++){
            if(fromfile.get(i) instanceof Utilizador){
                this.user = (Utilizador) fromfile.get(i);
            }
            else if(fromfile.get(i) instanceof JogadorFutebol){
                this.jogadores_guardados.put(((JogadorFutebol) fromfile.get(i)).getNome(), (JogadorFutebol) fromfile.get(i));
            }
            else if(fromfile.get(i) instanceof EquipaFutebol){
                this.equipas_guardadas.put(((EquipaFutebol) fromfile.get(i)).getNome(),(EquipaFutebol) fromfile.get(i));
            }
            else if(fromfile.get(i) instanceof JogoFutebol){
                this.jogos_guardados.add((JogoFutebol) fromfile.get(i));
            }
        }
    }

    /**
     * hasJogador, verifica se um jogador está presente na lista de guardados
     * @param nome Nome do jogador a pesquisar
     * @return True, se existir, False, caso contrário
     */
    public boolean hasJogador(String nome){

        return this.jogadores_guardados.containsKey(nome);
    }

    /**
     * hasEquipa, verifica se uma equipa está presente na lista de guardados
     * @param equipa Nome equipa
     * @return True, se existir
     */
    public boolean hasEquipa(String equipa){

        return this.equipas_guardadas.containsKey(equipa);
    }

    public JogadorFutebol get_jogador(String nome){

        if(this.jogadores_guardados.containsKey(nome))
            return this.jogadores_guardados.get(nome);
        return new JogadorFutebol();
    }

    public EquipaFutebol get_equipa(String nome){

        if(this.equipas_guardadas.containsKey(nome))
            return this.equipas_guardadas.get(nome);
        return new EquipaFutebol();
    }

    public void executaJogo(JogoFutebol jogoFutebol) throws InterruptedException {
        int escolhe_quem_comeca = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        double fator_chances = jogoFutebol.getEquipaCasa().getHabilidade()/jogoFutebol.getEquipaFora().getHabilidade() * 1.2;
        int chances_casa;
        int chances_fora;
        int chances_fora_aux;
        int chances_casa_aux;
        int equipa_atacar;
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
            ClientView.warning("A equipa " + jogoFutebol.get_nome_equipa_casa() + " comeca com a bola");
            equipa_atacar = 1;
        }
        else{
            ClientView.warning("A equipa " + jogoFutebol.get_nome_equipa_fora() + " comeca com a bola");
            equipa_atacar = 2;
        }

        TimeUnit.SECONDS.sleep(2);
        for(int j = 0; j < 2; j++) {
            if(j == 0) {
                ClientView.warning("Comecou a 1a parte do jogo Q('-')Q");
            }
            else {
                substituicoes(jogoFutebol);
                ClientView.pause();
                ClientView.warning("Comecou a 2a parte do jogo Q('-')Q");
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
                        ClientView.warning("A equipa " + jogoFutebol.get_nome_equipa_casa() + " está a atacar");
                        TimeUnit.SECONDS.sleep(2);

                        if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaCasa().getOverallMedios(), jogoFutebol.getEquipaFora().getOverallMedios())) {
                            equipa_casa_ultrapassa_medios(jogoFutebol);

                            if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaCasa().getOverallAvancados(), jogoFutebol.getEquipaFora().getOverallDefesas())) {
                                atacante = equipa_casa_ultrapassa_defesas(jogoFutebol, atacante);

                                if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(atacante.getHabilidade(), jogoFutebol.getEquipaFora().getGoalKeeper().getHabilidade() * 2)) {
                                    ClientView.warning("GOOOOOOOOOOOLO. Magnifico golo de " + atacante.getNome() + " a favor da equipa " + jogoFutebol.get_nome_equipa_casa());
                                    jogoFutebol.getEquipaCasa().addGolo();
                                    chances_casa_aux--;
                                    equipa_atacar = 2;
                                    TimeUnit.SECONDS.sleep(1);
                                } else {
                                    ClientView.warning("Foi por um triz, o guarda redes " + jogoFutebol.getEquipaFora().getGoalKeeper().getNome() + " conseguiu defender");
                                    equipa_atacar = 2;
                                    chances_casa_aux--;
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            } else {
                                ClientView.warning("Corte estupendo por parte de " + jogoFutebol.getEquipaFora().getRandomDefesa());
                                equipa_atacar = 2;
                                chances_casa_aux--;
                                TimeUnit.SECONDS.sleep(1);
                            }
                        } else {
                            ClientView.warning(jogoFutebol.getEquipaCasa().getRandomMedio() + " perdeu a bola");
                            equipa_atacar = 2;
                            chances_casa_aux--;
                            TimeUnit.SECONDS.sleep(1);
                        }
                    }
                } else {
                    if (chances_fora_aux != 0) {
                        ClientView.warning("A equipa " + jogoFutebol.get_nome_equipa_fora() + " está a atacar");
                        TimeUnit.SECONDS.sleep(2);
                        if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaFora().getOverallMedios(), jogoFutebol.getEquipaCasa().getOverallMedios())) {
                            equipa_fora_ultrapassa_medios(jogoFutebol);
                            if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(jogoFutebol.getEquipaFora().getOverallAvancados(), jogoFutebol.getEquipaCasa().getOverallDefesas())) {
                                atacante = equipa_fora_ultrapassa_defesas(jogoFutebol, atacante);
                                if (ThreadLocalRandom.current().nextInt(1, 100 + 1) < conta(atacante.getHabilidade(), jogoFutebol.getEquipaCasa().getGoalKeeper().getHabilidade() * 2)) {
                                    ClientView.warning("GOOOOOOOOOOOLO. Magnifico golo de " + atacante.getNome() + " a favor da equipa " + jogoFutebol.get_nome_equipa_fora());
                                    jogoFutebol.getEquipaFora().addGolo();
                                    chances_fora_aux--;
                                    equipa_atacar = 1;
                                    TimeUnit.SECONDS.sleep(1);
                                } else {
                                    ClientView.warning("Foi por um triz, o guarda redes " + jogoFutebol.getEquipaCasa().getGoalKeeper().getNome() + " conseguiu defender");
                                    equipa_atacar = 1;
                                    chances_fora_aux--;
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            } else {
                                ClientView.warning("Corte estupendo por parte de " + jogoFutebol.getEquipaCasa().getRandomDefesa());
                                equipa_atacar = 1;
                                chances_fora_aux--;
                                TimeUnit.SECONDS.sleep(1);
                            }
                        } else {
                            ClientView.warning(jogoFutebol.getEquipaFora().getRandomMedio() + " perdeu a bola");
                            equipa_atacar = 1;
                            chances_fora_aux--;
                            TimeUnit.SECONDS.sleep(1);
                        }

                    }
                }
            }
            if(j == 0){
                ClientView.warning("Terminou a 1a parte com " + jogoFutebol.getEquipaCasa().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_casa()
                        + " e " + jogoFutebol.getEquipaFora().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_fora());
            }
            else{
                ClientView.warning("Terminou o jogo com " + jogoFutebol.getEquipaCasa().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_casa()
                        + " e " + jogoFutebol.getEquipaFora().getGolos() + " golos para " + jogoFutebol.get_nome_equipa_fora());

                    if(jogoFutebol.getEquipaCasa().getGolos() > jogoFutebol.getEquipaFora().getGolos()){
                        ClientView.warning("Parabéns a equipa " + jogoFutebol.get_nome_equipa_casa());
                        this.user.setPoints(this.user.getPoints() + 30 + 15*jogoFutebol.getEquipaCasa().getGolos());
                        ClientView.warning("Recebeste " + (30 + 15*jogoFutebol.getEquipaCasa().getGolos()) + " pontos pela vitoria");
                    }
                    else if(jogoFutebol.getEquipaFora().getGolos() > jogoFutebol.getEquipaCasa().getGolos()){
                        ClientView.warning("Parabéns a equipa " + jogoFutebol.get_nome_equipa_fora());
                        ClientView.warning("Nao ganhaste pontos. Better luck next time");
                    }
                    else{
                        ClientView.warning("O jogo acabou com um empate");
                    }
            }
        }
        jogoFutebol.getEquipaCasa().reinicia_golos();
        jogoFutebol.getEquipaFora().reinicia_golos();
    }

    void equipa_casa_ultrapassa_medios(JogoFutebol jogoFutebol) throws InterruptedException {
        ClientView.warning(jogoFutebol.getEquipaCasa().getRandomMedio() + " fintou " + jogoFutebol.getEquipaFora().getRandomMedio() + " e passa para o ataque");
        TimeUnit.SECONDS.sleep(1);
        ClientView.warning(jogoFutebol.getEquipaCasa().getRandomAvancado() + " recebeu a bola");
        TimeUnit.SECONDS.sleep(3);
    }

    void equipa_fora_ultrapassa_medios(JogoFutebol jogoFutebol) throws InterruptedException{
        ClientView.warning(jogoFutebol.getEquipaFora().getRandomMedio() + " fintou " + jogoFutebol.getEquipaCasa().getRandomMedio() + " e passa para o ataque");
        TimeUnit.SECONDS.sleep(1);
        ClientView.warning(jogoFutebol.getEquipaFora().getRandomAvancado() + " recebeu a bola");
        TimeUnit.SECONDS.sleep(3);
    }

    JogadorFutebol equipa_casa_ultrapassa_defesas(JogoFutebol jogoFutebol, JogadorFutebol atacante) throws InterruptedException {
        atacante = jogoFutebol.getEquipaCasa().getJogadorByName(jogoFutebol.getEquipaCasa().getRandomAvancado());
        ClientView.warning(atacante.getNome() + " ultrapassou os defesas e prepara-se para o remate");
        TimeUnit.SECONDS.sleep(3);
        return atacante;
    }

    JogadorFutebol equipa_fora_ultrapassa_defesas(JogoFutebol jogoFutebol, JogadorFutebol atacante) throws InterruptedException {
        atacante = jogoFutebol.getEquipaFora().getJogadorByName(jogoFutebol.getEquipaFora().getRandomAvancado());
        ClientView.warning(atacante.getNome() + " ultrapassou os defesas e prepara-se para o remate");
        TimeUnit.SECONDS.sleep(3);
        return atacante;
    }

    int conta(double eq_atacar, double eq_defender){
        return (int) ((eq_atacar * 100)/(eq_defender + eq_atacar));
    }

    void substituicoes(JogoFutebol jogoFutebol){
        int subs;
        boolean flag;

        do {
            ClientView.warning("Quantas substituicoes queres fazer? ");
            subs = ClientView.get_Int("Numero de substituicoes: ");
            flag = ClientView.not_an_option(subs,0,3);
        }while (!flag);

        JogadorFutebolView.print_jogadores_info(jogoFutebol.getEquipaCasa().getJogadoresTitulares());
        JogadorFutebolView.print_jogadores_info(jogoFutebol.getEquipaCasa().getJogadoresSuplentes());
    }
}
