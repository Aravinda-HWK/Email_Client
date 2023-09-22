package EmailClient;

import java.io.IOException;

public class OfficialFriend extends Recipient implements EmailSendable {
    private String birthDay;
    private String position;


    public OfficialFriend(String[] content) {
        super(content[0],content[1]);
        this.birthDay = content[3].substring(5,10);
        this.position = content[2];
        addBirthdayList(this);
    }

    public String getBirthDay() {
        return birthDay;
    }

    //Sending mails for official friends
    public void sendEmail(String date) throws IOException {
        String subject="Birthday wishing";
        String content="Wish you a Happy Birthday. \n\n Aravinda";
        SendEmail newMail=new SendEmail(date,this.getEmailAddress(),subject,content);
        newMail.sendMail();

        //Serialization send office friend birthday wishes
        SerializationObject serializationObject=new SerializationObject("obj.ser",newMail);
        serializationObject.serialization();


    }

    //Add to the birthday
    public void addBirthdayList(OfficialFriend object){
        BirthdayList.createBirthdayList(object);
    }


}

