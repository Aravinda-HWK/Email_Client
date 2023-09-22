package EmailClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BirthdayWishing {

    public static void wish(boolean addRecipient) throws IOException {

        //Taking current date
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        ReadFile.read("clientList.txt",currentDate.format(now));

        //Check the existence of recipient list file
        if (ReadFile.isExistFile()){
            ArrayList<Recipient> objList=ReadFile.getBirthdayObjectList();

            boolean Loop=true;
            ReadObjectFile.read("obj.ser");
            if (ReadObjectFile.isExistFile()){
                ArrayList<SendEmail> sendEmailObjects = ReadObjectFile.getSendEmailsObjects();
                for (SendEmail mails : sendEmailObjects) {

                    //Check whether today the email client has send birthday wishes
                    if (mails.getSubject().equals("Birthday wishing")&&mails.getDate().equals(currentDate.format(now))){
                        Loop=false;
                    }
                }
            }
            //Sending birthday wishes
            if (Loop){
                for (Recipient recipient : objList) {
                    if (recipient instanceof Personal){
                        //Send mail to a personal recipient.
                        EmailSendable personal = (Personal) recipient;
                        personal.sendEmail(currentDate.format(now));
                        System.out.println("Birthday wish was sent to the "+recipient.getName());

                    }
                    if (recipient instanceof OfficialFriend){
                        //Sending mail to a office friend.
                        EmailSendable officeFriend = (OfficialFriend) recipient;
                        officeFriend.sendEmail(currentDate.format(now));
                        System.out.println("Birthday wish was sent to the "+recipient.getName());

                    }
                }
            }

            //Check whether the recipient who is added today and also his or her birthday is today
            if (addRecipient&&!Loop){
                if (objList.get(objList.size() - 1) instanceof Personal personal){
                    if (personal.getBirthDay().equals(currentDate.format(now).substring(5,10))){
                        EmailSendable personal1=(Personal) objList.get(objList.size()-1);
                        personal1.sendEmail(currentDate.format(now));
                        System.out.println("Birthday wish was sent to the "+personal.getName());
                    }
                }
                if (objList.get(objList.size() - 1) instanceof OfficialFriend officialFriend){
                    if (officialFriend.getBirthDay().equals(currentDate.format(now).substring(5,10))){
                        EmailSendable officialFriend1=(OfficialFriend) objList.get(objList.size()-1);
                        officialFriend1.sendEmail(currentDate.format(now));
                        System.out.println("Birthday wish was sent to the "+officialFriend.getName());
                    }
                }
            }

        }
    }
}
