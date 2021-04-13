import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testaMain {

    public static void main(String[] args){

    	
    	Scanner lerInput = new Scanner(System.in);


    /*
    	System.out.println("\n\n#Vamos comecar!!");

    	System.out.print("#Que nome queres dar ao teu jogador?: ");
    	String nome = lerInput.nextLine();

    	Jogador jogador1 = new Jogador(nome);

    	System.out.println("\n" + jogador1.toString());
    	
    	System.out.println("\nDefinir idade=19, altura=1.75, peso=70\n");
    	jogador1.setIdade(19);
    	jogador1.setAltura(1.75);
    	jogador1.setPeso(70);

    	Jogador copia1 = jogador1.clone();
    	System.out.println("\n# O jogador 1 e igual a copia criada? [" + jogador1.equals(copia1) + "]\n");

    	System.out.println("Jogador copia: " + copia1.toString() + "\n\n");
	*/

    	// testaJogador ^/----------------------------------------------------------------------------------------------------------


		System.out.print("\n\n#Que nome queres dar ao teu jogador?: ");
		String nome = lerInput.nextLine();
		System.out.print("\n\n#Que posicao queres dar ao teu jogador?: ");
		String posicao = lerInput.nextLine();

        PosicaoCampo pc = PosicaoCampo.transforma_Posicao(posicao);

        JogadorFutebol jf1;
    	if(pc == PosicaoCampo.GR){
    	    jf1 = new GuardaRedes(nome, pc);
    	    ((GuardaRedes) jf1).setElasticidade(20);
    	}
    	else {
            jf1 = new JogadorFutebol(nome, pc);
        }

        jf1.setNumero(7);
        jf1.setOverall(12.5);
        jf1.setVelocidade(3);
        jf1.setImpulsao(5);
        jf1.setResistencia(10);
        jf1.setDestreza(2);
        jf1.setJogoCabeca(1);
        jf1.setRemate(12);
        jf1.setPasse(5);
        jf1.setHumor(2);
        List<String> clubes1 = new ArrayList<String>();
        clubes1.add("Braga"); clubes1.add("Porto"); clubes1.add("Sporting");
        jf1.setHistorico(clubes1);

        System.out.println("\n#Jogador " + jf1.getNome() + " criado!:\n" + jf1.toString());




       	System.out.print("\n\n#Que nome queres dar ao teu jogador?: ");
		nome = lerInput.nextLine();
		System.out.print("\n\n#Que posicao queres dar ao teu jogador?: ");
		posicao = lerInput.nextLine();
		pc = PosicaoCampo.transforma_Posicao(posicao);

    	JogadorFutebol jf2;
    	if(pc == PosicaoCampo.GR){
    	    jf2 = new GuardaRedes(nome, pc);
    	    ((GuardaRedes) jf2).setElasticidade(20);
    	}
    	else {
            jf2 = new JogadorFutebol(nome, pc);
        }

        jf2.setNumero(7);
        jf2.setOverall(12.5);
        jf2.setVelocidade(3);
        jf2.setImpulsao(5);
        jf2.setResistencia(10);
        jf2.setDestreza(2);
        jf2.setJogoCabeca(1);
        jf2.setRemate(12);
        jf2.setPasse(5);
        jf2.setHumor(2);
        List<String> clubes2 = new ArrayList<String>();
        clubes2.add("Rio Ave"); clubes2.add("Sporting"); clubes2.add("Guimaraes"); clubes2.add("Santa Clara");
        jf2.setHistorico(clubes2);





		System.out.print("\n\n#Que nome queres dar ao teu jogador?: ");
		nome = lerInput.nextLine();
		System.out.print("\n\n#Que posicao queres dar ao teu jogador?: ");
		posicao = lerInput.nextLine();
		pc = PosicaoCampo.transforma_Posicao(posicao);

    	JogadorFutebol jf3;
    	if(pc == PosicaoCampo.GR){
    	    jf3 = new GuardaRedes(nome, pc);
    	    ((GuardaRedes) jf3).setElasticidade(20);
    	}
    	else {
            jf3 = new JogadorFutebol(nome, pc);
        }

       	jf3.setNumero(7);
        jf3.setOverall(12.5);
        jf3.setVelocidade(3);
        jf3.setImpulsao(5);
        jf3.setResistencia(10);
        jf3.setDestreza(2);
        jf3.setJogoCabeca(1);
        jf3.setRemate(12);
        jf3.setPasse(5);
        jf3.setHumor(2);
        List<String> clubes3 = new ArrayList<String>();
        clubes3.add("Rio Ave"); clubes3.add("Sporting"); clubes3.add("Guimaraes"); clubes3.add("Santa Clara");
        jf3.setHistorico(clubes3);



        System.out.printf("\n#Foram criados 3 jogadores, 1_\"%s\", 2_\"%s\", 3_\"%s\"\n", jf1.getNome(), jf2.getNome(), jf3.getNome());
       
        System.out.println("\n#Os jogadores 2 e 3 sao iguais? [" + jf2.equals(jf3) + "]\n");


        System.out.println(jf2.toString() + "\n\n" + jf3.toString());


    }
}
