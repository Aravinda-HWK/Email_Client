package EmailClient;

public class RecipientFactory {

    public void makeRecipient(String[] content) {
            String[] array1=content[1].split(",");

            //Factory to make recipients
            switch (content[0]){
                case "Official"->{
                    Official official = new Official(array1);
                }
                case "Office_friend"->{
                    OfficialFriend oofficialFriend = new OfficialFriend(array1);
                }
                case "Personal"->{
                    Personal personal = new Personal(array1);
                }
            }
    }
}
