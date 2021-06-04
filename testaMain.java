import Equipa.Equipa;
import Jogadores.Jogador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class testaMain {

    public static void main(String[] args) throws IOException {


        LogParser parser = new LogParser("logs.txt");

        Map<String, Equipa> equipas = parser.getEquipas();

        Collection<JogoFutebol> jogos = parser.getJogos();
        int counter = 0;

        for(JogoFutebol jf : jogos){

            System.out.println(jf.toString());
        }

        System.out.println("\n#> sao " + counter + " jogadores\n");
    }
}