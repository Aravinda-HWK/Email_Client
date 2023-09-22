package EmailClient;

import java.io.Serializable;

public class Recipient implements Serializable {
    private static int numberOfRecipients=0;
    private String name;
    private final String emailAddress;

    public Recipient(String name,String emailAddress) {
        this.emailAddress=emailAddress;
        this.name=name;
        numberOfRecipients++;
    }

    //Returning the number of recipients
    public static int getNumberOfRecipients() {
        return numberOfRecipients;
    }

    //Returing the names of the recipients
    public String getName() {
        return name;
    }

    //returning the mail address of the recipients
    public String getEmailAddress() {
        return emailAddress;
    }

    public static void setNumberOfRecipients(){
        numberOfRecipients=0;
    }

}
