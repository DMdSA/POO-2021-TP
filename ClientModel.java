import Equipa.EquipaFutebol;
import Jogadores.*;
import Views.JogadorFutebolView;

import java.util.*;
import java.util.stream.Collectors;

public class ClientModel{

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

        return this.jogos_guardados.stream().map(JogoFutebol::clone).collect(Collectors.toCollection(TreeSet :: new));
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

        for(JogadorFutebol jf : ef.getJogadoresTitulares()){    //Para cada jogador, se for novo adiciona aos jogadores
            this.addJogador(jf);                                //presentes na conta deste user
        }

        for(JogadorFutebol jf : ef.getJogadoresSuplentes()){    //Para cada jogador, se for novo adiciona aos jogadores
            this.addJogador(jf);                                //presentes na conta deste user
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

        if(this.jogos_guardados.contains(jf)) return false;
        this.jogos_guardados.add(jf.clone());
        return true;
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

        Avancado novo = new Avancado(JogadorFutebolView.get_nome(), PosicaoCampo.A);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setFinalizacao(JogadorFutebolView.get_finalizacao());
        return novo;
    }

        public GuardaRedes cria_guardaredes(){

        GuardaRedes novo = new GuardaRedes(JogadorFutebolView.get_nome(), PosicaoCampo.GR);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setElasticidade(JogadorFutebolView.get_elasticidade());
        return novo;
    }


        public Defesa cria_defesa(){

        Defesa novo = new Defesa(JogadorFutebolView.get_nome(), PosicaoCampo.D);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setCapacidadeBloquearBolas(JogadorFutebolView.get_capacidade_bloquear_bolas());
        return novo;
    }


        public Lateral cria_lateral(){

        Lateral novo = new Lateral(JogadorFutebolView.get_nome(), PosicaoCampo.L);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setCapacidadeCruzamentos(JogadorFutebolView.get_capacidade_cruzamentos());
        return novo;
    }


        public Medio cria_medio(){

        Medio novo = new Medio(JogadorFutebolView.get_nome(), PosicaoCampo.M);
        novo.setIdade(JogadorFutebolView.get_idade()); novo.setAltura(JogadorFutebolView.get_altura());
        novo.setPeso(JogadorFutebolView.get_peso()); novo.setNumero(JogadorFutebolView.get_numero());
        novo.setVelocidade(JogadorFutebolView.get_velocidade()); novo.setResistencia(JogadorFutebolView.get_resistencia());
        novo.setDestreza(JogadorFutebolView.get_destreza()); novo.setJogoCabeca(JogadorFutebolView.get_jogo_cabeca());
        novo.setRemate(JogadorFutebolView.get_remate()); novo.setPasse(JogadorFutebolView.get_passe());
        novo.setImpulsao(JogadorFutebolView.get_impulsao());
        novo.setCapacidadeRecuperarBolas(JogadorFutebolView.get_capacidade_recuperar_bolas());
        return novo;
    }




}
