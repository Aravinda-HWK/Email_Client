package EmailClient;


import java.io.*;
import java.util.ArrayList;


public class DeserializationObject {

        //Making array list of send mails
        ArrayList<SendEmail> sendEmailObjects = new ArrayList<>();


        //Read the objects from the obj.ser file and add them to the array list.
        public void setSendEmailObjects() throws IOException {
            ObjectInputStream objectInputStream = null;
            FileInputStream fileInputStream = null;
            try {
                File filename = new File("obj.ser");
                fileInputStream = new FileInputStream(filename);
                SendEmail sendMail;
                while (true) {
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                        sendMail = (SendEmail) objectInputStream.readObject();
                        sendEmailObjects.add(sendMail);
                    } catch (EOFException e) {
                        break;
                    }
                    if (sendMail == null) {
                        break;
                    }

                }

            } catch (ClassNotFoundException error) {
                System.out.println("Error: "+error.getMessage());
            } finally {
                assert objectInputStream != null;
                objectInputStream.close();
                fileInputStream.close();
            }
        }


        //Returning the send mail object array list
        public ArrayList<SendEmail> getSendEmailObjects() {
            return sendEmailObjects;
        }
}


