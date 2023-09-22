package EmailClient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void write(String fileName,String input) throws IOException {
        //Create file if there is no file in the folder or appending clients list if there is the file in the folder.
        FileWriter file = new FileWriter(fileName, true);
        BufferedWriter bufferedFile = new BufferedWriter(file);
        bufferedFile.write(input);
        bufferedFile.newLine();
        //Close the file.
        bufferedFile.close();
        file.close();
    }
}
