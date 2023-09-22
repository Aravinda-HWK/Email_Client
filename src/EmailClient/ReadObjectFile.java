package EmailClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadObjectFile {
    private static boolean existFile;
    public static ArrayList<SendEmail> sendEmailsObjects;

    //Read the object file
    public static void read(String fileName) throws IOException {
        File myFile=new File(fileName);
        if (myFile.exists()){
            existFile=true;
            DeserializationObject DeseObject=new DeserializationObject();
            DeseObject.setSendEmailObjects();
            sendEmailsObjects = DeseObject.getSendEmailObjects();

        }else{
            existFile=false;
        }
    }


    //Printing the details of mails that has been sent on given date
    public static void printMail(String input){
        //Printing the mail details
        if (existFile){
            for (SendEmail mails : sendEmailsObjects) {
                if (input.equals(mails.getDate())) {
                    System.out.println("Date: "+mails.getDate()+
                            ", To: "+mails.getEmail()+
                            ", Email Subject: "+mails.getSubject());
                }
            }
        }
    }

    //Return the existence of object file
    public static boolean isExistFile() {
        return existFile;
    }

    //Return the send mails as an Array list
    public static ArrayList<SendEmail> getSendEmailsObjects() {
        return sendEmailsObjects;
    }
}
