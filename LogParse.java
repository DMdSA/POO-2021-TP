import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;


public class LogParse{


	public static void Parse(String filename){

		List<String> linhas = readFile(filename);
		Map<String, Equipa> equipas = new HashMap<>();
		Map<Integer, Jogador> jogadores = new HashMap<>();									//What is the need of this, if I clone it's content to each 'equipa' ?
		//List<JogoFutebol> jogos = new ArrayList<>();
		Equipa ultima = NULL; JogadorFutebol currentPlayer = NULL;
		String[] analyse;

		for(String s : linhas){

			analyse = s.split(":", 2);

			switch(analyse[0]){

				case "Equipa":

					Equipa thisOne = EquipaFutebol.parse(analyse[1]);
					equipas.put(thisOne.getNome(), thisOne);
					ultima = thisOne;
					break;

				case "Lateral":

					currentPlayer = Lateral.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();				//Shouldn't I make another expection for the case Jogador does not exist??...
					ultima.adicionaTitular(currentPlayer.clone());
					break;

				case "Defesa":

					currentPlayer = Defesa.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adicionaTitular(currentPlayer.clone());
					break;

				case "Medio":

					currentPlayer = Medio.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adicionaTitular(currentPlayer.clone());
					break;

				case "Avancado":

					currentPlayer = Avancado.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adicionaTitular(currentPlayer.clone());
					break;

				case "Guarda-Redes":

					currentPlayer = GuardaRedes.parse(analyse[1]);
					jogadores.put(currentPlayer.getNumero(), currentPlayer);
					// if (ultima == null) throw new LinhaIncorretaException();
					ultima.adicionaTitular(currentPlayer.clone());
					break;

/*
				case "Jogo":
					Jogo jo = Jogo.parse(linhaPartida[1]);
					jogos.add(jo);
					break;
*/	
				default:
					//throw new LinhaIncorreta();
					break;
			}
		}
	}




	/**
	 *	Permite ler todas as linhas de um determinado ficheiro para uma lista de strings
	 */

	public static List<String> readFile(String file){


		Path filepath = Paths.get(file);
		Charset charset = StandardCharsets.UTF_8;
		List<String> allLines = new ArrayList<>();

		try{

			allLines = Files.readAllLines(filepath, charset);

		}				catch(IOException ex){

							System.out.println("\n#> File error: specified file not oppended (" + file + ")\n");
						}

		return allLines;
	}


}