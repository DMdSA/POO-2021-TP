import Equipa.EquipaFutebol;
import Jogadores.Futebol.JogadorFutebol;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ObjectFileProcessing {

    public static void WriteObjectToFile(Object o, String filepath) throws FileNotFoundException, IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(o);
            objectOut.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void carrega_dados_obj(ClientModel cm, String filename) throws IOException, ClassNotFoundException {

        cm.setJogadores_guardados(new HashMap<>());
        cm.setEquipas_guardadas(new HashMap<>());
        cm.setJogos_guardados(new HashSet<>());

        FileInputStream fileStream = new FileInputStream(filename);
        ObjectInputStream input = new ObjectInputStream(fileStream);
        ArrayList<Object> fromfile;

        fromfile =(ArrayList<Object>) input.readObject();
        for (Object o : fromfile) {
            if (o instanceof Utilizador) {
                cm.setUser((Utilizador) o);
            } else if (o instanceof JogadorFutebol) {
                cm.addJogador((JogadorFutebol) o);
            } else if (o instanceof EquipaFutebol) {
                cm.addEquipa((EquipaFutebol) o);
            } else if (o instanceof JogoFutebol) {
                cm.addJogo((JogoFutebol) o);
            }
        }
    }
}
