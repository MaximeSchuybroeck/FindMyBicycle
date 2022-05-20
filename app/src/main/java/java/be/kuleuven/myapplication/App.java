package java.be.kuleuven.myapplication;

public class App {

    private static Bike editBike;
    private static UserProfile user;
    private static String popUpTitle;
    private static String popUpMessage;

    public App(){
        user = new UserProfile("koenraad", "testwachtwoord");
        Bike testBike = new Bike("bike1", "test");
        setEditBike(testBike);
        user.getBikeList().add(testBike);
    }

    public static Bike getEditBike() {
        return editBike;
    }

    public static void setEditBike(Bike editBike) {
        App.editBike = editBike;
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
