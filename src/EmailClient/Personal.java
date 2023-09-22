package EmailClient;

import java.io.*;

public class Personal extends Recipient implements EmailSendable{
    private String birthDay;
    private String nickName;

    public Personal(String[] content) {
        super(content[0],content[2]);
        this.birthDay = content[3].substring(5,10);
        this.nickName = content[1];
        addBirthdayList(this);
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getNickName() {
        return nickName;
    }

    public void sendEmail(String date) throws IOException {
        String subject="Birthday wishing";
        String content="Hugs and love on your birthday. \n\n Aravinda";
        SendEmail newMail=new SendEmail(date,this.getEmailAddress(),subject,content);
        newMail.sendMail();

        //Serialization send personal birthday wishes
        SerializationObject serializationObject=new SerializationObject("obj.ser",newMail);
        serializationObject.serialization();
    }

    public void addBirthdayList(Personal object){

        BirthdayList.createBirthdayList(object);
    }
}

