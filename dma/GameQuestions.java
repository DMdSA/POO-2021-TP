import java.util.Scanner;


public class GameQuestions{




	public static JogadorFutebol criaJogador(){

		Scanner lerInput = new Scanner(System.in);

		System.out.print("\n\n#Que nome queres dar ao teu jogador?: ");
		String nome = lerInput.nextLine();														//Guarda o nome do jogador
		
		System.out.print("\n\n#Que posicao queres dar ao teu jogador?: ");
		String posicao = lerInput.nextLine();													//Guarda a string que deverá ser transformada numa posição do jogo

        PosicaoCampo pc = PosicaoCampo.transforma_Posicao(posicao);								//Transforma a string na posicao correspondente

        int numero;
		double valor;
        
        JogadorFutebol jf;																		//Inicialização do objeto
    	
    	if(pc == PosicaoCampo.GR){																//Se for um Guarda-Redes, fazer o cast correto
    	   
    	    jf = new GuardaRedes(nome, pc);
			//((GuardaRedes) jf).setElasticidade(20);
    	}
    	
    	else {
           
            jf = new JogadorFutebol(nome, pc);													//Se for um jogador normal, utilizar o seu construtor
        }

        System.out.print("#Idade: ");
        numero = lerInput.nextInt();
        jf.setIdade(numero);

        System.out.print("#Peso: ");
        valor = lerInput.nextDouble();
        jf.setPeso(valor);

        System.out.print("#Altura: ");
        valor = lerInput.nextDouble();
        jf.setAltura(valor);

        System.out.print("#Numero: ");
        numero = lerInput.nextInt();
        jf.setNumero(numero);
        
        System.out.println("\n#Velocidade: ");
        valor = lerInput.nextDouble();
        jf.setVelocidade(valor);

        System.out.println("\n#Impulsao: ");
        valor = lerInput.nextDouble();
        jf.setImpulsao(valor);

        System.out.println("\n#Resistencia: ");
        valor = lerInput.nextDouble();
        jf.setResistencia(valor);

        System.out.println("\n#Destreza: ");
        valor = lerInput.nextDouble();
        jf.setDestreza(valor);

        System.out.println("\n#Jogo Cabeca: ");
        valor = lerInput.nextDouble();
        jf.setJogoCabeca(valor);

        System.out.println("\n#Remate: ");
        valor = lerInput.nextDouble();
        jf.setRemate(valor);

        System.out.println("\n#Passe: ");
        valor = lerInput.nextDouble();
        jf.setPasse(valor);

        System.out.println("\n#Humor: ");
        valor = lerInput.nextDouble();
        jf.setHumor(valor);

        if(jf.getPosicaoCampo() == PosicaoCampo.GR){

            System.out.println("\n#Elasticidade: ");
            valor = lerInput.nextDouble();
            ((GuardaRedes)jf).setElasticidade(valor);
        }


        return jf;
	}

















}