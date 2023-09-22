package EmailClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationObject {

    String outputFile;
    SendEmail mail;

    public SerializationObject(String outputFile, SendEmail mail) {
        this.outputFile = outputFile;
        this.mail = mail;
    }

    public void serialization() throws IOException {
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputFile, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(mail);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
            if (fileOutputStream!=null) {
                fileOutputStream.close();
            }
        }
    }
}
