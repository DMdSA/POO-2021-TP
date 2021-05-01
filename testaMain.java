import java.util.ArrayList;
import java.util.List;

public class testaMain {

    public static void main(String[] args){

    	
        List<String> historico1 = new ArrayList<>();
        historico1.add("Braga");
        JogadorFutebol j1 = new Avancado("Diogo", 20, 175, 75.3, PosicaoCampo.A, 7, 12.2, 5.5, 2.2, 8, 3, 5, 1, 7, historico1, 11);
        System.out.println("\n#> Foi criado o jogador -> " + j1.getNome());
        
        List<String> historico2 = new ArrayList<>();
        historico2.add("Braga"); historico2.add("Porto");
        JogadorFutebol j2 = new Avancado("Joao", 28, 165, 76.3, PosicaoCampo.A, 6, 2.2, 15.5, 2.22, 4, 8,8, 2.1, 0, historico2, 10);
        System.out.println("\n#> Foi criado o jogador -> " + j2.getNome());
        
        List<String> historico3 = new ArrayList<>();
        historico3.add("Benfica"); historico3.add("Porto");
        JogadorFutebol j3 = new Avancado("Renato", 19, 168, 68.1, PosicaoCampo.GR, 3, 12.2, 5.5, 4.02, 3, 4,0, 6.1, 6, historico3, 5);
        System.out.println("\n#> Foi criado o jogador -> " + j3.getNome());
        
        List<String> historico4 = new ArrayList<>();
        historico4.add("Sporting"); historico4.add("Tadim"); historico4.add("Vilaverdense");
        JogadorFutebol j4 = new Lateral("Afonso", 20, 184, 72.0, PosicaoCampo.L, 9, 2.2, 11.1, 2.99, 13, 3,8, 2.1, 1, historico4, 13);
        System.out.println("\n#> Foi criado o jogador -> " + j4.getNome());
        
        List<String> historico5 = new ArrayList<>();
        historico5.add("Braga"); historico5.add("Sporting"); historico5.add("Rio Ave");
        JogadorFutebol j5 = new Lateral("Pedro", 26, 180, 67.42, PosicaoCampo.L, 4, 28.2, 1.1666, 6.9, 0, 13, 6, 2.8, 0, historico5, 6);
        System.out.println("\n#> Foi criado o jogador -> " + j5.getNome());
        
        JogadorFutebol j6 = new Lateral("Jorge", 20, 184, 72.0, PosicaoCampo.L, 9, 2.2, 11.1, 2.99, 13, 3,8, 2.1, 0, 13);
        System.out.println("\n#> Foi criado o jogador -> " + j6.getNome());
        
        List<String> historico7 = new ArrayList<>();
        historico7.add("Braga");
        JogadorFutebol j7 = new Avancado("Ze", 20, 175, 75.3, PosicaoCampo.A, 7, 12.2, 5.5, 2.2, 8, 3, 5, 1, 7, historico7, 11);
        System.out.println("\n#> Foi criado o jogador -> " + j7.getNome());
        
        List<String> historico8 = new ArrayList<>();
        historico8.add("Braga"); historico8.add("Porto");
        JogadorFutebol j8 = new Avancado("Mateus", 28, 165, 76.3, PosicaoCampo.A, 6, 2.2, 15.5, 2.22, 4, 8,8, 2.1, 0, historico8, 10);
        System.out.println("\n#> Foi criado o jogador -> " + j8.getNome());
        
        List<String> historico9 = new ArrayList<>();
        historico9.add("Benfica"); historico9.add("Porto");
        JogadorFutebol j9 = new Avancado("Henrique", 19, 168, 68.1, PosicaoCampo.A, 3, 12.2, 5.5, 4.02, 3, 4,0, 6.1, 6, historico9, 5);
        System.out.println("\n#> Foi criado o jogador -> " + j9.getNome());
        
        
        List<String> historico10 = new ArrayList<>();
        historico10.add("Sporting"); historico10.add("Tadim"); historico10.add("Vilaverdense");
        JogadorFutebol j10 = new Lateral ("Passas", 20, 184, 72.0, PosicaoCampo.L, 9, 2.2, 11.1, 2.99, 13, 3,8, 2.1, 1, historico10, 13);
        System.out.println("\n#> Foi criado o jogador -> " + j10.getNome());
        
        List<String> historico11 = new ArrayList<>();
        historico11.add("Braga"); historico11.add("Sporting"); historico11.add("Rio Ave");
        JogadorFutebol j11 = new Lateral ("Rebelo", 26, 180, 67.42, PosicaoCampo.L, 4, 28.2, 1.1666, 6.9, 0, 13, 6, 2.8, 0, historico11, 6);
        System.out.println("\n#> Foi criado o jogador -> " + j11.getNome());
        
        JogadorFutebol j12 = new Lateral("Joel", 20, 184, 72.0, PosicaoCampo.L, 9, 2.2, 11.1, 2.99, 13, 3,8, 2.1, 0, 13);
        System.out.println("\n#> Foi criado o jogador -> " + j12.getNome());
        

        EquipaFutebol ef1 = new EquipaFutebol("TamoFudjido", Cor.VERMELHO, Cor.ROSA);
        System.out.println("\n#> Foi criada a equipa -> " + ef1.getNome());

		ef1.adicionaTitular(j1);ef1.adicionaTitular(j2);ef1.adicionaTitular(j3);ef1.adicionaTitular(j4);ef1.adicionaTitular(j5);ef1.adicionaTitular(j6);
        ef1.adicionaTitular(j7);ef1.adicionaTitular(j8);ef1.adicionaTitular(j9);ef1.adicionaTitular(j10);ef1.adicionaTitular(j11);ef1.adicionaTitular(j12);


        System.out.println("\n#>Equipa preenchida: \n\n" + ef1.toString());
        System.out.println("\n#>Esta equipa esta pronta para jogar? " + ef1.isReady());

    }
}
