package EmailClient;

public class Official extends Recipient {
    private String position;

    //Constructor of the Official class
    public Official(String[] content) {
        super(content[0],content[1]);
        this.position = content[2];
    }


}

