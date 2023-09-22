package EmailClient;

import java.util.ArrayList;

public class BirthdayList {

    //Making array list of recipients who has birthdays on given date
    private static ArrayList<Recipient> objectList = new ArrayList<>();

    //Setting the array list
    public static void createBirthdayList(Recipient object){
        objectList.add(object);
    }

    public static ArrayList<Recipient> getObjectList() {
        return objectList;
    }

    public static void clearBirthdayList(){
        objectList.clear();
    }

}
