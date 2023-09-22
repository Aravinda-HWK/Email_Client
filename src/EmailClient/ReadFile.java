package EmailClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private static boolean existFile;
    private static ArrayList<Recipient> birthdayObjectList =new ArrayList<>();

    //Read the clientList.txt file
    public static void read(String fileName,String input) throws FileNotFoundException {
        File myFile1=new File(fileName);
        if (myFile1.exists()){
            Scanner myReader = new Scanner(myFile1);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] array = data.split(":");
                RecipientFactory factory = new RecipientFactory();
                factory.makeRecipient(array);

            }
            myReader.close();

            //Making birthday list array.
            for (Recipient object: BirthdayList.getObjectList()){
                if (object instanceof Personal per){
                    if (per.getBirthDay().equals(input.substring(5,10))){
                        birthdayObjectList.add(object);
                        existFile=true;
                    }
                }
                if (object instanceof OfficialFriend offFri){
                    if (offFri.getBirthDay().equals(input.substring(5,10))){
                        birthdayObjectList.add(object);
                        existFile=true;
                    }
                }
            }

        }else{
            existFile=false;
        }
    }


    //Printing the details that every recipient who has birthday on given date.
    public static void printDetails(String input){
        if (existFile){
            for (Recipient recipient : birthdayObjectList) {
                //Printing out their names.
                System.out.println("Recipient Name: "+recipient.getName()+
                        ", Recipient Email Address: "+recipient.getEmailAddress()+
                        ", Birthday Date: "+input.substring(5,10));
            }
        }else{
            System.out.println("There is no client file to read or there is no recipient who has birthday on"+input);
        }

    }

    //Returning the existence of the file

    public static boolean isExistFile() {
        return existFile;
    }

    //Returning the array list of reciepients who have birthday on given date.
    public static ArrayList<Recipient> getBirthdayObjectList() {
        return birthdayObjectList;
    }

    public static void clearBirthdayObject(){
        birthdayObjectList.clear();
    }
}
