package java.be.kuleuven.myapplication;

public class app {

    private static Bike editBike;
    private static UserProfile user;
    private static String popUpTitle;
    private static String popUpMessage;

    public app(){
        user = null;
    }

    public static Bike getEditBike() {
        return editBike;
    }

    public static void setEditBike(Bike editBike) {
        app.editBike = editBike;
    }
/*
    //popUp message getters en setters
    public static String getPopUpTitle(){ return popUpTitle;}
    public static void setPopUpTitle(String title){ popUpTitle = title;}
    public static String getPopUpMessage(){ return popUpMessage;}
    public static void setPopUpMessage(String message){ popUpMessage = message;}

 */

    //userProfile getters en setters
    public static UserProfile getUser(){ return user;}
    public static void setUser( UserProfile newUser){ user = newUser;}
}
