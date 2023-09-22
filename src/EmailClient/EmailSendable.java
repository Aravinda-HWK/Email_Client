package EmailClient;

import java.io.IOException;

public interface EmailSendable{
    //Interface to send mails
    void sendEmail(String date) throws IOException;
}
