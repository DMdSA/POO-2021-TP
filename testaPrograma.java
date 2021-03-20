/**
 * testaPrograma Class
 *
 * @author dma_
 * @version 1.0
 */


public class testaPrograma{


	public static void main(String[] args){


		//Jogador

		Jogador j1 = new Jogador("Luis", 31);

		System.out.println(j1.toString());

		Jogador j2 = new Jogador("Diogo", 20, 13.3f, 1, 4.33f, 9.0f);

		System.out.println(j2.toString());

		System.out.println("Qual e o nome do 2o jogador?: " + j2.clone().getNome());


		//JogadorFutebol


		JogadorFutebol jf1 = new JogadorFutebol("Passas", 21, "Defesa");
		JogadorFutebol jf2 = new JogadorFutebol("Petty", 20, 1f, 2f, 3f, 4f, "Avancado", 5f, 6f, 7f);

		System.out.println("\n" + jf1.toString());
		System.out.println("\n\n" + jf2.toString());

		System.out.println("Capacidade de passe: " + jf2.getNome() + " -> " + jf2.getCapacidadePasse());

		


	}



}