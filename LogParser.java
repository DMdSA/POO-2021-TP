import Equipa.*;
import Jogadores.Futebol.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser {
	/**                                            Variáveis instância  */
    private Map<String, EquipaFutebol> equipas;
	//private Map<Integer, Jogador> jogadores;
	private Collection<JogoFutebol> jogos;


	public LogParser(String filename){

		Collection<String> linhas = readFile(filename);
		Map<String, EquipaFutebol> equipas = new HashMap<>();
		Map<Integer, JogadorFutebol> jogadores = new HashMap<>();									//What is the need of this, if I clone it's content to each 'equipa' ?
		Collection<JogoFutebol> jogos = new ArrayList<>();
		EquipaFutebol ultima = null; JogadorFutebol currentPlayer = null;
		String[] analyse;

		for(String s : linhas){

			analyse = s.split(":", 2);

			switch(analyse[0]){

				case "Equipa":

					EquipaFutebol thisOne = EquipaFutebol.parse(analyse[1]);
					equipas.put(thisOne.getNome(), thisOne);
					ultima = thisOne;
					break;

				case "Lateral":

					currentPlayer = Lateral.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();				//Shouldn't I make another expection for the case Jogador does not exist??...
					ultima.adiciona_jogador(currentPlayer.clone());
					break;

				case "Defesa":

					currentPlayer = Defesa.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adiciona_jogador(currentPlayer.clone());
					break;

				case "Medio":

					currentPlayer = Medio.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adiciona_jogador(currentPlayer.clone());
					break;

				case "Avancado":

					currentPlayer = Avancado.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adiciona_jogador(currentPlayer.clone());
					break;

				case "Guarda-Redes":

					currentPlayer = GuardaRedes.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adiciona_jogador(currentPlayer.clone());
					break;


				case "Jogo":

					JogoFutebol current = JogoFutebol.parse(analyse[1]);
					jogos.add(current);
					break;

				default:
					//throw new LinhaIncorreta();
					break;
			}
		}

		this.equipas = equipas;
		//this.jogadores = jogadores;
		this.jogos = jogos;
	}


    /**
     *
     * @param file filepath of file to parse
     * @return all lines from the file
     */
	public static Collection<String> readFile(String file){

		Path filepath = Paths.get(file);
		Charset charset = StandardCharsets.UTF_8;
		Collection<String> allLines = new ArrayList<>();

		try{

			allLines = Files.readAllLines(filepath, charset);

		}				catch(IOException ex){

							System.out.println("\n#> File error: specified file not oppended (" + file + ")\n");
						}

		return allLines;
	}


	public Map<String, EquipaFutebol> getEquipas(){

	    return this.equipas.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    /*public Map<Integer, Jogador> getJogadores(){

	    return this.jogadores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }*/

    public Collection<JogoFutebol> getJogos(){

	    return this.jogos.stream().map(JogoFutebol::clone).collect(Collectors.toCollection(LinkedList::new));
    }

}
