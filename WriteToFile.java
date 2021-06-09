import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteToFile {

    public void WriteObjectToFile(Object o, String filepath) throws FileNotFoundException, IOException {
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
}
