package Equipa;
import Jogadores.Futebol.Avancado;
import Jogadores.Futebol.GuardaRedes;
import Jogadores.Futebol.JogadorFutebol;
import Jogadores.Futebol.PosicaoCampo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * EquipaFutebol Class
 *
 * @author Diogo Araújo, Diogo Rebelo
 * @version 1.0
 */

public class EquipaFutebol extends Equipa {
	/**                                            Variáveis instância  */
	private int substituicoes;
	private Map<String, JogadorFutebol> jogadoresTitulares;
	private Map<String, JogadorFutebol> jogadoresSuplentes;
	private double overall;
	private Cor corPrimaria;
	private Cor corSecundaria;
	private int golos;

	/**
	 * Construtores
	 */
	public EquipaFutebol() {

		super();
		this.substituicoes = 3;																	//Confirmar regras!
		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
		this.golos = 0;
	}

	public EquipaFutebol(String nome) {

		super(nome);
		this.substituicoes = 3;
		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
		this.golos = 0;
	}

	public EquipaFutebol(String nome, Cor p, Cor s) {

		super(nome);
		this.substituicoes = 3;
		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		this.overall = 0;
		this.corPrimaria = p;
		this.corSecundaria = s;
		this.golos = 0;
	}

	public EquipaFutebol(String nome, int titulares, int suplentes, int substituicoes, List<JogadorFutebol> jTitulares
			, List<JogadorFutebol> jSuplentes) {

		super(nome, titulares, suplentes);
		this.substituicoes = substituicoes;
		this.jogadoresTitulares = new HashMap<String, JogadorFutebol>();
		for (JogadorFutebol jf : jTitulares)
			this.jogadoresTitulares.put(jf.getNome(), jf.clone());

		this.jogadoresSuplentes = new HashMap<String, JogadorFutebol>();
		for (JogadorFutebol jf : jSuplentes)
			this.jogadoresSuplentes.put(jf.getNome(), jf.clone());

		this.overall = 0;
		this.corPrimaria = Cor.NONE;
		this.corSecundaria = Cor.NONE;
		this.golos = 0;
	}

	public EquipaFutebol(String nome, int titulares, int suplentes, int substituicoes, List<JogadorFutebol> jTitulares
			, List<JogadorFutebol> jSuplentes, double overall, Cor primaria, Cor secundaria) {

		super(nome, titulares, suplentes);
		this.substituicoes = substituicoes;
		this.jogadoresTitulares = new HashMap<>();
		for (JogadorFutebol jf : jTitulares)
			this.jogadoresTitulares.put(jf.getNome(), jf.clone());

		this.jogadoresSuplentes = new HashMap<>();
		for (JogadorFutebol jf : jSuplentes)
			this.jogadoresSuplentes.put(jf.getNome(), jf.clone());

		this.overall = overall;
		this.corPrimaria = primaria;
		this.corSecundaria = secundaria;
		this.golos = 0;
	}

	public EquipaFutebol(EquipaFutebol ef) {

		super(ef);
		this.substituicoes = ef.getSubstituicoes();
		this.jogadoresTitulares = ef.getJogadoresTitulares().entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));

		this.jogadoresSuplentes = ef.getJogadoresSuplentes().entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));

		this.overall = ef.getOverall();
		this.corPrimaria = ef.getCorPrimaria();
		this.corSecundaria = ef.getCorSecundaria();
		this.golos = ef.getGolos();
	}

	public static EquipaFutebol parse(String input){

		String[] parametro = input.split(",");
		return new EquipaFutebol(parametro[0]);
	}

	/**
	 * getters
	 */
	public int getSubstituicoes(){ return this.substituicoes;}

	public Map<String, JogadorFutebol> getJogadoresTitulares() {
		return this.jogadoresTitulares.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
	}

	public Map<String, JogadorFutebol> getJogadoresSuplentes() {
		return this.jogadoresSuplentes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
	}

	public double getOverall(){ return this.overall;}

	public Cor getCorPrimaria() {return this.corPrimaria;}

	public Cor getCorSecundaria() { return this.corSecundaria;}

	public int getGolos(){ return this.golos;}

	public int get_numero_titulares(){ return this.jogadoresTitulares.size();}

	public int get_numero_suplentes(){ return this.jogadoresSuplentes.size();}

	public double getHabilidade(){

		double habilidade = 0;
		for(Map.Entry<String, JogadorFutebol> jf : this.jogadoresTitulares.entrySet())
			habilidade += jf.getValue().getHabilidade();
		return habilidade/11;
	}

	public JogadorFutebol getJogador(int numero){

		for(Map.Entry<String, JogadorFutebol> jf : this.jogadoresTitulares.entrySet()){
			if(jf.getValue().getNumero() == numero) return jf.getValue().clone();
		}
		for(Map.Entry<String, JogadorFutebol> jf : this.jogadoresSuplentes.entrySet()){
			if(jf.getValue().getNumero() == numero) return jf.getValue().clone();
		}
		return new JogadorFutebol();			//Aqui devem-se tratar exceptions iguess, visto q em poo "n existe null"
	}

	/**
	 * getJogadorByName, Procura um jogador pelo seu nome
	 * @param s Nome do jogador
	 * @return JogadorFutebol
	 */
	public JogadorFutebol getJogadorByName(String s){
		if(this.jogadoresTitulares.containsKey(s)){
			return this.jogadoresTitulares.get(s);
		}
		return new JogadorFutebol();
	}


	/**
	 * clone
	 */
	public EquipaFutebol clone() { return new EquipaFutebol(this); }

	/**
	 * Setters
	 */
	public void setSubstituicoes(int substituicoes){ this.substituicoes = substituicoes;}

	public void setJogadoresTitulares(Map<String, JogadorFutebol> jTitulares) {
		this.jogadoresTitulares = jTitulares.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
	}

	public void setJogadoresSuplentes(Map<String, JogadorFutebol> jSuplentes) {
		this.jogadoresSuplentes = jSuplentes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
	}

	public void serOverall(double overall) {this.overall = overall;}

	public void setCorPrimaria(Cor c) {this.corPrimaria = c;}

	public void setCorSecundaria(Cor c) {this.corSecundaria = c;}

	public void setGolos(int golos){ this.golos = golos;}

	/**
	 * equals
	 * @param o Objeto a ser comparado
	 * @return True, se forem iguais
	 */
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || o.getClass() != this.getClass()) return false;
		EquipaFutebol that = (EquipaFutebol) o;
		return super.equals(that) &&
				this.substituicoes == that.substituicoes &&
				this.jogadoresTitulares.equals(that.jogadoresTitulares) &&
				this.jogadoresSuplentes.equals(that.jogadoresSuplentes) &&
				this.overall == that.overall &&
				this.corPrimaria == that.corPrimaria &&
				this.corSecundaria == that.corSecundaria &&
				this.golos == that.golos;
	}

	/**
	 * toString
	 */
	public String toString() {

		StringBuilder s = new StringBuilder("Equipa Futebol [" + this.getNome() + "]:\n");
		s.append("\tNumero Titulares: ").append(this.getTitulares()).append(", Numero Suplentes: ")
				.append(this.getSuplentes()).append(", Numero substituicoes: ").append(this.getSubstituicoes()).append("\n");

		s.append("\tTitulares:\n");
		for (Map.Entry<String, JogadorFutebol> jf : this.jogadoresTitulares.entrySet())
			s.append(jf.toString());

		s.append("\tSuplentes:\n");
		for (Map.Entry<String, JogadorFutebol> jf : this.jogadoresSuplentes.entrySet())
			s.append(jf.toString());

		s.append("\tGolos: ").append(this.golos).append("\n");
		return s.toString();
	}

	/**
	 * adicionaTitular, adiciona um jogador aos titulares de uma equipa
	 * @param jf jogador a ser adicionado
	 * @return True, se for adicionado com sucesso, False, caso contrário
	 */
	public boolean adicionaTitular(JogadorFutebol jf) {

		if (this.getTitulares() == 11)                                               			//Se o limite de jogadores tiver sido alcançado, return false
			return false;

		if (this.jogadoresTitulares.containsKey(jf.getNome()))                        			//se o jogador já se encontra na equipa, return false
			return false;

		if (jf instanceof GuardaRedes) {                                              			//Se o jogador a adicionar é GR &&

			for (Map.Entry<String, JogadorFutebol> j : this.jogadoresTitulares.entrySet()) {	//Se a equipa já tem um guarda-redes, return false
				if (j.getValue() instanceof GuardaRedes)
					return false;
			}
		}
		jf.adiciona_equipa(this.getNome());
		this.jogadoresTitulares.put(jf.getNome(), jf.clone());
		this.setTitulares(this.getTitulares() + 1);
		return true;
	}

	/**
	 * removeTitular, remove um jogador da lista de titulares de uma equipa
	 * @param jf jogador a ser removido
	 * @return True, se for removido com sucesso, False, caso contrário
	 */
	public boolean removeTitular(JogadorFutebol jf) {

		if (this.getTitulares() == 0) return false;

		if (this.jogadoresTitulares.containsKey(jf.getNome())) {
			this.jogadoresTitulares.remove(jf.getNome(), jf);
			this.setTitulares(this.getTitulares() - 1);
			return true;
		}
		else return false;
	}

	/**
	 * adicionaSuplente, adiciona um jogador à lista de suplentes de uma equipa
	 * @param jf
	 * @return
	 */
	public boolean adicionaSuplente(JogadorFutebol jf) {

		if (this.getSuplentes() == 12)                                                //Se o limite de jogadores tiver sido alcançado, return false
			return false;

		if (this.jogadoresSuplentes.containsKey(jf.getNome()))                                //se o jogador já se encontra na equipa, return false
			return false;

		jf.adiciona_equipa(this.getNome());
		this.jogadoresSuplentes.put(jf.getNome(), jf.clone());
		this.setSuplentes(this.getSuplentes() + 1);
		return true;
	}

	/**
	 * removeSuplente, remove um jogador da lista de suplentes de uma equipa
	 * @param jf
	 * @return
	 */
	public boolean removeSuplente(JogadorFutebol jf) {

		if (this.getSuplentes() == 0) return false;

		if (this.jogadoresSuplentes.containsKey(jf.getNome())) {
			this.jogadoresSuplentes.remove(jf.getNome(), jf);
			this.setSuplentes(this.getSuplentes() - 1);
			return true;
		} else return false;
	}

	/**
	 * isReady, confirma se uma equipa tem os parâmetros corretos para ser considerada uma equipa válida para jogo
	 * @return True se uma equipa tiver os requisitos mínimos para ser considerada apta a jogo
	 */
	public boolean isReady(){													//Confirma se a equipa tem o número de jogadores necessários para começar
		if(this.getTitulares() >= 7 && this.getTitulares() <= 11){

			if(this.getSuplentes() <= 12 && this.golos == 0){

				for(Map.Entry<String, JogadorFutebol> j : this.jogadoresTitulares.entrySet())
					if(j.getValue() instanceof GuardaRedes)
						return true;
			}
		}
		return false;
	}

	/**
	 * substitui, Substitui um jogador titular por outro que esteja no banco
	 * @param jCampo Titular substituido
	 * @param jBanco Suplente a ser substituido
	 * @return True, se os jogadores efetuarem a troca com sucesso
	 */
	public boolean substitui(JogadorFutebol jCampo, JogadorFutebol jBanco){

		if(jCampo instanceof GuardaRedes && jBanco instanceof JogadorFutebol) return false;

		if(this.jogadoresTitulares.containsKey(jCampo.getNome()) && this.jogadoresSuplentes.containsKey(jBanco.getNome()) && substituicoes > 0){

			this.removeTitular(jCampo);
			this.adicionaTitular(jBanco);
			this.removeSuplente(jBanco);
			this.adicionaSuplente(jCampo);
			this.substituicoes--;
			return true;
		}
		return false;
	}

	/**
	 * addGolo, adiciona um golo à equipa
	 */
	public void addGolo(){
		this.golos++;
	}

	/**
	 * reinicia_golos, Reinicia o número de golos de uma equipa
	 */
	public void reinicia_golos(){ this.golos = 0;}

	/**
	 * hasJogador Verifica se um jogador está presente na equipa
	 * @param j Nome do jogador
	 * @return True, se o jogador pertencer a esta equipa
	 */
	public boolean hasJogador(String j){

		if(this.jogadoresTitulares.containsKey(j)) return true;
		return this.jogadoresSuplentes.containsKey(j);
	}

	/**
	 * hasTitular Verifica se um jogador é titular na equipa
	 * @param j Nome do jogador
	 * @return True, se o jogador for titular
	 */
	public boolean hasTitular(String j){

		return this.jogadoresTitulares.containsKey(j);
	}

	/**
	 * hasTitular Verifica se um jogador é suplente na equipa
	 * @param j Nome do jogador
	 * @return True, se o jogador for suplente
	 */
	public boolean hasSuplente(String j){

		return this.jogadoresSuplentes.containsKey(j);
	}

	/**
	 * substituir, Efetua a substituição de 2 jogadores na equipa
	 * @param j1 Nome do titular
	 * @param j2 Nome do Suplente
	 * @return True, se a troca for efetuada com sucesso
	 */
	public boolean substituir(String j1, String j2){

        if(!this.hasTitular(j1) || !this.hasSuplente(j2)){
            return false;   //neste caso não é feita nenhuma substituição
        }
        return this.substitui(this.jogadoresTitulares.get(j1), this.jogadoresSuplentes.get(j2));
    }

	/**
	 * adiciona_jogador, Adiciona um jogador a uma equipa
	 * @param jf Jogador a ser adicionado
	 * @return True, se for adicionado à equipa com sucesso
	 */
    public boolean adiciona_jogador(JogadorFutebol jf){

		if(this.hasJogador(jf.getNome())) return false;
		if(this.get_numero_titulares() < 11){
			jf.adiciona_equipa(this.getNome());
			this.adicionaTitular(jf);
			return true;
		}
		else if(this.get_numero_suplentes() < 12){
			jf.adiciona_equipa(this.getNome());
			this.adicionaSuplente(jf);
			return true;
		}
		return false;
	}

	/**
	 * getOverallMedios, Calcula o overall de todos os medios da equipa
	 * @return Overall dos Medios
	 */
	public double getOverallMedios(){
    	double sum = 0;
    	int count = 0;

    	for(Map.Entry<String, JogadorFutebol> entrada : this.getJogadoresTitulares().entrySet()){
    		if(entrada.getValue().getPosicaoCampo() == PosicaoCampo.M){
    			sum += entrada.getValue().getHabilidade();
    			count++;
			}
		}
    	return sum/count;
	}

	/**
	 * getOverallAvancados, Calcula o overall de todos os avancados da equipa
	 * @return Overall dos Avancados
	 */
	public double getOverallAvancados(){
		double sum = 0;
		int count = 0;

		for(Map.Entry<String, JogadorFutebol> entrada : this.getJogadoresTitulares().entrySet()){
			if(entrada.getValue().getPosicaoCampo() == PosicaoCampo.A || entrada.getValue().getPosicaoCampo() == PosicaoCampo.L){
				sum += entrada.getValue().getHabilidade();
				count++;
			}
		}
		return sum/count;
	}

	/**
	 * getOverallDefesas, Calcula o overall de todos os defesas da equipa
	 * @return Overall dos Defesas
	 */
	public double getOverallDefesas(){
		double sum = 0;
		int count = 0;

		for(Map.Entry<String, JogadorFutebol> entrada : this.getJogadoresTitulares().entrySet()){
			if(entrada.getValue().getPosicaoCampo() == PosicaoCampo.D){
				sum += entrada.getValue().getHabilidade();
				count++;
			}
		}
		return sum/count;
	}

	/**
	 * getRandomMedio,
	 * @return
	 */
	public String getRandomMedio(){
    	ArrayList<String> medios = new ArrayList<>();

		for(Map.Entry<String, JogadorFutebol> entrada : this.getJogadoresTitulares().entrySet()){
			if(entrada.getValue().getPosicaoCampo() == PosicaoCampo.M){
				medios.add(entrada.getKey());
			}
		}
		return medios.get((ThreadLocalRandom.current().nextInt(0, medios.size())));
	}

	/**
	 * getRandomAvancado,
	 * @return
	 */
	public String getRandomAvancado(){
		ArrayList<String> Avancados = new ArrayList<>();

		for(Map.Entry<String, JogadorFutebol> entrada : this.getJogadoresTitulares().entrySet()){
			if(entrada.getValue().getPosicaoCampo() == PosicaoCampo.A || entrada.getValue().getPosicaoCampo() == PosicaoCampo.L){
				Avancados.add(entrada.getKey());
			}
		}
		return Avancados.get((ThreadLocalRandom.current().nextInt(0, Avancados.size())));
	}

	/**
	 * getRandomDefesa,
	 * @return
	 */
	public String getRandomDefesa(){

		ArrayList<String> Defesas = new ArrayList<>();
		for(Map.Entry<String, JogadorFutebol> entrada : this.getJogadoresTitulares().entrySet()){
			if(entrada.getValue().getPosicaoCampo() == PosicaoCampo.D){
				Defesas.add(entrada.getKey());
			}
		}
		return Defesas.get((ThreadLocalRandom.current().nextInt(0, Defesas.size())));
	}

	/**
	 * getGoalKeeper, Devolve o guarda redes da equipa
	 * @return Guarda Redes
	 */
	public JogadorFutebol getGoalKeeper(){
		for(Map.Entry<String, JogadorFutebol> entrada : this.getJogadoresTitulares().entrySet()){
			if(entrada.getValue().getPosicaoCampo() == PosicaoCampo.GR){
				return entrada.getValue();
			}
		}
		return new JogadorFutebol();
	}
}