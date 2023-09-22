package EmailClient;

// Index number:200045U
// Name        :H.W.K.Aravinda

//import libraries

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Email_Client {

    public static void main(String[] args) throws IOException {
        boolean Loop=true;
        while (Loop){
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Enter option type:\s
                    1 - Adding a new recipient
                    2 - Sending an email
                    3 - Printing out all the recipients who have birthdays
                    4 - Printing out details of all the emails sent
                    5 - Printing out the number of recipient objects in the application""");
            try{
                int option = scanner.nextInt();

            //Taking current date by importing java library.
            DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            boolean addRecipient=false;
            SetMailClient.setMailClient();
            switch (option) {
                case 1 -> {
                    System.out.println("""
                    Enter recipients as following input:\s
                    Official:nimal,nimal@gmail.com,ceo
                    Office_friend:kamal,kamal@gmail.com,clerk,2000/12/12
                    Personal:sunil,<nick-name>,sunil@gmail.com,2000/10/10""");
                    scanner.nextLine();
                    String input1 = scanner.nextLine();
                    WriteFile.write("clientList.txt", input1);
                    System.out.println("The new recipient is successfully added to the clientList.txt file.");
                    addRecipient=true;
                }
                case 2 -> {
                    System.out.println("Enter the email,subject and content using coma seperated: ");
                    scanner.nextLine();
                    String input2 = scanner.nextLine();
                    //Spliting the input
                    String[] array2 = input2.split(",");

                    //Sending the mail using email,subject and content given by the user.
                    try{
                        SendEmail newMail = new SendEmail(currentDate.format(now), array2[0], array2[1], array2[2]);

                        newMail.sendMail();

                        //Serialization newMail objects
                        SerializationObject serObject = new SerializationObject("obj.ser", newMail);
                        serObject.serialization();
                        System.out.println("The email was sent successfully.");
                    }catch(ArrayIndexOutOfBoundsException error){
                        System.out.println("Input format is false.");
                    }

                }
                case 3 -> {
                    System.out.println("Enter the date [input format - yyyy/MM/dd (ex: 2018/09/17)]");
                    scanner.nextLine();
                    String input3 = scanner.nextLine();
                    //Taking the array list as recipients who have birthdays on the given date.
                    ReadFile.read("clientList.txt", input3);
                    ReadFile.printDetails(input3);
                }
                case 4 -> {
                    System.out.println("Enter the date [input format - yyyy/MM/dd (ex: 2018/09/17)]");
                    scanner.nextLine();
                    String input4 = scanner.nextLine();
                    //Making array list for saving SendMail objects after deserializing objects from text file.
                    ReadObjectFile.read("obj.ser");
                    ReadObjectFile.printMail(input4);
                }
                case 5 -> {
                    System.out.println("Number of recipients objects in the application: ");
                    ReadFile.read("clientList.txt", "             ");
                    System.out.println(Recipient.getNumberOfRecipients());
                }
            }
            SetMailClient.setMailClient();
            //Check whether that there are recipients who have birthday on current date.
            BirthdayWishing.wish(addRecipient);

            }catch (InputMismatchException error){
                System.out.println("This input format is false.Give a correct format.");
            }
            System.out.println("""
                    Do you want to continue Email Client operations?\s
                    1:Yes
                    2:No""");
            int terminate = scanner.nextInt();
            switch (terminate){
                case 1->{
                }
                case 2-> Loop=false;
            }
        }
    }
}
