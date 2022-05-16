package java.be.kuleuven.myapplication;

public class app {

    private UserProfile userProfile;
    private static Bike bike;
    private UserProfile user;
    private static String popUpTitle;
    private static String popUpMessage;

    public app(){}

    public static Bike getBike() {
        return bike;
    }

    public static void setBike(Bike bike) {
        app.bike = bike;
    }

    //popUp message getters en setters
    public static String getPopUpTitle(){ return popUpTitle;}
    public static void setPopUpTitle(String title){ popUpTitle = title;}
    public static String getPopUpMessage(){ return popUpMessage;}
    public static void setPopUpMessage(String message){ popUpMessage = message;}

    //userProfile getters en setters
    public static UserProfile getUserProfile(){ return userProfile;}
    public static void setUserProfile
}
